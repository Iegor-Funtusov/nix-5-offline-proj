package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.controller.UniversityController;
import org.example.entity.StudentInCourse;
import org.example.entity.Course;
import org.example.entity.Student;

import java.util.Collection;
import java.util.Scanner;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static UniversityController uni = new UniversityController();

    public static void main(String[] args) {
        System.out.println("Welcome! \n" +
                "The purpose of this program is to track students and courses, and which students attend which courses");


        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=== Main menu ===");
            System.out.println("1 -To fill database with example information");
            System.out.println();
            System.out.println("2 -To manage students");
            System.out.println("3 -To manage courses");
            System.out.println("4 -To view all students attending a course");
            System.out.println("5 -To view all courses attended by a student");
            System.out.println();
            System.out.println("6 -To assign a student to a course");
            System.out.println("7 -To remove a student from a course");
            System.out.println();
            System.out.println("0 -To exit");

            switch (scanner.nextLine()) {
                case "1": {
                    uni = getExampleController();
                    continue;
                }
                case "2": {
                    manageStudents(scanner);
                    break;
                }
                case "3": {
                    manageCourses(scanner);
                    break;
                }
                case "4": {
                    viewStudentsByCourse(scanner);
                    break;
                }
                case "5": {
                    viewCoursesByStudent(scanner);
                    break;
                }
                case "6": {
                    assignStudentToCourse(scanner);
                    break;
                }
                case "7": {
                    removeStudentFromCourse(scanner);
                    break;
                }
                case "0":
                    return;
                default:
                    System.out.println("Incorrect input, please retry");
            }
        }

    }

    private static UniversityController getExampleController() {
        UniversityController result = new UniversityController();
        result.createStudent(new Student().setFirstName("Vasya").setLastName("Ivanov").setAddress("Kharkiv"));
        result.createStudent(new Student().setFirstName("Petya").setLastName("Vasilyev").setAddress("Kiyv"));
        result.createStudent(new Student().setFirstName("Igor").setLastName("Petechkin").setAddress("Voronej"));

        result.createCourse(new Course().setName("Mathematics").setDescription("learn mathematics!!"));
        result.createCourse(new Course().setName("Java").setDescription("Learn java!!!"));

        result.createStudentInCourse(new StudentInCourse().setCourseId("Course0").setStudentId("Student0"));
        result.createStudentInCourse(new StudentInCourse().setCourseId("Course1").setStudentId("Student0"));
        result.createStudentInCourse(new StudentInCourse().setCourseId("Course0").setStudentId("Student1"));
        result.createStudentInCourse(new StudentInCourse().setCourseId("Course0").setStudentId("Student2"));

        return result;
    }

    private static void manageStudents(Scanner scanner) {
        while (true) {
            System.out.println("=== Managing students ===");

            System.out.println("1 -To create new student");
            System.out.println("2 -To view student by ID");
            System.out.println("3 -To view all students");
            System.out.println("4 -To update a student");
            System.out.println("5 -To delete a student");
            System.out.println("0 -To go back");

            switch (scanner.nextLine()) {
                case "1": {
                    System.out.println("Enter student's first name, last name, address, separated by line breaks:");
                    String firstName = scanner.nextLine();
                    String lastName = scanner.nextLine();
                    String address = scanner.nextLine();
                    String id;
                    try {
                        id = uni.createStudent(new Student().setFirstName(firstName).setLastName(lastName).setAddress(address));
                    } catch (IllegalArgumentException ex) {
                        System.out.println("Incorrect input, please retry; " + ex.getMessage());
                        break;
                    }
                    System.out.println("Created student " + uni.readStudent(id));
                    break;
                }
                case "2": {
                    System.out.println("Enter student's ID:");
                    String id = scanner.nextLine();
                    Student s = uni.readStudent(id);
                    if (s != null) {
                        System.out.println("Found student " + s);
                        break;
                    }
                    System.out.println("Incorrect input, please retry");
                    break;
                }
                case "3": {
                    Collection<Student> students = uni.readStudent();
                    if (!students.isEmpty()) {
                        System.out.println("Found students:");
                        students.forEach(System.out::println);
                        break;
                    }
                    System.out.println("No students found");
                    break;
                }
                case "4": {
                    System.out.println("Enter student's ID, then updated first name, last name, address, separated by line breaks:");
                    String id = scanner.nextLine();
                    String firstName = scanner.nextLine();
                    String lastName = scanner.nextLine();
                    String address = scanner.nextLine();
                    Student student = new Student().setFirstName(firstName).setLastName(lastName).setAddress(address);
                    student.setId(id);

                    try {
                        uni.updateStudent(student);
                    } catch (RuntimeException ex) {
                        System.out.println("Incorrect input, please retry; " + ex.getMessage());
                        break;
                    }
                    System.out.println("Student successfully updated");
                    break;
                }
                case "5": {
                    System.out.println("Enter student's ID:");
                    String id = scanner.nextLine();

                    try {
                        uni.deleteStudent(id);
                    } catch (IllegalArgumentException ex) {
                        System.out.println("Incorrect input, please retry; " + ex.getMessage());
                        break;
                    }
                    System.out.println("Student deleted");
                    break;
                }
                case "0":
                    return;
                default:
                    System.out.println("Incorrect input, please retry");
                    break;
            }

        }
    }

    private static void manageCourses(Scanner scanner) {
        while (true) {
            System.out.println("=== Managing courses ===");
            System.out.println("1 -To create new course");
            System.out.println("2 -To view course by ID");
            System.out.println("3 -To view all courses");
            System.out.println("4 -To update a course");
            System.out.println("5 -To delete a course");
            System.out.println("0 -To go back");

            switch (scanner.nextLine()) {
                case "1": {
                    System.out.println("Enter name and description for the course, separated by line breaks:");
                    String name = scanner.nextLine();
                    String description = scanner.nextLine();
                    String id;
                    try {
                        id = uni.createCourse(new Course().setName(name).setDescription(description));
                    } catch (IllegalArgumentException ex) {
                        System.out.println("Incorrect input, please retry; " + ex.getMessage());
                        break;
                    }
                    System.out.println("Created course " + uni.readCourse(id));
                    break;
                }
                case "2": {
                    System.out.println("Enter course's ID:");
                    String id = scanner.nextLine();
                    Course c = uni.readCourse(id);
                    if (c != null) {
                        System.out.println("Found course " + c);
                        break;
                    }
                    System.out.println("Incorrect input, please retry");
                    break;
                }
                case "3": {
                    Collection<Course> courses = uni.readCourse();
                    if (!courses.isEmpty()) {
                        System.out.println("Found courses:");
                        courses.forEach(System.out::println);
                        break;
                    }
                    System.out.println("No courses found");
                    break;
                }
                case "4": {
                    System.out.println("Enter course's ID, then updated name, description, separated by line breaks:");
                    String id = scanner.nextLine();
                    String name = scanner.nextLine();
                    String description = scanner.nextLine();
                    Course course = new Course().setName(name).setDescription(description);
                    course.setId(id);

                    try {
                        uni.updateCourse(course);
                    } catch (RuntimeException ex) {
                        System.out.println("Incorrect input, please retry; " + ex.getMessage());
                        break;
                    }
                    System.out.println("Course successfully updated");
                    break;
                }
                case "5": {
                    System.out.println("Enter course's ID:");
                    String id = scanner.nextLine();

                    try {
                        uni.deleteCourse(id);
                    } catch (IllegalArgumentException ex) {
                        System.out.println("Incorrect input, please retry; " + ex.getMessage());
                        break;
                    }
                    System.out.println("Course deleted");
                    break;
                }
                case "0":
                    return;
                default:
                    System.out.println("Incorrect input, please retry");
                    break;
            }
        }
    }

    private static void viewStudentsByCourse(Scanner scanner) {
        while (true) {
            System.out.println("=== Viewing students by course ===");
            Collection<Course> courses = uni.readCourse();
            if (courses == null) {
                System.out.println("No courses found, create some first");
                return;
            }
            System.out.println("Following courses exist:");
            courses.forEach(System.out::println);
            System.out.println("Enter course's ID to view students attending it, 0 to exit");
            String id = scanner.nextLine();
            if ("0".equals(id)) {
                return;
            }
            Collection<Student> students;
            try {
                students = uni.readAllStudentsByCourse(id);
            } catch (IllegalArgumentException ex) {
                System.out.println("Incorrect input, please retry; " + ex.getMessage());
                continue;
            }
            if (!students.isEmpty()) {
                System.out.println("The course " + uni.readCourse(id) + " is attended by these students:");
                students.forEach(System.out::println);
                continue;
            }
            System.out.println("No students found");
        }
    }

    private static void viewCoursesByStudent(Scanner scanner) {
        while (true) {
            System.out.println("=== Viewing courses by student ===");
            Collection<Student> students = uni.readStudent();
            if (students == null) {
                System.out.println("No students found, create some first");
                return;
            }
            System.out.println("Following students exist:");
            students.forEach(System.out::println);
            System.out.println("Enter student's ID to view courses the student is attending, 0 to exit");
            String id = scanner.nextLine();
            if ("0".equals(id)) {
                return;
            }
            Collection<Course> courses;
            try {
                courses = uni.readAllCoursesByStudent(id);
            } catch (IllegalArgumentException ex) {
                System.out.println("Incorrect input, please retry; " + ex.getMessage());
                continue;
            }
            if (!courses.isEmpty()) {
                System.out.println("The student " + uni.readStudent(id) + " is attending these courses:");
                courses.forEach(System.out::println);
                continue;
            }
            System.out.println("No courses found");
        }
    }

    private static void assignStudentToCourse(Scanner scanner) {
        while (true) {
            System.out.println("=== Assigning students to courses ===");
            Collection<Student> students = uni.readStudent();
            Collection<Course> courses = uni.readCourse();
            if (students.isEmpty()) {
                System.out.println("No students exist, create some first");
                return;
            } else if (courses.isEmpty()) {
                System.out.println("No courses exist, create some first");
                return;
            }
            System.out.println("The following courses are registered:");
            courses.forEach(System.out::println);
            System.out.println("The following students are registered:");
            students.forEach(System.out::println);
            System.out.println("Enter student's ID, then course's ID, separated by line breaks, or 0 to exit");
            String studentId = scanner.nextLine();
            if ("0".equals(studentId)) {
                return;
            }
            String courseId = scanner.nextLine();

            try {
                uni.createStudentInCourse(new StudentInCourse().setStudentId(studentId).setCourseId(courseId));
            } catch (IllegalArgumentException ex) {
                System.out.println("Incorrect input, please retry; " + ex.getMessage());
                continue;
            }
            System.out.println("Student successfully assigned to course");
        }
    }

    private static void removeStudentFromCourse(Scanner scanner) {
        while (true) {
            System.out.println("=== Removing students from courses ===");
            Collection<Student> students = uni.readStudent();
            Collection<Course> courses = uni.readCourse();
            if (students.isEmpty()) {
                System.out.println("No students exist, create some first");
                return;
            } else if (courses.isEmpty()) {
                System.out.println("No courses exist, create some first");
                return;
            }
            System.out.println("Enter student's ID, then course's ID, separated by line breaks, or 0 to exit:");
            String studentId = scanner.nextLine();
            if ("0".equals(studentId)) {
                return;
            }
            String courseId = scanner.nextLine();
            try {
                uni.deleteStudentInCourse(studentId, courseId);
            } catch (IllegalArgumentException ex) {
                System.out.println("Incorrect input, please retry; " + ex.getMessage());
                continue;
            }
            System.out.println("Student successfully removed from course");
        }
    }
}