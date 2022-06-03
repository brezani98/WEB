<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en"/>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>


<nav class="navbar navbar-expand-lg navbar-dark bg-dark ">
    <a class="navbar-brand" href="../index.jsp">
        <img src="https://journalism.unr.edu/wp-content/uploads/job-manager-uploads/company_logo/2021/09/OnePlusLogo.png" width="110" height="35" alt="">
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">

            <li class="nav-item active">
                <a class="nav-link" href="../views/listArticles.jsp">Články</a>
            </li>

            <% if (session.getAttribute("user") != null) { %>
            <li class="nav-item active">
                <a class="nav-link" href="../views/formularArticle.jsp">Pridať článok</a>
            </li>


            <li class="nav-item active">
                <a class="nav-link" href="../views/listUsers.jsp">Spravovať uživateľov</a>
            </li>
            <% } %>
        </ul>

        <% if (session.getAttribute("user") != null) { %>
        <div class="navbar-nav active"  >
            <a style="color: red;" href="../views/userProfile.jsp">Profil</a>
        </div>
        &nbsp

        <div class="log out"  >
            <a style="color: white;" href="/logout-user"> Odhlásiť sa</a>
        </div>
        <% } %>

        <% if (session.getAttribute("user") == null) { %>
        <li class="navbar-nav">
            <a style="color: white;" href="../views/formularLogin.jsp" >Prihlásenie</a>
        </li>
        <% } %>
    </div>
</nav>

</body>