package tests;

import main.Location;
import main.Range;
import main.World;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Test for all applicable methods of a World with randomly generated Locations and Events
 */
public class WorldTest {
    private World world = new World(-10, 10, -10, 10);
    private Location loc1 = new Location(0, 0);
    private Location loc2 = new Location(1, 1);
    private Location loc3 = new Location(11, 11);
    private Location loc4 = new Location(-1000, 4321);

    /**
     * Tests if Manhattan distance between 2 locations is computed correctly
     * @throws Exception
     */
    @Test
    public void manhatDistance() throws Exception {
        assertEquals(0, world.manhatDistance(loc1, loc1));
        assertEquals(2, world.manhatDistance(loc1, loc2));
        assertEquals(22, world.manhatDistance(loc1, loc3));
        assertEquals(5321, world.manhatDistance(loc1, loc4));
        assertEquals(5321, world.manhatDistance(loc4, loc1));
    }

    /**
     * Tests if closest events are displayed in correct order of distance
     * @throws Exception
     */
    @Test
    public void getClosestEvents() throws Exception {
        ArrayList<Location> locations = world.getClosestEvents(5, loc1);

        //Ensures that enough closest events are retrieved
        while (locations.size() < 5) {
            world = new World(-10, 10, -10, 10);
            locations = world.getClosestEvents(5, loc1);
        }

        //Closest Event distance from loc1
        int shouldBeSmaller = world.manhatDistance(loc1, locations.get(0));

        //Event further away from loc1
        int shouldBeLarger = world.manhatDistance(loc1, locations.get(4));

        //Fail test if closest event isn't actually closer
        if (shouldBeSmaller > shouldBeLarger) throw new Exception();

    }

    /**
     * Tests that a invalid location is correctly recognised
     * @throws Exception
     */
    @Test
    public void isLocationValid() throws Exception {
        assertEquals(true, world.isLocationValid(loc1));
        assertEquals(true, world.isLocationValid(loc2));
        assertEquals(false, world.isLocationValid(loc3));
        assertEquals(false, world.isLocationValid(loc4));
    }

    /**
     * Tests that the World has correct x dimension
     * @throws Exception
     */
    @Test
    public void getxRange() throws Exception {
        Range shouldBe = new Range(-10, 10);
        Range actual = world.getxRange();

        //Test fails if x range is not correct
        if ((shouldBe.getMin() != actual.getMin()) || (shouldBe.getMax() != actual.getMax())) {
            throw new Exception();
        }
    }

    /**
     * Tests that the World has correct y dimension
     * @throws Exception
     */
    @Test
    public void getyRange() throws Exception {
        Range shouldBe = new Range(-10, 10);
        Range actual = world.getyRange();

        //Test fails if y range is not correct
        if ((shouldBe.getMin() != actual.getMin()) || (shouldBe.getMax() != actual.getMax())) {
            throw new Exception();
        }
    }

}