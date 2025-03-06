<%@ page import="com.model.Role" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Registration</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container py-5">
    <h1 class="text-center mb-4">User Registration</h1>
    <form id="registrationForm" action="AddUser" method="post" class="needs-validation" novalidate>

        <div class="mb-3">
            <label for="name" class="form-label">Nom</label>
            <input type="text" class="form-control" id="name" name="nom" placeholder="Enter your name" required>
            <div class="invalid-feedback">Veuillez indiquer votre nom.</div>
        </div>

        <div class="mb-3">
            <label for="email" class="form-label">Address Email </label>
            <input type="email" class="form-control" id="email" name="email" placeholder="Enter your email" required>
            <div class="invalid-feedback">S'il vous plait, mettez une adresse email valide.</div>
        </div>

        <div class="mb-3">
            <label for="password" class="form-label">Mot de passe</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Enter your password" required minlength="6">
            <div class="invalid-feedback">Le mot de passe doit comporter au moins 6 caracteres.</div>
        </div>

        <div class="mb-3">
            <label class="form-label">Role</label>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="role" id="candidate" value="<%=Role.CANDIDAT%>" required>
                <label class="form-check-label" for="candidate">Candidate</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="role" id="recruiter" value="<%=Role.RECRUTEUR%>" required>
                <label class="form-check-label" for="recruiter">Recruiter</label>
            </div>
            <div class="invalid-feedback">Please select a role.</div>
        </div>

        <div class="d-flex justify-content-between align-items-center">
            <button type="submit" class="btn btn-primary">Register</button>
            <a href="login.jsp" class="text-decoration-none">J'ai un compte</a>
        </div>
    </form>
</div>

<script>
    (function () {
        'use strict';
        const forms = document.querySelectorAll('.needs-validation');
        Array.from(forms).forEach(function (form) {
            form.addEventListener('submit', function (event) {
                if (!form.checkValidity()) {
                    event.preventDefault();
                    event.stopPropagation();
                }
                form.classList.add('was-validated');
            }, false);
        });
    })();
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
