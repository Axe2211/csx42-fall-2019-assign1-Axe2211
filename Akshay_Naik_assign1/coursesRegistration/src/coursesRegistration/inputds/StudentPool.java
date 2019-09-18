package coursesRegistration.inputds;

public class StudentPool{
    private int studentId;
    private int studentYear;
    private String[] coursePreference;

    //constructor
    public StudentPool(int studentIdIn, int studentYearIn, String[] coursePreferenceIn){
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

    public String[] getCoursePreference(){
        return coursePreference;
    }

    public void setStudentId(int studentIdIn){
        studentId = studentIdIn;
    }

    public void setStudentYear(int studentYearIn){
        studentYear = studentYearIn;
    }

    public void setCoursePreference(String[] coursePreferenceIn){
        coursePreference = coursePreferenceIn;
    }


    
}