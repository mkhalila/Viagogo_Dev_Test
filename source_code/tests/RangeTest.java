package tests;

import main.Range;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for all Range class methods conducted with 4 varying Ranges
 */
public class RangeTest {
    private Range range1 = new Range(-10, 10);
    private Range range2 = new Range(-999, 999);
    private Range range3 = new Range(5, 10);
    private Range range4 = new Range(-15, -10);

    @Test
    public void getMin() throws Exception {
        assertEquals(-10, range1.getMin());
        assertEquals(-999, range2.getMin());
        assertEquals(5, range3.getMin());
        assertEquals(-15, range4.getMin());
    }

    @Test
    public void getMax() throws Exception {
        assertEquals(10, range1.getMax());
        assertEquals(999, range2.getMax());
        assertEquals(10, range3.getMax());
        assertEquals(-10, range4.getMax());
    }

    @Test
    public void isInRange() throws Exception {
        assertEquals(true, range1.isInRange(5));
        assertEquals(true, range1.isInRange(-10));
        assertEquals(true, range1.isInRange(10));
        assertEquals(false, range1.isInRange(11));
        assertEquals(false, range1.isInRange(9999));
        assertEquals(false, range1.isInRange(-53));
    }

    @org.junit.Test
    public void rangeSize() throws Exception {
        assertEquals(20, range1.rangeSize());
        assertEquals(1998, range2.rangeSize());
        assertEquals(5, range3.rangeSize());
        assertEquals(5, range4.rangeSize());
    }

}