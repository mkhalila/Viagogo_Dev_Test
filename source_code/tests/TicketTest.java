package tests;

import main.Ticket;
import org.junit.Test;

import java.text.DecimalFormat;

import static org.junit.Assert.*;

/**
 * Test to see if a Ticket has a randomly generated price to 2 decimal places
 */
public class TicketTest {
    Ticket ticket = new Ticket();

    @Test
    public void getPrice() throws Exception {
        DecimalFormat df = new DecimalFormat(".##");
        //Price formatted to 2 decimal places again
        double price = Double.valueOf(df.format(ticket.getPrice()));

        //Checks if pre and post formatted values are same
        assertEquals(price, ticket.getPrice());
    }

}