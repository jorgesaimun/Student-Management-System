import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static StudentManagementSystem sms = new StudentManagementSystem();

    private static Admin admin;

    public static void main(String[] args) {

        System.out.print("Enter Admin Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Admin Password: ");
        String password = scanner.nextLine();

        if (isAdminValid(name, password) == true) {
            admin = new Admin(name, password, sms);
            System.out.println("Log in successful, Welcome to Student Management System ");

            while (true) {
                displayMenu();
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        deleteStudent();
                        break;
                    case 3:
                        updateStudent();
                        break;
                    case 4:
                        searchStudent();
                        break;
                    case 5:
                        manageEnrollment();
                        break;
                    case 6:
                        addGrade();
                        break;
                    case 7:
                        displayAllStudents();
                        break;
                    case 8:
                        exit();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Log in failed . Try again ");
        }
    }

    private static boolean isAdminValid(String name, String password) {

        return true;
    }

    private static void displayMenu() {
        System.out.println("\nStudent Management System");
        System.out.println("1. Add Student");
        System.out.println("2. Delete Student");
        System.out.println("3. Update Student");
        System.out.println("4. Search Student");
        System.out.println("5. Manage Enrollment");
        System.out.println("6. Add Grade");
        System.out.println("7. Display All Students");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student department: ");
        String department = scanner.nextLine();
        System.out.print("Enter student contact info: ");
        String contactInfo = scanner.nextLine();

        Student student = new Student(name, department, contactInfo);
        admin.addStudent(student);
        System.out.println("Student added successfully.");
    }

    private static void deleteStudent() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        if (isIdFounded(studentId)) {
            admin.deleteStudent(studentId);
            System.out.println("Student deleted successfully.");
        }
    }

    private static void updateStudent() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();

        if (isIdFounded(studentId)) {
            System.out.print("Enter new student name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new student department: ");
            String department = scanner.nextLine();
            System.out.print("Enter new student contact info: ");
            String contactInfo = scanner.nextLine();

            admin.updateStudent(studentId, name, department, contactInfo);
            System.out.println("Student updated successfully.");
        } else {

            System.out.println("Try Again? \n 1.Yes \n 2.No");
            System.out.println("Enter your choice:");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                updateStudent();
            }
        }

    }

    private static void searchStudent() {
        // scanner.nextLine(); // consume the newline
        System.out.print("Enter student ID or name: ");
        String criteria = scanner.nextLine();
        Student student = admin.searchStudent(criteria);

        if (student != null) {
            System.out.println("Student found: " + student);
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void manageEnrollment() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        if (isIdFounded(studentId)) {
            System.out.print("Enter course ID: ");
            String courseId = scanner.nextLine();
            admin.manageEnrollment(studentId, courseId);
            System.out.println("Student enrolled successfully.");
        } else {
            System.out.println("Try Again? \n 1.Yes \n 2.No");
            System.out.print("Enter your choice:");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                manageEnrollment();
            }
        }
    }

    private static void addGrade() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();

        if (isIdFounded(studentId)) {
            // jump to here again
            while (true) {
                System.out.print("Enter course ID: ");
                String courseId = scanner.nextLine();
                // check course id is valid or not

                Student student = sms.getStudentById(studentId);

                List<String> course = student.getCourses();
                int flag = 0;
                for (String c : course) {
                    if (c.equals(courseId)) {
                        flag = 1;
                        System.out.print("Enter grade: ");
                        String grade = scanner.nextLine();
                        admin.addGrade(studentId, courseId, grade);
                        System.out.println("Grade added successfully.");
                        return;
                    }
                }

                if (flag == 0) {
                    System.out.println("Course Not enrolled");
                    System.out.println("Try Again? \n 1.Yes \n 2.No");
                    System.out.print("Enter your choice:");

                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    if (choice != 1) {
                        return;
                    }
                }
            }
        } else {
            System.out.println("Try Again? \n 1.Yes \n 2.No");
            System.out.print("Enter your choice:");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                addGrade();
            }
        }
    }

    private static void displayAllStudents() {

        int studentCount = sms.studentCount();

        if (studentCount == 0) {
            System.out.println("No student found");
        }

        for (Student student : sms.getAllStudents()) {
            System.out.println(student);
        }
    }

    private static void exit() {
        System.out.println("Exiting...");
    }

    private static boolean isIdFounded(String studentId) {
        if (sms.findById(studentId) == false) {
            System.out.println("Student Id not found ");
            return false;
        }
        return true;
    }

}
