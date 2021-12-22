package manageEntities.student;

import java.util.ArrayList;

import model.Student;

public class StudentDatabase {
	
	private static ArrayList<Object> studenti=new ArrayList<Object>();
	
	public ArrayList<Object> getListOfEntites() {
		return studenti;
	}
	
	public void addStudent(Student s) {
   	 	studenti.add(s);
	}
	
	

}
