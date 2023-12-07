package ru.alina_corp.lesson1.sample;


import ru.alina_corp.lesson1.regular.Calculator;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int a = 10;
        int b = 5;

        System.out.println("Сумма: " + calculator.sum(a, b));
        System.out.println("Разность: " + calculator.subtract(a, b));
        System.out.println("Произведение: " + calculator.multiply(a, b));
        System.out.println("Частное: " + calculator.divide(a, b));
    }
}
