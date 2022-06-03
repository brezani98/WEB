<%@ page import="sk.kmikt.mvc.controllers.ArticleController" %>
<%@ page import="sk.kmikt.mvc.models.Article" %>
<%@ page import="java.util.ArrayList" %>
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
    <title>Články</title>
    <%@include file="../navigationBar.jsp" %>
</head>
<body>
<%
    ArticleController articleController = new ArticleController();
    ArrayList<Article> article = articleController.getAllArticles();
    UserController userController = new UserController();
%>

<% for (int i = 0; i < article.size(); i++) { %>
<div>
    <div class=" mx-auto d-flex justify-content-center col-12"
         style="width: 25rem; border-radius: 20px; margin-top: 50px; margin-bottom: 50px;">
        <h1><%=article.get(i).getTitle()%>
        </h1></div>
    <p><%=article.get(i).getContent()%>
    </p>
    <!--This is a comment. Comments are not displayed in the browser
    <p>Autor:userController.getUserById(article.get(i).getForeignId()).getName()%>
    </p>-->
    <%
        if (session.getAttribute("user") != null) {
            if (((User) session.getAttribute("user")).getId() == article.get(i).getForeignId() || ((User) session.getAttribute("user")).getId() == 1) {
    %>
    <td><a href="editArticle.jsp?id=<%=article.get(i).getId()%>" class="btn btn-outline-danger">Upraviť</a></td>
    <td><a href="/delete-article?id=<%=article.get(i).getId()%>" class="btn btn-danger">Vymazať</a></td>


    <%
            }
        }
    %>


    <hr>
</div>


<%
        ;
    }%>


</body>
</html>
