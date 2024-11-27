package com.busanit501.firstpractice.User.Controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebServlet (name = "user", urlPatterns = "/user")
//public class UserMain extends HttpServlet {
//
//    @Override
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        HttpSession session = request.getSession();
//
//        if (session.isNew()) response.sendRedirect("/user/register");
//        else if (session.getAttribute("loginInfo") == null) response.sendRedirect("/user/logIn");
//        else response.sendRedirect("/user/userView");
//    }
//}
