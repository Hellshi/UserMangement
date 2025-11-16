package Model.User;
public enum Role {
    Dev("dev"),
    PO("po"),
    QA("qa"),
    Manager("manager");

    private final String roleText;

    Role(String roleText) {
        this.roleText = roleText;
    }

    public static Role fromString(String input) {
        for (Role role : values()) {
            if (role.roleText.equalsIgnoreCase(input)) {
                return role;
            }
        }
        return null;
    }
}
