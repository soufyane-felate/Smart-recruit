<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, com.model.JobOffer" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<header class="bg-primary text-white text-center py-3">
    <h1>Admin Dashboard</h1>
</header>

<div class="container mt-4">
    <h2 class="text-center mb-4">Job Opportunities</h2>
    <div class="text-center mb-3">
        <a href="profile.jsp" class="btn btn-outline-primary">Profile</a>
    </div>

    <% if (request.getAttribute("successMessage") != null) { %>
    <div class="alert alert-success text-center">
        <%= request.getAttribute("successMessage") %>
    </div>
    <% } %>

    <% if (request.getAttribute("errorMessage") != null) { %>
    <div class="alert alert-danger text-center">
        <%= request.getAttribute("errorMessage") %>
    </div>
    <% } %>

    <div class="row g-3">
        <%
            List<JobOffer> offers = (List<JobOffer>) request.getAttribute("offers");
            if (offers != null && !offers.isEmpty()) {
                for (JobOffer offer : offers) {
        %>
        <div class="col-md-6 col-lg-4">
            <div class="card shadow-sm h-100">
                <div class="card-body">
                    <h5 class="card-title"><%= offer.getTitle() %></h5>
                    <p class="card-text"><%= offer.getDescription() %></p>
                    <p class="card-text"><strong>Date:</strong> <%= offer.getDate() %></p>
                    <p class="card-text"><strong>ID:</strong> <%= offer.getId() %></p>
                    <form method="post" action="OfferServlet">
                        <input type="hidden" name="action" value="postuler">
                        <input type="hidden" name="idCandidat" value="1">
                        <input type="hidden" name="idOffreEmploi" value="<%= offer.getId() %>">
                        <button type="submit" class="btn btn-primary w-100">Postuler</button>
                    </form>
                </div>
            </div>
        </div>
        <%
            }
        } else {
        %>
        <div class="col-12 text-center">
            <p class="text-muted">No job offers available.</p>
        </div>
        <%
            }
        %>
    </div>
</div>

<footer class="bg-dark text-white text-center py-3 mt-4">
    <p>&copy; 2025 Admin Dashboard</p>
</footer>
</body>
</html>