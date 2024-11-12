package SchoolSystem.Entities;

import java.util.List;

public class School {
    private String name;
    public String address;
    public List<Student> students;
    public List<Teacher> teachers;
    public Library library;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
