package coursesRegistration.util;

import coursesRegistration.scheduler.CourseAllocation;
import coursesRegistration.util.FileProcessor;

public interface FileDisplayInterface {

    public void writeToFile(CourseAllocation allocater, String outputFile);
	
}
