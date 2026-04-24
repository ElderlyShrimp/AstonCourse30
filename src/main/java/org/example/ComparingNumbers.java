package org.example;

public class ComparingNumbers {
    public static String compare(int a, int b){
        if (a > b){
            return  a + " больше " + b;
        }
        if (a < b) return b + " больше " + a;
        else return "Числа равны";
    }
}
