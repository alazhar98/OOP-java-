package SchoolSystem.Entities;

import java.util.Date;
public class Book {
    public String name;
    public String author;
    public Integer id;
    public String yearOfPublishing;
    public Boolean isAvailable;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
