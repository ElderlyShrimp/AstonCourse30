package org.example;

import java.util.List;

public class Student {
    String name;
    String group;
    int course;
    List<Integer> grades;

    public Student(String name, String group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public double getAverageGrade() {
        int sum = 0;
        for (int i = 0; i < grades.size(); i++) {
            sum = sum + grades.get(i);
        }
        return (double) sum / grades.size();
    }
}