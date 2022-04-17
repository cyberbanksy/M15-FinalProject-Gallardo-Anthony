package com.company;

public class Person{
    // state or properties
    private String name;
    private double salary;
    protected double earnedIncome;
    public Person(String name, double salary){
        this.name = name;
        this.salary = salary;
        this.earnedIncome = 0;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public double getEarnedIncome() {
        return earnedIncome;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setSalary(double salary){
        this.salary = salary;
    }
    public void updateEarnedIncome(){
        this.earnedIncome += getSalary();
    }
}
