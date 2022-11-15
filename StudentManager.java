package cs141.jmcrowley.Project;
import java.util.*;

public class StudentManager {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>();
        Scanner scnr = new Scanner(System.in);
        int continueVal = 0;
        int choice;

        System.out.println("~~ Welcome to the Student Management System 1.0 ~~");

        do{
            System.out.println("\n1. Add a Student");
            System.out.println("2. Remove a Student");
            System.out.println("3. Print Students");
            System.out.println("4: View a Student's Grades");
            System.out.println("5: Update a Student's Grades");
            System.out.println("6: View a Student's Class");
            System.out.println("7: Change a Student's Class");
            System.out.println("8: Exit");
            System.out.print("\nChoose an action: ");
            choice = scnr.nextInt();
            System.out.println("");

            switch(choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scnr.nextInt();
                    System.out.print("Enter Name: ");
                    String name = scnr.nextLine();
                    name = scnr.nextLine();
                    System.out.print("Enter Course: ");
                    String course = scnr.nextLine();
                    System.out.print("Enter Teacher: ");
                    String teacher = scnr.nextLine();
                    System.out.print("Enter Grade: ");
                    String grade = scnr.nextLine();
                    students.add(new Student(id, name, course, teacher, grade));
                    break;
                case 2:
                    for (int i = 0; i < students.size(); i++) {
                        System.out.println(i + 1 + ": " + students.get(i).getName());
                    }
                    System.out.print("\nWhich Student would you like to remove? ");
                    int removeVal = scnr.nextInt()-1;
                    students.remove(removeVal);
                case 3:
                    for (int i = 0; i < students.size(); i++) {
                        System.out.println("ID: " + students.get(i).getId());
                        System.out.println("Name: " + students.get(i).getName());
                        System.out.println("Course: " + students.get(i).getCourse());
                        System.out.println("Teacher: " + students.get(i).getTeacher());
                        System.out.println("Grade: " + students.get(i).getGrade() + "\n");
                    }
                    break;
                case 4:
                    for (int i = 0; i < students.size(); i++) {
                        System.out.println(i + 1 + ": " + students.get(i).getName());
                    }
                    System.out.print("\nWhich Student's grade would you like to view? ");
                    int viewVal = scnr.nextInt() - 1;
                    System.out.println("\nGrade: " + students.get(viewVal).getGrade());
                    break;
                case 5:
                    for (int i = 0; i < students.size(); i++) {
                        System.out.println(i + 1 + ": " + students.get(i).getName());
                    }
                    System.out.print("\nWhich Student's grade would you like to change? ");
                    int gradeChangeVal = scnr.nextInt() - 1;
                    System.out.println("\nCurrent Grade: " + students.get(gradeChangeVal).getGrade());
                    System.out.print("What would you like to change it to? ");
                    String gradeVal = scnr.next();
                    students.get(gradeChangeVal).setGrade(gradeVal);
                    break;
                case 8:
                    continueVal = 1;
                    break;
            }

        } while (continueVal == 0);
        scnr.close();
    }
}
