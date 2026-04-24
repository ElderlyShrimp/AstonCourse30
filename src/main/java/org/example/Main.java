package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Факториал: " + Factorial.multiplicationNumbers(5));

        System.out.println("Площадь треугольника: " + AreaTriangle.area(4, 3));

        System.out.println("Сравнение чисел: " + ComparingNumbers.compare(3, 4));

        System.out.println("Сложение чисел: " + Calculator.sum(5, 5));
        System.out.println("Вычитание чисел: " + Calculator.subtraction(6,1));
        System.out.println("Умножение чисел: " + Calculator.multiplication(3, 4));
        System.out.println("Деление чисел " + Calculator.split(4, 2));
    }
}