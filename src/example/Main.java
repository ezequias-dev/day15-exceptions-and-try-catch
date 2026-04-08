package example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductService();

        productService.addProduct(new ProductRecord(1, "Ezequias"));
        productService.addProduct(new ProductRecord(2, "Marli"));

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter id: ");
            int id = scanner.nextInt();

            ProductRecord found = productService.findById(id);

            if (found != null) {
                System.out.println("Id: " + found.getId() + " | Name: " + found.getName());
                System.out.println("Product found.");
            } else {
                System.out.println("Product not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. You must enter a number.");
        }
    }
}