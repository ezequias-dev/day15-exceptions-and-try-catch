package challenge;

public class CustomerRecord {
    private final int id;
    private final String fullName;
    private final String email;
    private boolean active;

    public CustomerRecord(int id, String fullName, String email, boolean active) {
        this.id = id;
        this.fullName = normalize(fullName);
        this.email = normalize(email);
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isValidCustomer() {
        return id > 0
            && hasValidFullName()
            && hasValidEmail();
    }

    public void showCustomerSummary() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format(
            "Id: %d | Full name: %s | Email: %s | Active: %b",
            id, fullName, email, active
        );
    }

    private boolean hasValidFullName() {
        return fullName != null && fullName.length() >= 3;
    }

    private boolean hasValidEmail() {
        if (email == null) {
            return false;
        }

        int atIndex = email.indexOf('@');
        int lastAtIndex = email.lastIndexOf('@');
        int dotIndex = email.lastIndexOf('.');

        return atIndex > 0
            && atIndex == lastAtIndex
            && dotIndex > atIndex + 1
            && dotIndex < email.length() - 1;
    }

    private static String normalize(String value) {
        if (value == null) {
            return null;
        }

        String normalized = value.trim();
        return normalized.isEmpty() ? null : normalized;
    }
}
