package SchoolSystem.Services;


import SchoolSystem.Entities.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubjectService {
    static Scanner scanner = new Scanner(System.in);

    public static Subject addSubject(Boolean isTeacher) {

        Subject subject = new Subject();
        System.out.println("Enter Subject Name");
        subject.name = scanner.nextLine();

        System.out.println("Enter credit Hours of the Subject");
        subject.creditHours = scanner.nextShort();


        if (!isTeacher) {

            System.out.println("Enter marks for subject: " );

            subject.marks = MarkService.addMarks();
        }

        return subject;
    }

    public static List<Subject> addSubjects(Boolean isTeacher) {
        Boolean flag = true;
        List<Subject> subjects = new ArrayList<>();
        do {
            subjects.add(SubjectService.addSubject(isTeacher));
            System.out.println("Enter N to exit, Enter Any Key to continue");
            flag = scanner.nextLine().equals("N") ? false : true;

        }
        while (flag);
        return subjects;


    }
}
