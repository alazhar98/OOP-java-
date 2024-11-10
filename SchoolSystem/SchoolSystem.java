package SchoolSystem;


import SchoolSystem.Services.*;

public class SchoolSystem {
    public static void main(String[] args) {


        System.out.println("***School details***");
        SchoolService.addSchool();

        TeacherService.addTeachers();
        System.out.println("Book Details ");
        LibraryService.addLibrary();
    }
}
