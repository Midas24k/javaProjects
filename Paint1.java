import java.util.Scanner;
import java.util.InputMismatchException;

public class Paint1 {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        double wallHeight = 0.0;
        double wallWidth = 0.0;
        double wallArea = 0.0;
        double gallonsPaintNeeded = 0.0;

        final double squareFeetPerGallons = 350.0;

        boolean validInput;

        // Get wall height with validation
        do {
            System.out.println("Enter wall height (feet): ");
            validInput = true;

            try {
                wallHeight = scnr.nextDouble();

                if (wallHeight <= 0.0) {
                    System.out.println("Invalid input. Height must be greater than 0.");
                    validInput = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                validInput = false;
                scnr.next();  // clear bad token
            }
        } while (!validInput);

        // Get wall width with validation
        do {
            System.out.println("Enter wall width (feet): ");
            validInput = true;

            try {
                wallWidth = scnr.nextDouble();

                if (wallWidth <= 0.0) {
                    System.out.println("Invalid input. Width must be greater than 0.");
                    validInput = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                validInput = false;
                scnr.next();  // clear bad token
            }
        } while (!validInput);

        // Calculate and output wall area
        wallArea = wallHeight * wallWidth;
        System.out.println("Wall area: " + wallArea + " square feet");

        // Calculate and output exact gallons needed (no rounding)
        gallonsPaintNeeded = wallArea / squareFeetPerGallons;
        System.out.println("Paint needed: " + gallonsPaintNeeded + " gallons");

        scnr.close();
    }
}