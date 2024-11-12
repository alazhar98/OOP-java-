package SchoolSystem.Entities;

import java.util.List;

public class School {
    private String name;
    private String address;
    private List<Student> students;
    private List<Teacher> teachers;
    private Library library;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
