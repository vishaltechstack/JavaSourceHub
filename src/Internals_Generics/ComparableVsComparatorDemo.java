package Internals_Generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// 1. Implementing Comparable<Student> defines the DEFAULT sort order (by rollNumber ascending)
class Student implements Comparable<Student> {
    int rollNumber;
    String name;
    double gpa;

    public Student(int rollNumber, String name, double gpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.gpa = gpa;
    }

    // Natural ordering: returns negative if 'this < other', 0 if equal, positive if 'this > other'
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.rollNumber, other.rollNumber);
    }

    @Override
    public String toString() {
        return "Roll: " + rollNumber + " | Name: " + name + " | GPA: " + gpa;
    }
}

public class ComparableVsComparatorDemo {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student(103, "Rohan", 8.4));
        students.add(new Student(101, "Vishal", 9.2));
        students.add(new Student(102, "Ananya", 9.6));

        // 1. Sorting using Comparable (Natural Order: Roll Number)
        Collections.sort(students);
        System.out.println("=== 1. Natural Order (Comparable - Roll Number) ===");
        students.forEach(System.out::println);

        // 2. Sorting using Comparator (Custom Order 1: Alphabetical by Name)
        Comparator<Student> byName = (s1, s2) -> s1.name.compareTo(s2.name);
        students.sort(byName);
        System.out.println("\n=== 2. Custom Order (Comparator - Name A-Z) ===");
        students.forEach(System.out::println);

        // 3. Sorting using Comparator (Custom Order 2: Highest GPA first)
        students.sort(Comparator.comparingDouble((Student s) -> s.gpa).reversed());
        System.out.println("\n=== 3. Custom Order (Comparator - Highest GPA) ===");
        students.forEach(System.out::println);
    }
}