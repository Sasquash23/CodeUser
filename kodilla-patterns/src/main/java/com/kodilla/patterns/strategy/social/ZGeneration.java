package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publisher.SnapchatPublisher;

public class ZGeneration extends User {
    public ZGeneration(String name, String fullname, String nick) {
        super(name, fullname, nick);
        this.socialPublisher = new SnapchatPublisher();

    }
}