package coursesRegistration.driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import coursesRegistration.util.FileProcessor;
import coursesRegistration.inputds.CoursePool;
import coursesRegistration.inputds.Course;
import coursesRegistration.inputds.StudentPool;
import coursesRegistration.inputds.Student;
import coursesRegistration.scheduler.CourseAllocation;
import coursesRegistration.util.Results;

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
		
		CoursePool coursePool = new CoursePool();
		StudentPool studentPool = new StudentPool();
		Results result = new Results();

		coursePool.loadList(courseData);
		studentPool.loadList(studentData);
		
		CourseAllocation allocater = new CourseAllocation(studentPool, coursePool);

		allocater.allocate();
		
		 result.writeToFile(allocater, args[2]);
		 result.writeToStdOut(allocater);
	}
}
