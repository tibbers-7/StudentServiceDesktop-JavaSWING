package manageEntities.student;

import java.util.ArrayList;

import model.Student;

public class StudentDatabase extends Student{
	
	private static ArrayList<Object> studenti=new ArrayList<Object>();
	
	public static ArrayList<Object> getListOfEntites() {
		return studenti;
	}
	
	public static void addStudent(Student s) {
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
	
	public static void changeStudent(Student sNew,int id) {
		
		sNew.setStudentId(id);
		studenti.set(id-1, sNew);
	}
	
	public static void delStudent(int id) {
		studenti.remove(id);
	}

}
