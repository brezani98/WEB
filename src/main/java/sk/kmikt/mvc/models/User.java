package sk.kmikt.mvc.models;

public class User {
    int id;
    String email;
    String password;
    String name;
    boolean blocked;

    public User(int id, String email, String password, String name, Boolean blocked) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.blocked = blocked;
    }
    public User(int id, String email, String password, String name) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public User(String email, String password, String name, Boolean blocked) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.blocked = blocked;
    }

    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
