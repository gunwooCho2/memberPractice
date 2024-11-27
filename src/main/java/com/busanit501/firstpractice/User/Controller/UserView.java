package com.busanit501.firstpractice.User.Controller;

import com.busanit501.firstpractice.User.Serviece.UserService;
import com.busanit501.firstpractice.User.VO.UserVO;
import lombok.SneakyThrows;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@WebServlet(name = "userView", urlPatterns = "/user/userView")
public class UserView extends HttpServlet {
    private final UserService service = UserService.INSTANCE;

    @SneakyThrows
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        if (request.getParameter("userNo") == null) {
            doPost(request, response);
            return;
        }
        int userNo = Integer.parseInt(request.getParameter("userNo"));
        UserVO userVO = service.getUser(userNo);
        request.setAttribute("userVO", userVO);
        request.getRequestDispatcher("/WEB-INF/UserView.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        ArrayList<UserVO> userList;
        userList = service.getAllUsers();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("/WEB-INF/UserList.jsp")
                .forward(request, response);
    }
}
