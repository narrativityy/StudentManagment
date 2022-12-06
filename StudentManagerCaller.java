import java.io.IOException;
import java.util.*;

public class StudentManagerCaller {

	public static void main(String[] args) throws IOException {
		
		
		Scanner scnr = new Scanner(System.in);
		StudentManager students = new StudentManager();
        int continueVal = 0;
        int choice = 0;

        System.out.println("~~ Welcome to the Student Management System 1.0 ~~");
        
		do {
			System.out.println("~~ MAIN MENU OPTIONS ~~");
            System.out.println("\n1. Add a Student");
            System.out.println("2. Remove a Student");
            System.out.println("3. Print All Student Info");
            System.out.println("4: Print All Failing Students");
            System.out.println("5: View a Student's Grades");
            System.out.println("6: Update a Student's Grades");
            System.out.println("7: View a Student's Class");
            System.out.println("8: Change a Student's Class");
            System.out.println("9: Change Grading Type");
            System.out.println("10: Clear File and Exit");
            System.out.println("11: Save File and Exit");
            System.out.print("\nChoose an action: ");
            
            // error checking
            boolean needInput = true;
    		while (needInput) {
    			try {
    				choice = scnr.nextInt();
    				needInput = false;
        		}
        		catch (InputMismatchException e) {
        			System.out.print("Error! Please enter a valid integer: ");
					scnr.next();
        		}
    		}
            System.out.println("------------------------------------------------");

            switch(choice) {
            	
            	// add student
                case 1:
                	System.out.println("~ NOW ADDING A STUDENT ~");
                    students.addStudent();
                    System.out.println("------------------------------------------------");
                    break;               
                    
                 // remove student
                case 2:
                	System.out.println("~ NOW REMOVING A STUDENT ~");
                	students.removeStudent();
                    System.out.println("------------------------------------------------");
                    break;
               
                // print all students info
                case 3:
                	System.out.println("~ NOW PRINTING ALL STUDENTS ~");
                    students.printStudents();
                    System.out.println("------------------------------------------------");
                    break;
                
                // print failing students
                case 4:
                	System.out.println("~ NOW PRINTING ALL FAILING STUDENTS ~");
                	students.printFailingStudents();
                    System.out.println("------------------------------------------------");
                	break;
                	
                // print one student's grade
                case 5:
                	System.out.println("~ NOW PRINTING A GRADE ~");
                	students.printGrade();
                    System.out.println("------------------------------------------------");
                    break;
                    
                // change grade
                case 6:
                	System.out.println("~ NOW UPDATING A GRADE ~");
                	students.updateGrade();
                    System.out.println("------------------------------------------------");
                    break;
                    
                // print one student's class
                case 7:
                	System.out.println("~ NOW PRINTING A CLASS ~");
                	students.printClass();
                    System.out.println("------------------------------------------------");
                    break;
                    
                // change class
                case 8:
                	System.out.println("~ NOW UPDATING A CLASS ~");
                	students.updateClass();
                    System.out.println("------------------------------------------------");
                	break;
                
                // change grading type
                case 9:
                	System.out.println("~ NOW CHANGING GRADING TYPE ~");
                	students.changeGradingType();
                    System.out.println("------------------------------------------------");
                	break;
                
                // clear file and exit
                case 10:
                    students.clearFile();
                    continueVal = 1;
                    break;
                    
                // save file and exit
                case 11:
                    students.writeToFile();
                	continueVal = 1;
                	break;
                    
                default:
                	System.out.println("Error! Please enter a valid option.");
            }

        } while (continueVal == 0);
        
		System.out.println("Thanks for using the Student Management System 1.0!");
		scnr.close();
	}

}
