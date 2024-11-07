package SchoolSystem.Services;

import SchoolSystem.Entities.School;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SchoolService {
    static Scanner scanner = new Scanner(System.in);

    public static School addSchool() {

        School school = new School();
        System.out.println("Enter School Name");
        school.name = scanner.nextLine();

        System.out.println("Enter School Address");
        school.address = scanner.nextLine();

        school.students=StudentService.addStudents();
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
