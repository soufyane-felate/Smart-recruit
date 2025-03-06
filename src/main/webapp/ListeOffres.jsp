<%--
  Created by IntelliJ IDEA.
  User: Dev
  Date: 05/03/2025
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.example.model.Offre" %> <!-- Modifie ce chemin selon ta classe Offre -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Offres</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid black;
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        a {
            text-decoration: none;
            color: blue;
        }
    </style>
</head>
<body>

<h2>Liste des Offres</h2>

<table>
    <tr>
        <th>ID</th>
        <th>Titre</th>
        <th>Description</th>
        <th>Date de publication</th>
        <th>Actions</th>
    </tr>

    <%
        List<Offre> offres = (List<Offre>) request.getAttribute("offres");
        if (offres != null && !offres.isEmpty()) {
            for (Offre offre : offres) {
    %>
    <tr>
        <td><%= offre.getId() %></td>
        <td><%= offre.getTitre() %></td>
        <td><%= offre.getDescription() %></td>
        <td><%= offre.getDatePublication() %></td>
        <td>
            <a href="postuler.jsp?id=<%= offre.getId() %>">Postuler</a>
        </td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="6">Aucune offre disponible.</td>
    </tr>
    <%
        }
    %>

</table>

</body>
</html>
