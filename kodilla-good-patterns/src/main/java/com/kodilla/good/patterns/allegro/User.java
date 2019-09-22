package com.kodilla.good.patterns.allegro;

public class User {
    private String userLogin;
    private String userName;
    private String userSurname;

    public User(String userLogin, String userName, String userSurname) {
        this.userLogin = userLogin;
        this.userName = userName;
        this.userSurname = userSurname;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserSurname() {
        return userSurname;
    }
}
