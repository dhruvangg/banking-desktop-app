/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package champ;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dhruvang.gajjar
 */
public class Bank {

    private final Map<String, Account> accounts = new HashMap<>();

    public void createAccount(String accountNumber, String accountHolderName, double initialBalance) {
        if (!accounts.containsKey(accountNumber)) {
            accounts.put(accountNumber, new Account(accountNumber, accountHolderName, initialBalance));
            System.out.println("Account created Successfully!");
        } else {
            System.out.println("Account number already exists");
        }
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public void transferFunds(String fromAcc, String toAcc, double amount) {
        Account sender = accounts.get(fromAcc);
        Account receiver = accounts.get(toAcc);

        if (sender == null || receiver == null) {
            System.out.println("Invalid account number(s)!");
        }

        if (sender.withdraw(amount)) {
            receiver.deposit(amount);
            System.out.println("Transfer successful!");
        }
    }

    public void listAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found!");
            return;
        }
        System.out.println("\n --- Bank Accounts ---");
        for (Account acc : accounts.values()) {
            acc.displayAccountDetails();
        }
    }
}
