import java.util.Scanner;
import java.io.*;

public class StudentRecord {
    public static void main(String[] args) throws IOException{

        Scanner inFile = new Scanner(new File("classList.txt"));
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter the student's name: ");
        String name = scan.nextLine();

        //by default, found is false
        boolean found = false;

        while(inFile.hasNextLine()){

            String line = inFile.nextLine();
            if(line.contains(name)){
                //found is toggled to true
                found = true;
                displayInfo(line);
            }
        }

        //when found=true, !found=flase, it is skipped
        if(!found){
            System.out.println("No match.");
        }

        inFile.close();
    }

    public static void displayInfo(String line){
        int index1 = line.indexOf(":");
        int index2 = line.lastIndexOf(":");

        String name = line.substring(0, index1);
        String id = line.substring(index1+1, index2);
        String score = line.substring(index2+1);
        
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Final: " + score);
    }
}
