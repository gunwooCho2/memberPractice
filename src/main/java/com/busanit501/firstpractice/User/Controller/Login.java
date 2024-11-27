package com.busanit501.firstpractice.User.Controller;

import com.busanit501.firstpractice.User.DTO.LoginDTO;
import com.busanit501.firstpractice.User.Serviece.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "logIn", urlPatterns = "/user/logIn")
public class Login extends HttpServlet {
    private final UserService service = UserService.INSTANCE;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userID = request.getParameter("userID");
        String password = request.getParameter("userPassword");
        LoginDTO loginDTO = new LoginDTO(userID, password);

        if (service.logInUser(loginDTO)) {
            request.getSession().setAttribute("loginInfo", loginDTO);
            request.getRequestDispatcher("/user/userView").forward(request, response);
        }
        else {
            String guide = "id or password is incorrect";
            request.setAttribute("error", guide);
            doGet(request, response);
        }
    }
}
