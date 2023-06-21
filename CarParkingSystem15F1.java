
/************************** TITLE OF THE PROJECT*************************
 * Implement a car-parking system that records which cars are currently parked in the car park. 
 * Only registered cars must be allowed to enter the car park, 
 * so the system must be able to keep a list of authorized vehicles
 * as well as those actually parked at a particular time. 
 * The system must be able to provide a series of reports, 
 * for example indicating whether or not the car park is full, 
 * displaying lists of registered vehicles and those parked.
 * 
 * RESULT OF EXECUTION: RESULT FILE IS SAVED WITH THE NAME OF "registered_plates.txt"
 * RESULT OF INNOVATION: SIMPLIFYING THE PROGRAM AS FOR THE FORWARD UPDATES WITH SAMPLE FUNCTIONS.
*/

import java.io.*;
import java.util.*;

public class CarParkingSystem15F1 {

    // Define constants and variables used throughout the code.
    public static final int NUM_ROWS = 5;
    public static final int NUM_COLS = 10;

    public static String[][] parkingLot = new String[NUM_ROWS][NUM_COLS];
    public static String[] registeredPlates = new String[NUM_ROWS * NUM_COLS];
    public static String[] parkedPlates = new String[NUM_ROWS * NUM_COLS];
    public static String[] parkedPlateOwners = new String[NUM_ROWS * NUM_COLS];
    public static int numRegisteredPlates = 0;
    public static int numParkedPlates = 0;

    public static void main(String[] args) throws IOException {

        // Initialize the parking lot and scanner for user input.
        initializeParkingLot();
        Scanner scanner = new Scanner(System.in);

        // Create a boolean to control the main loop
        boolean quit = false;
        while (quit == false) {

            // Display the menu options to the user
            System.out.println("\nEnter 1 to add a registered vehicle");
            System.out.println("Enter 2 to check if a vehicle is registered");
            System.out.println("Enter 3 to add a parked vehicle");
            System.out.println("Enter 4 to remove a parked vehicle");
            System.out.println("Enter 5 to generate reports");
            System.out.println("Enter 6 to check vehicle parked place");
            System.out.println("Enter q to quit");

            String input = scanner.nextLine();

            // Control the user's menu selection using a switch statement.
            switch (input) {
                case "1":
                    addRegisteredPlate(scanner);
                    break;
                case "2":
                    checkIfRegistered(scanner);
                    break;
                case "3":
                    addParkedPlate(scanner);
                    break;
                case "4":
                    removeParkedPlate(scanner);
                    break;
                case "5":
                    generateReports();
                    break;
                case "6":
                    searchByPlate(scanner);
                    break;

                case "q":
                    quit = true;
                    break;
                default:

                    // Display an error message for invalid input
                    System.out.println("Invalid input");
            }
        }

        // Functions to save the state of the program before exiting.
        saveParkingLot();
        saveRegisteredPlates();
        saveParkedPlates();
        saveParkedPlateOwners();
    }

