package SchoolSystem.Services;

import SchoolSystem.Entities.Book;
import SchoolSystem.Entities.School;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookService {
    static Scanner scanner = new Scanner(System.in);

    public static Book addBook() {

        Book book = new Book();
        System.out.println("Enter Book Name");
        book.name = scanner.nextLine();

        System.out.println("Enter Book Author ");
        book.author = scanner.nextLine();

        System.out.println("Enter Book Id");
        book.id = scanner.nextInt();

        System.out.println("the book its Available");
        book.isAvailable = scanner.nextBoolean();

        System.out.println("what is year Of Publishing");
        book.yearOfPublishing = scanner.nextLine();

        return book;
    }
    public static List<Book> addBooks() {
        Boolean flag = true;
        List<Book> books = new ArrayList<>();
        while (flag) {
            books.add(BookService.addBook());
        }
        return books;
    }
}
