package com.busanit501.firstpractice.Filter;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Log4j2
@WebFilter (urlPatterns = {"/user/*"})
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("doFilter ,/todo/* 하위로 들어오는 모든 url 에 대해서 로그인 체크함");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        String uri = request.getRequestURI();
        if (uri.equals("/user/logIn") || uri.equals("/user/register")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        if (session.isNew()) {
            response.sendRedirect("/user/register");
            return;
        }
        if (session.getAttribute("loginInfo") == null) {
            response.sendRedirect("/user/logIn");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse); // 정상적으로 로그인된 경우 요청 계속 처리
    }
}
