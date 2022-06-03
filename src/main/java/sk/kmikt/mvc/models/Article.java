package sk.kmikt.mvc.models;

public class Article {
    private int id;
    private String title;
    private String content;
    private int foreignId;

    public Article(int id, String title, String content, int foreignId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.foreignId = foreignId;
    }

    public Article(String title, String content, int foreignId) {
        this.title = title;
        this.content = content;
        this.foreignId = foreignId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getForeignId() {
        return foreignId;
    }

    public void setForeignId(int foreignId) {
        this.foreignId = foreignId;
    }
}
