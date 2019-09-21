package coursesRegistration.inputds;

import coursesRegistration.inputds.Course;
import coursesRegistration.inputds.Pool;
import coursesRegistration.util.FileProcessor;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.lang.Iterable;

public class CoursePool implements Pool{
    private List<Course> courseList;

	//constructor
    public CoursePool(){
        this.courseList = new ArrayList<Course>();
    }

    //method to load data into studentList
    public void loadList(FileProcessor file){
        String line = null;
        String[] splitSpaceCourse = null;
		String[] splitSColonCapacityTiming = null;
        try{
			while((line = file.readLine()) != null){
				//System.out.println(line);
                splitSpaceCourse = line.split(" ");
				splitSColonCapacityTiming = splitSpaceCourse[1].split(";");

				String readCourse = splitSpaceCourse[0];
				String readCapacity = splitSColonCapacityTiming[0].split(":")[1];
				String readTiming = splitSColonCapacityTiming[1].split(":")[1];

				courseList.add(new Course(readCourse, Integer.parseInt(readCapacity), Integer.parseInt(readTiming)));		
			}
		}
		catch(NumberFormatException e){
			System.out.println("Formatting Error: " + e);
		}
        catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Array Index Error: " + e + "\n Please remove lines without any data lines without data from the input file..");
		}
    }

	public List<Course> getCourseList(){
		return courseList;
	}

	public Course getCourse(String courseIn){
		Iterator courseItr = courseList.iterator();
        Course currentCourse = (Course)courseItr.next();
        while(!courseIn.equals(currentCourse.getCourseName())){
            currentCourse = (Course)courseItr.next();
            continue;
        }
		return currentCourse;
	}
}
