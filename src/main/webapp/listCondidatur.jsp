<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>

<%@ page import="java.sql.SQLException" %>
<%@ page import="com.dao.CandidatureDAO" %>
<%@ page import="com.model.Candidature" %>
<html>
<head>
    <title>Liste des Candidatures</title>
</head>
<body>
<h1>Liste des Candidatures</h1>
<table border="1">
    <tr>
        <th>ID Candidat</th>
        <th>ID Offre Emploi</th>
        <th>Date Candidature</th>
        <th>Statut</th>
        <th>Actions</th>
    </tr>
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
            <form action="updateStatus" method="post">
                <input type="hidden" name="id" value="<%= candidature.getId() %>">
                <button type="submit" name="statut" value="En attente">En attente</button>
                <button type="submit" name="statut" value="Accepté">Accepter</button>
                <button type="submit" name="statut" value="Refusé">Refuser</button>
            </form>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>