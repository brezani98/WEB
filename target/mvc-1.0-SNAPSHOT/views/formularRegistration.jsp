<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <%@include file="../navigationBar.jsp" %>
    <title>Registrácia</title>
</head>
<body>
<form action="/insert-user" method="post">
    <div class="d-flex justify-content-center align-items-center container">
        <div class="col-md-6 col-md-offset-6">
            <br>
            <div class="form-group">
                <label for="email">E-mail</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="password">Heslo</label>
                <input type="password" class="form-control" id="password" name="password" minlength="5" placeholder="min. dĺžka 5 znakov" prequired>
            </div>
            <div class="form-group">
                <label for="name">Meno</label>
                <input type="text" class="form-control" id="name" name="name" required>
            </div>
            <br>
            <br>
            <div class="form-group">
            </div>
            <button type="submit" class="btn btn-danger btn-block">Registrovať sa</button>
        </div>
    </div>
</form>

</body>
</html>