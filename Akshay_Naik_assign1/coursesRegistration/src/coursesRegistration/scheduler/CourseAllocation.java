package coursesRegistration.scheduler;

import coursesRegistration.inputds.Student;
import coursesRegistration.inputds.StudentPool;
import coursesRegistration.inputds.Course;
import coursesRegistration.inputds.CoursePool;
import coursesRegistration.util.FileProcessor;
import java.util.Iterator;
import java.util.List;

public class CourseAllocation{
    private StudentPool students;
    private CoursePool courses;
    private int avgSatisfaction;

    public CourseAllocation(StudentPool studentsIn, CoursePool courseIn){
        this.students = studentsIn;
        this.courses = courseIn;
    }

    public void allocate(){

        Iterator studentItr = students.getStudentList().iterator();
        Student currentStudent;
        String currentStudentPref;
        Iterator coursePrefItr;

        while(studentItr.hasNext()){
            currentStudent = (Student)studentItr.next();
            coursePrefItr = currentStudent.getCoursePreference().iterator();
            while((currentStudent.getCourseSpot() < 3) && coursePrefItr.hasNext()){
                currentStudentPref = (String)coursePrefItr.next();
                Course courseOption = courses.getCourse(currentStudentPref);
                int courseCapacity = courseOption.getCourseCapacity();
                if(courseCapacity>0 && !currentStudent.isTimingClash(courseOption)){
                    currentStudent.addCourse(courseOption);
                    int currentStudPrefSatisfaction = currentStudent.getCourseSatisfaction(currentStudentPref);
                    currentStudent.updateSatisfactionIndex(currentStudPrefSatisfaction);
                    courseOption.setCourseCapacity(courseCapacity - 1);
                }
                else{
                    continue;
                }
            }
        }

        setAvgSatisfaction();
    }

    public void setAvgSatisfaction(){
        int studentCount = 0;
        int netSatisfaction = 0;
        Iterator studentItr = students.getStudentList().iterator();
        Student student = (Student)studentItr.next();

        while(studentItr.hasNext()){
            netSatisfaction = netSatisfaction + student.getSatisfactionIndex();
            studentCount = studentCount + 1;
            student = (Student)studentItr.next();
        }
        avgSatisfaction = netSatisfaction/studentCount;
    }

    public int getAvgSatisfaction(){
        return avgSatisfaction;
    }

    public StudentPool getStudents(){
        return students;
    }
}
