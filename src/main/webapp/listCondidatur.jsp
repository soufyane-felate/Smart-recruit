<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, com.model.Candidature" %>

<html>
<head>
    <title>List Candidatures</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<header class="bg-primary text-white text-center py-3">
    <h1>Liste des Candidatures</h1>
</header>

<div class="container mt-4">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID Candidat</th>
            <th>ID Offre Emploi</th>
            <th>Date de Candidature</th>
            <th>Statut</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Candidature> candidatures = (List<Candidature>) request.getAttribute("candidatures");
            if (candidatures != null) {
                for (Candidature candidature : candidatures) {
        %>
        <tr>
            <td><%= candidature.getIdCandidat() %></td>
            <td><%= candidature.getIdOffreEmploi() %></td>
            <td><%= candidature.getDateCandidature() %></td>
            <td><%= candidature.getStatut() %></td>
            <td>
                <form method="post" action="UpdateStatusServlet">
                    <input type="hidden" name="id" value="<%= candidature.getId() %>">
                    <button type="submit" name="status" value="En attente" class="btn btn-warning">En attente</button>
                    <button type="submit" name="status" value="Accepté" class="btn btn-success">Accepté</button>
                    <button type="submit" name="status" value="Refusé" class="btn btn-danger">Refusé</button>
                </form>
            </td>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="5" class="text-center">Aucune candidature disponible.</td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>

<footer class="bg-dark text-white text-center py-3 mt-4">
    <p>2025 Admin Dashboard</p>
</footer>

</body>
</html>
