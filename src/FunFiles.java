import java.io.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

public class FunFiles {

    String myFilesName = "test.txt";

    public FunFiles(){

        //findFiles();

        createFile();

        writeToFile();

        fileReader();
    }

    public void findFiles(){

        File myPath = new File("C:\\Users\\ganerud.max\\IdeaProjects\\File");

        String[] allFiles = myPath.list();

        for(String fileNames : allFiles){

            System.out.println(fileNames);

        }

    }
     /*
     * Skapa ny fil
      */
    public void createFile(){

        File myFile = new File("test.txt");

        try {

            boolean success = myFile.createNewFile();

            if (!success) {

                System.out.printf("Din mamma fanns redan");

            }

        }

        catch(IOException e){

            System.out.println("L");

            e.printStackTrace();

        }

    }

    /*
    * Write data to file
     */

    public void writeToFile(){

        try{

            FileWriter myWriter = new FileWriter(myFilesName);

            myWriter.write("This text file belongs to me.");

            myWriter.close();

            System.out.println("Succses.");

        }
        catch(IOException a){

            System.out.println("Nah brooo u can't doo that!");

            a.printStackTrace();

        }

    }

    public void fileReader(){

        File myFile = new File(myFilesName);

        try{

            Scanner myScan = new Scanner(myFile);

            String data = myScan.next();

            System.out.println(data);

        }catch(IOException b){

            System.out.println("Nada fr fr nocap.");

            b.printStackTrace();
        }

        //while(myReader.hasNextLine()){}

    }

}
