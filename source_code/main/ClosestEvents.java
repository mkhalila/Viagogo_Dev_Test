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

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your location (e.g. \"4,2\"):");
        String userInput = scanner.nextLine();
        Pair<Integer, Integer> userLoc = new Pair<>(Integer.parseInt(String.valueOf(userInput.charAt(0))),
                Integer.parseInt(String.valueOf(userInput.charAt(2))));

    }
}
