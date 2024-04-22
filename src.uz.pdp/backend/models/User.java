package backend.models;

import backend.enums.Role;

public class User extends BaseModel {
    private String name;
    private Integer age;
    private String userName;
    private String password;
    private Role role;

    public User(String name, Integer age, String userName, String password, Role role) {
        this.name = name;
        this.age = age;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getStatus() {
        return role;
    }

    public void setStatus(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return userName + " " + getId();
    }
}

