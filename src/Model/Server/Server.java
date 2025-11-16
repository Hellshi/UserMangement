package Model.Server;
import Controller.Users.UserController;

import java.util.Scanner;

public class Server {
    UserController userController;
    Scanner scanner = new Scanner(System.in);

    public void start() {

        System.out.println("Server started. Type 'exit' to stop.\n");

        while (true) {
            System.out.print("Enter command: \n create \n read \n update \n delete \n list \n exit\n");
            String command = scanner.nextLine().trim();

            ServerActions action = ServerActions.fromCommand(command);

            if (action == null) {
                System.out.println("Unknown command. Try: create, read, update, delete, list, exit\n");
                continue;
            }

            if (action == ServerActions.EXIT) {
                System.out.println("Stopping server...");
                break;
            }

            execute(action);
        }
    }

    private void execute(ServerActions action) {
        switch (action) {
            case CREATE_USER:
                System.out.println("[SERVER] Creating user...");
                String name = scanner.nextLine().trim();
                double salary = Double.parseDouble(scanner.nextLine().trim());
                String role = scanner.nextLine().trim();
                this.userController.createUser(salary, name, role);
                break;

            case READ_USER:
                System.out.println("[SERVER] Reading user...");
                break;

            case UPDATE_USER:
                System.out.println("[SERVER] Updating user...");
                break;

            case DELETE_USER:
                System.out.println("[SERVER] Deleting user...");
                break;

            case LIST_ALL_USERS:
                System.out.println("[SERVER] Listing all users...");
                break;

            default:
                System.out.println("[SERVER] Unknown action.");
        }

        System.out.println();
    }
}
