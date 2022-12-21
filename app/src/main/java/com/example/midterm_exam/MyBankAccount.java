package com.example.midterm_exam;

import java.io.Serializable;

public class MyBankAccount implements Serializable {
    // variables
    private int accountNumber;
    private double balance;
    private String bankName;

    // Constructor
    public MyBankAccount(int accountNumber, double balance, String bankName) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.bankName = bankName;
    }
    //Getters
    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getBankName() {
        return bankName;
    }
    //Setters
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    //methods to deposit and withdraw
    public void deposit(double amount){
        balance += amount;
    }
    public void  withdraw(double amount){
        //check if account has enough funds
        if(balance > amount){
            balance -= amount;
        }
    }
}
