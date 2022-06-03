<%@ page import="sk.kmikt.mvc.controllers.UserController" %>
<%@ page import="sk.kmikt.mvc.models.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Uživatelia</title>
    <%@include file="../navigationBar.jsp" %>
</head>
<body>

<%
    UserController userController = new UserController();
    ArrayList<User> users = userController.getAllUsers();
   if (((User)session.getAttribute("user")).getId() == 1){
%>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Email</th>
        <th scope="col">Meno</th>
        <th scope="col">Vymazať uživateľa</th>
        <th scope="col">Blokovať uživateĺa</th>
    </tr>
    </thead>
    <tbody>
    <%
        for(User user : users){
    %>
    <tr>
        <td><%=user.getId()%></td>
        <td><%=user.getEmail()%></td>
        <td><%=user.getName()%></td>
        <td>
            <a href="/delete-user?id=<%=user.getId()%>">Vymazať</a>
        </td>
        <td>
            <% if(user.isBlocked()){ %>
            <a href="/block-user?id=<%=user.getId()%>">Unblock</a>
            <% }else{%>
            <a href="/block-user?id=<%=user.getId()%>">Block</a>

            <%}%>


        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<%
    }
%>

</body>
</html>
