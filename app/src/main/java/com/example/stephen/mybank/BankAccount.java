package com.example.stephen.mybank;

import java.util.InputMismatchException;

/**
 * Created by gamee on 2/16/2016.
 */
public class BankAccount {

    private static final double overDraftFee = 30;
    private double balance;

    public double withdraw(double money) {
       return balance -= money;
    }

    public void deposit(double money) {
        balance += money;

    }

    public double BankBalance() {
        return balance;
    }

    public static double odf(){

        return overDraftFee;
    }

}
