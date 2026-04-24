package org.example;

public class Factorial {
    public static long multiplicationNumbers(int a){
        long result = 1;
        for (int i = 2; i <= a; i++){
            result *= i;
        }
        return result;
    }
}
