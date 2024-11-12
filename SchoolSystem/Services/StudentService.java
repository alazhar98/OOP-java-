package SchoolSystem.Services;


import SchoolSystem.Entities.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService {
    static Scanner scanner = new Scanner(System.in);

    public static Student addStudent() {

        Student student = new Student();
        System.out.println("Enter Student Name");
        String studentName = scanner.nextLine();
        student.setName(studentName);

        System.out.println("Enter Student id ");
        String studentId = scanner.nextLine();
        student.setId(studentId);

        System.out.println("Enter student age ");
        Short studentAge = scanner.nextShort();
        student.setAge(studentAge);
        scanner.nextLine();

        System.out.println("Enter student grade ");
        String studentGrade = scanner.nextLine();
        student.setGrade(studentGrade);

        student.courses = SubjectService.addSubjects(false);

        return student;
    }

    public static List<Student> addStudents() {
        Boolean flag = true;
        List<Student> students = new ArrayList<>();
        while (flag) {
            students.add(StudentService.addStudent());
            System.out.println("Enter N to exit from student, Enter Any Key to continue");
            if (scanner.nextLine().equalsIgnoreCase("N")) {
                flag = false;
            }
        }
        return students;
    }
}