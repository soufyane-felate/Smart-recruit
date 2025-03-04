<%--
  Created by IntelliJ IDEA.
  User: oucht
  Date: 3/3/2025
  Time: 12:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="AddCandidat" method="post">
    <div class="form-group">
        <input type="text" class="form-control" id="nom" name="nom" placeholder="Entrez votre nom">
    </div>

    <div class="form-group">
        <input type="email" class="form-control" id="email" name="email" placeholder="Enterez votre email">
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
