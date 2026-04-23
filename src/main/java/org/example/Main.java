package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        students.add(new Student("Мария Ряттель", "0323", 4, List.of(4, 5, 4, 3)));
        students.add(new Student("Александр Трусов", "1324-А", 3, List.of(3, 2, 4, 3)));
        students.add(new Student("Павел Дуров", "2123", 1, List.of(3, 2, 2, 3, 5, 1)));

        deleteStudent(students);

        promoteStudents(students);

        printStudents(students, 4);


        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "89117113232");
        phoneBook.add("Иванов", "89552321111");
        phoneBook.add("Сидоров", "89532343232");
        System.out.println(phoneBook.get("Иванов"));
    }

    public static void deleteStudent(Set<Student> students){
        Iterator<Student> iterator = students.iterator();

        while (iterator.hasNext()){
            Student student = iterator.next();
            if (student.averageGrade() < 3.0){
                iterator.remove();
            }
        }
    }

    public static void promoteStudents(Set<Student> students){
        for (Student student : students){
            if (student.averageGrade() >= 3.0){
                student.setCourse(student.getCourse() + 1);
            }
        }
    }

    public static void printStudents(Set<Student> students, int course){
        for (Student student : students){
            if (student.getCourse() == course){
                System.out.println(student.getName());
            }
        }
    }

}