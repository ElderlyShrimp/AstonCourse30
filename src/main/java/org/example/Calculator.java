package org.example;

public class Calculator {
    public static int sum(int a, int b){
        return a + b;
    }

    public static int subtraction(int a, int b){
        return a - b;
    }

    public static int split(int a, int b){
        if (b != 0) return a / b;
        else {
            throw new ArithmeticException("Делить на 0 нельзя!");
        }
    }

    public static int multiplication(int a, int b){
        return a * b;
    }

}