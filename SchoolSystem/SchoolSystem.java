package SchoolSystem;


import SchoolSystem.Services.*;


import java.util.Scanner;

public class SchoolSystem {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter School details");
        SchoolService.addSchool();
    }
}
