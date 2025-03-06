<%@ page import="com.model.User" %>
<%
  User user = (User) session.getAttribute("role");
  if (user == null) {
    response.sendRedirect("login.jsp");
    return;
  }
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Candidate Profile</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5">
  <div class="card shadow">
    <div class="card-header bg-primary text-white">
      <h3 class="text-center">Candidate Profile</h3>
    </div>
    <div class="card-body">
      <form>
        <div class="mb-3">
          <h1>Email : <%= user.getEmail() %></h1>
        </div>
        <div class="d-flex justify-content-between">
          <button type="button" class="btn btn-success">Update</button>
          <button type="button" class="btn btn-danger">Delete Account</button>
          <form action="logout" method="post">
            <button type="submit" class="btn btn-secondary">Logout</button>

          </form>
        </div>
      </form>
    </div>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>