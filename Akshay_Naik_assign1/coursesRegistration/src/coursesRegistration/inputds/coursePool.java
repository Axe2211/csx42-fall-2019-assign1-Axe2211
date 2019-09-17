package coursesRegistration.inputds;

public class coursePool{
   //data members
   private String courseName;
   private int courseCapacity;
   private int classTiming;

   // constructor
   public coursePool(String courseNameIn, int courseCapacityIn, int classTimingIn){
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
}