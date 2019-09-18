package coursesRegistration.util;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class FileProcessor {
	private String fileName;
    private File inputFile;
    private Scanner inputFileHandler;
    private PrintWriter outputFileHandler;

    //constructor
    public FileProcessor(String fileNameIn){

        if(fileNameIn == null){
            System.err.println("Error: File Name is Null..");
            System.exit(1);
        }
        else{
            fileName = fileNameIn;
        }
        try{
            inputFile = new File(fileName);
            //outputFileHandler = new PrintWriter(inputFile);
            inputFileHandler = new Scanner(inputFile);
        }
        catch(FileNotFoundException ex){
            System.err.println("File Not Found in specified location..");
            System.exit(0);
        }

    }

    public String readLine(){
        String currentLine = null;

        try{
            if(inputFileHandler.hasNextLine()){
                currentLine = inputFileHandler.nextLine();
                return currentLine;
            }
        }
        catch(Exception e){
            System.err.println("Error: Unable to read next line.. ");
            System.exit(0);
        }
        currentLine = null;
        return currentLine;
    }
}