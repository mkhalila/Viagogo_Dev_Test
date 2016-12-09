package tests;

import main.Event;
import main.Location;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for all Location class methods conducted with 3 varying Locations
 */
public class LocationTest {
    private Location loc1 = new Location(0, 0);
    private Location loc2 = new Location(-1, -9999);
    private Location loc3 = new Location(9999, 1);

    @Test
    public void getX() throws Exception {
        assertEquals(0, loc1.getX());
        assertEquals(-1, loc2.getX());
        assertEquals(9999, loc3.getX());
    }

    @Test
    public void getY() throws Exception {
        assertEquals(0, loc1.getY());
        assertEquals(-9999, loc2.getY());
        assertEquals(1, loc3.getY());
    }

    @Test
    public void setAndGetEvent() throws Exception {
        Event event = new Event(loc1);

        loc1.setEvent(event);
        loc2.setEvent(event);
        loc3.setEvent(event);

        assertEquals(event, loc1.getEvent());
        assertEquals(event, loc2.getEvent());
        assertEquals(event, loc3.getEvent());
    }

}