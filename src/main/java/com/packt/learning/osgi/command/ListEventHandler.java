package com.packt.learning.osgi.command;

import java.util.Set;

import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;

@Command(scope = "eventhandler", name = "list", description = "Lists all EventHandlers.")
public class ListEventHandler extends OsgiCommandSupport {

    EventHandlerRepository repository;

    @Override
    protected Object doExecute() throws Exception {

        Set<String> filters = repository.getFilters();
        StringBuilder builder = new StringBuilder();
        builder.append("Registered EventHandler Topics\n");

        for (String filt : filters) {
            builder.append(filt);
            builder.append("\n");
        }

        System.out.println(builder.toString());
        return null;
    }

    public void setRepository(EventHandlerRepository repository) {
        this.repository = repository;
    }
}
