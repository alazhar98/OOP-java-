package SchoolSystem.Services;


import SchoolSystem.Entities.Subject;
import SchoolSystem.Entities.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService {
    static Scanner scanner = new Scanner(System.in);

    public static Teacher addTeacher() {
        Teacher teacher = new Teacher();
        System.out.println("Enter teacher Name");
        String teacherName = scanner.nextLine();
        teacher.setName(teacherName);

        System.out.println("Enter teacher id ");
        String teacherId = scanner.nextLine();
        teacher.setId(teacherId);

        System.out.println("Enter years Of Experience of the teacher  ");
        Integer teacherYearsOfExperience=scanner.nextInt();
        teacher.setYearsOfExperience(teacherYearsOfExperience);

        List<Subject> getSubjectsExpertiseList=SubjectService.addSubjects(true);
        teacher.setSubjectsExpertiseList(getSubjectsExpertiseList);


        return teacher;
    }
    public static List<Teacher> addTeachers() {
        Boolean flag = true;
        List<Teacher> teachers = new ArrayList<>();
        while (flag) {
            teachers.add(TeacherService.addTeacher());
            System.out.println("Enter N to exit from Teacher, Enter Any Key to continue");
            flag = scanner.nextLine().equals("N") ? false : true;
        }
        return teachers;
    }

}
