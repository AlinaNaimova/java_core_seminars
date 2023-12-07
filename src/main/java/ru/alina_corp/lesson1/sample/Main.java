package ru.alina_corp.lesson1.sample;


import ru.alina_corp.lesson1.regular.Calculator;
import ru.alina_corp.lesson1.regular.Formatter;
public class Main {
    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        int result = Calculator.sum(a, b);
        System.out.println(Formatter.formatOutput(result));
        result = Calculator.subtract(a, b);
        System.out.println(Formatter.formatOutput(result));
        result = Calculator.multiply(a, b);
        System.out.println(Formatter.formatOutput(result));
        result = Calculator.divide(a, b);
        System.out.println(Formatter.formatOutput(result));
    }
}
