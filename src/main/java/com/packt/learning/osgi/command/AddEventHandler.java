package com.packt.learning.osgi.command;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;

@Command(scope = "eventhandler", name = "add", description = "Adds an event listener.")
public class AddEventHandler extends OsgiCommandSupport {

    @Argument(index = 0, name = "filter",
        description = "The event topic to listen to (*, org/apache/karaf, org/apache/karaf/*, org/apache/karaf/log,"
            + "org.apache/karaf/log2) only one handler per topic will be created. The filter is space separated",
        required = true, multiValued = false)
    String filter;
    EventHandlerRepository repository;

    @Override
    protected Object doExecute() throws Exception {
        repository.addEvent(filter);
        return null;
    }

    public void setRepository(EventHandlerRepository repository) {
        this.repository = repository;
    }
}
