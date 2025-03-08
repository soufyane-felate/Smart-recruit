<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, com.model.JobOffer" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .row {
            display: flex;
            flex-direction: column;
            width: 100%;
            justify-content: center;
            align-items: center;
            gap: 24px;
        }
        .col-md-4 {
            width: 600px;
        }
        .card-body {
            display: flex;
            align-items: center;
            flex-direction: column;
        }
    </style>
</head>
<body>
<header class="bg-primary text-white text-center py-3">
    <h1>Admin Dashboard</h1>
</header>

<div class="container mt-4">
    <h2 class="text-center mb-4">Job Opportunities</h2>
    <div class="row">
        <%
            List<JobOffer> offers = (List<JobOffer>) request.getAttribute("offers");
            if (offers != null) {
                for (JobOffer offer : offers) {
        %>
        <div class="col-md-4">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title"><%= offer.getTitle() %></h5>
                    <p class="card-text"><%= offer.getDescription() %></p>
                    <p class="card-text"><strong>Date:</strong> <%= offer.getDate() %></p>
                    <form method="post" action="OfferServlet">
                        <input type="hidden" name="action" value="postuler">
                        <input type="hidden" name="idCandidat" value="1">
                        <input type="hidden" name="idOffreEmploi" value="<%= offer.getId() %>">
                        <button class="btn btn-primary">Postuler</button>
                    </form>
                </div>
            </div>
        </div>
        <%
            }
        } else {
        %>
        <p>No job offers available.</p>
        <%
            }
        %>
    </div>
</div>

<footer class="bg-dark text-white text-center py-3 mt-4">
    <p>2025 Admin Dashboard</p>
</footer>
</body>
</html>
