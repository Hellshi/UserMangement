package Model.Server;

public enum ServerActions {
    CREATE_USER("create"),
    READ_USER("read"),
    UPDATE_USER("update"),
    DELETE_USER("delete"),
    LIST_ALL_USERS("list"),
    EXIT("exit");

    private final String commandText;

    ServerActions(String commandText) {
        this.commandText = commandText;
    }

    public String getCommandText() {
        return commandText;
    }

    // Find enum by command
    public static ServerActions fromCommand(String input) {
        for (ServerActions action : values()) {
            if (action.commandText.equalsIgnoreCase(input)) {
                return action;
            }
        }
        return null;
    }
}