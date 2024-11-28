package com.busanit501.firstpractice.Food.Controller;

import com.busanit501.firstpractice.Food.DTO.FoodDTO;
import com.busanit501.firstpractice.Food.Service.FoodService;
import com.busanit501.firstpractice.User.DTO.RegisterDTO;
import com.busanit501.firstpractice.User.Serviece.UserService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@WebServlet (name = "foodInsert", urlPatterns = "/food/insert")
public class FoodInsert extends HttpServlet {
    private final UserService service = UserService.INSTANCE;
    private final FoodService foodService = FoodService.INSTANCE;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RegisterDTO registerDTO = (RegisterDTO) request.getSession().getAttribute("loginInfo");
        request.setAttribute("userName", registerDTO.getUserName());
        request.getRequestDispatcher("/WEB-INF/Food/foodInput.jsp")
                .forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RegisterDTO registerDTO = (RegisterDTO) request.getSession().getAttribute("loginInfo");
        String userName = registerDTO.getUserName();

        if (userName == null) {
            request.getRequestDispatcher("/user/logout").forward(request, response);
            return;
        }

        if (service.isUserName(userName)){
            String foodName = request.getParameter("foodName");
            String foodExplain = request.getParameter("foodExplain");

            foodService.insertFood(new FoodDTO(foodName, foodExplain, userName));
            response.sendRedirect("/food/list");
        }
        else request.getRequestDispatcher("/user/logout").forward(request, response);
    }
}
