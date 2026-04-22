package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание 1");

        List<Student> students = new ArrayList<>();

        List<Integer> g1 = new ArrayList<>();
        g1.add(5);
        g1.add(4);
        g1.add(5);
        g1.add(4);
        g1.add(5);
        students.add(new Student("Иванов Иван", "А-01", 1, g1));

        List<Integer> g2 = new ArrayList<>();
        g2.add(2);
        g2.add(3);
        g2.add(2);
        g2.add(2);
        g2.add(3);
        students.add(new Student("Петров Петр", "Б-02", 2, g2));

        List<Integer> g3 = new ArrayList<>();
        g3.add(4);
        g3.add(4);
        g3.add(3);
        g3.add(5);
        g3.add(4);
        students.add(new Student("Сидорова Анна", "А-01", 1, g3));

        List<Integer> g4 = new ArrayList<>();
        g4.add(2);
        g4.add(2);
        g4.add(2);
        g4.add(2);
        g4.add(2);
        students.add(new Student("Козлов Дмитрий", "В-03", 3, g4));

        List<Integer> g5 = new ArrayList<>();
        g5.add(5);
        g5.add(5);
        g5.add(4);
        g5.add(5);
        g5.add(5);
        students.add(new Student("Смирнова Елена", "Б-02", 2, g5));

        List<Integer> g6 = new ArrayList<>();
        g6.add(3);
        g6.add(3);
        g6.add(4);
        g6.add(3);
        g6.add(4);
        students.add(new Student("Васильев Андрей", "В-03", 3, g6));

        System.out.println("Список студентов:");
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            System.out.println(s.name + " | курс " + s.course + " | средний балл " + s.getAverageGrade());
        }

        for (int i = students.size() - 1; i >= 0; i--) {
            if (students.get(i).getAverageGrade() < 3) {
                System.out.println("Удаляем " + students.get(i).name);
                students.remove(i);
            }
        }

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getAverageGrade() >= 3) {
                students.get(i).course = students.get(i).course + 1;
                System.out.println(students.get(i).name + " переведён на " + students.get(i).course + " курс");
            }
        }

        System.out.println("Оставшиеся студенты:");
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            System.out.println(s.name + " | курс " + s.course);
        }

        Set<Student> studentSet = new HashSet<>();
        for (int i = 0; i < students.size(); i++) {
            studentSet.add(students.get(i));
        }

        printStudents(studentSet, 2);
        printStudents(studentSet, 3);
        printStudents(studentSet, 4);

        System.out.println();
        System.out.println("Задание 2");

        PhoneBook pb = new PhoneBook();

        pb.add("Иванов", "89111234567");
        pb.add("Петров", "89117654321");
        pb.add("Иванов", "89119876543");
        pb.add("Сидоров", "89115556677");
        pb.add("Иванов", "89111234567");

        System.out.println("Номера Иванова: " + pb.get("Иванов"));
        System.out.println("Номера Петрова: " + pb.get("Петров"));
        System.out.println("Номера Кузнецова: " + pb.get("Кузнецов"));

        System.out.println("Телефонный справочник:");
        for (Map.Entry<String, List<String>> entry : pb.book.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void printStudents(Set<Student> students, int course) {
        System.out.println("Студенты на " + course + " курсе:");
        for (Student s : students) {
            if (s.course == course) {
                System.out.println(" - " + s.name);
            }
        }
    }
}