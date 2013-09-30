package com.packt.learning.osgi.command;

import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

public class EventDisplayer implements EventHandler {

    @Override
    public void handleEvent(Event event) {

        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        builder.append("### Event received ###");
        builder.append("\n");
        builder.append(event.getTopic());
        for (String property : event.getPropertyNames()) {
            builder.append(property);
            builder.append("->");
            builder.append(event.getProperty(property));
            builder.append("\n");
        }
        System.out.println(builder.toString());
    }
}
