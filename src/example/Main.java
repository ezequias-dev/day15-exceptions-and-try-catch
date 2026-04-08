package example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();

            System.out.println("Age entered: " + age);
        } catch (InputMismatchException exception) {
            System.out.println("Invalid input. You must enter a number.");
        }

        scanner.close();
    }
}