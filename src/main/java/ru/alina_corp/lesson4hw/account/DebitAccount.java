package ru.alina_corp.lesson4hw.account;

/**
 * Реализация дебетового счета, унаследованного от Account.
 */
class DebitAccount extends Account {
    private double overdraft;

    public DebitAccount(double initialBalance, double overdraft) {
        super(initialBalance);
        this.overdraft = overdraft;
    }

    public double getOverdraft() {
        return this.overdraft;
    }
}