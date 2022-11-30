public class Student {
    public int id;
    public String name;
    public String course;
    public String teacher;
    public String grade;
    public static int numStudents;


    // constructor
    public Student(int id, String name, String course, String teacher, String grade) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.teacher = teacher;
        this.grade = grade;
        Student.incrementNumStudents();
    }
    
    // print student info
    public void printStudent() {
    	System.out.println("Name: " + name);
    	System.out.println("ID: " + id);
    	System.out.println("Course: " + course);
    	System.out.println("Teacher: " + teacher);
    	System.out.println("Grade: " + grade);
        System.out.println();
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
