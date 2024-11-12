package SchoolSystem.Entities;

import java.util.List;

public class Subject {
    private String name;
    private Integer creditHours;
    private List<Mark> marks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCreditHours() {
        return creditHours;
    }

    public Integer setCreditHours(Integer creditHours) {
        return creditHours;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }
}
