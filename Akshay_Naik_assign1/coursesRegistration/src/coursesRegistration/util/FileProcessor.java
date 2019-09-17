package coursesRegistration.util;
import coursesRegistration.inputds.coursePool;
import coursesRegistration.inputds.studentPool;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class FileProcessor {
	private String fileName;
    private File inputFile;
    private Scanner inputFileHandler;

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
            inputFileHandler = new Scanner(inputFile);
        }
        catch(FileNotFoundException ex){
            System.err.println("File Not Found in specified location..");
            System.exit(1);
        }
    }
}