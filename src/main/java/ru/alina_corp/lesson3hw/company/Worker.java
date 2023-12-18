package ru.alina_corp.lesson3hw.company;

public class Worker extends BaseWorker {

    public Worker(String name, double monthlyPayment, String position) {
        super(name, monthlyPayment, position);
    }

    @Override
    public double calculateAverageMonthlySalary() {
        return monthlyPayment;
    }
}
