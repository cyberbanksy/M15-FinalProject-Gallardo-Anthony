package com.company;

public class Director extends Crew {
    private double royalities;

    public Director(String name,double salary, String department){
        super(name,salary,department);
        this.royalities = 0;

    }
    public void RoyalCalc(){
        royalities = Movie.getProfit() * .01;
        updateMoneyEarned(royalities);
    }

    public double getRoyalities() {
        return royalities;
    }
    public void updateMoneyEarned(double royalities){
        earnedIncome += royalities;
    }

}
