<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .row{
            display: flex;
            flex-direction: column;
            width: 100%;
            justify-content: center;
            align-items: center;
            gap: 24px;
        }
        .col-md-4{
            width: 600px;
        }
        .card-body{
            display: flex;
            align-items: center;
            flex-direction: column;
        }
    </style>
</head>
<body>
<h1>Hello I'm home!</h1>
<header class="bg-primary text-white text-center py-3">
    <h1>Admin Dashboard</h1>
</header>

<div class="container mt-4">
    <h2 class="text-center mb-4">Job Opportunities</h2>
    <div class="row">
        <div class="col-md-4">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Software Engineer</h5>
                    <p class="card-text">description</p>
                    <a href="#"><button class="btn btn-primary">postule</button></a>
                </div>
            </div>
        </div>
    </div>
</div>

<footer class="bg-dark text-white text-center py-3 mt-4">
    <p>2025 Admin Dashboard</p>
</footer>
</body>
</html>
