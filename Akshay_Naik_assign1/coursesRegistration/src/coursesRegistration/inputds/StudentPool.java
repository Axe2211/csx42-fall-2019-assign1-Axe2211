package coursesRegistration.inputds;

import coursesRegistration.inputds.Student;
import coursesRegistration.inputds.Pool;
import coursesRegistration.util.FileProcessor;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class StudentPool implements Pool{
    private List<Student> studentList;
	
    //constructor
    public StudentPool(){
        this.studentList = new ArrayList<Student>();
    }

    //method to load data into studentList
    public void loadList(FileProcessor file){
        String line = null;
        String[] readId = null;
		String[] readYear = null;
		int readYearInt = 0;
        ArrayList<String> readCPreference = null;
        try{
			while((line = file.readLine()) != null){
			//	System.out.println(line);
				
				readId = null;
				readYear = null;
				readYearInt = 0;
				readCPreference = null;
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
					System.err.println("Incorrect Options found in Student Year field in input file ");
				}
				readCPreference = new ArrayList<String>(Arrays.asList(readYear[0].split(",")));
				studentList.add(new Student(Integer.parseInt(readId[0]), readYearInt, readCPreference));		
			}
		}
		catch(NumberFormatException e){
			System.out.println("Formatting Error: " + e);
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Array Index Error: " + e + "\n Please remove lines without any data lines without data from the input file..");
		}

		Collections.sort(studentList, Collections.reverseOrder((student1, student2)-> {
			return Integer.compare(student1.getStudentYear(),student2.getStudentYear());
		}));
    }

	public List<Student> getStudentList(){
		return studentList;
	}

}