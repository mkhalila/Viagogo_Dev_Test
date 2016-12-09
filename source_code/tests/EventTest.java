package tests;

import main.Event;
import main.Location;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for Event class
 */
public class EventTest {
    private Location loc1 = new Location(5, 3);
    private Location loc2 = new Location(-1, 4);
    private Event event1 = new Event(loc1);
    private Event event2 = new Event(loc2);

    /**
     * Ensures that correct location of Event is retrieved
     * @throws Exception
     */
    @Test
    public void getLocation() throws Exception {
        assertEquals(loc1, event1.getLocation());
        assertEquals(loc2, event2.getLocation());
    }

    /**
     * Ensures that 2 consecutively constructed Events have an identifier that
     * is only 1 different from each other
     * @throws Exception
     */
    @Test
    public void getIdentifier() throws Exception {
        assertEquals(1, event2.getIdentifier() - event1.getIdentifier());
    }

}