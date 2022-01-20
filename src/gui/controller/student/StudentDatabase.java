package gui.controller.student;

import java.util.ArrayList;

import gui.model.Student;

//*********************************************************************
//*********************************************************************

	//Baza za rukovanje studentima
	// 1.dodavanje
	// 2. trazenje preko id
	// 3. izmena
	// 4. brisanje
	// 5. provera da li id/indeks postoji
	// 6. izmena id kad se obrise student

//*********************************************************************
//*********************************************************************
public class StudentDatabase extends Student {

	private static ArrayList<Object> studenti=new ArrayList<>();
	public static int rowNum=0;

	public static ArrayList<Object> getListOfEntites() {
		return studenti;
	}

	public static void addStudent(Student s) {
		rowNum++;
		s.setStudentId(rowNum);
   	 	studenti.add(s);
	}

	public static void addStudents(ArrayList<Object> studList) {
		for (Object it:studList) {
			Student s=(Student) it;
			addStudent(s);
		}
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
		sNew.setStudentId(id+1);
		studenti.set(id, sNew);
	}

	public static void delStudent(int id) {
		id--;
		Student sCurr=new Student();
		Student sNew=new Student();
		for(int i=id+1;i<studenti.size();i++) {
			int stId=i+1;
			sCurr=findByID(stId);
			sNew=sCurr;
			sNew.setStudentId(sCurr.getStudentId()-1);
			studenti.set(i, sNew);
		}

		studenti.remove(id);
		rowNum--;
	}



	public static boolean idExists(int id) {
		for(Object it:studenti) {
			Student s=(Student) it;
			if (s.getStudentId()==id) {
				return true;
			}
		}
		return false;
	}

	public static boolean indexExists(String index) {
		for(Object it:studenti) {
			Student s=(Student) it;
			if (s.getIndex().equals(index)) {
				return true;
			}
		}
		return false;
	}

	public static void decrementIDs() {
		for (Object o:studenti) {
			Student s=(Student) o;
			int prevId=s.getStudentId();
			s.setStudentId(prevId-1);
		}

	}

}
