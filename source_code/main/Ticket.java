package main;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * A Class that represents a Ticket for an Event
 */
class Ticket {
    //The price for the Ticket
    private double price;

    /**
     * The Constructor for a Ticket with a randomly generated price between 0 - 100
     */
    Ticket() {
        //Generates random price between 0-100 and converts it to 2 decimal places
        DecimalFormat priceFormat = new DecimalFormat("###.##");
        price = Double.valueOf(priceFormat.format(100 * new Random().nextDouble()));
    }

    /**
     * Getter for the price of a ticket
     * @return The price of the Ticket
     */
    double getPrice() {
        return price;
    }

    /**
     * toString method for Ticket, returns price of Ticket
     * @return String representing this object
     */
    @Override
    public String toString() {
        return "" + price;
    }
}
