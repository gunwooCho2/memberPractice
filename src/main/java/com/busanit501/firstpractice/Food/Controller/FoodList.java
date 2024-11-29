package com.busanit501.firstpractice.Food.Controller;

import com.busanit501.firstpractice.Food.Service.FoodService;
import com.busanit501.firstpractice.Food.VO.FoodVO;
import com.busanit501.firstpractice.Utill.CookieUtil;
import com.busanit501.firstpractice.Utill.MapperUtil;
import org.modelmapper.ModelMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "foodList", urlPatterns = "/food/list")
public class FoodList extends HttpServlet {
    private final FoodService service = FoodService.INSTANCE;
    private final CookieUtil cookieUtil = CookieUtil.INSTANCE;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("foodList", service.getFoodViewDTOList());
        Cookie cookie = cookieUtil.getCookie(request.getCookies(), "lastRecord");

        if (cookie != null) {
            FoodVO foodVO = service.getFood(Integer.parseInt(cookie.getValue()));
            request.setAttribute("lastRecord", foodVO);
        }

        request.getRequestDispatcher("/WEB-INF/Food/foodList.jsp")
                .forward(request, response);
    }
}
