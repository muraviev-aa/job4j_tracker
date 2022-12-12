package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int minus(int a) {
        return a - x;
    }

    public double divide(int a) {
        return a / x;
    }

    public static int sum(int a) {
        return x + a;
    }

    public int multiply(int a) {
        return x * a;
    }

    public double sumAllOperation(int a) {
        return sum(a) + multiply(a) + minus(a) + divide(a);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(sum(3));
        System.out.println(calculator.multiply(4));
        System.out.println(minus(2));
        System.out.println(calculator.divide(11));
        System.out.println(calculator.sumAllOperation(2));
    }
}
