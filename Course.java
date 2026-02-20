/*
 * Name: Aydan Romayor
 * Date: 2/9/2026
 * Purpose: Course Class
*/

import java.util.Arrays;
import java.util.ArrayList;

public class Course {
    // Private fields
    private String courseName;
    private ArrayList<Integer> courseGrades;
    private char[] grades = {'A', 'B', 'C', 'D', 'F'};

    // Constructor
    public Course (String name) {
        courseName = name;
        courseGrades = new ArrayList<Integer>();

        for (int i = 0; i < 5; i++) courseGrades.add(0);
    }

    // Setter and getter methods
    public void setName(String name) {
        courseName = name;
    }

    public String getName() {
        return courseName;
    }

    public void setGrade(char grade, int num) {
        int index = Arrays.binarySearch(grades, grade);
        courseGrades.set(index, num);
    }

    public int getGrades(char grade) {
        int index = Arrays.binarySearch(grades, grade);
        return courseGrades.get(index);
    }

    // Returns number of total grades
    public int getTotalGrades() {
        int total = 0;
        
        for (int i = 0; i < courseGrades.size(); i++) {
            total += courseGrades.get(i);
        }

        return total;
    }

    // Returns the percentage of A's in all the grades
    public double getAPercent() {
        int total = getTotalGrades();
        if (total == 0) return 0.0;
        return (double) courseGrades.get(0) / total * 100.0;
    }

    // Returns a string version of the course
    public String toString() {
        return String.format("Course: " + getName() + "\nA: " + getGrades('A') + "\nB: " + getGrades('B') + "\nC: " + getGrades('C') + "\nD: " + getGrades('D') + "\nF: " + getGrades('F') + "\nTotal: " + getTotalGrades() + "\nA%%: " + "%.2f", getAPercent());
    }
}