package sk.kmikt.mvc.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sk.kmikt.mvc.controllers.ArticleController;
import sk.kmikt.mvc.models.Article;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UpdateArticleServlet", value = "/update-article")
public class UpdateArticleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




        Article article = new Article(
                Integer.parseInt(request.getParameter("id")),
                request.getParameter("title"),
                request.getParameter("content"),
                Integer.parseInt(request.getParameter("foreignId"))
        );

        ArticleController articleController = new ArticleController();
        try {
            articleController.updateArticle(article);
            response.sendRedirect("/views/listArticles.jsp");
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
    }
}
