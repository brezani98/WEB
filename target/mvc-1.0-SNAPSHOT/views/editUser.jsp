<%@ page import="sk.kmikt.mvc.controllers.UserController" %>
<%@ page import="sk.kmikt.mvc.models.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Úprava profilu</title>
    <%@include file="../navigationBar.jsp" %>
</head>
<body>
<%UserController userController = new UserController();%>
<%int userId = ((User) session.getAttribute("user")).getId();%>
<%User user = userController.getUserById(userId);%>
<form action="/update-user" method="post">
    <div class="d-flex justify-content-center align-items-center container">
        <div class="col-md-6 col-md-offset-6">
            <div class="form-group">
                <label for="email">E-mail</label>
                <input type="text" class="form-control" id="email" name="email" value="<%=user.getEmail()%>">
            </div>
            <div class="form-group">
                <label for="password">New password</label>
                <input type="password" class="form-control" id="password" name="password" minlength="5" >
            </div>
            <div class="form-group">
                <label for="name">Name</label>
                <input type="text" class="form-control" id="name" name="name" value="<%=user.getName()%>">
            </div>
            <div class="form-group">
            </div>
            <button type="submit" class="btn btn-danger">Submit</button>
        </div>
    </div>
</form>


</body>
</html>
