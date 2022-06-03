package sk.kmikt.mvc.controllers;

import sk.kmikt.mvc.Database;
import sk.kmikt.mvc.models.Article;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ArticleController {

    public int insertArticle(Article article) throws SQLException, NamingException {
        Connection connection = Database.getConnection();

        String sql = "INSERT INTO articles (title, content, foreignId) VALUES (?, ?, ?);";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, article.getTitle());
        preparedStatement.setString(2, article.getContent());
        preparedStatement.setInt(3, article.getForeignId());
        return preparedStatement.executeUpdate();
    }

    public void updateArticle(Article article) throws SQLException, NamingException {
        Connection connection = Database.getConnection();
        String sql = "UPDATE articles SET title = ?, content = ? WHERE id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, article.getTitle());
        preparedStatement.setString(2, article.getContent());
        preparedStatement.setInt(3, article.getId());
        preparedStatement.executeUpdate();
        connection.close();
    }

    public void deleteArticleById(int id_) throws SQLException, NamingException {
        Connection connection = Database.getConnection();
        String sql = "DELETE FROM articles WHERE id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id_);
        preparedStatement.executeUpdate();
        connection.close();
    }

    public Article getArticleById(int id_) throws SQLException, NamingException {
        Article article = null;
        Connection connection = Database.getConnection();
        String sql = "SELECT * FROM articles WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id_);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            article = new Article(
                    resultSet.getInt("id"),
                    resultSet.getString("title"),
                    resultSet.getString("content"),
                    resultSet.getInt("foreignId")

            );
        }
        connection.close();
        return article;
    }


    public ArrayList<Article> getArticlesByUser(int userId_) throws SQLException, NamingException {
        ArrayList<Article> articles = new ArrayList<>();
        Connection connection = Database.getConnection();
        String sql = "SELECT * FROM articles WHERE userId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, userId_);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            articles.add(new Article(
                    resultSet.getInt("id"),
                    resultSet.getString("title"),
                    resultSet.getString("content"),
                    resultSet.getInt("foreignId")

            ));
        }
        connection.close();
        return articles;
    }

    public ArrayList<Article> getAllArticles() throws SQLException, NamingException {
        ArrayList<Article> articles = new ArrayList<>();
        Connection connection = Database.getConnection();
        String sql = "SELECT * FROM articles ORDER BY id DESC";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            articles.add(new Article(
                    resultSet.getInt("id"),
                    resultSet.getString("title"),
                    resultSet.getString("content"),
                    resultSet.getInt("foreignId")
            ));
        }
        connection.close();
        return articles;
    }

}
