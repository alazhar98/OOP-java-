package SchoolSystem.Services;

import SchoolSystem.Entities.School;
import SchoolSystem.Entities.Student;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SchoolService {
    static Scanner scanner = new Scanner(System.in);

    public static School addSchool() {

        School school = new School();
        System.out.println("Enter School Name");
        String schoolName = scanner.nextLine();
        school.setName(schoolName);


        System.out.println("Enter School Address");
        String address = scanner.nextLine();

        List<Student>schoolStudents = StudentService.addStudents();
        return school;
    }

    public static List<School> addSchools() {
        Boolean flag = true;
        List<School> schools = new ArrayList<>();
        while (flag) {
            schools.add(SchoolService.addSchool());
        }
        return schools;
    }
}
