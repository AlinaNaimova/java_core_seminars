package ru.alina_corp.lesson3hw.company;

public class Freelancer extends BaseWorker {
    private final double hourlyRate;
    private final int workedHours;

    public Freelancer(String name, double hourlyRate, int workedHours, String position) {
        super(name, 0, position);
        this.hourlyRate = hourlyRate;
        this.workedHours = workedHours;
        this.monthlyPayment = calculateAverageMonthlySalary();

    }


    @Override
    public double calculateAverageMonthlySalary() {
        return 20.8 * 8 * hourlyRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public int getWorkedHours() {
        return workedHours;
    }
}
