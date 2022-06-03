package sk.kmikt.mvc.servlets;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sk.kmikt.mvc.controllers.UserController;
import sk.kmikt.mvc.models.User;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UpdateUserServlet", value = "/update-user")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hashPassword = BCrypt.withDefaults().hashToString(
                12, request.getParameter("password").toCharArray()
        );
        User user = new User(
                request.getParameter("email"),
                hashPassword,
                request.getParameter("name")
        );
        UserController userController = new UserController();
        try {
            userController.updateUser(user);
            response.sendRedirect("/views/userProfile.jsp");
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
    }
}