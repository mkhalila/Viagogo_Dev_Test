package main;

import java.util.ArrayList;
import java.util.Random;

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
        System.out.println("Created an Event with ID: " + identifier
        + " and " + tickets.size() + " tickets");
    }

    //Assigns ID for this Event
    private void assignID() {
        //Increments eventCounter then assigns ID of this Event
        identifier = ++eventCounter;
    }

    //Generate tickets for this Event
    private void generateTickets() {
        //Initialise Tickets list
        tickets = new ArrayList<>();

        //Ensures that an Event has at least one Ticket
        tickets.add(new Ticket());

        //Generates up to 4 more Tickets for this Event
        for (int i = 0; i < new Random().nextInt(5); ++i) {
            tickets.add(new Ticket());
        }
    }
}
