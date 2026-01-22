package Practice3;

public class Student {
    // Properties
    private String name;
    private int id;
    private double[] grades;
    private int gradeCount;
    private double gpa;

    // Constructor 1: Initialize with name and id only
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.grades = new double[10]; // Array capacity for 10 grades
        this.gradeCount = 0;
        this.gpa = 0.0;
    }

    // Constructor 2: Initialize with name, id, and initial grades
    public Student(String name, int id, double[] initialGrades) {
        this.name = name;
        this.id = id;
        this.gradeCount = initialGrades.length;
        this.grades = new double[Math.max(10, initialGrades.length * 2)];
        System.arraycopy(initialGrades, 0, this.grades, 0, initialGrades.length);
        calculateGPA();
    }

    // Constructor 3: Initialize with just name and id as separate params with capacity
    public Student(String name, int id, int capacity) {
        this.name = name;
        this.id = id;
        this.grades = new double[capacity];
        this.gradeCount = 0;
        this.gpa = 0.0;
    }

    // Method to add a grade
    public void addGrade(double grade) {
        if (grade < 0 || grade > 100) {
            System.out.println("Error: Grade must be between 0 and 100");
            return;
        }
        
        // Expand array if needed
        if (gradeCount >= grades.length) {
            double[] newGrades = new double[grades.length * 2];
            System.arraycopy(grades, 0, newGrades, 0, grades.length);
            grades = newGrades;
        }
        
        grades[gradeCount] = grade;
        gradeCount++;
        calculateGPA();
    }

    // Method to calculate GPA (assuming 4.0 scale: 90-100=4.0, 80-89=3.0, 70-79=2.0, etc.)
    public void calculateGPA() {
        if (gradeCount == 0) {
            gpa = 0.0;
            return;
        }

        double sum = 0;
        for (int i = 0; i < gradeCount; i++) {
            sum += grades[i];
        }
        
        double average = sum / gradeCount;
        
        if (average >= 90) {
            gpa = 4.0;
        } else if (average >= 80) {
            gpa = 3.0;
        } else if (average >= 70) {
            gpa = 2.0;
        } else if (average >= 60) {
            gpa = 1.0;
        } else {
            gpa = 0.0;
        }
    }

    // Method to display student information
    public void displayInfo() {
        System.out.println("\n--- Student Information ---");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Number of Grades: " + gradeCount);
        
        if (gradeCount > 0) {
            System.out.print("Grades: ");
            for (int i = 0; i < gradeCount; i++) {
                System.out.print(grades[i] + " ");
            }
            System.out.println();
            
            double average = 0;
            for (int i = 0; i < gradeCount; i++) {
                average += grades[i];
            }
            average /= gradeCount;
            System.out.println("Average: " + String.format("%.2f", average));
            System.out.println("GPA: " + gpa);
        } else {
            System.out.println("No grades added yet.");
        }
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getGPA() {
        return gpa;
    }

    public double[] getGrades() {
        return grades;
    }

    public int getGradeCount() {
        return gradeCount;
    }
}
