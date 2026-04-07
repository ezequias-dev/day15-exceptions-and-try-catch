package review;

import java.util.ArrayList;

class UserRecord {
    private final int id;
    private final String fullName;
    private final String email;

    public UserRecord(int id, String fullName, String email) {
        this.id = id;
        this.fullName = fullName == null ? null : fullName.trim();
        this.email = email == null ? null : email.trim();
    }

    public String getEmail() {
        return email;
    }

    public boolean isValidUser() {
        return fullName != null
            && fullName.length() >= 3
            && email != null
            && email.contains("@");
    }

    public void showUserSummary() {
        System.out.printf(
            "Id: %d | Full name: %s | Email: %s%n",
            id, fullName, email
        );
    }
}

class UserService {
    private final ArrayList<UserRecord> users = new ArrayList<>();

    public boolean addUser(UserRecord user) {
        if (user == null) {
            return false;
        }

        if (!user.isValidUser()) {
            return false;
        }

        if (findByEmail(user.getEmail()) != null) {
            return false;
        }

        users.add(user);
        return true;
    }

    public void listUsers() {
        if (users.isEmpty()) {
            System.out.println("No users registered.");
            return;
        }

        for (UserRecord user : users) {
            user.showUserSummary();
        }
    }

    public UserRecord findByEmail(String email) {
        if (email == null) {
            return null;
        }

        email = email.trim();

        for (UserRecord user : users) {
            if (email.equals(user.getEmail())) {
                return user;
            }
        }
        return null;
    }
}

public class Day14QuickReview {
    public static void main(String[] args) {
        UserService userService = new UserService();
        boolean[] added = new boolean[4];

        added[0] = userService.addUser(new UserRecord(1, "Ezequias Souza", "ezequias@email.com"));
        added[1] = userService.addUser(new UserRecord(2, "Marli Santos", "marli@email.com"));
        added[2] = userService.addUser(new UserRecord(3, "Ma", "marcos@email.com"));
        added[3] = userService.addUser(new UserRecord(4, "Marli Silva", "marli@email.com"));

        for (int i = 0; i < added.length; i++) {
            System.out.println("User " + (i + 1) + " added: " + added[i]);
        }

        System.out.println();
        System.out.println("---- LIST USERS ----");
        userService.listUsers();
    }
}