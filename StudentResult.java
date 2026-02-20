import java.util.Scanner;

public class StudentResult {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.println("Enter marks for 5 subjects:");
        int[] marks = new int[5];
        int total = 0;
        boolean passed = true;

        for (int i = 0; i < 5; i++) {
            marks[i] = sc.nextInt();
            total += marks[i];
            if (marks[i] < 35) {
                passed = false;
            }
        }

        // Calculations
        double average = total / 5.0;
        String result = passed ? "PASS" : "FAIL";

        // Grade based on average
        String grade;
        if (average >= 90) {
            grade = "A+";
        } else if (average >= 80) {
            grade = "A";
        } else if (average >= 70) {
            grade = "B";
        } else if (average >= 60) {
            grade = "C";
        } else if (average >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Display Result
        System.out.println("\n----- STUDENT RESULT -----");
        System.out.println("Name      : " + name);
        System.out.println("Total Marks: " + total);
        System.out.printf("Average   : %.1f%n", average);
        System.out.println("Result    : " + result);
        System.out.println("Grade     : " + grade);

        sc.close();
    }
}