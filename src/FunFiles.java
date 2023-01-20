import java.io.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

public class FunFiles {

    //String myFileName = "C:\\Users\\ganerud.max\\IdeaProjects\\Program Lektion 06122022\\src\\words.txt";
    String myFileName = "C:\\Users\\ganerud.max\\IdeaProjects\\Program Lektion 06122022\\src\\svenska-ord.txt";

    String myFileSortOutput = "C:\\Users\\ganerud.max\\IdeaProjects\\Program Lektion 06122022\\src\\SortOutput.txt";

    public FunFiles(){

        findFiles();
        createFile();
        writeToFile();
        readFile();
        NameList();
        sortFile();
        findLongestWord();

    }

    public void findFiles(){

        File myPath = new File("C:\\Users\\ganerud.max\\IdeaProjects\\File");

        String[] allFiles = myPath.list();

        for(String fileNames : allFiles){

            System.out.println(fileNames);

        }

    }

    public void createFile(){

        File myFile = new File(myFileName);

        try {

            boolean success = myFile.createNewFile();

            if (!success) {

                System.out.printf("Din mamma fanns redan");

            }

        }

        catch(IOException e){

            System.out.println("An Error Occurred");

            e.printStackTrace();

        }

    }

    /*
    * Write data to file
     */

    public void writeToFile(){

        try{

            FileWriter myWriter = new FileWriter(myFileName);

            myWriter.write("Filip är Nörd");

            myWriter.close();

            System.out.println("Success");

        }
        catch (IOException a){

            System.out.println("Nah brooo u can't doo that!");

            a.printStackTrace();

        }

    }

    public void readFile(){

        File myFile = new File(myFileName);

        try{

            Scanner myScan = new Scanner(myFile);

            while (myScan.hasNextLine()) {

                String data = myScan.nextLine();

                System.out.println(data);

                myScan.close();
            }


        }catch(IOException b){

            System.out.println("Nada fr fr nocap.");

            b.printStackTrace();
        }

    }

    public void NameList(){

        try{

            BufferedWriter myScan = new BufferedWriter(
                    new FileWriter("C:\\Users\\ganerud.max\\Desktop\\Output\\Outputtext.txt"));

            myScan.write("Timmy\n");
            myScan.write("Daniella\n");
            myScan.write("Fredrick");
            myScan.close();

        }catch(IOException e){

            e.printStackTrace();

        }
    }

    public void sortFile(){

        try{
            BufferedReader br = new BufferedReader(new FileReader("myFileName"));

            ArrayList<String> lines = new ArrayList<String>();

            String currentLine = br.readLine();

            while (currentLine != null)
            {
                lines.add(currentLine);
                currentLine = br.readLine();
            }

            Collections.sort(lines);

            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("myFileSortOutput"));

            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }

        }catch (IOException f) {

        }


    }

    public String findLongestWord()
    {

        String longestWord = "";
        String current;

        try {

            Scanner newScanner = new Scanner("words.txt");

            // Så länge som den kan så ska den jämnföra dembåda orden

            while (newScanner.hasNext()) {

                current = newScanner.next();

                if (current.length() > longestWord.length()) {
                    longestWord = current;
                }

            }

            System.out.println("\n"+longestWord+"\n");

        }
        catch (Exception e){

            System.out.println("Det blev fel");

        }

        return longestWord;

    }

}


