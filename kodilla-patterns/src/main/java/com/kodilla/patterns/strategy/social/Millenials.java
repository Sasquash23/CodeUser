package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publisher.FacebookPublisher;

public class Millenials extends User {
    public Millenials(String name, String fullname, String nick) {
        super(name, fullname, nick);
        this.socialPublisher = new FacebookPublisher();
    }
}
