package SchoolSystem.Services;

import SchoolSystem.Entities.Mark;


import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class MarkService {
    static Scanner scanner = new Scanner(System.in);

    public static Mark addMark() {

        Mark mark = new Mark();

        System.out.println("Enter Student marks");
        mark.marks = scanner.nextFloat();

        System.out.println("Enter comments");
        mark.comments = scanner.nextLine();

        System.out.println("Enter description");
        mark.description = scanner.nextLine();

        System.out.println("Enter the grade");
        mark.grade = scanner.nextLine();

        return mark;
    }

    public static List<Mark> addMarks() {
        Boolean flag = true;
        List<Mark> marks = new ArrayList<>();
        while (flag) {
            marks.add(MarkService.addMark());
        }
        return marks;
    }
}


