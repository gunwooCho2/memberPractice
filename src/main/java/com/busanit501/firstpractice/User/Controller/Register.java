package com.busanit501.firstpractice.User.Controller;

import com.busanit501.firstpractice.User.DTO.LoginDTO;
import com.busanit501.firstpractice.User.DTO.RegisterDTO;
import com.busanit501.firstpractice.User.Serviece.UserService;
import com.busanit501.firstpractice.Utill.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@WebServlet(name = "Register", urlPatterns = "/user/register")
public class Register extends HttpServlet {
    private final UserService service = UserService.INSTANCE;
    private final ModelMapper modelMapper = MapperUtil.INSTANCE.getModelMapper();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/Register.jsp")
                .forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userID = request.getParameter("userID");
        String password = request.getParameter("userPassword");
        String userName = request.getParameter("userName");

        RegisterDTO registerDTO = new RegisterDTO(userID, password, userName);
        String guide = service.duplicatesCheck(registerDTO);
        if (guide.isEmpty()) {
            service.insertUser(registerDTO);
            LoginDTO loginDTO = modelMapper.map(registerDTO, LoginDTO.class);
            request.getSession().setAttribute("loginInfo", loginDTO);
            response.sendRedirect("/user/logIn");
            return;
        }
        request.setAttribute("error", guide);
        doGet(request, response);
    }
}
