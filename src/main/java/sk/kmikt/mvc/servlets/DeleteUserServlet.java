package sk.kmikt.mvc.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sk.kmikt.mvc.controllers.UserController;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteUserServlet", value = "/delete-user")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int isDelete = new UserController().deleteUserById(Integer.parseInt(request.getParameter("id")));
            if(isDelete > 0) {
                response.sendRedirect("/views/listUsers.jsp");
            } else {
                System.out.println("User NOT updated");
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
    }
}