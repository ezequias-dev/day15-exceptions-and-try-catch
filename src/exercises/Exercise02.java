package exercises;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class UserRecord {
    private final int id;
    private final String fullName;

    public UserRecord(int id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void showUserSummary() {
        System.out.printf(
            "Id: %d | Full name: %s%n", id, fullName
        );
    }
}

class UserService {
    private final ArrayList<UserRecord> users = new ArrayList<>();

    public void addUser(UserRecord user) {
        if (user == null) {
            return;
        }

        users.add(user);
    }

    public UserRecord findById(int id) {
        if (id < 1) {
            return null;
        }

        for (UserRecord user : users) {
            if (id == user.getId()) {
                return user;
            }
        }

        return null;
    }
}

public class Exercise02 {
    public static void main(String[] args) {
        UserService userService = new UserService();

        userService.addUser(new UserRecord(1, "Ezequias Souza"));
        userService.addUser(new UserRecord(2, "Marli Santos"));
        userService.addUser(new UserRecord(3, "Pedro Silva"));

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter id: ");
            int id = scanner.nextInt();

            UserRecord foundUser = userService.findById(id);

            if (foundUser != null) {
                foundUser.showUserSummary();
            } else {
                System.out.println("User not found");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid id input");
        }
    }
}