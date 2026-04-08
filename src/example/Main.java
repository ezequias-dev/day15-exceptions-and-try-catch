package example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the first number: ");
            int firstNumber = scanner.nextInt();

            System.out.print("Enter the second number: ");
            int secondNumber = scanner.nextInt();

            int result = firstNumber / secondNumber;

            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
        }
    }
}