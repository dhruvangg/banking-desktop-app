/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package champ;

/**
 *
 * @author dhruvang.gajjar
 */
public class Account {
    private final String accountNumber;
    private final String accountHolderName;
    private double balance;
    
    public Account(String accountNumber, String accountHolderName, double balance){
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }
    
    public String getAccountNumber(){
        return this.accountNumber;
    }
    
    public String getAccountHolderName(){
        return this.accountHolderName;
    }
    
    public double getBalnce(){
        return this.balance;
    }
    
    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("Deposited: ₹" + amount);
        }
    }
    
    public boolean withdraw(double amount){
        if(amount > 0 && amount <= balance){
            balance -= amount;
            System.out.println("withdrawn: ₹" + amount);
            return true;
        } else {
            System.out.println("Invalid withdrawl amount or insufficient balance!");
            return false;
        }
    }
    
    public void displayAccountDetails(){
        System.out.println("\nAccount Number: "+ accountNumber);
        System.out.println("Account Holder Name: "+ accountHolderName);
        System.out.println("\nBalance: INR"+ balance);
    }
}
