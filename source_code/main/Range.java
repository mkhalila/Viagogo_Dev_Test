package main;

/**
 * Class that represents a Range of integers. Used by the World class - Package protected
 */
public class Range {
    //Bounds of the Range object
    private int min, max;

    /**
     * Constructs a Range object
     * @param minIn Minimum bound of this range
     * @param maxIn Maximum bound of this range
     */
    public Range(int minIn, int maxIn) {
        min = minIn;
        max = maxIn;
    }

    /**
     * Returns minimum bound of range
     * @return minimum integer bound of range
     */
    int getMin() {
        return min;
    }

    /**
     * Returns maximum bound of range
     * @return maximum integer bound of range
     */
    int getMax() {
        return max;
    }

    /**
     * Determines if a given number is within the bounds of the range
     * @param number number to check
     * @return true if number is within the range, false if not
     */
    boolean isInRange(int number){
        return (number >= min && number <= max);
    }

    /**
     * Returns difference between maximum and minimum bounds of range
     * @return Size of this range
     */
    int rangeSize() {
        return max - min;
    }
}
