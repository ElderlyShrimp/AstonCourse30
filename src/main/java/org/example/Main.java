package org.example;

import static org.example.LessonOne.*;

public class Main {
    public static void main(String[] args) {
        LessonOne method = new LessonOne();
        method.printThreeWords();

        method.checkSumSign();

        method.printColor();

        method.compareNumbers();

        System.out.println(checkingAmount(1, 9));
        System.out.println();

        method.positiveOrNegative(-1);

        System.out.println(isNegative(333));
        System.out.println();

        method.printStringToNumber("восьмой метод", 3);

        System.out.println(leapYear(104));
        System.out.println();

        method.changeArray();

        method.emptyArray();

        method.multiplySmallNumbers();

        method.squareArray();

        method.createArray(3, 5);
    }
}