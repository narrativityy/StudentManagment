import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class FileHandler {    
    public static final String fileName = "StudentInformation.txt";

    public static ArrayList<Student> printFile() throws FileNotFoundException {
        File file = new File(fileName);
        ArrayList<Student> studentSystem = new ArrayList<Student>();
        Scanner scnr = new Scanner(file);
        while (scnr.hasNext()) {
            studentSystem.add(new Student(scnr.nextInt(), scnr.nextLine() + scnr.nextLine(), scnr.nextLine(), scnr.nextLine(), scnr.nextLine()));
        }
        scnr.close();
        return studentSystem;
    }
    
    public static void clearFile() throws IOException {
        FileWriter fileWrtier = new FileWriter(fileName, false); 
        PrintWriter printWriter = new PrintWriter(fileWrtier, false);
        printWriter.flush();
        printWriter.close();
        fileWrtier.close();
    }

    public static void writeFileLines(ArrayList<Student> studentSystem) throws IOException {
        FileWriter file = new FileWriter(fileName);
        String writer;
        for (int i = 0; i < studentSystem.size(); i++) {
            writer = studentSystem.get(i).getId() + "\n" + studentSystem.get(i).getName() + "\n" + studentSystem.get(i).getCourse() + "\n" + studentSystem.get(i).getTeacher() + "\n" + studentSystem.get(i).getGrade() + "\n";
            file.write(writer);
        }
        file.close();
    }

}
