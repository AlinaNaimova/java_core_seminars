package ru.alina_corp.lesson4hw.account;

/**
 * Реализация кредитного счета, унаследованного от Account.
 */
class CreditAccount extends Account {
    private double creditLimit;

    public CreditAccount(double initialBalance, double creditLimit) {
        super(initialBalance);
        this.creditLimit = creditLimit;
    }

    public double getCreditLimit() {
        return this.creditLimit;
    }
}
