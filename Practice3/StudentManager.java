package Practice3;

public class StudentManager {
    private Student[] students;
    private int studentCount;

    // Constructor
    public StudentManager(int capacity) {
        this.students = new Student[capacity];
        this.studentCount = 0;
    }

    // Method to add a student
    public void addStudent(Student student) {
        if (studentCount >= students.length) {
            System.out.println("Error: Maximum student capacity reached");
            return;
        }
        students[studentCount] = student;
        studentCount++;
        System.out.println("Student " + student.getName() + " added successfully.");
    }

    // Method to find student by id
    public Student findStudentById(int id) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId() == id) {
                return students[i];
            }
        }
        return null;
    }

    // Method to display all students
    public void displayAllStudents() {
        System.out.println("\n========== All Students ==========");
        if (studentCount == 0) {
            System.out.println("No students in the system.");
            return;
        }
        
        for (int i = 0; i < studentCount; i++) {
            students[i].displayInfo();
        }
    }

    // Method to find student with highest GPA
    public Student getTopStudent() {
        if (studentCount == 0) {
            return null;
        }
        
        Student topStudent = students[0];
        for (int i = 1; i < studentCount; i++) {
            if (students[i].getGPA() > topStudent.getGPA()) {
                topStudent = students[i];
            }
        }
        return topStudent;
    }

    // Test/Demo method
    public static void main(String[] args) {
        // Create StudentManager with capacity for 5 students
        StudentManager manager = new StudentManager(5);

        // Create students using different constructors
        Student student1 = new Student("Alice Johnson", 101);
        Student student2 = new Student("Bob Smith", 102);
        Student student3 = new Student("Carol Williams", 103, new double[]{85, 90, 88});

        // Add students to manager
        manager.addStudent(student1);
        manager.addStudent(student2);
        manager.addStudent(student3);

        // Add grades to students
        System.out.println("\n--- Adding Grades ---");
        student1.addGrade(92);
        student1.addGrade(85);
        student1.addGrade(88);
        System.out.println("Added grades for Alice.");

        student2.addGrade(78);
        student2.addGrade(82);
        student2.addGrade(80);
        System.out.println("Added grades for Bob.");

        student3.addGrade(91);
        System.out.println("Added grade for Carol.");

        // Display all students
        manager.displayAllStudents();

        // Display top student
        System.out.println("\n========== Top Student ==========");
        Student top = manager.getTopStudent();
        if (top != null) {
            System.out.println("Top Student: " + top.getName() + " with GPA: " + top.getGPA());
        }

        // Find specific student
        System.out.println("\n========== Search Student ==========");
        Student found = manager.findStudentById(102);
        if (found != null) {
            System.out.println("Found student: " + found.getName());
        }

        // Demonstrate object references
        System.out.println("\n========== Object References Demo ==========");
        Student reference = student1;
        System.out.println("Original: " + student1.getName() + ", GPA: " + student1.getGPA());
        System.out.println("Reference: " + reference.getName() + ", GPA: " + reference.getGPA());
        reference.addGrade(95);
        System.out.println("After adding grade via reference:");
        System.out.println("Original: " + student1.getName() + ", GPA: " + student1.getGPA());
    }
}
