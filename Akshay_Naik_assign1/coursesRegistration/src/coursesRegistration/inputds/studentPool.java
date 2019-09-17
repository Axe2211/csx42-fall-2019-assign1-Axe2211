package coursesRegistration.inputds;

import java.util.ArrayList;

public class studentPool{
    private int studentId;
    private int studentYear;
    private ArrayList<String> coursePreference;

    //constructor
    public studentPool(int studentIdIn, int studentYearIn, ArrayList<String>coursePreferenceIn){
        studentId = studentIdIn;
        studentYear = studentYearIn;
        coursePreference =  coursePreferenceIn;
    }

    //get set methods
    public int getStudentId(){
        return studentId; 
    }

    public int getStudentYear(){
        return studentYear;
    }

    public ArrayList<String> getCoursePreference(){
        return coursePreference;
    }
}