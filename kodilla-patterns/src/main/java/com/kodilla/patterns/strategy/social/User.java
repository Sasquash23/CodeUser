package com.kodilla.patterns.strategy.social;

import java.util.Objects;

public class User {
    private String name;
    private String fullname;
    private String nick;
    protected SocialPublisher socialPublisher;

    public User(String name, String fullname, String nick) {
        this.name = name;
        this.fullname = fullname;
        this.nick = nick;
    }

    public String sharePost(){
        return socialPublisher.share();
    }

    public void setPublisherStrategy(SocialPublisher socialPublisher) {
        this.socialPublisher = socialPublisher;
    }

    public String getName() {
        return name;
    }

    public String getFullname() {
        return fullname;
    }

    public String getNick() {
        return nick;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(fullname, user.fullname) && Objects.equals(nick, user.nick);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, fullname, nick);
    }
}
