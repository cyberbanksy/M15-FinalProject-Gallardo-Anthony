package com.company;

public class Actor extends Person {
    private String role;

    public Actor(String name, double salary, String role){
        super(name,salary);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
