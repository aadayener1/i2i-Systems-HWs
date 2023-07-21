package org.example;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class ReceiverActor extends AbstractActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, message -> {
                    log.info("Received message: {}", message);

                    // Send a message back to the sender actor in akkaDemo1
                    getSender().tell("Hi from Actor2", getSelf());
                })
                .build();
    }
}



