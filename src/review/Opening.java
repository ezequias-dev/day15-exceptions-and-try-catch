package review;

import java.util.Scanner;

public class Opening {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter age: ");
            int age = scanner.nextInt();

            System.out.println("Age: " + age);

        } catch (Exception exception) {
            System.out.println("Invalid value.");
        }
    }
}