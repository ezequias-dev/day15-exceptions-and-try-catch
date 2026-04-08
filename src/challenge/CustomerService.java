package challenge;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private final List<CustomerRecord> customers = new ArrayList<>();

    public boolean addCustomer(CustomerRecord customer) {
        if (customer == null || !customer.isValidCustomer()) {
            return false;
        }

        if (findById(customer.getId()) != null) {
            return false;
        }

        customers.add(customer);
        return true;
    }

    public void listCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers registered.");
            return;
        }

        for (CustomerRecord customer : customers) {
            customer.showCustomerSummary();
        }
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

    public boolean updateActiveById(int id, boolean active) {
        CustomerRecord foundCustomer = findById(id);

        if (foundCustomer == null) {
            return false;
        }

        foundCustomer.setActive(active);
        return true;
    }

    public boolean removeById(int id) {
        CustomerRecord foundCustomer = findById(id);

        if (foundCustomer == null) {
            return false;
        }

        customers.remove(foundCustomer);
        return true;
    }

    public int countActiveCustomers() {
        int activeCustomers = 0;

        for (CustomerRecord customer : customers) {
            if (customer.isActive()) {
                activeCustomers++;
            }
        }

        return activeCustomers;
    }

    public int getTotalCustomers() {
        return customers.size();
    }
}