package sk.kmikt.mvc.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sk.kmikt.mvc.controllers.ArticleController;
import sk.kmikt.mvc.models.User;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteArticleServlet", value = "/delete-article")
public class DeleteArticleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArticleController articleController = new ArticleController();
        try {
            articleController.deleteArticleById(Integer.parseInt(request.getParameter("id")));
            HttpSession session = request.getSession();
            int userId = ((User)session.getAttribute("user")).getId();
            response.sendRedirect("/views/listArticles.jsp");
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
    }
}
