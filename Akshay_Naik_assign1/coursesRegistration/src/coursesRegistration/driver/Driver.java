package coursesRegistration.driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import coursesRegistration.util.FileProcessor;
import coursesRegistration.inputds.CoursePool;
import coursesRegistration.inputds.StudentPool;

/**
 * @author John Doe
 *
 */
public class Driver {
	public static void main(String[] args) throws Exception {

		/*
		 * As the build.xml specifies the arguments as argX, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */
		if (args.length != 3 || args[0].equals("${arg0}") || args[1].equals("${arg1}") 
		    || args[2].equals("${arg2}")) {

			System.err.println("Error: Incorrect number of arguments. Program accepts 3 arguments.");
			System.exit(0);
		}

		System.out.println("Hello World! Lets get started with the assignment");

		FileProcessor studentData = new FileProcessor(args[0]);
		FileProcessor courseData = new FileProcessor(args[1]);
		String line = null;
		List<CoursePool> coursePool = new ArrayList<>();
		List<StudentPool> studentPool = new ArrayList<>();

		try{
			while((line = studentData.readLine()) != null){
			//	System.out.println(line);
				
				String[] readId = null;
				String[] readYear = null;
				int readYearInt = 0;
				String[] readCPreference = null;
				readId = line.split(" ");
				readYear = readId[1].split("::");
				if(readYear[1].toUpperCase().equals("FIRST_YEAR")){
					readYearInt = 1;
				}
				else if(readYear[1].toUpperCase().equals("SECOND_YEAR")){
					readYearInt = 2;			
				}
				else if(readYear[1].toUpperCase().equals("THIRD_YEAR")){
					readYearInt = 3;		
				}
				else{
					System.err.println("Incorrect Options found in Student Year field in input file: " + args[0]);
				}
				readCPreference = readYear[0].split(",");
				studentPool.add(new StudentPool(Integer.parseInt(readId[0]), readYearInt, readCPreference));		
			}
		}
		catch(NumberFormatException e){
			System.out.println("Formatting Error: " + e);
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Array Index Error: " + e);
		}
		/*
		Iterator studentItr = studentPool.iterator();
		System.out.println("Student List: ");
		while(studentItr.hasNext()){
			StudentPool nextElement = (StudentPool)studentItr.next();
			System.out.println("Student Id: " + nextElement.getStudentId());
			System.out.println("Student Year: " + nextElement.getStudentYear() + "\n");
			for(int cPrefIndex = 0; cPrefIndex < nextElement.getCoursePreference().length; cPrefIndex++){
				System.out.print(" Preference " + cPrefIndex + ": " + nextElement.getCoursePreference()[cPrefIndex]);
			}
			System.out.println();
		}
		*/
		line = null;
		try{
			while((line = courseData.readLine()) != null){
				//System.out.println(line);
				String[] splitSpaceCourse = null;
				String[] splitSColonCapacityTiming = null;
				
				splitSpaceCourse = line.split(" ");
				splitSColonCapacityTiming = splitSpaceCourse[1].split(";");

				String readCourse = splitSpaceCourse[0];
				String readCapacity = splitSColonCapacityTiming[0].split(":")[1];
				String readTiming = splitSColonCapacityTiming[1].split(":")[1];

				coursePool.add(new CoursePool(readCourse, Integer.parseInt(readCapacity), Integer.parseInt(readTiming)));		
			}
		}
		catch(NumberFormatException e){
			System.out.println("Formatting Error: " + e);
		}
		/*
		Iterator courseItr = coursePool.iterator();
		System.out.println("Course List: ");
		while(courseItr.hasNext()){
			CoursePool nextElement = (CoursePool)courseItr.next();
			System.out.println("Course Name: " + nextElement.getCourseName());
			System.out.println("Course Capacity: " + nextElement.getCourseCapacity());
			System.out.print(" Class Timing: "  + nextElement.getClassTimings());
			System.out.println();
		}
		*/
	}
}
