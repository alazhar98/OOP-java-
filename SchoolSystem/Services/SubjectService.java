package SchoolSystem.Services;


import SchoolSystem.Entities.Mark;
import SchoolSystem.Entities.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubjectService {
    static Scanner scanner = new Scanner(System.in);

    public static Subject addSubject(Boolean isTeacher) {

        Subject subject = new Subject();
        System.out.println("Enter Subject Name");
        String subjectName = scanner.nextLine();
        subject.setName(subjectName);
        subject.getName();

        System.out.println("Enter credit Hours of the Subject");
        Integer subjectCreditHours = scanner.nextInt();
        subject.setCreditHours(subjectCreditHours);
        scanner.nextLine();
        subject.getCreditHours();

        if (!isTeacher) {

            System.out.println("Enter marks for subject: ");

            List<Mark> subjectMarks = MarkService.addMarks();
            subject.setMarks(subjectMarks);
            subject.getMarks();
        }

        return subject;
    }

    public static List<Subject> addSubjects(Boolean isTeacher) {
        Boolean flag = true;
        List<Subject> subjects = new ArrayList<>();
        while (flag) {
            subjects.add(SubjectService.addSubject(isTeacher));
            System.out.println("Enter N to exit from subject, Enter Any Key to continue");
            if (scanner.nextLine().equalsIgnoreCase("N")) {
                flag = false;
            }
        }
        return subjects;


    }
}
