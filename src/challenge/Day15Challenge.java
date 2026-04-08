package challenge;

import java.util.Scanner;

public class Day15Challenge {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final CustomerService CUSTOMER_SERVICE = new CustomerService();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            showMenu();
            String option = SCANNER.nextLine().trim();

            switch (option) {
                case "1":
                    registerCustomer();
                    break;
                case "2":
                    listCustomers();
                    break;
                case "3":
                    findCustomerById();
                    break;
                case "4":
                    updateCustomerActiveStatus();
                    break;
                case "5":
                    removeCustomerById();
                    break;
                case "6":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option");
            }

            System.out.println();
        }
    }

    private static void showMenu() {
        System.out.println("=== Customer Menu ===");
        System.out.println("1 - Register customer");
        System.out.println("2 - List customers");
        System.out.println("3 - Find customer by id");
        System.out.println("4 - Update active status by id");
        System.out.println("5 - Remove customer by id");
        System.out.println("6 - Exit");
        System.out.print("Choose an option: ");
    }

    private static void registerCustomer() {
        Integer id = readId("Id: ");
        if (id == null) {
            return;
        }

        System.out.print("Full name: ");
        String fullName = SCANNER.nextLine();

        System.out.print("Email: ");
        String email = SCANNER.nextLine();

        boolean active = readActive("Active (true/false): ");
        CustomerRecord customer = new CustomerRecord(id, fullName, email, active);

        if (CUSTOMER_SERVICE.addCustomer(customer)) {
            System.out.println("Customer registered successfully");
            return;
        }

        System.out.println("Could not register customer");
    }

    private static void listCustomers() {
        CUSTOMER_SERVICE.listCustomers();
        System.out.println("Total: " + CUSTOMER_SERVICE.getTotalCustomers());
        System.out.println("Active: " + CUSTOMER_SERVICE.countActiveCustomers());
    }

    private static void findCustomerById() {
        Integer id = readId("Id: ");
        if (id == null) {
            return;
        }

        CustomerRecord customer = CUSTOMER_SERVICE.findById(id);
        if (customer == null) {
            System.out.println("Customer not found");
            return;
        }

        customer.showCustomerSummary();
    }

    private static void updateCustomerActiveStatus() {
        Integer id = readId("Id: ");
        if (id == null) {
            return;
        }

        boolean active = readActive("New active status (true/false): ");
        if (CUSTOMER_SERVICE.updateActiveById(id, active)) {
            System.out.println("Customer status updated successfully");
            return;
        }

        System.out.println("Customer not found");
    }

    private static void removeCustomerById() {
        Integer id = readId("Id: ");
        if (id == null) {
            return;
        }

        if (CUSTOMER_SERVICE.removeById(id)) {
            System.out.println("Customer removed successfully");
            return;
        }

        System.out.println("Customer not found");
    }

    private static Integer readId(String prompt) {
        System.out.print(prompt);

        try {
            return Integer.parseInt(SCANNER.nextLine().trim());
        } catch (NumberFormatException exception) {
            System.out.println("Invalid id input");
            return null;
        }
    }

    private static boolean readActive(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = SCANNER.nextLine().trim();

            if ("true".equalsIgnoreCase(input)) {
                return true;
            }

            if ("false".equalsIgnoreCase(input)) {
                return false;
            }

            System.out.println("Invalid active input. Type true or false.");
        }
    }
}