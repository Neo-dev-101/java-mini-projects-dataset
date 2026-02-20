import java.util.Scanner;

public class AttendanceManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        System.out.print("Enter total working days: ");
        int workingDays = sc.nextInt();

        int[] daysPresent = new int[n];

        System.out.println("Enter attendance (days present) for each student:");
        for (int i = 0; i < n; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            daysPresent[i] = sc.nextInt();
        }

        // Display Report
        System.out.println("\n------ ATTENDANCE REPORT ------");
        System.out.println("Total Working Days: " + workingDays);

        for (int i = 0; i < n; i++) {
            double percentage = ((double) daysPresent[i] / workingDays) * 100;
            String eligibility = (percentage >= 75) ? "ELIGIBLE" : "NOT ELIGIBLE";

            System.out.println("--------------------------------");
            System.out.println("Student " + (i + 1));
            System.out.println("Days Present   : " + daysPresent[i]);
            System.out.printf("Attendance %%   : %.2f%n", percentage);
            System.out.println("Eligibility    : " + eligibility);
        }

        System.out.println("--------------------------------");
        sc.close();
    }
}