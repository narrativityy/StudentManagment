public class Student {
    public int id;
    public String name;
    public String course;
    public String teacher;
    public String grade;
    public double doubleGrade;
    public static int numStudents;


    // constructor - String grade
    public Student(int id, String name, String course, String teacher, String grade) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.teacher = teacher;
        this.grade = grade;
        updateGradeToDouble();
        Student.incrementNumStudents();
    }
    
    // constructor - double grade
    public Student(int id, String name, String course, String teacher, double grade) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.teacher = teacher;
        this.doubleGrade = grade;
        updateGradeToString();
        Student.incrementNumStudents();
    }
    
    // print student info
    public void printStudent(boolean isStringGraded) {
    	if (isStringGraded) {
    		System.out.println("Name: " + name);
        	System.out.println("ID: " + id);
        	System.out.println("Course: " + course);
        	System.out.println("Teacher: " + teacher);
        	System.out.println("Grade: " + grade);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    	} else {
    		System.out.println("Name: " + name);
        	System.out.println("ID: " + id);
        	System.out.println("Course: " + course);
        	System.out.println("Teacher: " + teacher);
        	System.out.println("Grade: " + doubleGrade);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    	}
    	
    }
    
    // updates grade to double (updates doubleGrade variable)
    // no switch statement due to String values
    public void updateGradeToDouble() {
    	if (this.grade.equalsIgnoreCase("A+")) {
    		this.doubleGrade = 105.00;
    	} else if (this.grade.equalsIgnoreCase("A")) {
    		this.doubleGrade = 95.00;
    	} else if (this.grade.equalsIgnoreCase("A-")) {
    		this.doubleGrade = 90.00;
    	} else if (this.grade.equalsIgnoreCase("B+")) {
    		this.doubleGrade = 89.00;
    	} else if (this.grade.equalsIgnoreCase("B")) {
    		this.doubleGrade = 85.00;
    	} else if (this.grade.equalsIgnoreCase("B-")) {
    		this.doubleGrade = 80.00;
    	} else if (this.grade.equalsIgnoreCase("C+")) {
    		this.doubleGrade = 79.00;
    	} else if (this.grade.equalsIgnoreCase("C")) {
    		this.doubleGrade = 75.00;
    	} else if (this.grade.equalsIgnoreCase("C-")) {
    		this.doubleGrade = 70.00;
    	} else if (this.grade.equalsIgnoreCase("D+")) {
    		this.doubleGrade = 69.00;
    	} else if (this.grade.equalsIgnoreCase("D")) {
    		this.doubleGrade = 65.00;
    	} else if (this.grade.equalsIgnoreCase("D-")) {
    		this.doubleGrade = 60.00;
    	} else if (this.grade.equalsIgnoreCase("F")) {
    		this.doubleGrade = 50.00;
    	} else {
    		this.doubleGrade = 0.00;
    	}
    }
    
    // updates grade to String (updates normal String grade variable)
    public void updateGradeToString() {
    	if(this.doubleGrade > 100.0) {
    		this.grade = "A+";
    	} else if (this.doubleGrade <= 100.00 && this.doubleGrade >= 93.00) {
    		this.grade = "A";
    	} else if (this.doubleGrade < 93.00 && this.doubleGrade >= 90.00) {
    		this.grade = "A-";
    	} else if (this.doubleGrade < 90.00 && this.doubleGrade >= 87.00) {
    		this.grade = "B+";
    	} else if (this.doubleGrade < 87.00 && this.doubleGrade >= 83.00) {
    		this.grade = "B";
    	} else if (this.doubleGrade < 83.00 && this.doubleGrade >= 80.00) {
    		this.grade = "B-";
    	} else if (this.doubleGrade < 80.00 && this.doubleGrade >= 77.00) {
    		this.grade = "C+";
    	} else if (this.doubleGrade < 77.00 && this.doubleGrade >= 73.00) {
    		this.grade = "C";
    	} else if (this.doubleGrade < 73.00 && this.doubleGrade >= 70.00) {
    		this.grade = "C-";
    	} else if (this.doubleGrade < 70.00 && this.doubleGrade >= 67.00) {
    		this.grade = "D+";
    	} else if (this.doubleGrade < 67.00 && this.doubleGrade >= 63.00) {
    		this.grade = "D";
    	} else if (this.doubleGrade < 63.00 && this.doubleGrade >= 60.00) {
    		this.grade = "D-";
    	} else if (this.doubleGrade < 60.00) { 
    		this.grade = "F";
    	}
    }
    
    
    // print conversion table
    public static void printConversionTable() {
    	System.out.println("--------------------------------");
    	System.out.println(" Automatically Assigned Values:");
    	System.out.println("--------------------------------");
    	System.out.println("A+: 101.00, A: 95.00, A-: 90.00");
    	System.out.println("B+: 89.00,  B: 85.00, B-: 80.00");
    	System.out.println("C+: 79.00,  C: 75.00, C-: 70.00");
    	System.out.println("D+: 69.00,  D: 65.00, D-: 60.00");
    	System.out.println("F:  50.00,  No Match: 0.00");
    	System.out.println("\nIf assigned No Match, the system\nautomatically assigns an F.");
    }
    
    // getters & setters
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCourse() {
        return this.course;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    public String getTeacher() {
        return this.teacher;
    }
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
    public String getGrade() {
        return this.grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public double getDoubleGrade() {
        return this.doubleGrade;
    }
    public void setDoubleGrade(double doubleGrade) {
        this.doubleGrade = doubleGrade;
    }
    public static int getNumStudents() {
    	return numStudents;
    }
    public static void incrementNumStudents() {
        ++numStudents;
    }
    public static void decrementNumStudents() {
        --numStudents;
    }
    
}
