package com.busanit501.firstpractice.Food.Controller;

import com.busanit501.firstpractice.Food.Service.FoodService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "foodView", urlPatterns = "/food/view")
public class FoodView extends HttpServlet {
    private final FoodService service = FoodService.INSTANCE;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int foodNo = Integer.parseInt(request.getParameter("foodNo"));
        request.setAttribute("foodVO", service.getFood(foodNo));

        request.getRequestDispatcher("/WEB-INF/Food/foodView.jsp")
                .forward(request, response);
    }
}
