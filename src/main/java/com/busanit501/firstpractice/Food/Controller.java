package com.busanit501.firstpractice.Food;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet (name = "foodList", urlPatterns = "/food/list")
public class Controller extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<FoodDTO> foodlist = FoodServiece.INSTANCE.listAll();
        request.setAttribute("foodList", foodlist);
        request.getRequestDispatcher("/WEB-INF/Food.jsp")
                .forward(request, response);
    }
}
