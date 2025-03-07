package com.controller;

import com.dao.OffreDao;
import com.model.Emploi;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class OffreServlet extends HttpServlet {
    private final OffreDao offreDao = new OffreDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        listEmploi(request, response);
    }

    private void listEmploi(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Emploi> emploiList = offreDao.getEmploi();

        request.setAttribute("emploiList", emploiList);
        request.getRequestDispatcher("home.jsp").forward(request, response);
        System.out.println("listEmploi");
        System.out.println(emploiList);
    }
}
