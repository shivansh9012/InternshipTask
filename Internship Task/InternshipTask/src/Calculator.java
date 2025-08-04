import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        // Create a Scanner object to take input from the user
        Scanner num = new Scanner(System.in);

        // Take two numbers from the user
        double a = num.nextDouble();
        double b = num.nextDouble();

        // Display the available operations
        System.out.println("Select an operation:");
        System.out.println("1: Addition (+)");
        System.out.println("2: Subtraction (-)");
        System.out.println("3: Multiplication (*)");
        System.out.println("4: Division (/)");
        System.out.println("5: Modulo (%)");

        // Take the operation choice from the user
        System.out.print("Enter the operation (1/2/3/4/5): ");
        int operation = num.nextInt();

        // Perform the corresponding operation and display the result
        switch (operation) {
            case 1:
                // Addition
                System.out.println("The result of " + a + " + " + b + " is: " + (a + b));
                break;
            case 2:
                // Subtraction
                System.out.println("The result of " + a + " - " + b + " is: " + (a - b));
                break;
            case 3:
                // Multiplication
                System.out.println("The result of " + a + " * " + b + " is: " + (a * b));
                break;
            case 4:
                // Division
                if (b == 0) {
                    System.out.println("Error: Division by zero is not allowed!");
                } else {
                    System.out.println("The result of " + a + " / " + b + " is: " + (a / b));
                }
                break;
            case 5:
                // Modulo
                System.out.println("The result of " + a + " % " + b + " is: " + (a % b));
                break;
            default:
                System.out.println("Invalid operation! Please select a valid operation (1-5).");
        }

        
    }
}
