<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.model.Role" %>
<html>
<head>
    <title>User Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <form id="myForm" action="Login" method="post">
        <div class="form-group">
            <label for="email">Email address</label>
            <input type="email" class="form-control" id="email" name="email"
                   placeholder="Enter your email" required>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" name="password"
                   placeholder="Enter your password" required>
        </div>
        <div class="form-group">
            <label>Role</label>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="role" id="candidat" value="<%=Role.CANDIDAT%>">
                <label class="form-check-label" for="candidat">Candidate</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="role" id="recruteur" value="<%=Role.RECRUTEUR%>">
                <label class="form-check-label" for="recruteur">Recruiter</label>
            </div>
            <div id="roleError" style="color: red;"></div>
        </div>
        <button type="submit" class="btn btn-primary">Login</button>
        <a href="register.jsp" class="btn btn-primary">create new account</a>


        <% if (request.getAttribute("errorMessage") != null) { %>
        <p style="color: red;"><%= request.getAttribute("errorMessage") %></p>
        <% } %>
    </form>
</div>

<script>
    document.addEventListener("DOMContentLoaded", function() {
        document.getElementById("myForm").addEventListener("submit", function(event) {
            var radios = document.getElementsByName("role");
            var selected = false;

            for (var i = 0; i < radios.length; i++) {
                if (radios[i].checked) {
                    selected = true;
                    break;
                }
            }

            if (!selected) {
                event.preventDefault();
                document.getElementById("roleError").innerText = "S'il vous plaît, sélectionnez un rôle.";
            }
        });
    });
</script>

</body>
</html>
