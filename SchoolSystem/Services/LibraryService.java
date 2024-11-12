package SchoolSystem.Services;

import SchoolSystem.Entities.Book;
import SchoolSystem.Entities.Library;

import java.util.List;
import java.util.Scanner;

public class LibraryService {
    static Scanner scanner = new Scanner(System.in);

    public static Library addLibrary() {

        Library library = new Library();
        System.out.println("Enter Library Name");
        String libraryName = scanner.nextLine();
        library.setName(libraryName);
        List<Book>libraryBooks=BookService.addBooks();
        library.setBooks(libraryBooks);
        library.getName();
        library.getBooks();
        return library;

    }
}
