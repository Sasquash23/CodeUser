package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser {
    private final int uId;
    private  String userName;
    private char sex;
    private LocalDate birthdayDate;
    private int postsNumber;

    public ForumUser(final int uId, String userName, char sex, LocalDate birthdayDate, int postsNumber) {
        this.uId = uId;
        this.userName = userName;
        this.sex = sex;
        this.birthdayDate = birthdayDate;
        this.postsNumber = postsNumber;
    }

    public int getUId() {
        return uId;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthdayDate() {
        return birthdayDate;
    }

    public int getPostsNumber() {
        return postsNumber;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "uId=" + uId +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", birthdayDate=" + birthdayDate +
                ", postsNumber=" + postsNumber +
                '}';
    }
}
