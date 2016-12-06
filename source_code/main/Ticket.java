package main;

import java.util.Random;

/**
 * A Class that represents a Ticket for an Event
 */
public class Ticket {
    //The price for the Ticket
    private double price;

    /**
     * The Constructor for a Ticket with a randomly generated price between 0 - 100
     */
    public Ticket() {
        price = 100 * new Random().nextDouble();
        System.out.println("Created a Ticket with price: " + price);
    }

    /**
     * Getter for the price of a ticket
     * @return The price of the Ticket
     */
    public double getPrice() {
        return price;
    }
}
