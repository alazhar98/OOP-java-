package SchoolSystem.Services;

import SchoolSystem.Entities.Library;
import java.util.Scanner;

public class LibraryService {
    static Scanner scanner = new Scanner(System.in);

    public static Library addLibrary() {

        Library library = new Library();
        System.out.println("Enter Library Name");
        library.name = scanner.nextLine();

        return library;
    }
}
