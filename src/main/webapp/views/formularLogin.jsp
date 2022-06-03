<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Prihlásenie</title>
    <%@include file="../navigationBar.jsp" %>
</head>
<body>
<div class="container-fluid">
    <div class="row justify-content-center align-item-center vh-100">
        <div class="col col-sm-6 col-md-6 col-lg-4 col-xl-3 h-100">
            <br>
            <form action="/login-user" method="post">
                <div class="form-group">
                    <label for="email">E-mail</label>
                    <input type="email" name="email" id="email" class="form-control" required>
                </div>

                <div class="form-group">
                    <label for="password">Heslo</label>
                    <input type="password" name="password" id="password" class="form-control" minlength="5" required>
                </div>
                <br>
                <br>
                <div class="form-group">
                    <input type="submit" value="Prihlásiť sa" class="btn btn-danger btn-block">
                </div>
            </form>
            <div class="container">
                <p>Nemáš účet? <a href="/views/formularRegistration.jsp">Zaregistruj sa tu</a></p>

            </div>
        </div>
    </div>
</div>
</body>
</html>