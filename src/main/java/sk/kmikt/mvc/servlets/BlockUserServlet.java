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

@WebServlet(name = "BlockUserServlet", value = "/block-user")
public class BlockUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UserController us = new UserController();
            us.blockUserById(Integer.parseInt(request.getParameter("id")));
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/views/listUsers.jsp");
    }
}