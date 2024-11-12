package SchoolSystem.Entities;

import java.util.List;

public class Library {
    private List<Book> books;
    private String name;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
