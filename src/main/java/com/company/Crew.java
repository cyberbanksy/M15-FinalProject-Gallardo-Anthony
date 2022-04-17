package com.company;

public class Crew extends Person {
    private String department;

    public Crew(String name,double salary,String department){
        super(name,salary);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
