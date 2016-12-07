package main;

import javafx.util.Pair;

import java.util.Scanner;

/**
 * Class that represents the retrieval of Closest Events to a given location given by the user via a Scanner.
 * Main is stored in this class.
 */
public class ClosestEvents {
    public static void main(String[] args) {
        //Initialise a world from -10 to 10 dimensions in both x and y axis
        World world = new World(new Range(-10, 10), new Range(-10, 10));

        Pair<Integer, Integer> userLoc = retrieveUserLocation(world);

        System.out.println(userLoc.getKey() + " " + userLoc.getValue());
    }

    //Keeps asking the user for their location until a valid location is entered
    //A Location is valid if it is within the world's boundaries
    //The given location is converted to a pair (x, y) and returned
    private static Pair<Integer,Integer> retrieveUserLocation(World world) {
        Pair<Integer, Integer> userLoc = promptUserLocation();

        while (!world.isLocationValid(userLoc)){
            userLoc = promptUserLocation();
        }

        return userLoc;
    }

    //Prompts the user for a location and converts it to the desired format
    //Returns a pair(x,y) for the location
    private static Pair<Integer, Integer> promptUserLocation() {
        Scanner scanner = new Scanner(System.in);

        //Prompt user & store user input
        System.out.print("Enter your location (e.g. \"4,2\"): ");
        String userInput = scanner.nextLine();

        //Convert to desired format - keeping only numbers, comma and negatives
        userInput = userInput.replaceAll("[^0-9|^,|^-]", "");
        String[] loc = userInput.split(",");

        //Return location as pair(x,y)
        return new Pair<>(Integer.parseInt(loc[0]),
                Integer.parseInt(loc[1]));
    }
}
