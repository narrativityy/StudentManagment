import java.io.*;
import java.util.*;

public class StudentManager {
    	private ArrayList <Student> studentSystem;
    	Scanner scnr = new Scanner(System.in);
    	boolean needInput; // for error checking

    	// constructor - no parameters
    	public StudentManager() throws FileNotFoundException {
    			studentSystem = new ArrayList<Student>(); // now making dynamic space for customerCart
				studentSystem = FileHandler.printFile();
			}	
    	
    	// add a student
    	public void addStudent() {	
    		System.out.print("Enter ID: ");
            int id = -1;
            
            needInput = true;
    		while (needInput) {
    			try {
    				id = scnr.nextInt();
    				needInput = false;
        		}
        		catch (InputMismatchException e) {
        			System.out.print("Error! Please enter a valid integer: ");
					scnr.next();
        		}
    		}
    		
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
            int removeVal = -1;
            
            needInput = true;
    		while (needInput) {
    			try {
    				removeVal = scnr.nextInt() - 1;
    				needInput = false;
        		}
        		catch (InputMismatchException e) {
        			System.out.print("Error! Please enter a valid integer: ");
					scnr.next();
        		}
    		}
    		
    		
            studentSystem.remove(removeVal);
            Student.decrementNumStudents();
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
            int userIndex = -1;
            needInput = true;
    		while (needInput) {
    			try {
    				userIndex = scnr.nextInt() - 1;
    				needInput = false;
        		}
        		catch (InputMismatchException e) {
        			System.out.print("Error! Please enter a valid integer: ");
					scnr.next();
        		}
    		}
    		
            while (userIndex >= studentSystem.size() || userIndex < 0) {
				System.out.print("Error! Please enter a valid corresponding number: ");
				needInput = true;
	    		while (needInput) {
	    			try {
	    				userIndex = scnr.nextInt() - 1;
	    				needInput = false;
	        		}
	        		catch (InputMismatchException e) {
	        			System.out.print("Error! Please enter a valid integer: ");
						scnr.next();
	        		}
	    		}
			}
            
            System.out.println("\n" + studentSystem.get(userIndex).getName() + "'s Current Grade: " + studentSystem.get(userIndex).getGrade());
            
            System.out.print("What would you like to change it to? ");
            studentSystem.get(userIndex).setGrade(scnr.next());
    	}
    	
    	// update class
    	public void updateClass() {
    		if (studentSystem.size() == 0) {
    			System.out.println("ERROR! You have no students in your system.");
    			return;	
    		}
    		
    		formatPrintAll();
            System.out.print("\nWhich Student's class would you like to change? ");
    	           
            // error checking
            int userIndex = -1;
            needInput = true;
    		while (needInput) {
    			try {
    				userIndex = scnr.nextInt() - 1;
    				needInput = false;
        		}
        		catch (InputMismatchException e) {
        			System.out.print("Error! Please enter a valid integer: ");
					scnr.next();
        		}
    		}
    		
    		// more error checking
            while (userIndex >= studentSystem.size() || userIndex < 0) {
				System.out.print("Error! Please enter a valid corresponding number: ");
				needInput = true;
	    		while (needInput) {
	    			try {
	    				userIndex = scnr.nextInt() - 1;
	    				needInput = false;
	        		}
	        		catch (InputMismatchException e) {
	        			System.out.print("Error! Please enter a valid integer: ");
						scnr.next();
	        		}
	    		}
			}
            
            
            System.out.println("\n" + studentSystem.get(userIndex).getName() + "'s Current Class: " + studentSystem.get(userIndex).getCourse());
            
            System.out.print("What would you like to change it to? ");
            studentSystem.get(userIndex).setCourse(scnr.next());
    		
    	}
    	
    	// print students
    	public void printStudents() {
    		System.out.println("TOTAL NUM OF STUDENTS: " + Student.getNumStudents());
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    		for (int i = 0; i < studentSystem.size(); i++) {
    			studentSystem.get(i).printStudent();
    		} 		
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
    		int userIndex = -1;
    		needInput = true;
    		while (needInput) {
    			try {
    				userIndex = scnr.nextInt() - 1;
    				needInput = false;
        		}
        		catch (InputMismatchException e) {
        			System.out.print("Error! Please enter a valid integer: ");
					scnr.next();
        		}
    		}
    		
    		// more error checking
    		while (userIndex >= studentSystem.size() || userIndex < 0) {
				System.out.print("Error! Please enter a valid corresponding number: ");
				
				needInput = true;
	    		while (needInput) {
	    			try {
	    				userIndex = scnr.nextInt() - 1;
	    				needInput = false;
	        		}
	        		catch (InputMismatchException e) {
	        			System.out.print("Error! Please enter a valid integer: ");
						scnr.next();
	        		}
	    		}
			}
			
            System.out.println("\nGrade: " + studentSystem.get(userIndex).getGrade());
    	}
    	
    	// print class
    	public void printClass() {
    		if (studentSystem.size() == 0) {
    			System.out.println("ERROR! You have no students in your system.");
    			return;
    		}
    		
    		formatPrintAll();
    		System.out.print("\nWhich Student's class would you like to view? ");
    		
    		// error checking
    		int userIndex = -1;
    		needInput = true;
    		while (needInput) {
    			try {
    				userIndex = scnr.nextInt() - 1;
    				needInput = false;
        		}
        		catch (InputMismatchException e) {
        			System.out.print("Error! Please enter a valid integer: ");
					scnr.next();
        		}
    		}
    		
    		// more error checking
    		while (userIndex >= studentSystem.size() || userIndex < 0) {
				System.out.print("Error! Please enter a valid corresponding number: ");
				
				needInput = true;
	    		while (needInput) {
	    			try {
	    				userIndex = scnr.nextInt() - 1;
	    				needInput = false;
	        		}
	        		catch (InputMismatchException e) {
	        			System.out.print("Error! Please enter a valid integer: ");
						scnr.next();
	        		}
	    		}
			}
			
            System.out.println("\nClass: " + studentSystem.get(userIndex).getCourse());
    	}

		public void writeToFile() throws IOException {
			FileHandler.writeFileLines(studentSystem);
		}

		public void clearFile() throws IOException {
			FileHandler.clearFile();
		}
  
    	// private methods
    	// way of printing students to user
    	private void formatPrintAll() {
    		 for (int i = 0; i < studentSystem.size(); i++) {
                 System.out.println(i + 1 + ": " + studentSystem.get(i).getName());
             }
    	}
    	
    	
}