package com.company;

import com.company.interfaces.Observer;
import com.company.model.EmailTOpicSubscriber;
import com.company.model.EmailTopic;

public class Main {

    public static void main(String[] args) {
        EmailTopic topic = new EmailTopic();

        //create observers
        Observer firstObserver = new EmailTOpicSubscriber("First Observer");
        Observer secondObserver = new EmailTOpicSubscriber("second Observer");
        Observer thirdObserver = new EmailTOpicSubscriber("third Observer");

        //Register Observers
        topic.register(firstObserver);
        topic.register(secondObserver);
        topic.register(thirdObserver);

        //Attaching observers to subject
        firstObserver.setSubject(topic);
        secondObserver.setSubject(topic);
        thirdObserver.setSubject(topic);

        //check for updates
        firstObserver.update();
        thirdObserver.update();

        //provider/ subject (broadcaster)
        topic.postMessage("Hello Subscribers");

        topic.unRegister(firstObserver);

        topic.postMessage("Hello Subscribers, after unsubscribing the first observer");

    }
}
