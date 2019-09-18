package coursesRegistration.inputds;

public class CoursePool{
   //data members
   private String courseName;
   private int courseCapacity;
   private int classTiming;

   // constructor
   public CoursePool(String courseNameIn, int courseCapacityIn, int classTimingIn){
       courseName = courseNameIn;
       courseCapacity = courseCapacityIn;
       classTiming = classTimingIn;
   }

   //get set methods
   public String getCourseName(){
       return courseName;
   };

   public int getCourseCapacity(){
       return courseCapacity;
   };

   public int getClassTimings(){
       return classTiming;
   };

   public void setCourseName(String courseNameIn){
       courseName = courseNameIn;
   }

   public void setCourseCapacity(int courseCapacityIn){
       courseCapacity = courseCapacityIn;
   };

   public void setClassTimings(int classTimingIn){
       classTiming = classTimingIn;
   };
}