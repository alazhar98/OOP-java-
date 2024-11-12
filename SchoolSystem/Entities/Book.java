package SchoolSystem.Entities;

import java.util.Date;

public class Book {
    private String name;
    private String author;
    private Integer id;
    private String yearOfPublishing;
    private Boolean isAvailable;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
