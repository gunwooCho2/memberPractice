package com.busanit501.firstpractice.Food.Controller;

import com.busanit501.firstpractice.Food.Service.FoodService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "foodList", urlPatterns = "/food/list")
public class FoodList extends HttpServlet {
    private final FoodService service = FoodService.INSTANCE;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("foodList", service.getFoodViewDTOList());
        request.getRequestDispatcher("/WEB-INF/Food/foodList.jsp")
                .forward(request, response);
    }
}
