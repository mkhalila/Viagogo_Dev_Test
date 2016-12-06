package main;

import java.util.ArrayList;

/**
 * Class that represents a World containing Events at integer co-ordinate locations
 */
public class World {
    //X axis of world dimension e.g. -10 to 10
    private Range xRange;
    //Y axis of world dimension e.g. -10 to 10
    private Range yRange;
    //List of events in this World
    private ArrayList<Event> events;

    public World(Range xRangeIn, Range yRangeIn) {

    }
}
