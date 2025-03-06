package com.controller;

import com.dao.DBConnection;
import com.model.Role;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebFilter("/*")
public class Authentication implements Filter {

        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                throws IOException, ServletException {

            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;

            HttpSession session = req.getSession(false);
            if (session == null || session.getAttribute("Role") == null) {
                res.sendRedirect(req.getContextPath() + "/login.jsp");
            }

        }

        public void destroy() {}
    }
