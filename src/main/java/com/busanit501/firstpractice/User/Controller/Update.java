package com.busanit501.firstpractice.User.Controller;

import com.busanit501.firstpractice.User.DTO.RegisterDTO;
import com.busanit501.firstpractice.User.Serviece.UserService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "update", urlPatterns = "/user/update")
@Log4j2
public class Update extends HttpServlet {
    private final UserService service = UserService.INSTANCE;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("userNo", request.getParameter("userNo"));
        request.getRequestDispatcher("/WEB-INF/UserUpdate.jsp")
                .forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userNo = Integer.parseInt(request.getParameter("userNo"));
        String userID = request.getParameter("userID");
        String password = request.getParameter("userPassword");
        String userName = request.getParameter("userName");

        RegisterDTO registerDTO = new RegisterDTO(userID, password, userName);
        String guide = service.duplicatesCheck(registerDTO);

        if (!guide.isEmpty()) {
            request.setAttribute("error", guide);
            doGet(request, response);
            return;
        }
        service.updateUser(userNo, registerDTO);
        request.getRequestDispatcher("/user/userView")
                .forward(request, response);
    }
}
