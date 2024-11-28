package com.busanit501.firstpractice.User.Controller;

import com.busanit501.firstpractice.Utill.CookieUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet (name = "logout", urlPatterns = "/user/logout")
public class LogOut extends HttpServlet {
    private final CookieUtil cookieUtil = CookieUtil.INSTANCE;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("loginInfo");
        session.invalidate();

        Cookie removeCookie = cookieUtil.removeCookie(request.getCookies(), "loginInfo");
        if (removeCookie != null) response.addCookie(removeCookie);

        response.sendRedirect("/user/logIn");
    }
}
