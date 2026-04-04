package org.example;


import javax.sound.midi.Soundbank;

import java.sql.SQLOutput;

import static org.example.LessonOne.*;

public class Main {
    public static void main(String[] args) {
        LessonOne method1 = new LessonOne();
        method1.printThreeWords();

        LessonOne method2 = new LessonOne();
        method2.checkSumSign();

        LessonOne method3 = new LessonOne();
        method3.printColor();

        LessonOne method4 = new LessonOne();
        method4.compareNumbers();

        System.out.println(checkingAmount(1, 9));
        System.out.println();

        LessonOne method6 = new LessonOne();
        method6.positiveOrNegative(-1);

        System.out.println(isNegative(333));
        System.out.println();

        LessonOne method8 = new LessonOne();
        method8.printStringToNumber("восьмой метод", 3);

        System.out.println(leapYear(104));
        System.out.println();


    }
}