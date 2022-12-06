import java.io.*;
import java.util.*;

public class StudentManager {
    	private ArrayList <Student> studentSystem;
    	private boolean isStringGraded = true;
    	Scanner scnr = new Scanner(System.in);
    	private boolean needInput; // for error checking

    	// constructor - no parameters
    	public StudentManager() throws FileNotFoundException {
    			studentSystem = new ArrayList<Student>(); // now making dynamic space for studentSystem
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
        		} catch (InputMismatchException e) {
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
            
            // putting in values to get rid of error/initialization messages
            String grade = "";
            double doubleGrade = 0.0;
            
            // error checking
            System.out.print("Enter Grade: ");
            if (isStringGraded) {
                grade = scnr.nextLine();
            } else {
            	needInput = true;
            	while (needInput) {
            		try {
        				doubleGrade = scnr.nextDouble();
        				needInput = false;
            		} catch (InputMismatchException e) {
            			System.out.print("Error! Please enter a valid double: ");
    					scnr.next();
            		}
            	}
            }
            
            Student newStudent;
            if (isStringGraded) {
            	newStudent = new Student(id, name, course, teacher, grade);   
            	newStudent.updateGradeToDouble();
            } else {
            	newStudent = new Student(id, name, course, teacher, doubleGrade);   
            	newStudent.updateGradeToString();
            }
            
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
    		
    		while (removeVal >= studentSystem.size() || removeVal < 0) {
				System.out.print("Error! Please enter a valid corresponding number: ");
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
            
            // setting grade depending on grading system
            if (this.isStringGraded) {
            	System.out.println("\n" + studentSystem.get(userIndex).name + "'s Current Grade: " + studentSystem.get(userIndex).grade);
             
                System.out.print("What would you like to change it to? ");
                studentSystem.get(userIndex).setGrade(scnr.next());
            } else {
            	System.out.println("\n" + studentSystem.get(userIndex).name + "'s Current Grade: " + studentSystem.get(userIndex).doubleGrade);

                System.out.print("What would you like to change it to? ");
                needInput = true;
            	while (needInput) {
            		try {
                        studentSystem.get(userIndex).setDoubleGrade(scnr.nextDouble());
        				needInput = false;
            		} catch (InputMismatchException e) {
            			System.out.print("Error! Please enter a valid double: ");
    					scnr.next();
            		}
            	}
            }
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
            
            
            System.out.println("\n" + studentSystem.get(userIndex).name + "'s Current Class: " + studentSystem.get(userIndex).course);
            
            System.out.print("What would you like to change it to? ");
            studentSystem.get(userIndex).setCourse(scnr.next());
    		
    	}
    	
    	// print students
    	public void printStudents() {
    		System.out.println("TOTAL NUM OF STUDENTS: " + Student.getNumStudents());
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    		for (int i = 0; i < studentSystem.size(); i++) {
    			studentSystem.get(i).printStudent(this.isStringGraded);
    		} 		
    	}
    	
    	// print failing students
    	public void printFailingStudents() {
    		int counter = 0;
    		
    		for (int i = 0; i < studentSystem.size(); i++) {
    			studentSystem.get(i).updateGradeToDouble(); // to make comparisons
    			if (studentSystem.get(i).doubleGrade < 73.0) {
    				counter++;
    				if (this.isStringGraded) {
        				System.out.println(counter + ") " + studentSystem.get(i).name + " : " + studentSystem.get(i).grade);
    				} else {
        				System.out.println(counter + ") " + studentSystem.get(i).name + " : " + studentSystem.get(i).doubleGrade);
    				}
    			}
    		} 
    		
    		if (counter == 0) {
    			System.out.println("There are no failing students, congrats!");
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
    		
    		 if (this.isStringGraded) {
    	         System.out.println("\nGrade: " + studentSystem.get(userIndex).grade);
             } else {
    	         System.out.println("\nGrade: " + studentSystem.get(userIndex).doubleGrade);
             }
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
			
            System.out.println("\nClass: " + studentSystem.get(userIndex).course);
    	}

    	// change grading type
    	public void changeGradingType() {
    		if (this.isStringGraded) {
    			System.out.println("Grading system changed from Letter to 4.0 Scale!");
    			System.out.println("\nNote: Decimal values have automatically updated:");
    			Student.printConversionTable();
    			
    			// update grades
    			for (int i = 0; i < studentSystem.size(); i++) {
                    studentSystem.get(i).updateGradeToDouble();
                }    	
    			this.isStringGraded = false;
    			
    		} else {
    			System.out.println("Grading system changed from 4.0 to Letter Scale!");
    			
    			// update grades
    			for (int i = 0; i < studentSystem.size(); i++) {
                    studentSystem.get(i).updateGradeToString();
                }    	
    			this.isStringGraded = true;
    		}
    		
    	}
    	
    	// file methods
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
                 System.out.println(i + 1 + ": " + studentSystem.get(i).name);
             }
    	}
    	
    	
}