package main;

import java.util.ArrayList;

/**
 * Class that represents an Event. Each Event has a unique identifier
 * and a list of Ticket objects.
 */
public class Event {
    //Static counter for the number of Events that have been constructed
    private static int eventCounter;
    //Unique identifier for each Event instance
    private int identifier;
    //List of all the Ticket types for this event
    private ArrayList<Ticket> tickets;

    /**
     * Constructor for an Event: assigns unique id,
     * and creates a a random no. of Tickets
     */
    public Event() {
        assignID();
        generateTickets();
    }

    private void assignID() {
    }

    private void generateTickets() {
    }
}
