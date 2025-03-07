package com.controller;

import com.model.Role;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);

        String requestURI = httpRequest.getRequestURI();

        // Pages accessible without authentication
        if (requestURI.endsWith("login.jsp") || requestURI.endsWith("register.jsp") ||
                requestURI.endsWith("login") || requestURI.endsWith("AddUser")) {
            chain.doFilter(request, response);

            return;
        }

        if (session == null || session.getAttribute("role") == null) {
            // Redirect to the login page if the user is not authenticated
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
            return;
        }

        String role = (String) session.getAttribute("role");

        if (Role.CANDIDAT.equals(role)) {
            if (!requestURI.endsWith("home.jsp")) {
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/home.jsp");
                return;
            }
        }

        if (Role.RECRUTEUR.equals(role)) {
            chain.doFilter(request, response);
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}