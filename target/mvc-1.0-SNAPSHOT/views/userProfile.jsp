<%@ page import="sk.kmikt.mvc.models.User" %>
<%@ page import="sk.kmikt.mvc.controllers.UserController" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Profil</title>
    <%@include file="../navigationBar.jsp" %>
</head>
<body>
<%
    User user = new UserController().getUserById(((User) session.getAttribute("user")).getId());
%>

    <div class="card-body">
        <h5 class="card-title"><%=user.getName()%>
        </h5>
    </div>
    <ul class="list-group list-group-flush">
        <li class="list-group-item">E-mail: <%=user.getEmail()%></li>
    </ul>
    <div class="card-body"> <a class="btn btn-outline-secondary btn-lg" href="editUser.jsp" role="button">Upraviť profil</a> </div>
<%if (user.getEmail() =="brezani20@stud.uniza.sk"){ %>

<div class="card-body">
    <a class="btn btn-outline-secondary btn-lg" href="../views/listUsers.jsp" role="button">Spravovať používateľov</a></div>


<%}%>


</body>
</html>
