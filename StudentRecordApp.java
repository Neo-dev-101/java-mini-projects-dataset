import java.io.*;
import java.util.Scanner;

public class StudentRecordApp {

    static final String FILE_NAME = "students.txt";

    public static void main(String[] args) {
        createFileIfNotExists();

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== STUDENT RECORD MANAGER =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Delete Student by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // IMPORTANT: clears Enter key

            switch (choice) {
                case 1:
                    addStudent(sc);
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    System.out.print("Enter Student ID to search: ");
                    String searchId = sc.nextLine();
                    searchStudent(searchId);
                    break;
                case 4:
                    System.out.print("Enter Student ID to delete: ");
                    String deleteId = sc.nextLine();
                    deleteStudent(deleteId);
                    break;
                case 5:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1-5.");
            }

        } while (choice != 5);

        sc.close();
    }

    // ─────────────────────────────────────────────
    // Step 2: Create file if it doesn't exist
    // ─────────────────────────────────────────────
    static void createFileIfNotExists() {
        try {
            File file = new File(FILE_NAME);
            if (file.createNewFile()) {
                System.out.println("File created: " + FILE_NAME);
            }
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }

    // ─────────────────────────────────────────────
    // Step 5: Add Student — write to file
    // ─────────────────────────────────────────────
    static void addStudent(Scanner sc) {
        System.out.print("Enter ID: ");
        String id = sc.nextLine().trim();

        System.out.print("Enter Name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter Department: ");
        String dept = sc.nextLine().trim();

        System.out.print("Enter Year: ");
        String year = sc.nextLine().trim();

        System.out.print("Enter Email: ");
        String email = sc.nextLine().trim();

        String record = id + "," + name + "," + dept + "," + year + "," + email;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(record);
            bw.newLine();
            System.out.println("Student record added successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // ─────────────────────────────────────────────
    // Step 6: View All Students — read line-by-line
    // ─────────────────────────────────────────────
    static void viewAllStudents() {
        System.out.println("\n--- All Student Records ---");

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            boolean hasRecords = false;

            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    String[] parts = line.split(",");
                    if (parts.length == 5) {
                        System.out.println("ID       : " + parts[0]);
                        System.out.println("Name     : " + parts[1]);
                        System.out.println("Dept     : " + parts[2]);
                        System.out.println("Year     : " + parts[3]);
                        System.out.println("Email    : " + parts[4]);
                        System.out.println("----------------------------");
                        hasRecords = true;
                    }
                }
            }

            if (!hasRecords) {
                System.out.println("No student records found.");
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // ─────────────────────────────────────────────
    // Step 7: Search Student by ID
    // ─────────────────────────────────────────────
    static void searchStudent(String searchId) {
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5 && parts[0].trim().equals(searchId.trim())) {
                    System.out.println("\n--- Student Found ---");
                    System.out.println("ID       : " + parts[0]);
                    System.out.println("Name     : " + parts[1]);
                    System.out.println("Dept     : " + parts[2]);
                    System.out.println("Year     : " + parts[3]);
                    System.out.println("Email    : " + parts[4]);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Student with ID " + searchId + " not found.");
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // ─────────────────────────────────────────────
    // Step 8: Delete Student by ID (temp file rewrite)
    // ─────────────────────────────────────────────
    static void deleteStudent(String deleteId) {
        File originalFile = new File(FILE_NAME);
        File tempFile = new File("students_temp.txt");
        boolean deleted = false;

        try (
            BufferedReader br = new BufferedReader(new FileReader(originalFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))
        ) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5 && parts[0].trim().equals(deleteId.trim())) {
                    deleted = true; // skip this record (don't write it)
                } else {
                    bw.write(line);
                    bw.newLine();
                }
            }

        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
            return;
        }

        // Replace original with temp file
        if (originalFile.delete()) {
            if (tempFile.renameTo(originalFile)) {
                if (deleted) {
                    System.out.println("Student deleted successfully!");
                } else {
                    System.out.println("Student with ID " + deleteId + " not found.");
                }
            } else {
                System.out.println("Error: Could not rename temp file.");
            }
        } else {
            System.out.println("Error: Could not delete original file.");
        }
    }
}