<%--
  Created by IntelliJ IDEA.
  User: MAJD
  Date: 3/6/2025
  Time: 11:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Job</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .footer{
            position: fixed;
            bottom: 0;
            width: 100%;
        }
    </style>
</head>
<body>

<header class="bg-primary text-white text-center py-3">
    <h1>Admin Dashboard</h1>
</header>

<div class="container mt-4">
    <h2 class="text-center mb-4">Add New Job</h2>
    <form action="AddJobServlet" method="post" class="mb-4">
        <div class="mb-3">
            <label for="jobTitle" class="form-label">Job Title</label>
            <input type="text" class="form-control" id="jobTitle" name="jobTitle" required>
        </div>
        <div class="mb-3">
            <label for="jobDescription" class="form-label">Job Description</label>
            <textarea class="form-control" id="jobDescription" name="jobDescription" rows="3" required></textarea>
        </div>
        <button type="submit" class="btn btn-success">Add Job</button>
    </form>
</div>

<footer class="bg-dark text-white text-center py-3 mt-4 footer">
    <p>2025 Admin Dashboard</p>
</footer>
</body>
</html>
