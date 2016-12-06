package main;

/**
 * A Class that represents a Ticket for an Event
 */
public class Ticket {
    //The price for the Ticket
    private double price;

    /**
     * The Constructor for a Ticket.
     * @param priceIn Initialises price of this Ticket
     */
    public Ticket(double priceIn) {
        price = priceIn;
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
