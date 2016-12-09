package main;

/**
 * Class that represents a integer co-ordinate location in the world
 */
public class Location {
    private int x, y;
    private Event event;

    /**
     * Creates a Location (x, y)
     * @param xIn x Co-ordinate of this Location
     * @param yIn y Co-ordinate of this Location
     */
    public Location(int xIn, int yIn) {
        x = xIn;
        y = yIn;
    }

    /**
     * Gets x Co-ordinate of this Location
     * @return x Co-ordinate of this Location as integer
     */
    public int getX() {
        return x;
    }

    /**
     * Gets y Co-ordinate of this Location
     * @return y Co-ordinate of this Location as integer
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the Event at this Location to the given Event
     * @param eventIn Event object
     */
    public void setEvent(Event eventIn) {
        event = eventIn;
    }

    /**
     * Get's the Event taking place at this Location
     */
    public Event getEvent() {
        return event;
    }

    /**
     * toString method for Location object
     * @return toString of the event at this location
     */
    @Override
    public String toString() {
        return "" + event;
    }
}
