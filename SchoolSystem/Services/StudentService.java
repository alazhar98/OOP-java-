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
        student.name = scanner.nextLine();

        System.out.println("Enter Student id ");
        student.id = scanner.nextLine();

        System.out.println("Enter student age ");
        student.age = scanner.nextShort();

        scanner.nextLine();

        System.out.println("Enter student grade ");
        student.grade = scanner.nextLine();


        student.courses = SubjectService.addSubjects(false);

        return student;
    }

    public static List<Student> addStudents() {
        Boolean flag = true;
        List<Student> students = new ArrayList<>();
        while (flag) {
            students.add(StudentService.addStudent());
        }
        return students;
    }
}
