package SchoolSystem.Services;


import SchoolSystem.Entities.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService {
    static Scanner scanner = new Scanner(System.in);

    public static Teacher addTeacher() {
        Teacher teacher = new Teacher();
        System.out.println("Enter teacher Name");
        teacher.name = scanner.nextLine();

        System.out.println("Enter teacher id ");
        teacher.id = scanner.nextLine();

        System.out.println("Enter years Of Experience of the teacher  ");
        teacher.yearsOfExperience=scanner.nextShort();

        teacher.subjectsExpertiseList=SubjectService.addSubjects(true);
        return teacher;
    }
    public static List<Teacher> addTeachers() {
        Boolean flag = true;
        List<Teacher> teachers = new ArrayList<>();
        while (flag) {
            teachers.add(TeacherService.addTeacher());
        }
        return teachers;
    }

}
