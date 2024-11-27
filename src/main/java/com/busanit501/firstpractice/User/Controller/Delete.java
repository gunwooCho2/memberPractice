package com.busanit501.firstpractice.User.Controller;

import com.busanit501.firstpractice.User.Serviece.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "delete", urlPatterns = "/user/delete")
public class Delete extends HttpServlet {
    private final UserService service = UserService.INSTANCE;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userNo = Integer.parseInt(request.getParameter("userNo"));
        service.deleteUser(userNo);
        request.getRequestDispatcher("/user/userView")
                .forward(request, response);
    }
}
