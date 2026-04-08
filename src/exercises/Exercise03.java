package exercises;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class CustomerRecord {
    private final int id;
    private final String fullName;
    private boolean active;

    public CustomerRecord(int id, String fullName, boolean active) {
        this.id = id;
        this.fullName = fullName;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void showCustomerSummary() {
        System.out.printf("Id: %d | Full name: %s | Active: %b%n", id ,fullName, active);
    }
}

class CustomerService {
    private final ArrayList<CustomerRecord> customers = new ArrayList<>();

    public void addCustomer(CustomerRecord customer) {
        if (customer == null) {
            return;
        }

        customers.add(customer);
    }

    public CustomerRecord findById(int id) {
        if (id < 1) {
            return null;
        }

        for (CustomerRecord customer : customers) {
            if (id == customer.getId()) {
                return customer;
            }
        }

        return null;
    }

    public boolean updateStatusById(int id, boolean newStatus) {
        if (id < 1) {
            return false;
        }

        CustomerRecord foundCustomer = findById(id);

        if (foundCustomer != null) {
            foundCustomer.setActive(newStatus);
            return true;
        }

        return false;
    }
}

public class Exercise03 {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();

        customerService.addCustomer(new CustomerRecord(1, "Ezequias Souza", true));
        customerService.addCustomer(new CustomerRecord(2, "Marli Santos", true));
        customerService.addCustomer(new CustomerRecord(3, "Pedro Henrique", false));

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter id: ");
            int id = scanner.nextInt();

            boolean changed = customerService.updateStatusById(id, true);

            if (changed) {
                System.out.println("Status updated successfully");
                CustomerRecord foundCustomer = customerService.findById(id);
                foundCustomer.showCustomerSummary();
            } else {
                System.out.println("Customer not found");
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid id input");
        }
    }
}