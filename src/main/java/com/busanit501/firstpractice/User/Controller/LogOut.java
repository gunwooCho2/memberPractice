package com.busanit501.firstpractice.User.Controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet (name = "logout", urlPatterns = "/user/logout")
public class LogOut extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("loginInfo");
        session.invalidate();

        response.sendRedirect("/user/logIn");
    }
}
