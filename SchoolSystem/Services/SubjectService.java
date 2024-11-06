package SchoolSystem.Services;


import SchoolSystem.Entities.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubjectService {
    static Scanner scanner = new Scanner(System.in);

    public static Subject addSubject() {

        Subject subject = new Subject();
        System.out.println("Enter Subject Name");
        subject.name = scanner.nextLine();

        System.out.println("Enter credit Hours of the Subject");
        subject.creditHours = scanner.nextShort();

        return subject;
    }
    public static List<Subject> addSubjects() {
        Boolean flag = true;
        List<Subject> subjects = new ArrayList<>();
        while (flag) {
            subjects.add(SubjectService.addSubject());
        }
        return subjects;
    }
}
