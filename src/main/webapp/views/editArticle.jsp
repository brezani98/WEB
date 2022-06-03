<%@ page import="sk.kmikt.mvc.controllers.ArticleController" %>
<%@ page import="sk.kmikt.mvc.models.Article" %>
<%@ page import="sk.kmikt.mvc.models.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Úprava článku</title>
    <%@include file="../navigationBar.jsp" %>
</head>
<body>

<%
    ArticleController articleController = new ArticleController();
    Article article = articleController.getArticleById(Integer.parseInt(request.getParameter("id")));
    System.out.println("eze");
%>
<form action="/update-article" method="post">
    <div class="d-flex justify-content-center align-items-center container">
        <div class="col-md-6 col-md-offset-6">
            <input type="hidden" name="id" value="<%=article.getId()%>">
            <div class="form-group">
                <label for="title">Nadpis článku</label>
                <input type="text" class="form-control" id="title" name="title" minlength="3" maxlength="50" value="<%=article.getTitle()%>">
            </div>
            <div class="form-group">
                <label for="content">Text</label>
                <input type="text" class="form-control" id="content" name="content" minlength="3" maxlength="1000" value="<%=article.getContent()%>">
            </div>
        </div>
    </div>

    </div>
    <input type="hidden" name="foreignId" value="<%=((User)session.getAttribute("user")).getId()%>">
    <div class="form-group"></div>

    <button type="submit" class="btn btn-danger">Submit</button>

</form>


</body>
</html>
