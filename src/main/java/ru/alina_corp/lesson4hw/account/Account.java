package ru.alina_corp.lesson4hw.account;

public class Account {
    private double balance;

    /**
     * Конструктор для инициализации баланса счета.
     * @param initialBalance начальный баланс счета
     * @throws IllegalArgumentException если начальный баланс отрицательный
     */
    public Account(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Начальный баланс не может быть отрицательным");
        }
        this.balance = initialBalance;
    }

    /**
     * Метод для внесения денежного вклада на счет.
     * @param amount сумма вклада
     * @throws IllegalArgumentException если сумма вклада отрицательная
     */
    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Сумма депозита не может быть отрицательной");
        }
        this.balance += amount;
    }

    /**
     * Метод для снятия денег со счета.
     * @param amount сумма для снятия
     * @throws InsufficientFundsException если недостаточно средств на счете
     */
    public void withdraw(double amount) {
        if (amount > this.balance) {
            throw new InsufficientFundsException("Недостаточно средств. Текущий баланс: " + this.balance);
        }
        this.balance -= amount;
    }

    /**
     * Метод для получения текущего баланса счета.
     * @return текущий баланс счета
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * Точка входа в программу.
     */
    public static void main(String[] args) {
        try {
            Account account = new Account(100.0);
            System.out.println("Начальный баланс: " + account.getBalance());
            account.deposit(50.0);
            System.out.println("Баланс после внесения депозита: " + account.getBalance());
            account.withdraw(30.0);
            System.out.println("Баланс после снятия средств: " + account.getBalance());
            // Создание объектов различных типов счетов
            CreditAccount creditAccount = new CreditAccount(500.0, 1000.0);
            DebitAccount debitAccount = new DebitAccount(200.0, 50.0);
            // Проведение транзакции между счетами
            Transaction.transfer(creditAccount, debitAccount, 300.0);
            System.out.println("Остаток кредитного счета после перевода:" + creditAccount.getBalance());
            System.out.println("Остаток дебетового счета после перевода: " + debitAccount.getBalance());
            // Попытка провести транзакцию с недостаточными средствами
            Transaction.transfer(debitAccount, creditAccount, 100.0); // Кидает исключение InsufficientFundsException
        } catch (IllegalArgumentException | InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}



