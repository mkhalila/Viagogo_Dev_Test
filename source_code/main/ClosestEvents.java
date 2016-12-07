package main;

import javafx.util.Pair;

import java.util.Scanner;

/**
 * Class that represents the retrieval of Closest Events to a given location given by the user via a Scanner.
 * Main is stored in this class.
 */
public class ClosestEvents {
    public static void main(String[] args) {
        World world = new World(new Range(-10, 10), new Range(-10, 10));

        Pair<Integer, Integer> userLoc = retrieveUserLocation();

    }

    //Keeps asking the user for their location until a valid location is entered
    //A Location is valid if it is within the world's boundaries
    //The given location is converted to a pair (x, y) and returned
    private static Pair<Integer,Integer> retrieveUserLocation() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your location (e.g. \"4,2\"): ");
        String userInput = scanner.nextLine();

        userInput = userInput.replaceAll("[^0-9|^,]", "");
        String[] loc = userInput.split(",");

        return new Pair<>(Integer.parseInt(loc[0]), Integer.parseInt(loc[1]));
    }
}
