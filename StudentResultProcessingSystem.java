import java.util.Scanner;

public class StudentResultProcessingSystem {

    // ===== Student Class with Constructor =====
    static class Student {

        // Fields
        int rollNumber;
        String name;
        int mark1, mark2, mark3;
        int total;
        double average;
        String grade;

        // Parameterized Constructor
        Student(int rollNumber, String name, int mark1, int mark2, int mark3) {
            // Initialize using 'this' keyword
            this.rollNumber = rollNumber;
            this.name = name;
            this.mark1 = mark1;
            this.mark2 = mark2;
            this.mark3 = mark3;

            // Calculate Total
            this.total = this.mark1 + this.mark2 + this.mark3;

            // Calculate Average
            this.average = (double) this.total / 3;

            // Assign Grade
            if (this.average >= 90) {
                this.grade = "S";
            } else if (this.average >= 80) {
                this.grade = "A";
            } else if (this.average >= 70) {
                this.grade = "B";
            } else if (this.average >= 60) {
                this.grade = "C";
            } else if (this.average >= 50) {
                this.grade = "D";
            } else {
                this.grade = "F";
            }
        }

        // Display Result Method
        void displayResult() {
            System.out.println("\n----- STUDENT RESULT -----");
            System.out.println("Roll Number : " + this.rollNumber);
            System.out.println("Name        : " + this.name);
            System.out.println("Subject 1   : " + this.mark1);
            System.out.println("Subject 2   : " + this.mark2);
            System.out.println("Subject 3   : " + this.mark3);
            System.out.println("Total       : " + this.total);
            System.out.println("Average     : " + this.average);
            System.out.println("Grade       : " + this.grade);
            System.out.println("--------------------------");
        }
    }

    // ===== Main Method =====
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter Roll Number: ");
        int rollNumber = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Marks in Subject 1: ");
        int mark1 = sc.nextInt();

        System.out.print("Enter Marks in Subject 2: ");
        int mark2 = sc.nextInt();

        System.out.print("Enter Marks in Subject 3: ");
        int mark3 = sc.nextInt();

        // Object Creation — Constructor does all computation automatically
        Student student = new Student(rollNumber, name, mark1, mark2, mark3);

        // Display Result
        student.displayResult();

        sc.close();
    }
}