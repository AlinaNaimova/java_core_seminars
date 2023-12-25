package ru.alina_corp.lesson4hw.account;

class Transaction {
    /**
     * Переводит указанную сумму с одного счета на другой.
     * @param fromAccount счет, с которого переводятся средства
     * @param toAccount счет, на который переводятся средства
     * @param amount сумма перевода
     * @throws InsufficientFundsException если недостаточно средств на счете fromAccount
     */
    public static void transfer(Account fromAccount, Account toAccount, double amount) {
        try {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
        } catch (InsufficientFundsException e) {
            throw new TransactionException("Transaction failed: " + e.getMessage());
        }
    }
}
