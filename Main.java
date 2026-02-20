/*
 * Name: Aydan Romayor, Matthew Briones, Giovanni Hinojosa
 * Date: 2/20/2026
 * Program: Course Grades Analyzer - reads CSV grade totals and analyzes A percentages.
 */

// Imports that allow us to read files
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Course> courses = new ArrayList<Course>(); // Create a list of courses
        File courseFile = new File("courseAndGradesData.csv"); // Open the csv file
        
        String line;
        String[] courseData;
        ArrayList<Integer> grades = new ArrayList<Integer>();
        try (Scanner scnr = new Scanner(courseFile)) { // Initialize a scanner to read the file
            // Skips the first two lines
            scnr.nextLine();
            scnr.nextLine();
            while(scnr.hasNextLine()) { // Checks if the file has ended
                line = scnr.nextLine();
                courseData = line.split(","); // Splits the line into parts based on where the commas are

                // Converts the grades in the cvs file into useable integers
                for (int i = 1; i < courseData.length; i++) {
                    grades.add(Integer.parseInt(courseData[i]));
                }

                Course c = new Course(courseData[0]); // Creates a course object
                // Sets each grade individually
                c.setGrade('A', grades.get(0));
                c.setGrade('B', grades.get(1));
                c.setGrade('C', grades.get(2));
                c.setGrade('D', grades.get(3));
                c.setGrade('F', grades.get(4));

                courses.add(c); // Adds the course to the course list
                grades.clear(); // Clears the grades list for the next iteration
            }
            scnr.close(); // Close the file
        } catch (FileNotFoundException e) { // Exception in case something goes wrong
            System.out.println("An error occured.");
            e.printStackTrace();
        }

        // Print the summary table for all clases and find the best course
        Course best = courses.get(0);
        for (Course c : courses) {
            System.out.println(c);
            System.out.println();

            if (c.getAPercent() > best.getAPercent()) {
                best = c;
            }
        }

        // Prints the best course
        System.out.println("Best Course:");
        System.out.println(best);

        Scanner scnr = new Scanner(System.in);
        String userCourse;
        boolean found = false;

        // Asks the user to search for a class
        System.out.println("\nSearch for a class: ");
        userCourse = scnr.next();
        scnr.close();

        System.out.println("\nSearching for class...");


        // Searches the class database for the requested class using a linear search
        for (Course c : courses) {
            if (c.getName().equalsIgnoreCase(userCourse)) {
                found = true;
                System.out.println("Class found!");
                System.out.println("\n" + c);

                break;
            }
        }

        if (!found) System.out.println("Sorry, couldn't find that class."); // Prints if the class wasn't found in the file
    }
}