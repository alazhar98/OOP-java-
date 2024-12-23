package SchoolSystem.Entities;

import java.util.List;

public class Teacher {
    private String name;
    private String id;
    private Integer yearsOfExperience;
    private List<Subject> subjectsExpertiseList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public List<Subject> getSubjectsExpertiseList() {
        return subjectsExpertiseList;
    }

    public void setSubjectsExpertiseList(List<Subject> subjectsExpertiseList) {
        this.subjectsExpertiseList = subjectsExpertiseList;
    }
}
