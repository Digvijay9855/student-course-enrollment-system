package controller;

import model.*;
import service.*;
import java.util.List;
import java.util.Scanner;

public class MainController {
    private I_StudentService studentService = new StudentServiceImpl();
    private I_CourseService courseService = new CourseServiceImpl();
    private I_InstructorService instructorService = new InstructorServiceImpl();
    private I_EnrollmentService enrollmentService = new EnrollmentServiceImpl();

    private Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. View Students");
            System.out.println("4. View Courses");
            System.out.println("5. Update Student");
            System.out.println("6. Update Course");
            System.out.println("7. Delete Student");
            System.out.println("8. Delete Course");
            System.out.println("9. Enroll Student");
            System.out.println("10. View Enrollments");
            System.out.println("11. Unenroll Student");
            System.out.println("12. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1: addStudent(); break;
                case 2: addCourse(); break;
                case 3: viewStudents(); break;
                case 4: viewCourses(); break;
                case 5: updateStudent(); break;
                case 6: updateCourse(); break;
                case 7: deleteStudent(); break;
                case 8: deleteCourse(); break;
                case 9: enrollStudent(); break;
                case 10: viewEnrollments(); break;
                case 11: unenrollStudent(); break;
                case 12: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid option.");
            }
        }
    }

    private void addStudent() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        studentService.addStudent(new Student(id, name));
    }

    private void addCourse() {
        System.out.print("Enter course ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter course name: ");
        String name = scanner.nextLine();
        System.out.print("Enter instructor ID: ");
        int instructorId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter instructor name: ");
        String instructorName = scanner.nextLine();
        Instructor instructor = new Instructor(instructorId, instructorName);
        courseService.addCourse(new Course(id, name, instructor));
    }

    private void viewStudents() {
        List<Student> students = studentService.viewStudents();
        students.forEach(System.out::println);
    }

    private void viewCourses() {
        List<Course> courses = courseService.viewCourses();
        courses.forEach(System.out::println);
    }

    private void updateStudent() {
        System.out.print("Enter student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new student name: ");
        String name = scanner.nextLine();
        studentService.updateStudent(id, new Student(id, name));
    }

    private void updateCourse() {
        System.out.print("Enter course ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new course name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new instructor name: ");
        String instructorName = scanner.nextLine();
        Course updatedCourse = new Course(id, name, new Instructor(id, instructorName));
        courseService.updateCourse(id, updatedCourse);
    }

    private void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();
        studentService.deleteStudent(id);
    }

    private void deleteCourse() {
        System.out.print("Enter course ID to delete: ");
        int id = scanner.nextInt();
        courseService.deleteCourse(id);
    }

    private void enrollStudent() {
        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter course ID: ");
        int courseId = scanner.nextInt();
        scanner.nextLine();

        Student student = findStudentById(studentId);
        Course course = findCourseById(courseId);

        if (student != null && course != null) {
            enrollmentService.enrollStudent(new Enrollment(student, course));
        } else {
            System.out.println("Invalid student or course.");
        }
    }

    private void unenrollStudent() {
        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter course ID: ");
        int courseId = scanner.nextInt();
        scanner.nextLine();

        enrollmentService.unenrollStudent(studentId, courseId);
    }

    private void viewEnrollments() {
        List<Enrollment> enrollments = enrollmentService.viewEnrollments();
        enrollments.forEach(System.out::println);
    }

    private Student findStudentById(int id) {
        List<Student> students = studentService.viewStudents();
        return students.stream().filter(student -> student.getId() == id).findFirst().orElse(null);
    }

    private Course findCourseById(int id) {
        List<Course> courses = courseService.viewCourses();
        return courses.stream().filter(course -> course.getId() == id).findFirst().orElse(null);
    }
}
