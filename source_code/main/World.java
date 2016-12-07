package main;

import com.sun.javaws.exceptions.InvalidArgumentException;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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

    /**
     * Constructor for a World object. Initialises size of world, and generates the Events
     * @param xRangeIn x dimension range of world e.g. -10 to 10
     * @param yRangeIn y dimension range of world e.g. -10 to 10
     */
    public World(Range xRangeIn, Range yRangeIn) {
        initWorldSize(xRangeIn, yRangeIn);
        generateEvents();
        System.out.println("\nCreated a World with " + events.size() + " events.");
    }

    private void initWorldSize(Range xRangeIn, Range yRangeIn) {
        xRange = xRangeIn;
        yRange = yRangeIn;
    }

    private void generateEvents() {
        //Initialise Events list
        events = new ArrayList<>();

        //Generates events for this World - 0 to the maximum no. of locations in the world
        for (int i = 0; i < new Random().nextInt(calculateMaxLocations()); ++i) {
            events.add(new Event(generateLocation()));
        }
    }

    //Calculates no. of locations in the world
    private int calculateMaxLocations() {
        return xRange.rangeSize() * yRange.rangeSize();
    }

    //Generates a unused location for an Event
    private Pair<Integer,Integer> generateLocation() {
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
        return new Pair<>(xLoc, yLoc);
    }

    //Returns true if given location is free from an Event
    private boolean isLocationUnused(int xLoc, int yLoc) {
        //Loop over all current events
        for (Event event : events) {
            //Check if generated location is the same as any event's location and if it is return false
            if ((xLoc == event.getLocation().getKey()) && (yLoc == event.getLocation().getValue())) {
                return false;
            }
        }
        //No current event in the world has this location
        return true;
    }

    /**
     * Determines the distance between 2 locations given in Pair<Integer, Integer> form
     * @param loc1 Location as Pair<Integer, Integer>
     * @param loc2 Location as Pair<Integer, Integer>
     * @return Manhattan distance between the 2 provided locations
     */
    public int manhatDistance(Pair<Integer, Integer> loc1, Pair<Integer, Integer> loc2) {
        //Manhattan distance = |(x1 - x2)| + |(y1 - y2)|
        return Math.abs(loc1.getKey() - loc2.getKey()) + Math.abs(loc1.getValue() - loc2.getValue());
    }

    /**
     * Retrieves a list of the closest events to a given location
     * @param howMany How many of the closest events are wanted e.g. 5 closest events
     * @param fromLocation Where to find closest events from
     * @return List of events closest to given location, of size specified by howMany
     * @throws IndexOutOfBoundsException Total events in the world are less than how many were specified to retrieve
     */
    public ArrayList<Event> getClosestEvents(int howMany, Pair<Integer, Integer> fromLocation)
            throws IndexOutOfBoundsException {

        //Total events in the world are less than how many were specified to retrieve
        if (howMany > events.size()) throw new IndexOutOfBoundsException();

        //Sort events list with first element as closest event to fromLocation
        Collections.sort(events, new Comparator<Event>() {
            @Override
            public int compare(Event e1, Event e2) {
                int fromToE1 = manhatDistance(fromLocation, e1.getLocation());
                int fromToE2 = manhatDistance(fromLocation, e2.getLocation());

                if(fromToE1 < fromToE2) {
                   return -1;
                }
                else if (fromToE1 == fromToE2) {
                    return 0;
                }
                else {
                    return 1;
                }
            }
        });

        //Return sorted list of events - size based on how many events requested
        return new ArrayList<>(events.subList(0, howMany+1));
    }

    /**
     * Determines if a location is within the world's bounds
     * @param location Pair(x, y) denoting location
     * @return true if location is valid, false otherwise
     */
    public boolean isLocationValid(Pair<Integer, Integer> location) {
        return xRange.isInRange(location.getKey()) && yRange.isInRange(location.getValue());
    }
}
