package sk.kmikt.mvc.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sk.kmikt.mvc.controllers.UserController;
import sk.kmikt.mvc.models.User;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/login-user")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("email");
        String password = request.getParameter("password");


        User userInput = new User(login, password, ""); // novy konstruktor
        try {
            User user = new UserController().loginUser(userInput);
            if (user != null) {
                if (!user.isBlocked()) {
                    // User has correct email and password
                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);
                    response.sendRedirect("/views/listArticles.jsp");
                } else {
                    response.sendRedirect("../blocked.jsp");
                }
            } else {
                // Email or password is wrong
                response.sendRedirect("/views/formularLogin.jsp");
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
    }
}
