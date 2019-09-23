package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publisher.TwitterPublisher;

public class YGeneration extends User {
    public YGeneration(String name, String fullname, String nick) {
        super(name, fullname, nick);
        this.socialPublisher = new TwitterPublisher();
    }
}
