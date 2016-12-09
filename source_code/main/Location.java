package main;

/**
 * Class that represents a integer co-ordinate location in the world
 */
class Location {
    private int x, y;
    private Event event;

    /**
     * Creates a Location (x, y)
     * @param xIn x Co-ordinate of this Location
     * @param yIn y Co-ordinate of this Location
     */
    Location(int xIn, int yIn) {
        x = xIn;
        y = yIn;
    }

    /**
     * Gets x Co-ordinate of this Location
     * @return x Co-ordinate of this Location as integer
     */
    int getX() {
        return x;
    }

    /**
     * Gets y Co-ordinate of this Location
     * @return y Co-ordinate of this Location as integer
     */
    int getY() {
        return y;
    }

    /**
     * Sets the Event at this Location to the given Event
     * @param eventIn Event object
     */
    void setEvent(Event eventIn) {
        event = eventIn;
    }

    @Override
    public String toString() {
        return "" + event;
    }
}
