package Model.User;

import Model.Repository.BaseEntity;

public class UserEntity extends BaseEntity<UserEntity> implements IUser {
    private String id;
    private double salary;
    private String name;
    private Role role;

    public UserEntity() {
    }

    public void setAttributes(double salary, String name, Role role) {
        this.setSalary(salary);
        this.setName(name);
        this.setRole(role);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
