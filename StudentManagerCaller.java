import java.util.*;

public class StudentManagerCaller {

	public static void main(String[] args) {
		
		
		Scanner scnr = new Scanner(System.in);
		StudentManager students = new StudentManager();
        int continueVal = 0;
        int choice;

        System.out.println("~~ Welcome to the Student Management System 1.0 ~~");
        
		do {
			System.out.println("            ~~ CHOOSE AN OPTION ~~");
            System.out.println("\n1. Add a Student");
            System.out.println("2. Remove a Student");
            System.out.println("3. Print Students");
            System.out.println("4: View a Student's Grades");
            System.out.println("5: Update a Student's Grades");
            System.out.println("6: View a Student's Class");
            System.out.println("7: Change a Student's Class");
            System.out.println("8: Exit");
            System.out.print("\nChoose an action: ");
            
            // error checking - make sure that an int is next
            if (scnr.hasNextInt()) {
				choice = scnr.nextInt();
			} 
            else {
				while (!scnr.hasNextInt()) {
					System.out.print("Error! Please enter a valid integer: ");
					scnr.next();
				}
				choice = scnr.nextInt();
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
                	System.out.println("~ NOW REMOVING A STUDENTS ~");
                	students.removeStudent();
                    System.out.println("------------------------------------------------");
                    break;
               
                // print all students info
                case 3:
                    System.out.println("1: Print All Students");
                    System.out.println("2: Print a Specific Student");
                    System.out.print("Choose an action: ");
                    do {
                        if (scnr.hasNextInt()) {
                            choice = scnr.nextInt();
                        } 
                        else {
                            while (!scnr.hasNextInt()) {
                                System.out.print("Error! Please enter a valid integer: ");
                                scnr.next();
                            }
                            choice = scnr.nextInt();
                        }
                        switch(choice) {
                            case 1:    
                                System.out.println("~ NOW PRINTING ALL STUDENTS ~");
                                students.printStudents();
                                System.out.println("------------------------------------------------");
                                break;
                            case 2:
                                System.out.println("------------------------------------------------");
                                students.printSpecificStudent();
                                break;
                        }
                    } while(choice < 1 && choice > 2);
                    break;

                // print one student's grade
                case 4:
                	System.out.println("~ NOW PRINTING A GRADE ~");
                	students.printGrade();
                    System.out.println("------------------------------------------------");
                    break;
                    
                // change grade
                case 5:
                	System.out.println("~ NOW UPDATING A GRADE ~");
                	students.updateGrade();
                    System.out.println("------------------------------------------------");
                    break;
                    
                // change class
                case 7:
                	System.out.println("~ NOW UPDATING A CLASS ~");
                	
                    System.out.println("------------------------------------------------");
                	break;
                
                // exit menu
                case 8:
                    continueVal = 1;
                    break;
                    
                default:
                	System.out.println("Error! Please enter a valid option.");
            }

        } while (continueVal == 0);
        
		
		scnr.close();
	}

}
