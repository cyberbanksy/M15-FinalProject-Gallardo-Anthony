package com.company;
public class PA extends Crew{
 private double hoursWorked;

 public PA(String name, double salary, String department){
  super(name,salary,department);
  this.hoursWorked = 0;

 }

 public double getHoursWorked() {
  return hoursWorked;
 }

 public void setHoursWorked(double hoursWorked) {
  this.hoursWorked += hoursWorked;
 }
 public void payCalc(){
  earnedIncome = getSalary() * hoursWorked;
  System.out.println("Your PA's earned income is" + earnedIncome);
  this.hoursWorked = 0;
 }
}
