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
        int value = 111;
        if (value <= 0){
            System.out.println("Красный");
        }
        else if ((value > 0) && (value <= 100)) {
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
    public void changeArray(){
        int[] arr = {1, 0, 1, 0, 1, 0};
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == 1){
                arr[i] = 0;
            }
            else {
                arr[i] = 1;
            }
        }
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println();
    }

    // Метод 11
    public void emptyArray(){
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++){
            arr[i] = i + 1;
        }
        for (int i = 0; i < 100; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println();
    }

    // Метод 12
    public void multiplySmallNumbers(){
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < 6){
                arr[i] = arr[i] * 2;
            }
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println();
    }

    // Метод 13
    public void squareArray(){
        int[][] arr = new int[5][5];
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length; j++){
                if (i == j){
                    arr [i][j] = 1;
                }
                else if (i + j == arr.length - 1){
                    arr[i][j] = 1;
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Метод 14
    public void createArray(int len, int initialValue){
        int[] arr = new int[len];
        for (int i = 0; i < len; i++){
            arr[i] = initialValue;
            System.out.print(arr[i] + " ");
        }
    }
}
