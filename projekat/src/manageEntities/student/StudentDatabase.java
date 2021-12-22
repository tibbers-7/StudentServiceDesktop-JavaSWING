package manageEntities.student;

import java.util.ArrayList;

import model.Student;

public class StudentDatabase extends Student{
	
	private static ArrayList<Object> studenti=new ArrayList<Object>();
	
	public ArrayList<Object> getListOfEntites() {
		return studenti;
	}
	
	public void addStudent(Student s) {
		Student.rowNum++;
   	 	studenti.add(s);
	}
	
	public static Student findByID(int id) {
		
		for(Object it:studenti) {
			Student s=(Student) it;
			if (s.getStudentId()==id) {
				return s;
			}
		}
		return null;
	}
	
	public void changeStudent(Student sNew,int id) {
		Student sOld=findByID(id);
		sOld=sNew;
		studenti.set(id-1, sNew);
	}

}
