import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SchoolSystemUsingOOP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Object>> schools = new HashMap<>();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add School");
            System.out.println("2. Add Student to School");
            System.out.println("3. Add Subject to Student");
            System.out.println("4. Add Teacher and Assign to Subject");
            System.out.println("5. Display Schools, Students, Teachers, and Libraries");
            System.out.println("6. Retrieve Marks for a Student in a Subject");
            System.out.println("7. Calculate Average Marks for a Student");
            System.out.println("8. Delete Teacher from Subject");
            System.out.println("9. Add Book to Library");
            System.out.println("10. List Available Books");
            System.out.println("11. Assign Book to Student");
            System.out.println("12. List Assigned Books for Student");
            System.out.println("13. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addSchools(schools, scanner);
                    break;
                case 2:
                    addStudents(schools, scanner);
                    break;
                case 3:
                    addSubjects(schools, scanner);
                    break;
                case 4:
                    addTeacherAndAssignToSubject(schools, scanner);
                    break;
                case 5:
                    displaySchools(schools);
                    break;
                case 6:
                    retrieveMarks(schools, scanner);
                    break;
                case 7:
                    calculateAverageMarks(schools, scanner);
                    break;
                case 8:
                    deleteTeacherFromSubject(schools, scanner);
                    break;
                case 9:
                    addBookToLibrary(schools, scanner);
                    break;
                case 10:
                    listAvailableBooks(schools, scanner);
                    break;
                case 11:
                    assignBookToStudent(schools, scanner);
                    break;
                case 12:
                    listAssignedBooksForStudent(schools, scanner);
                    break;
                case 13:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addSchools(Map<String, Map<String, Object>> schools, Scanner scanner) {
        System.out.print("How many schools do you want to add? ");
        int numberOfSchools = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numberOfSchools; i++) {
            System.out.print("Enter school name: ");
            String schoolName = scanner.nextLine();
            System.out.print("Enter school address: ");
            String schoolAddress = scanner.nextLine();

            Map<String, Object> schoolInfo = new HashMap<>();
            schoolInfo.put("Address", schoolAddress);
            schoolInfo.put("Students", new ArrayList<Map<String, Object>>());
            schoolInfo.put("Teachers", new ArrayList<Map<String, Object>>());
            schoolInfo.put("Library", new ArrayList<Map<String, Object>>());
            schoolInfo.put("BookAssignments", new HashMap<Integer, List<Map<String, Object>>>());
            schools.put(schoolName, schoolInfo);
            System.out.println("School added successfully.");
        }
    }

    private static void addStudents(Map<String, Map<String, Object>> schools, Scanner scanner) {
        System.out.print("Enter school name to add students: ");
        String schoolName = scanner.nextLine();

        Map<String, Object> schoolInfo = schools.get(schoolName);
        if (schoolInfo != null) {
            System.out.print("How many students do you want to add? ");
            int numberOfStudents = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            for (int i = 0; i < numberOfStudents; i++) {
                System.out.print("Enter student name: ");
                String studentName = scanner.nextLine();
                System.out.print("Enter student ID: ");
                int studentID = scanner.nextInt();
                System.out.print("Enter student grade: ");
                String studentGrade = scanner.next();
                System.out.print("Enter student age: ");
                int studentAge = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                Map<String, Object> student = createStudent(studentID, studentName, studentGrade, studentAge);
                ((List<Map<String, Object>>) schoolInfo.get("Students")).add(student);
                System.out.println("Student added successfully.");
            }
        } else {
            System.out.println("School not found.");
        }
    }

    private static void addSubjects(Map<String, Map<String, Object>> schools, Scanner scanner) {
        System.out.print("Enter school name: ");
        String schoolName = scanner.nextLine();
        Map<String, Object> schoolInfo = schools.get(schoolName);

        if (schoolInfo != null) {
            System.out.print("Enter student name to add subjects: ");
            String studentName = scanner.nextLine();
            List<Map<String, Object>> students = (List<Map<String, Object>>) schoolInfo.get("Students");

            for (Map<String, Object> student : students) {
                if (student.get("Name").equals(studentName)) {
                    System.out.print("How many subjects do you want to add? ");
                    int numberOfSubjects = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    for (int i = 0; i < numberOfSubjects; i++) {
                        System.out.print("Enter subject name: ");
                        String subjectName = scanner.nextLine();
                        System.out.print("Enter marks for " + subjectName + ": ");
                        int marks = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        List<Map<String, Object>> subjects = (List<Map<String, Object>>) student.get("Subjects");
                        subjects.add(createSubject(subjectName, "Teacher Name", 3, marks, "A", "Good"));
                        System.out.println("Subject added successfully.");
                    }
                    return;
                }
            }
            System.out.println("Student not found.");
        } else {
            System.out.println("School not found.");
        }
    }

    private static void addTeacherAndAssignToSubject(Map<String, Map<String, Object>> schools, Scanner scanner) {
        System.out.print("Enter school name to add teacher: ");
        String schoolName = scanner.nextLine();
        Map<String, Object> schoolInfo = schools.get(schoolName);

        if (schoolInfo != null) {

            System.out.print("Enter teacher ID: ");
            int teacherID = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter teacher name: ");
            String teacherName = scanner.nextLine();
            System.out.print("Enter teacher subject expertise: ");
            String subjectExpertise = scanner.nextLine();
            System.out.print("Enter years of experience: ");
            int yearsOfExperience = scanner.nextInt();
            scanner.nextLine();

            Map<String, Object> teacher = createTeacher(teacherID, teacherName, subjectExpertise, yearsOfExperience);


            ((List<Map<String, Object>>) schoolInfo.get("Teachers")).add(teacher);
            System.out.println("Teacher added successfully.");


            System.out.print("Enter student name to assign teacher to subject: ");
            String studentName = scanner.nextLine();
            List<Map<String, Object>> students = (List<Map<String, Object>>) schoolInfo.get("Students");

            for (Map<String, Object> student : students) {
                if (student.get("Name").equals(studentName)) {
                    System.out.print("Enter subject name to assign teacher to: ");
                    String subjectName = scanner.nextLine();
                    List<Map<String, Object>> subjects = (List<Map<String, Object>>) student.get("Subjects");

                    for (Map<String, Object> subject : subjects) {
                        if (subject.get("SubjectName").equals(subjectName)) {
                            subject.put("TeacherName", teacherName);
                            System.out.println("Teacher " + teacherName + " assigned to subject " + subjectName);
                            return;
                        }
                    }
                    System.out.println("Subject not found.");
                    return;
                }
            }
            System.out.println("Student not found.");
        } else {
            System.out.println("School not found.");
        }
    }

    private static void addBookToLibrary(Map<String, Map<String, Object>> schools, Scanner scanner) {
        System.out.print("Enter school name to add book to library: ");
        String schoolName = scanner.nextLine();
        Map<String, Object> schoolInfo = schools.get(schoolName);

        if (schoolInfo != null) {

            System.out.print("Enter book ID: ");
            int bookID = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter book title: ");
            String title = scanner.nextLine();
            System.out.print("Enter book author: ");
            String author = scanner.nextLine();
            System.out.print("Enter publication year: ");
            int publicationYear = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter availability status (available/unavailable): ");
            String availabilityStatus = scanner.nextLine();

            Map<String, Object> book = createBook(bookID, title, author, publicationYear, availabilityStatus);

            ((List<Map<String, Object>>) schoolInfo.get("Library")).add(book);
            System.out.println("Book added successfully.");
        } else {
            System.out.println("School not found.");
        }
    }

    private static void listAvailableBooks(Map<String, Map<String, Object>> schools, Scanner scanner) {
        System.out.print("Enter school name to list available books: ");
        String schoolName = scanner.nextLine();
        Map<String, Object> schoolInfo = schools.get(schoolName);

        if (schoolInfo != null) {
            List<Map<String, Object>> library = (List<Map<String, Object>>) schoolInfo.get("Library");
            System.out.println("Available Books:");
            for (Map<String, Object> book : library) {
                if ("available".equalsIgnoreCase((String) book.get("AvailabilityStatus"))) {
                    System.out.printf("Book ID: %d, Title: %s, Author: %s, Published in: %d%n", book.get("BookID"), book.get("Title"), book.get("Author"), book.get("PublicationYear"));
                }
            }
        } else {
            System.out.println("School not found.");
        }
    }

    private static void assignBookToStudent(Map<String, Map<String, Object>> schools, Scanner scanner) {
        System.out.print("Enter school name to assign book to student: ");
        String schoolName = scanner.nextLine();
        Map<String, Object> schoolInfo = schools.get(schoolName);

        if (schoolInfo != null) {
            System.out.print("Enter student ID: ");
            int studentID = scanner.nextInt();
            scanner.nextLine();

            List<Map<String, Object>> students = (List<Map<String, Object>>) schoolInfo.get("Students");
            Map<String, Object> student = null;
            for (Map<String, Object> s : students) {
                if ((int) s.get("ID") == studentID) {
                    student = s;
                    break;
                }
            }

            if (student != null) {
                System.out.print("Enter book ID to assign to student: ");
                int bookID = scanner.nextInt();
                scanner.nextLine();
                List<Map<String, Object>> library = (List<Map<String, Object>>) schoolInfo.get("Library");

                Map<String, Object> bookToAssign = null;
                for (Map<String, Object> book : library) {
                    if ((int) book.get("BookID") == bookID && "available".equalsIgnoreCase((String) book.get("AvailabilityStatus"))) {
                        bookToAssign = book;
                        break;
                    }
                }

                if (bookToAssign != null) {
                    Map<Integer, List<Map<String, Object>>> bookAssignments = (Map<Integer, List<Map<String, Object>>>) schoolInfo.get("BookAssignments");
                    bookAssignments.putIfAbsent(studentID, new ArrayList<>());
                    bookAssignments.get(studentID).add(bookToAssign);

                    bookToAssign.put("AvailabilityStatus", "unavailable");

                    System.out.println("Book assigned to student successfully.");
                } else {
                    System.out.println("Book is not available.");
                }
            } else {
                System.out.println("Student not found.");
            }
        } else {
            System.out.println("School not found.");
        }
    }

    private static void listAssignedBooksForStudent(Map<String, Map<String, Object>> schools, Scanner scanner) {
        System.out.print("Enter school name to list assigned books for student: ");
        String schoolName = scanner.nextLine();
        Map<String, Object> schoolInfo = schools.get(schoolName);

        if (schoolInfo != null) {
            System.out.print("Enter student ID: ");
            int studentID = scanner.nextInt();
            scanner.nextLine();

            Map<Integer, List<Map<String, Object>>> bookAssignments = (Map<Integer, List<Map<String, Object>>>) schoolInfo.get("BookAssignments");
            List<Map<String, Object>> assignedBooks = bookAssignments.get(studentID);

            if (assignedBooks != null && !assignedBooks.isEmpty()) {
                System.out.println("Assigned Books for Student:");
                for (Map<String, Object> book : assignedBooks) {
                    System.out.printf("Book ID: %d, Title: %s%n", book.get("BookID"), book.get("Title"));
                }
            } else {
                System.out.println("No books assigned to this student.");
            }
        } else {
            System.out.println("School not found.");
        }
    }

    private static void retrieveMarks(Map<String, Map<String, Object>> schools, Scanner scanner) {
        System.out.print("Enter school name: ");
        String schoolName = scanner.nextLine();
        Map<String, Object> schoolInfo = schools.get(schoolName);

        if (schoolInfo != null) {
            System.out.print("Enter student name: ");
            String studentName = scanner.nextLine();
            List<Map<String, Object>> students = (List<Map<String, Object>>) schoolInfo.get("Students");

            for (Map<String, Object> student : students) {
                if (student.get("Name").equals(studentName)) {
                    System.out.print("Enter subject name: ");
                    String subjectName = scanner.nextLine();
                    List<Map<String, Object>> subjects = (List<Map<String, Object>>) student.get("Subjects");

                    for (Map<String, Object> subject : subjects) {
                        if (subject.get("SubjectName").equals(subjectName)) {
                            System.out.printf("Marks for %s in %s: %d%n", studentName, subjectName, subject.get("Marks"));
                            return;
                        }
                    }
                    System.out.println("Subject not found.");
                    return;
                }
            }
            System.out.println("Student not found.");
        } else {
            System.out.println("School not found.");
        }
    }

    private static void calculateAverageMarks(Map<String, Map<String, Object>> schools, Scanner scanner) {
        System.out.print("Enter school name: ");
        String schoolName = scanner.nextLine();
        Map<String, Object> schoolInfo = schools.get(schoolName);

        if (schoolInfo != null) {
            System.out.print("Enter student name: ");
            String studentName = scanner.nextLine();
            List<Map<String, Object>> students = (List<Map<String, Object>>) schoolInfo.get("Students");

            for (Map<String, Object> student : students) {
                if (student.get("Name").equals(studentName)) {
                    List<Map<String, Object>> subjects = (List<Map<String, Object>>) student.get("Subjects");
                    int totalMarks = 0;
                    int subjectCount = subjects.size();

                    for (Map<String, Object> subject : subjects) {
                        totalMarks += (int) subject.get("Marks");
                        System.out.printf("Subject: %s, Marks: %d%n", subject.get("SubjectName"), subject.get("Marks"));
                    }

                    if (subjectCount > 0) {
                        double average = (double) totalMarks / subjectCount;
                        System.out.printf("Average Marks for %s: %.2f%n", studentName, average);
                    } else {
                        System.out.println("No subjects found for the student.");
                    }
                    return;
                }
            }
            System.out.println("Student not found.");
        } else {
            System.out.println("School not found.");
        }
    }

    private static void deleteTeacherFromSubject(Map<String, Map<String, Object>> schools, Scanner scanner) {
        System.out.print("Enter school name to delete teacher from subject: ");
        String schoolName = scanner.nextLine();
        Map<String, Object> schoolInfo = schools.get(schoolName);

        if (schoolInfo != null) {
            System.out.print("Enter teacher name to delete from subject: ");
            String teacherName = scanner.nextLine();
            List<Map<String, Object>> students = (List<Map<String, Object>>) schoolInfo.get("Students");

            for (Map<String, Object> student : students) {
                List<Map<String, Object>> subjects = (List<Map<String, Object>>) student.get("Subjects");
                for (Map<String, Object> subject : subjects) {
                    if (subject.get("TeacherName").equals(teacherName)) {
                        subject.put("TeacherName", "");
                        System.out.println("Teacher " + teacherName + " removed from subject.");
                        return;
                    }
                }
            }
            System.out.println("Teacher not found in any subject.");
        } else {
            System.out.println("School not found.");
        }
    }

    private static Map<String, Object> createStudent(int id, String name, String grade, int age) {
        Map<String, Object> student = new HashMap<>();
        student.put("ID", id);
        student.put("Name", name);
        student.put("Grade", grade);
        student.put("Age", age);
        student.put("Subjects", new ArrayList<Map<String, Object>>());
        return student;
    }

    private static Map<String, Object> createTeacher(int id, String name, String subjectExpertise, int yearsOfExperience) {
        Map<String, Object> teacher = new HashMap<>();
        teacher.put("ID", id);
        teacher.put("Name", name);
        teacher.put("SubjectExpertise", subjectExpertise);
        teacher.put("YearsOfExperience", yearsOfExperience);
        return teacher;
    }

    private static Map<String, Object> createSubject(String subjectName, String teacherName, int creditHours, int marks, String grade, String comments) {
        Map<String, Object> subject = new HashMap<>();
        subject.put("SubjectName", subjectName);
        subject.put("TeacherName", teacherName);
        subject.put("CreditHours", creditHours);
        subject.put("Marks", marks);
        subject.put("Grade", grade);
        subject.put("Comments", comments);
        return subject;
    }

    private static Map<String, Object> createBook(int bookID, String title, String author, int publicationYear, String availabilityStatus) {
        Map<String, Object> book = new HashMap<>();
        book.put("BookID", bookID);
        book.put("Title", title);
        book.put("Author", author);
        book.put("PublicationYear", publicationYear);
        book.put("AvailabilityStatus", availabilityStatus);
        return book;
    }

    private static void displaySchools(Map<String, Map<String, Object>> schools) {
        for (Map.Entry<String, Map<String, Object>> entry : schools.entrySet()) {
            String schoolName = entry.getKey();
            System.out.println("School: " + schoolName + " (Address: " + entry.getValue().get("Address") + ")");
            List<Map<String, Object>> students = (List<Map<String, Object>>) entry.getValue().get("Students");
            for (Map<String, Object> student : students) {
                System.out.printf("  Student: %s (ID: %d, Grade: %s, Age: %d)%n", student.get("Name"), student.get("ID"), student.get("Grade"), student.get("Age"));
                List<Map<String, Object>> subjects = (List<Map<String, Object>>) student.get("Subjects");
                for (Map<String, Object> subject : subjects) {
                    System.out.printf("    Subject: %s, Marks: %d, Teacher: %s%n", subject.get("SubjectName"), subject.get("Marks"), subject.get("TeacherName"));
                }
            }

            List<Map<String, Object>> teachers = (List<Map<String, Object>>) entry.getValue().get("Teachers");
            for (Map<String, Object> teacher : teachers) {
                System.out.printf("  Teacher: %s (ID: %d, Expertise: %s, Experience: %d years)%n", teacher.get("Name"), teacher.get("ID"), teacher.get("SubjectExpertise"), teacher.get("YearsOfExperience"));
            }

            List<Map<String, Object>> books = (List<Map<String, Object>>) entry.getValue().get("Library");
            for (Map<String, Object> book : books) {
                System.out.printf("  Book: %s by %s, Published in: %d, Status: %s%n", book.get("Title"), book.get("Author"), book.get("PublicationYear"), book.get("AvailabilityStatus"));
            }
        }
    }
}