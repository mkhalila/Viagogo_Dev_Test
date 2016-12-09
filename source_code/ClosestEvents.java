import main.Location;
import main.Range;
import main.World;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class that represents the retrieval of Closest Events to a given location given by the user via a Scanner.
 * Main is stored in this class.
 */
public class ClosestEvents {
    public static void main(String[] args) {
        //Initialise a world from -10 to 10 dimensions in both x and y axis
        World world = new World(new Range(-10, 10), new Range(-10, 10));

        //Retrieves user location
        Location userLoc = retrieveUserLocation(world);

        //Retrieves closest locations (with their events) to the user provided location
        ArrayList<Location> closestEvents = world.getClosestEvents(5, userLoc);

        //Prints the closest events
        printClosestEvents(world, userLoc, closestEvents);
    }

    //Keeps asking the user for their location until a valid location is entered
    //A Location is valid if it is within the world's boundaries
    //The given location is converted to a Location object and returned
    private static Location retrieveUserLocation(World world) {
        Location userLoc = promptUserLocation();

        while (!world.isLocationValid(userLoc)){
            userLoc = promptUserLocation();
        }

        return userLoc;
    }

    //Prompts the user for a location and converts it to the desired format
    //Returns a pair(x,y) for the location
    private static Location promptUserLocation() {
        Scanner scanner = new Scanner(System.in);

        //Prompt user & store user input
        System.out.print("Enter your location (e.g. \"4,2\"): ");
        String userInput = scanner.nextLine();

        //Convert to desired format - keeping only numbers, comma and negatives
        //using regular expressions
        userInput = userInput.replaceAll("[^0-9|^,|^-]", "");
        String[] loc = userInput.split(",");

        //If 2 co-ordinates have not been entered
        if (loc.length != 2) return promptUserLocation();

        //Return location
        return new Location(Integer.parseInt(loc[0]),
                Integer.parseInt(loc[1]));
    }

    //Prints all closest events in provided list of closest locations
    private static void printClosestEvents(World world, Location userLoc, ArrayList<Location> closestEvents) {
        System.out.println("\nClosest Events to (" +
                userLoc.getX() + ", " + userLoc.getY() + "):");

        for (Location l : closestEvents) {
            System.out.println(l + " - Distance: " + world.manhatDistance(userLoc, l));
        }
    }
}
