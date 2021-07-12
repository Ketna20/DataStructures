package oopconcepts;
/*
 * ketnakhalasi created on 7/12/21
 * */

public class BankAccount {
    private String accountHolder;
    private int accountNumber;
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void depositAmount(double amount) {
        this.balance += amount;
    }

    public void withdrawAmount(double amount) {

        if (balance > amount) {
            balance -= amount;
        } else {
            System.out.println("not enough balance to withdraw this amount.");
        }
    }

}
