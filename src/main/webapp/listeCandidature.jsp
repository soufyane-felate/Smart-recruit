<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.dao.CandidatureDAO" %>
<%@ page import="com.model.Candidature" %>
<html>
<head>
    <title>Liste des Candidatures</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<header class="bg-primary text-white text-center py-3">
    <h1>Liste des Candidatures</h1>
</header>

<div class="container mt-4">
    <table class="table table-striped table-bordered">
        <thead class="table-dark">
        <tr>
            <th>ID Candidat</th>
            <th>ID Offre Emploi</th>
            <th>Date Candidature</th>
            <th>Statut</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <%
            CandidatureDAO candidatureDAO = new CandidatureDAO();
            List<Candidature> candidatures = candidatureDAO.getAllCandidatures();
            for (Candidature candidature : candidatures) {
        %>
        <tr>
            <td><%= candidature.getIdCandidat() %></td>
            <td><%= candidature.getIdOffreEmploi() %></td>
            <td><%= candidature.getDateCandidature() %></td>
            <td><%= candidature.getStatut() %></td>
            <td>
                <form action="updateStatus" method="post" class="d-flex gap-2">
                    <input type="hidden" name="id" value="<%= candidature.getId() %>">
                    <button type="submit" name="statut" value="En attente" class="btn btn-warning btn-sm">En attente</button>
                    <button type="submit" name="statut" value="Accepté" class="btn btn-success btn-sm">Accepter</button>
                    <button type="submit" name="statut" value="Refusé" class="btn btn-danger btn-sm">Refuser</button>
                </form>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>

    <a href="OfferServlet" class="btn btn-primary mt-3">Retour aux offres</a>
</div>

<footer class="bg-dark text-white text-center py-3 mt-4">
    <p>2025 Admin Dashboard</p>
</footer>
</body>
</html>