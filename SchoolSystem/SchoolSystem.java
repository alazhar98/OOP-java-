package SchoolSystem;

import SchoolSystem.Services.*;

public class SchoolSystem {
    public static void main(String[] args) {
        BookService bookService = new BookService();
        LibraryService libraryService = new LibraryService();
        MarkService markService = new MarkService();
        SchoolService schoolService = new SchoolService();
        StudentService studentService = new StudentService();
        SubjectService subjectService = new SubjectService();
        TeacherService teacherService = new TeacherService();

        System.out.println(schoolService);
        System.out.println(studentService);
        System.out.println(subjectService);
        System.out.println(markService);
        System.out.println(teacherService);
        System.out.println(libraryService);
        System.out.println(bookService);
    }

}
