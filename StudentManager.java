package cs141.jmcrowley.Project.HannahFiles;

import java.util.*;

public class StudentManager {
    	private ArrayList <Student> studentSystem;
    	Scanner scnr = new Scanner(System.in);

    	// constructor - no parameters
    	public StudentManager() {
    		studentSystem = new ArrayList<Student>(); // now making dynamic space for customerCart
    	}	
    	
    	// add a student
    	public void addStudent() {	
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
            
    		Student newStudent = new Student(id, name, course, teacher, grade);     
    		studentSystem.add(newStudent);
    	}
    	
    	// remove a student
    	public void removeStudent() {    	
    		if (studentSystem.size() == 0) {
    			System.out.println("ERROR! You have no students in your system.");
    			return;
    		}
    		
    		formatPrintAll();
            System.out.print("\nWhich Student would you like to remove? ");
            int removeVal = verifyIndexInt();
            studentSystem.remove(removeVal);
    	}
    	
    	// update grade
    	public void updateGrade() {
    		if (studentSystem.size() == 0) {
    			System.out.println("ERROR! You have no students in your system.");
    			return;
    		}
    		
    		formatPrintAll();
            System.out.print("\nWhich Student's grade would you like to change? ");
            
            // error checking
            int userIndex = verifyIndexInt();
            while (userIndex >= studentSystem.size() || userIndex < 0) {
				System.out.print("Error! Please enter a valid corresponding number: ");
				userIndex = verifyIndexInt();
			}
            
            System.out.println("\n" + studentSystem.get(userIndex).getName() + "'s Current Grade: " + studentSystem.get(userIndex).getGrade());
            
            System.out.print("What would you like to change it to? ");
            String gradeVal = scnr.next();
            studentSystem.get(userIndex).setGrade(gradeVal);
    	}
    	
    	// update class
    	public void updateClass() {
    		if (studentSystem.size() == 0) {
    			System.out.println("ERROR! You have no students in your system.");
    			return;	
    		}
    		
    		formatPrintAll();
            System.out.print("\nWhich Student's class would you like to change? ");
    		
    		
    	}
    	
    	// print students
    	public void printStudents() {
    		System.out.println("TOTAL NUM OF STUDENTS: " + Student.getNumStudents());
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    		for (int i = 0; i < studentSystem.size(); i++) {
    			studentSystem.get(i).printStudent();
    		}
    		
    		 // error checking
            int userIndex = verifyIndexInt();
            while (userIndex >= studentSystem.size() || userIndex < 0) {
				System.out.print("Error! Please enter a valid corresponding number: ");
				userIndex = verifyIndexInt();
			}
            
            // 
            System.out.println("\n" + studentSystem.get(userIndex).getName() + "'s Current Class: " + studentSystem.get(userIndex).getClass());
            
            System.out.print("What would you like to change it to? ");
            String userClass = scnr.next();
            studentSystem.get(userIndex).setGrade(userClass);
    	}
    	
    	
    	// print one student's grade
    	public void printGrade() {
    		if (studentSystem.size() == 0) {
    			System.out.println("ERROR! You have no students in your system.");
    			return;
    		}
    		
    		formatPrintAll();
    		System.out.print("\nWhich Student's grade would you like to view? ");
    		
    		// error checking
    		int userIndex = verifyIndexInt();
    		while (userIndex >= studentSystem.size() || userIndex < 0) {
				System.out.print("Error! Please enter a valid corresponding number: ");
				userIndex = verifyIndexInt();
			}
			
            System.out.println("\nGrade: " + studentSystem.get(userIndex).getGrade());
    	}
    	
    	
  
    	// private methods
    	// way of printing students to user
    	private void formatPrintAll() {
    		 for (int i = 0; i < studentSystem.size(); i++) {
                 System.out.println(i + 1 + ": " + studentSystem.get(i).getName());
             }
    	}
    	
    	// error checking 
    	private int verifyIndexInt() {
    		int userIndex;
    		if (scnr.hasNextInt()) {
				userIndex = scnr.nextInt() - 1;
			} else {
				while (!scnr.hasNextInt()) {
					System.out.print("Error! Please enter a valid integer: ");
					scnr.next();
				}
				userIndex = scnr.nextInt() - 1;
			}
    		return userIndex;
    	}
    	
    	
}