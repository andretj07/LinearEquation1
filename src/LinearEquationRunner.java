import java.util.Scanner;

public class LinearEquationRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Linear Equation Calculator!");
        System.out.print("Please enter the first coordinate (x1, y1): ");
        String coordinate1 = scanner.nextLine();
        coordinate1 = coordinate1.replaceAll("[^0-9,-]", "");

        System.out.print("Please enter the second coordinate (x2, y2): ");
        String coordinate2 = scanner.nextLine();
        coordinate2 = coordinate2.replaceAll("[^0-9,-]", "");

        
        String[] parts1 = coordinate1.split(",");
        String[] parts2 = coordinate2.split(",");
        
        int x1 = Integer.parseInt(parts1[0]);
        int y1 = Integer.parseInt(parts1[1]);
        int x2 = Integer.parseInt(parts2[0]);
        int y2 = Integer.parseInt(parts2[1]);

        
        if (x1 == x2) {
            System.out.println("The points fall on a vertical line, the slope is undefined.");
            System.out.println("The equation of the line is: x = " + x1);
            return;
        }

        
        LinearEquation equation = new LinearEquation(x1, y1, x2, y2);

        
        System.out.println("\nLine Information:");
        System.out.println(equation.lineInfo());

        
        System.out.print("\nEnter an x value: ");
        double xValue = scanner.nextDouble();
        scanner.nextLine();

        String coordinate = equation.coordinateForX(xValue);
        System.out.println("The coordinate point on the line with x = " + xValue + " is " + coordinate);
    }
}
