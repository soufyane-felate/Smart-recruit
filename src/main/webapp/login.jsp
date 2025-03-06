<%@ page import="com.model.Role" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Connexion</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container py-5">
    <h1 class="text-center mb-4">Login</h1>

    <div id="validate" class="text-danger fw-bold text-center"></div>

    <form id="login" action="Login" method="post" class="needs-validation" novalidate>
        <div class="mb-3">
            <label for="email" class="form-label">Address Email </label>
            <input type="email" class="form-control" id="email" name="email" placeholder="Enter your email" required>
            <div class="invalid-feedback">Veuillez entrer une adresse email valide.</div>
        </div>

        <div class="mb-3">
            <label for="password" class="form-label">Mot de passe</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Enter your password" required>
            <div class="invalid-feedback">Le mot de passe est obligatoire.</div>
        </div>

        <div class="mb-3">
            <label class="form-label">Role</label>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="role" id="candidate" value="<%= Role.CANDIDAT.toString() %>" required>
                <label class="form-check-label" for="candidate">Candidat</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="role" id="recruiter" value="<%= Role.RECRUTEUR.toString() %>" required>
                <label class="form-check-label" for="recruiter">Recruteur</label>
            </div>
            <div class="invalid-feedback">Veuillez sélectionner un rôle.</div>
        </div>

        <div class="d-flex justify-content-between align-items-center">
            <button type="submit" class="btn btn-primary">Login</button>
            <a href="register.jsp" class="text-decoration-none">Je n'ai pas de compte</a>
        </div>
    </form>
</div>

<script>
    (function () {
        'use strict';
        const form = document.querySelector('#login');
        const validate = document.querySelector('#validate');

        form.addEventListener('submit', function (event) {
            if (!form.checkValidity()) {
                event.preventDefault();
                event.stopPropagation();
                validate.innerHTML = 'tous les champs obligatoires';
            } else {
                validate.innerHTML = '';
            }
            form.classList.add('was-validated');
        });
    })();
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
