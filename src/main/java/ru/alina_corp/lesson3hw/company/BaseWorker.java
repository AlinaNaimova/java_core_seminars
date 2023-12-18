package ru.alina_corp.lesson3hw.company;

/**
 * Абстрактный класс BaseWorker является базовым классом для всех сотрудников.
 * Он содержит общие поля и методы, которые должны быть реализованы в подклассах.
 */
public abstract class BaseWorker implements Comparable<BaseWorker>{
    protected String name;
    protected Double monthlyPayment;
    protected String position;


    /**
     * Конструктор класса BaseWorker принимает имя, ежемесячную зарплату и должность сотрудника.
     *
     * @param name           имя сотрудника
     * @param monthlyPayment ежемесячная зарплата сотрудника
     * @param position       должность сотрудника
     */
    public BaseWorker(String name, double monthlyPayment, String position) {
        this.name = name;
        this.monthlyPayment = monthlyPayment;
        this.position = position;
    }


    /**
     * Абстрактный метод calculateAverageMonthlySalary должен быть реализован в подклассах
     * и должен возвращать среднюю ежемесячную зарплату сотрудника.
     *
     * @return средняя ежемесячная зарплата сотрудника
     */
    public abstract double calculateAverageMonthlySalary();

    public String getName() {
        return name;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public String getPosition() {
        return position;
    }

    /**
     * Метод compareTo сравнивает текущий объект BaseWorker с переданным объектом o
     * на основе значения поля monthlyPayment.
     *
     * @param o объект для сравнения
     * @return отрицательное значение, если текущий объект меньше переданного,
     *         положительное значение, если текущий объект больше переданного,
     *         нуль, если объекты равны
     */
    @Override
    public int compareTo(BaseWorker o) {
        return this.monthlyPayment.compareTo(o.monthlyPayment);
    }


    @Override
    public String toString() {
        return "\n" + "BaseWorker: " +
                "name='" + name + '\'' +
                ", monthlyPayment=" + monthlyPayment +
                ", position='" + position + '\'' +
                '.' + "\n";
    }
}
