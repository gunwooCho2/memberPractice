package com.busanit501.firstpractice.Food.Controller;

import com.busanit501.firstpractice.Food.Service.FoodService;
import com.busanit501.firstpractice.Utill.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "foodView", urlPatterns = "/food/view")
public class FoodView extends HttpServlet {
    private final FoodService service = FoodService.INSTANCE;
    private final CookieUtil cookieUtil = CookieUtil.INSTANCE;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int foodNo = Integer.parseInt(request.getParameter("foodNo"));
        Cookie cookie = cookieUtil.getCookie(request.getCookies(), "lastRecord");

        if (cookie == null) {
            cookie = new Cookie("lastRecord", "");
        }

        cookie.setValue(String.valueOf(foodNo));
        cookie.setPath("/");
        cookie.setMaxAge(60*60*24*7);
        response.addCookie(cookie);

        request.setAttribute("foodVO", service.getFood(foodNo));

        request.getRequestDispatcher("/WEB-INF/Food/foodView.jsp")
                .forward(request, response);
    }
}
