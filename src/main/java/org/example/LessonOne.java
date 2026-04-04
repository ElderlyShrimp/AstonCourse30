package org.example;

public class LessonOne {
    // Метод 1
    public void printThreeWords(){
        System.out.println("Orange\nBanana\nApple\n");
    }

    // Метод 2
    public void checkSumSign(){
        int a = -5;
        int b = 3;
        if ((a + b) >= 0) {
            System.out.println("Сумма положительная");
        }
        else {
            System.out.println("Сумма отрицательная");
        }
        System.out.println();
    }

    // Метод 3
    public void printColor(){
        int a = 111;
        if (a <= 0){
            System.out.println("Красный");
        }
        else if ((a > 0) && (a <= 100)) {
            System.out.println("Желтый");
        }
        else {
            System.out.println("Зеленый");
        }
        System.out.println();
    }

    // Метод 4
    public void compareNumbers(){
        int a = 10;
        int b = 10;
        if (a >= b){
            System.out.println("a >= b");
        }
        else {
            System.out.println("a < b");
        }
        System.out.println();
    }

    // Метод 5
    public static boolean checkingAmount(int a, int b){
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    // Метод 6
    public void positiveOrNegative(int a){
        if (a < 0){
            System.out.println("Отрицательное");
        }
        else {
            System.out.println("Положительное");
        }
        System.out.println();
    }

    // Метод 7
    public static boolean isNegative(int a){
        return a >= 0;
    }

    // Метод 8
    public void printStringToNumber(String a, int b){
        for (int i = 0; i < b; i++){
            System.out.println(a);
        }
        System.out.println();
    }

    // Метод 9
    public static boolean leapYear(int a){
        if (a % 400 == 0){
            return true;
        }
        else if (a % 100 == 0){
            return false;
        }
        else if (a % 4 == 0){
            return true;
        }
        else {
            return false;
        }
    }

    // Метод 10

    // Метод 11

    // Метод 12

    // Метод 13

    // Метод 14
}
