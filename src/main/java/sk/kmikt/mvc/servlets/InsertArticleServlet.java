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

@WebServlet(name = "InsertArticleServlet", value = "/insert-article")
public class InsertArticleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Article article = new Article(
                request.getParameter("title"),
                request.getParameter("content"),
                Integer.parseInt(request.getParameter("foreignId"))

        );

        try {
            if(new ArticleController().insertArticle(article) > 0) {
                response.sendRedirect("/views/listArticles.jsp");
            } else {

            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }

    }
}
