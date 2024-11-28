package com.busanit501.firstpractice.User.Controller;

import com.busanit501.firstpractice.User.DTO.LoginDTO;
import com.busanit501.firstpractice.User.DTO.RegisterDTO;
import com.busanit501.firstpractice.User.Serviece.UserService;
import com.busanit501.firstpractice.Utill.CookieUtil;
import com.busanit501.firstpractice.Utill.MapperUtil;
import org.modelmapper.ModelMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "logIn", urlPatterns = "/user/logIn")
public class Login extends HttpServlet {
    private final UserService service = UserService.INSTANCE;
    private final ModelMapper modelMapper = MapperUtil.INSTANCE.getModelMapper();
    private final CookieUtil cookieUtil = CookieUtil.INSTANCE;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userID = request.getParameter("userID");
        String password = request.getParameter("userPassword");
        boolean auto = request.getParameter("autoLogin") != null && request.getParameter("autoLogin").equals("true");
        LoginDTO loginDTO = new LoginDTO(userID, password);
        int userNo = service.logInUser(loginDTO);

        if (userNo != -1) {
            RegisterDTO registerDTO = modelMapper.map(service.getUser(userNo), RegisterDTO.class);
            request.getSession().setAttribute("loginInfo", registerDTO);
            if (auto) autoLogIn(request, response, userNo);
            request.getRequestDispatcher("/user/userView").forward(request, response);
        }
        else {
            String guide = "id or password is incorrect";
            request.setAttribute("error", guide);
            doGet(request, response);
        }
    }

    public void autoLogIn(HttpServletRequest request, HttpServletResponse response, int userNo){
        Cookie loginCookie = cookieUtil.getCookie(request.getCookies(), "loginInfo");
        if (loginCookie == null) loginCookie = new Cookie("loginInfo", "");
        loginCookie.setMaxAge(60*60*24);
        loginCookie.setPath("/");
        loginCookie.setValue(service.getUserUUID(userNo));
        response.addCookie(loginCookie);
    }
}
