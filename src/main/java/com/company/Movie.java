package com.company;

import java.util.List;

public class Movie {
private String genre;
private Director director;
private List <Actor> actors;
private List <Crew> crews;
private double budget;
private double moneyEarned;
private double moneySpent;
private static double profit;

public void Movie(String genre, Director director,List<Actor>actors,List<Crew>crews,double budget){
    this.genre = genre;
    this.director = director;
    this.actors = actors;
    this.crews = crews;
    this.budget =budget;
    this.moneyEarned = 0;
    this.moneySpent = 0;
    this.profit = 0;
}
public void updateProfit(double moneyEarned){
    this.profit = (this.budget-this.moneySpent) + moneyEarned;
    System.out.println("This movie made this much $" + this.profit);
}

public void updateMoneySpent(double moneySpent){
    this.moneySpent += this.moneySpent;

}

public void payDay(){
    updateMoneySpent(director.getSalary());
    director.updateMoneyEarned(director.getSalary());

    for(Actor actor:actors){
        actor.updateEarnedIncome();
        updateMoneySpent(actor.getSalary());
    }
    for(Crew crew:crews){
        crew.updateEarnedIncome();
        updateMoneySpent(crew.getSalary());
    }
    System.out.println("This Movie spent $"+moneySpent +" out of the budget $"+ moneyEarned);
}

public void updateMoneyEarned(double moneyEarned){
    this.moneyEarned += moneyEarned;
    updateProfit(moneyEarned);
    director.RoyalCalc();

}


    public static double getProfit() {
        return 0;
    }
}
