package exercises;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();

            if (age < 1) {
                System.out.println("Age cannot be less than one");
                return;
            }

            System.out.println("Age: " + age);
        } catch (InputMismatchException e) {
            System.out.println("Invalid age input");
        }

        scanner.close();
    }
}