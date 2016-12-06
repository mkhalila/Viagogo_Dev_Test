package main;

import java.util.ArrayList;

/**
 * Class that represents an Event. Each Event has a unique identifier
 * and a list of Ticket objects.
 */
public class Event {
    private static int eventCounter;
    private int identifier;
    private ArrayList<Ticket> tickets;
}
