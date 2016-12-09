package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class that represents a World containing Locations (which contain Events) at integer co-ordinate locations
 * World contains Locations, and Locations contain Events: This was done to make the code scalable
 * E.g. If requirements change and multiple events take place at a single location
 */
public class World {
    //X axis of world dimension e.g. -10 to 10
    private Range xRange;
    //Y axis of world dimension e.g. -10 to 10
    private Range yRange;
    //List of locations in this World
    private ArrayList<Location> locations;

    /**
     * Constructor for a World object. Initialises size of world, and generates the Locations
     * @param xMin Minimum x dimension value
     * @param xMax Maximum x dimension value
     * @param yMin Minimum y dimension value
     * @param yMax Maximum y dimension value
     */
    public World(int xMin, int xMax, int yMin, int yMax) {
        //Resets no. of Events created to 0
        Event.resetEventCounter();

        initWorldSize(new Range(xMin, xMax), new Range(yMin, yMax));
        generateLocations();
    }

    //Sets values of world size
    private void initWorldSize(Range xRangeIn, Range yRangeIn) {
        xRange = xRangeIn;
        yRange = yRangeIn;
    }

    //Generates random locations in the world
    private void generateLocations() {
        //Initialise Locations list
        locations = new ArrayList<>();

        //Generates locations for this World - 0 to the maximum no. of locations in the world
        for (int i = 0; i < new Random().nextInt(calculateMaxLocations()); ++i) {
            Location newLoc = new Location(generateLocation().getX(), generateLocation().getY());
            newLoc.setEvent(new Event(newLoc));
            locations.add(newLoc);
        }
    }

    //Calculates no. of locations in the world
    private int calculateMaxLocations() {
        return xRange.rangeSize() * yRange.rangeSize();
    }

    //Generates a unused location
    private Location generateLocation() {
        //Generate a random x co-ord within x range of world
        int xLoc = ThreadLocalRandom.current().nextInt(xRange.getMin(), xRange.getMax() + 1);
        //Generate a random y co-ord within y range of world
        int yLoc = ThreadLocalRandom.current().nextInt(yRange.getMin(), yRange.getMax() + 1);

        //Keep generating a new location until a free location is found
        while (!isLocationUnused(xLoc, yLoc)) {
            xLoc = ThreadLocalRandom.current().nextInt(xRange.getMin(), xRange.getMax() + 1);
            yLoc = ThreadLocalRandom.current().nextInt(yRange.getMin(), yRange.getMax() + 1);
        }

        //Return the unused location
        return new Location(xLoc, yLoc);
    }

    //Returns true if given location hasn't been generated before
    private boolean isLocationUnused(int xLoc, int yLoc) {
        //Loop over all current locations
        for (Location location : locations) {
            //Check if generated location is the same as any event's location and if it is return false
            if (xLoc == location.getX() && yLoc == location.getY()) {
                return false;
            }
        }
        //No current location in the world has this location
        return true;
    }

    /**
     * Determines the distance between 2 locations
     * @param loc1 from location as Location
     * @param loc2 to location as Location
     * @return Manhattan distance between the 2 provided locations
     */
    public int manhatDistance(Location loc1, Location loc2) {
        //Manhattan distance = |(x1 - x2)| + |(y1 - y2)|
        return Math.abs(loc1.getX() - loc2.getX()) + Math.abs(loc1.getY() - loc2.getY());
    }

    /**
     * Retrieves a list of the closest locations to a given location
     * @param howMany How many of the closest locations are wanted e.g. 5 closest locations
     * @param fromLocation Where to find closest events from
     * @return List of locations closest to given location, of size specified by howMany
     */
    public ArrayList<Location> getClosestEvents(int howMany, Location fromLocation) {

        //If a request is made for more Events than the number that exist in the World
        //Then only how many that exist are returned
        if (howMany > locations.size()) howMany = locations.size();

        //Sort events list with first element as closest event to fromLocation
        Collections.sort(locations, (l1, l2) -> {
            //Calculate distances of an event from given location
            int fromToL1 = manhatDistance(fromLocation, l1);
            int fromToL2 = manhatDistance(fromLocation, l2);

            if(fromToL1 < fromToL2) {
                //Puts event 1 ahead of event 2
               return -1;
            }
            else if (fromToL1 == fromToL2) {
                //Both same distance - no need to swap
                return 0;
            }
            else {
                //Puts event 2 ahead of event 1
                return 1;
            }
        });

        //Return sorted list of events - size based on how many events requested
        return new ArrayList<>(locations.subList(0, howMany));
    }

    /**
     * Determines if a location is within the world's bounds
     * @param location Location object
     * @return true if location is valid, false otherwise
     */
    public boolean isLocationValid(Location location) {
        return xRange.isInRange(location.getX()) && yRange.isInRange(location.getY());
    }

    /**
     * Returns x axis dimensions for this World
     * @return Range object: x axis dim. of World
     */
    public Range getxRange() {
        return xRange;
    }

    /**
     * Returns y axis dimensions for this World
     * @return Range object: y axis dim. of World
     */
    public Range getyRange() {
        return yRange;
    }
}
