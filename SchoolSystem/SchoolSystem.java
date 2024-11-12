package SchoolSystem;


import SchoolSystem.Services.*;

public class SchoolSystem {
    public static void main(String[] args) {


        System.out.println("***School details***");
        SchoolService.addSchool();

        System.out.println("***teacher details***");
        TeacherService.addTeacher();

        System.out.println("Book Details ");
        LibraryService.addLibrary();


    }
}