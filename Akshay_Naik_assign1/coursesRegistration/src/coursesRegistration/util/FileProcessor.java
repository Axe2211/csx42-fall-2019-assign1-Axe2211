package coursesRegistration.util;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;


public class FileProcessor {
	private String fileName;
    private File file;
    private Scanner inputFileHandler;
    
    //constructor
    public FileProcessor(String fileNameIn){

        if(fileNameIn == null){
            System.err.println("Error: File Name is Null..");
            System.exit(1);
        }
        else{
            this.fileName = fileNameIn;
        }
        //input mode
        
        try{
            this.file = new File(this.fileName);
            //outputFileHandler = new PrintWriter(File);
            this.inputFileHandler = new Scanner(this.file);
        }
        catch(FileNotFoundException ex){
            System.err.println("File Not Found in specified location..");
            System.exit(1);
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

    public void closeInFile(){
        inputFileHandler.close();
    }
}