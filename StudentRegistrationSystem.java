import java.util.Scanner;

public class StudentRegistrationSystem {

    // ===== Student Class =====
    static class Student {

        // ===== Static Fields (Shared by all students) =====
        static String collegeName;
        static String department;
        static String course;
        static int rollCounter;

        // ===== Static Block — Runs once when class is loaded =====
        static {
            collegeName  = "KGCAS";
            department   = "Computer Science";
            course       = "B.Sc Computer Science";
            rollCounter  = 1001;
            System.out.println("College Registration System Initialized");
        }

        // ===== Instance Fields =====
        int rollNumber;
        String name;

        // ===== Parameterized Constructor =====
        Student(String name) {
            this.name       = name;
            this.rollNumber = rollCounter; // assign current roll number
            rollCounter++;                 // auto-increment for next student
        }

        // ===== Display Student Details =====
        void displayDetails() {
            System.out.println("\n----- STUDENT DETAILS -----");
            System.out.println("Roll No    : " + this.rollNumber);
            System.out.println("Name       : " + this.name);
            System.out.println("College    : " + collegeName);
            System.out.println("Department : " + department);
            System.out.println("--------------------------");
        }
    }

    // ===== Main Method =====
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        // Array to store student objects
        Student[] students = new Student[n];

        // Input student names
        for (int i = 0; i < n; i++) {
            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();
            students[i] = new Student(name); // Constructor auto-assigns roll number
        }

        // Display all student details
        for (int i = 0; i < n; i++) {
            students[i].displayDetails();
        }

        sc.close();
    }
}