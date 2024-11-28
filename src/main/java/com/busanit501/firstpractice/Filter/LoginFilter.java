package com.busanit501.firstpractice.Filter;

import com.busanit501.firstpractice.User.DTO.RegisterDTO;
import com.busanit501.firstpractice.User.Serviece.UserService;
import com.busanit501.firstpractice.Utill.CookieUtil;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@Log4j2
@WebFilter (urlPatterns = {"/*"})
public class LoginFilter implements Filter {
    private CookieUtil cookieUtil = CookieUtil.INSTANCE;
    private UserService userService = UserService.INSTANCE;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        ArrayList<String> uris = new ArrayList<>(Arrays.asList("/user/logIn", "/user/register", "/"));
        Cookie loginCookie = cookieUtil.getCookie(request.getCookies(), "loginInfo");

        String uri = request.getRequestURI();
        if (uris.contains(uri)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        if (session.isNew()) {
            if (loginCookie != null) return;
        }

        if (session.getAttribute("loginInfo") == null) {
            if (loginCookie != null) {
                RegisterDTO registerDTO = userService.getRegDTOToUUID(loginCookie.getValue());
                if (registerDTO != null) {
                    session.setAttribute("loginInfo", registerDTO);
                    filterChain.doFilter(servletRequest, servletResponse);
                }
            }
            response.sendRedirect("/user/logIn");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse); // 정상적으로 로그인된 경우 요청 계속 처리
    }
}
