package main;

/**
 * Class that represents a Range of integers. Used by the World class - Package protected
 */
class Range {
    //Bounds of the Range object
    private int min, max;

    /**
     * Constructs a Range object
     * @param minIn Minimum bound of this range
     * @param maxIn Maximum bound of this range
     */
    Range(int minIn, int maxIn) {
        min = minIn;
        max = maxIn;
    }

    /**
     * Determines if a given number is within the bounds of the range
     * @param number
     * @return true if number is within the range, false if not
     */
    public boolean isInRange(int number){
        return (number >= min && number <= max);
    }
}
