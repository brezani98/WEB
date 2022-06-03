<%@ page import="sk.kmikt.mvc.models.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Vytvorenie príspevku</title>
    <%@include file="../navigationBar.jsp" %>
</head>
<body>
<form action="/insert-article" method="post">
        <div class="form-group">
        <label for="title">Nadpis článku</label>
        <input type="text" class="form-control" id="title" name="title" minlength="3" maxlength="50" required>
    </div>
    <div class="form-group">
        <label for="content">Text</label>
        <input type="text" class="form-control" id="content" name="content" minlength="3" maxlength="1000" required>
    </div>

    <input type="hidden" name="foreignId" value="<%=((User)session.getAttribute("user")).getId()%>"
           required>
    <div class="form-group">
        <input type="submit" value="Vytvoriť článok" class="btn btn-danger">
    </div>
</form>
</body>
</html>