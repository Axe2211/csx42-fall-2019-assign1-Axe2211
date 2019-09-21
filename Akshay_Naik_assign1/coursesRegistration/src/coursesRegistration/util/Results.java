package coursesRegistration.util;

import coursesRegistration.inputds.StudentPool;
import coursesRegistration.scheduler.CourseAllocation;
import coursesRegistration.inputds.Student;
import java.util.Iterator;
import java.io.PrintWriter;
import java.io.File;


public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	
    public void writeToFile(CourseAllocation allocation, String outputFileName){
 
        Iterator studentItr = allocation.getStudents().getStudentList().iterator();
        Student student;

        try{
            File outputFile = new File(outputFileName);
            outputFile.createNewFile();
            PrintWriter outputFileHandler = new PrintWriter(outputFile);
            while(studentItr.hasNext()){
                    student = (Student)studentItr.next();
                    outputFileHandler.println(new String(student.getStudentId() + 
                                    ": " + student.getAllocatedCourses()[0].getCourseName() +
                                    ", " + student.getAllocatedCourses()[1].getCourseName() +
                                    ", " + student.getAllocatedCourses()[2].getCourseName() +
                                    "::SatisfactionRating=" + student.getSatisfactionIndex()));
            }
            outputFileHandler.println(new String("AverageSatisfactionRating=" + allocation.getAvgSatisfaction()));
            outputFileHandler.close();
        }
        catch(Exception e){
            System.out.println(" Error in writing to file.. ");
        }
    }

    public void writeToStdOut(CourseAllocation allocation){

        Iterator studentItr = allocation.getStudents().getStudentList().iterator();
        Student student;

        try{
            while(studentItr.hasNext()){
                    student = (Student)studentItr.next();
                    System.out.println(new String(student.getStudentId() + 
                                    ": " + student.getAllocatedCourses()[0].getCourseName() +
                                    ", " + student.getAllocatedCourses()[1].getCourseName() +
                                    ", " + student.getAllocatedCourses()[2].getCourseName() +
                                    "::SatisfactionRating=" + student.getSatisfactionIndex()));
            }
            System.out.println(new String("AverageSatisfactionRating=" + allocation.getAvgSatisfaction()));
        }
        catch(Exception e){
            System.out.println(" Error in writing to standard display.. ");
        }
    }
}
 