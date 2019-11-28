package cn.hwj.domain;

public class User {
    private int id;
    private String username;
    private  String password;

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }



    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }
}
