package com.learnerManagement.ui;

import com.learnerManagement.entity.Course;
import com.learnerManagement.entity.Enrollment;
import com.learnerManagement.entity.Student;
import com.learnerManagement.exception.EntityNotFoundException;
import com.learnerManagement.service.CourseManagement;
import com.learnerManagement.service.EnrollmentManagement;
import com.learnerManagement.service.StudentManagement;

import java.util.List;
import java.util.Scanner;

public class MainMethod {

    static Scanner sc = new Scanner(System.in);
    public static void main(String []args){


            StudentManagement management = new StudentManagement();
            CourseManagement courseList = new CourseManagement();
            EnrollmentManagement EM = new EnrollmentManagement();

        int choice;

        do {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Student Management");
            System.out.println("2. Course Management");
            System.out.println("3. Enrollment Management");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = readInt();
            switch (choice) {
                case 1:
                    studentMenu(management);
                    break;
                case 2:
                    courseMenu(courseList);
                    break;
                case 3:
                    enrollmentMenu(management, courseList, EM);
                    break;
                case 0:
                    System.out.println("Application closed.");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
        }

// STUDENT MENU
    static void studentMenu(StudentManagement management) {
    int choice;

    do {
        System.out.println("\n--- STUDENT MENU ---");
        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Search Student");
        System.out.println("4. Deactivate Student");
        System.out.println("5. Update Student Course");
        System.out.println("0. Back");
        System.out.print("Enter choice: ");

        choice = readInt();

        switch (choice) {
            case 1:
                System.out.print("First name: ");
                String first = sc.nextLine();

                System.out.print("Last name: ");
                String last = sc.nextLine();

                System.out.print("Email: ");
                String email = sc.nextLine();

                System.out.print("Batch: ");
                String batch = sc.nextLine();
                try{
                    management.addStudent(
                            new Student(first, last, email,batch, true)
                    );
                    break;
                }catch (EntityNotFoundException e){
                    System.out.println("Error" + e.getMessage());
                }



            case 2:
                management.listStudents();
                break;

            case 3:
                try{
                    System.out.print("Student ID: ");
                    management.searchStudentDetailsByID(readInt());
                }catch (NumberFormatException ne){
                    System.out.println("Student not Found");
                }
                break;

            case 4:
                try{
                    System.out.print("Student ID: ");
                    management.deactivate(readInt());
                }catch (NumberFormatException ne){
                    System.out.println("Student not Found");
                }
                break;

            case 5:
                try {
                    System.out.print("Student ID: ");
                    int studentId = readInt();

                    System.out.print("New Batch: ");
                    String newBatch = sc.nextLine();

                    management.updateStudent(studentId, newBatch);
                }catch(NumberFormatException id){
                    System.out.println("Student not Found");
                }
                break;

            case 0:
                break;

            default:
                System.out.println("Invalid choice!");
        }

    } while (choice != 0);
}

// COURSE MENU
    static void courseMenu(CourseManagement courseList) {
        int choice;

        do {
            System.out.println("\n--- COURSE MENU ---");
            System.out.println("1. Add Course");
            System.out.println("2. View Courses");
            System.out.println("0. Back");
            System.out.print("Enter choice: ");

            choice = readInt();

            switch (choice) {
                case 1:
                    System.out.print("Course ID: ");
                    int id = readInt();

                    System.out.print("Course name: ");
                    String name = sc.nextLine();

                    System.out.print("Description: ");
                    String description = sc.nextLine();

                    System.out.print("Duration: ");
                    String duration = sc.nextLine();

                    courseList.addCourse(
                            new Course(id, name, description, duration, true)
                    );
                    break;

                case 2:
                    courseList.listCourse();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);
    }

// ENROLLMENT MENU
    static void enrollmentMenu(
            StudentManagement management,
            CourseManagement courseList,
            EnrollmentManagement EM) {

        int choice;

        do {
            System.out.println("\n--- ENROLLMENT MENU ---");
            System.out.println("1. Enroll Student");
            System.out.println("2. View Course Enrollments");
            System.out.println("0. Back");
            System.out.print("Enter choice: ");

            choice = readInt();

            switch (choice) {
                case 1:
                    System.out.print("Enrollment ID: ");
                    int enrollmentId = readInt();

                    System.out.print("Student ID: ");
                    int studentId = readInt();

                    System.out.print("Course ID: ");
                    int courseId = readInt();

                    System.out.print("Enrollment date (DD-MM-YYYY): ");
                    String date = sc.nextLine();
                    System.out.println("Select Enrollment Status:");
                    System.out.println("1. ACTIVE");
                    System.out.println("2. COMPLETED");
                    System.out.println("3. CANCELLED");

                    int statusChoice = readInt();

                    Enrollment.Status status;

                    switch (statusChoice) {
                        case 1:
                            status = Enrollment.Status.ACTIVE;
                            break;
                        case 2:
                            status = Enrollment.Status.COMPLETED;
                            break;
                        case 3:
                            status = Enrollment.Status.CANCELLED;
                            break;
                        default:
                            System.out.println("Invalid status choice.");
                            return;
                    }

                    Enrollment enrollment = new Enrollment(
                            enrollmentId,
                            studentId,
                            courseId,
                            date,
                            status
                    );

                    List<Course> courses = courseList.listCourse();
                    List<Student> students = management.listStudents();

                    EM.enrollStudent(enrollment, courses, students);
                    break;

                case 2:
                    EM.listCourseEnrollment();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);
    }

    static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid number: ");
            }
        }
    }

}
