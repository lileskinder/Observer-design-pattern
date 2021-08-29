package com.company.model;

import com.company.interfaces.Observer;
import com.company.interfaces.Subject;

public class EmailTOpicSubscriber implements Observer {
    private String name;

    private Subject topic;

    public EmailTOpicSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        String message = (String) topic.getUpdate(this);
        if (message == null) {
            System.out.println(name + " no new message on this topic!");
        } else {
            System.out.println(name + " retrieving message " + message);
        }
    }

    @Override
    public void setSubject(Subject subject) {
        this.topic = subject;
    }
}
