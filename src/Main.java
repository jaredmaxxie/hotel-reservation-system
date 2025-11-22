import java.util.Scanner;

public class Main {

    private static final Scanner kbd = new Scanner(System.in);         // user input reader
    private static final String[][] standard = new String[15][10];     // standard rooms for 10 days
    private static final String[][] deluxe = new String[10][10];       // deluxe rooms for 10 days
    private static final String[][] suite = new String[5][10];         // suite rooms for 10 days
    private static final String[] dates = {
            "11/17/2025", "11/18/2025", "11/19/2025", "11/20/2025",
            "11/21/2025", "11/22/2025", "11/23/2025", "11/24/2025",
            "11/25/2025", "11/26/2025"
    };

    public static void main(String[] args) {
        //TODO: User Interface

    }

    /*
    MAIN PROCESSES
     */
    private static void roomAvailability() {
        Scanner kbd = new Scanner(System.in);
            System.out.print("Input Room Type to check: (1. Standard, 2. Deluxe, 3. Suite): ");
            int type = kbd.nextInt();

            String roomTypeName = "";
            int price = 0;
            int totalRooms = 0;
            int availableRooms = 0;

            switch (type) {
                case 1 -> { 
                    roomTypeName = "Standard";
                    price = 2500;
                    totalRooms = standard.length;

                    for (int i = 0; i < standard.length; i++) {
                        boolean isAvailable = true;
                        for (int j = 0; j < dates.length; j++) {
                            if (standard[i][j] != null) {
                                isAvailable = false;
                                break;
                            }
                        }
                        if (isAvailable) availableRooms++;
                    }
                    StandardTable();
                }

                case 2 -> {
                    roomTypeName = "Deluxe";
                    price = 4000;
                    totalRooms = deluxe.length;

                    for (int i = 0; i < deluxe.length; i++) {
                        boolean isAvailable = true;
                        for (int j = 0; j < dates.length; j++) {
                            if (deluxe[i][j] != null) {
                                isAvailable = false;
                                break;
                            }
                        }
                        if (isAvailable) availableRooms++;
                    }
                    DeluxeTable();
                }

                case 3 -> { 
                    roomTypeName = "Suite";
                    price = 6000;
                    totalRooms = suite.length;

                    for (int i = 0; i < suite.length; i++) {
                        boolean isAvailable = true;
                        for (int j = 0; j < dates.length; j++) {
                            if (suite[i][j] != null) {
                                isAvailable = false;
                                break;
                            }
                        }
                        if (isAvailable) availableRooms++;
                    }
                    SuiteTable();
                }

                default -> {
                    System.out.println("Invalid room type!");
                    return;
                }
            }

            System.out.println("\nRoom Availability Status");
            System.out.println("Room Type: " + roomTypeName);
            System.out.println("Total Rooms: " + totalRooms);
            System.out.println("Available Rooms: " + availableRooms);
            System.out.println("Price per Night: ₱" + String.format("%,d", price));
        }
    }

    private static boolean makeReservation() {
        //TODO: should return true if the reservation is successful and false if otherwise

        // Reservation Process
        // 1. get guest name
        // 2. get room type
        // 3. display room type status table
        // 4. get number of days to reserve
        // 5. get the dates based on the number of days
        // 6. set successful = false
        // 7. Loop through every "ROOMS" (i.e. the "ROWS" of the array), for each loop:
        //      8.1. Check the columns that matches the dates
        //      8.2. If those columns are available:
        //              8.2.1 Assign the guest with the current "ROOM" for those columns (i.e. Dates) in the format ("1|<name>")
        //              8.2.2 Set successful = true
        //              8.2.3 Stop the loop
        // 9. If successful = false, print a statement to notify guest that no rooms are available for those dates

        String guestName = getUserInput("Input Guest Name: ");
        String roomType = "";

        do {
            roomType = getUserInput("Input Room Type: (1. Standard, 2. Deluxe, 3. Suite): ");

            switch (roomType) {
                case "1" -> checkRoomStatus(standard);
                case "2" -> checkRoomStatus(deluxe);
                case "3" -> checkRoomStatus(suite);
                default -> {
                    System.out.println("Invalid room type, try again");
                    roomType = "False";
                }
            }

        } while (roomType.equals("False"));

        // printTable()

        int numberOfDays = Integer.parseInt(getUserInput("Input number of days: "));
        String[] dates = new String[10];

        for (int i = 0; i < numberOfDays; i++) {
            dates[i] = getUserInput("Date " + (i + 1) + ": ");
        }

        System.out.println("Processing Reservation...");

        return false; // just a placeholder to avoid errors
    }

    private static boolean checkIn() {
        //TODO: should return true if check-in is successful and false if otherwise

        return false; // just a placeholder to avoid errors
    }

    private static boolean checkOut() {
        //TODO: should return true if check-out is successful and false if otherwise

        return false; // just a placeholder to avoid errors
    }

    private static boolean payment() {
        //TODO: should return true if payment is successful and false if otherwise

        return false; // just a placeholder to avoid errors
    }

    /*
    HELPER FUNCTIONS
     */
    private static String getUserInput(String message) {
        //TODO: print input message and return user input as a String
        System.out.print(message);
        return kbd.nextLine();
    }

    private static int getColIdx(String date) {
        int day = Integer.parseInt(date.split("/")[1].trim());

        return day - 17;
    }

    private static String checkRoomStatus(String[][] room) {

        return ""; // just a placeholder to avoid errors
    }

    private static void printTable() {
        //TODO: print table layout. (using the standard, deluxe, and suite 2D-arrays)

    }
}
