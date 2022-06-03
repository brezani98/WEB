<%@ page import="at.favre.lib.crypto.bcrypt.BCrypt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Hash</title>
</head>
<body>
  <%
    String password = "1234";
    String password2 = "987";
    String bcryptHashString =
            BCrypt.withDefaults().hashToString(
                    12, password.toCharArray()
            );
    boolean result =
            BCrypt.verifyer().verify(
                    password.toCharArray(),
                    bcryptHashString).verified;

    if (result) {
      session.setAttribute("isLogin", result);
    }
  %>
  <p>Plain text password: <%=password%></p>
  <p>Hash from password: <%=bcryptHashString%></p>
  <p>Is password correct: <%=result%></p>
</body>
</html>