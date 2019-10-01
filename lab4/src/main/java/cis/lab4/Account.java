package cis.lab4;

/*
 * Tim Malko (timofeymalko@stu.smccd.edu or timofei.malko@gmail.com)
 * Date: 9/16/2019
 *
 * Account.java
 * Account class with a constructor to validate and
 * initialize instance variable balance of type double.
 */
public class Account {
    private double checkingBalance;
    private double savingsBalance;

    public Account(double savingsBalance, double checkingBalance) {
        this.checkingBalance = checkingBalance < 0 ? 0 : checkingBalance;
        this.savingsBalance = savingsBalance < 0 ? 0 : savingsBalance;
    }

    public void creditSavings(double amount) {
        if (amount > 0)
            setSavingsBalance(getSavingsBalance() + amount);
    }

    public void creditChecking(double amount) {
        if (amount > 0)
            setCheckingBalance(getCheckingBalance() + amount);
    }

    public void debitChecking(double amount) {
        if (amount > 0 && amount <= getCheckingBalance())
            setCheckingBalance(getCheckingBalance() - amount);
    }

    public void debitSavings(double amount) {
        if (amount > 0 && amount <= getSavingsBalance())
            setSavingsBalance(getSavingsBalance() - amount);
    }

    public void moveFromCheckingToSavings(double amount) {
        if (amount > 0 && amount <= getCheckingBalance()) {
            debitChecking(amount);
            creditSavings(amount);
        }
    }

    public void moveFromSavingsToChecking(double amount) {
        if (amount > 0 && amount <= getSavingsBalance()) {
            debitSavings(amount);
            creditChecking(amount);
        }
    }

    @Override
    public String toString() {
        return String.format("account's balance:\n saving: $%.2f\n checking $%.2f",
                getSavingsBalance(), getCheckingBalance());
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void setSavingsBalance(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }
}
