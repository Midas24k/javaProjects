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

                if (wallHeight <= 0) {
                    System.out.println("Invalid input. Height must be greater than 0.");
                    validInput = false;
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                validInput = false;
                scnr.next();  // clear invalid token
            }

        } while (!validInput);


        // Get wall width with validation
        do {
            System.out.println("Enter wall width (feet): ");
            validInput = true;

            try {
                wallWidth = scnr.nextDouble();

                if (wallWidth <= 0) {
                    System.out.println("Invalid input. Width must be greater than 0.");
                    validInput = false;
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                validInput = false;
                scnr.next();
            }

        } while (!validInput);


        // Calculate wall area
        wallArea = wallHeight * wallWidth;
        System.out.println("Wall area: " + wallArea + " square feet");

        // Calculate paint needed (exact) and round up to whole gallons for purchase
        gallonsPaintNeeded = wallArea / squareFeetPerGallons;
        int gallonsToBuy = (int) Math.ceil(gallonsPaintNeeded);
        System.out.printf("Paint needed (exact): %.2f gallons%n", gallonsPaintNeeded);
        System.out.println("Paint needed (whole gallons to buy): " + gallonsToBuy + " gallon" + (gallonsToBuy == 1 ? "" : "s"));

        scnr.close();
    }
}