    // Method to initialize the parking lot to contain all empty spaces.
    public static void initializeParkingLot() {
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                parkingLot[row][col] = "-";
            }
        }
    }

    // Method to add a registered vehicle to the system.
    public static void addRegisteredPlate(Scanner scanner) throws IOException {
        System.out.println("\nEnter the vehicle plate number:");
        String plate = scanner.nextLine();

        // Check if the plate is already registered.
        if (isRegistered(plate)) {
            System.out.println("Vehicle already registered");
        } else {
            registeredPlates[numRegisteredPlates] = plate;
            numRegisteredPlates++;

            // Prompt the user for the owner's name and store it in the parkedPlateOwners
            // DOUBLE DIMEN. array.
            System.out.println("Enter the car owner's name:");

            String ownerName = scanner.nextLine();
            // OwnerName is just a sample that user can create new line of code to read
            // owner name only if they want.
            parkedPlateOwners[numParkedPlates] = ownerName;

            System.out.println("Vehicle registered successfully");
        }
    }

    // Method to check if a vehicle with the given plate number is registered of
    // not---> FOR UPCOMING FUNCTIONS.
    public static boolean isRegistered(String plate) {
        for (int i = 0; i < numRegisteredPlates; i++) {
            if (registeredPlates[i].equals(plate)) {
                return true;
            }
        }
        return false;
    }

    // Method to check if a vehicle with the given plate number is registered of not
    // just---> TO DISPLAY TO THE USER.
    public static void checkIfRegistered(Scanner scanner) {
        System.out.println("\nEnter the vehicle plate number:");
        String plate = scanner.nextLine();
        if (isRegistered(plate)) {
            System.out.println("Vehicle is registered");
        } else {
            System.out.println("Vehicle is not registered");
        }
    }

    // Method to park a vehicle to the system.
    public static void addParkedPlate(Scanner scanner) throws IOException {
        System.out.println("\nEnter the vehicle plate number:");
        String plate = scanner.nextLine();
        if (!isRegistered(plate)) {
            System.out.println("Vehicle is not registered");
        } else if (isParked(plate)) {
            System.out.println("Vehicle is already parked");
        } else {
            boolean parked = false;
            for (int row = 0; row < NUM_ROWS; row++) {
                for (int col = 0; col < NUM_COLS; col++) {
                    if (parkingLot[row][col].equals("-")) {
                        parkingLot[row][col] = plate;
                        parkedPlates[numParkedPlates] = plate;
                        numParkedPlates++;
                        System.out.println("Vehicle parked at row " + (row + 1) + ", col " + (col + 1));
                        parked = true;
                        break;
                    }
                }
                if (parked) {
                    break;
                }
            }
            if (!parked) {
                System.out.println("Parking lot is full");
            }
        }
    }

    // Method to check the given vehicle is Parked or not for addParkedPlate and
    // removeParkedPlate functions.
    public static boolean isParked(String plate) {
        for (int i = 0; i < numParkedPlates; i++) {
            if (parkedPlates[i].equals(plate)) {
                return true;
            }
        }
        return false;
    }

    // Method to remove the vehicle from the system.
    public static void removeParkedPlate(Scanner scanner) throws IOException {
        System.out.println("\nEnter the vehicle plate number:");
        String plate = scanner.nextLine();
        if (!isRegistered(plate)) {
            System.out.println("Vehicle is not registered");
        } else if (!isParked(plate)) {
            System.out.println("Vehicle is not parked");
        } else {
            for (int row = 0; row < NUM_ROWS; row++) {
                for (int col = 0; col < NUM_COLS; col++) {
                    if (parkingLot[row][col].equals(plate)) {
                        parkingLot[row][col] = "-";
                        for (int i = 0; i < numParkedPlates; i++) {
                            if (parkedPlates[i].equals(plate)) {
                                parkedPlates[i] = parkedPlates[numParkedPlates - 1];
                                parkedPlates[numParkedPlates - 1] = null;
                                numParkedPlates--;
                                System.out.println("Vehicle removed from row " + (row + 1) + ", col " + (col + 1));
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        }
    }

    // Method to Display and Generate REPORT as FINAL RESULT OF PER DAY.
    public static void generateReports() throws IOException {
        int numEmptySpaces = 0;
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                if (parkingLot[row][col].equals("-")) {
                    numEmptySpaces++;
                }
            }
        }

        System.out.println("\n---REPORTS---");
        System.out.println("Number of empty spaces: " + numEmptySpaces);
        System.out.println("Number of registered vehicles: " + numRegisteredPlates);
        System.out.println("Registered vehicles: ");
        for (int i = 0; i < numRegisteredPlates; i++) {
            System.out.println(registeredPlates[i]);
        }
        System.out.println("Number of parked vehicles: " + numParkedPlates);
        System.out.println("Parked vehicles: ");
        for (int i = 0; i < numParkedPlates; i++) {
            System.out.println(parkedPlates[i]);
        }
    }

    // Method to SAVE the PARKING LAYOUT for data.
    public static void saveParkingLot() throws IOException {
        FileWriter writer = new FileWriter("parking_lot.txt");
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                writer.write(parkingLot[row][col] + " ");
            }
            writer.write("\n");
        }
        writer.close();
    }

    // Method to SAVE the RegisteredPlates for data.
    public static void saveRegisteredPlates() {
        try (FileWriter writer = new FileWriter("registered_plates.txt")) {
            for (int i = 0; i < numRegisteredPlates; i++) {
                writer.write(registeredPlates[i] + "\n");
            }
            System.out.println("Registered plates saved to registered_plates.txt");
        } catch (IOException e) {
            System.out.println("Failed to save registered plates: ");
        }
    }

    // User can also SEARCH BY PLATE uploaded here just for SAMPLE how to add more
    // FUNCTIONS.
    public static void searchByPlate(Scanner scanner) {
        System.out.println("\nEnter the vehicle plate number:");
        String plate = scanner.nextLine();
        boolean found = false;
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                if (parkingLot[row][col].equals(plate)) {
                    System.out.println("Vehicle found parked at row " + (row + 1) + ", col " + (col + 1));
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        if (!found) {
            System.out.println("Vehicle is not parked in the parking lot");
        }
    }

    public static void saveParkedPlateOwners() {
        // implementation sample code here just for example in line no 249.
    }

    public static void saveParkedPlates() {
        // implementation sample code here just for example in line no 249.
    }
}
// THANK YOU!!
/*
 * TO HELP THE USER:
 * Here's an example of how to use this program:
 * 
 * Enter 1 to add a registered vehicle
 * Enter 2 to check if a vehicle is registered
 * Enter 3 to add a parked vehicle
 * Enter 4 to remove a parked vehicle
 * Enter 5 to generate reports
 * Enter q to quit
 * 
 * 1
 * Enter the vehicle plate number:
 * ABC123
 * Vehicle registered successfully
 * 
 * Enter 1 to add a registered vehicle
 * Enter 2 to check if a vehicle is registered
 * Enter 3 to add a parked vehicle
 * Enter 4 to remove a parked vehicle
 * Enter 5 to generate reports
 * Enter q to quit
 * 
 * 1
 * Enter the vehicle plate number:
 * XYZ789
 * Vehicle registered successfully
 * 
 * Enter 1 to add a registered vehicle
 * Enter 2 to check if a vehicle is registered
 * Enter 3 to add a parked vehicle
 * Enter 4 to remove a parked vehicle
 * Enter 5 to generate reports
 * Enter q to quit
 * 
 * 3
 * Enter the vehicle plate number:
 * ABC123
 * Vehicle parked at row 1, col 1
 * 
 * Enter 1 to add a registered vehicle
 * Enter 2 to check if a vehicle is registered
 * Enter 3 to add a parked vehicle
 * Enter 4 to remove a parked vehicle
 * Enter 5 to generate reports
 * Enter q to quit
 * 
 * 3
 * Enter the vehicle plate number:
 * XYZ789
 * Vehicle parked at row 1, col 2
 * 
 * Enter 1 to add a registered vehicle
 * Enter 2 to check if a vehicle is registered
 * Enter 3 to add a parked vehicle
 * Enter 4 to remove a parked vehicle
 * Enter 5 to generate reports
 * Enter q to quit
 * 
 * 4
 * Enter the vehicle plate number:
 * ABC123
 * Vehicle removed from row 1, col 1
 * 
 * Enter 1 to add a registered vehicle
 * Enter 2 to check if a vehicle is registered
 * Enter 3 to add a parked vehicle
 * Enter 4 to remove a parked vehicle
 * Enter 5 to generate reports
 * Enter q to quit
 * 
 * 5
 * Report generated successfully
 * 
 * Enter 1 to add a registered vehicle
 * Enter 2 to check if a vehicle is registered
 * Enter 3 to add a parked vehicle
 * Enter 4 to remove a parked vehicle
 * Enter 5 to generate reports
 * Enter q to quit
 * 
 * q
 * Registered plates saved to registered_plates.txt
 * YOU CAN CHECK THE UPDATED DATA IN
 * "E:\codes\Java\registered_plates.txt"
 */