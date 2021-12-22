package manageEntities.subject;

import java.util.ArrayList;

import model.Student;
import model.Subject;

public class SubjectDatabase extends Subject{
	private static ArrayList<Object> subjects=new ArrayList<Object>();
		
		public static ArrayList<Object> getListOfEntites() {
			return subjects;
		}
		
		public static void addSubject(Subject s) {
			Subject.rowNum++;
			s.setSubjectId(rowNum);
	   	 	subjects.add(s);
		}
		
		public static Subject findByID(int id) {
			for(Object it:subjects) {
				Subject s=(Subject) it;
				if (s.getSubjectId()==id) {
					return s;
				}
			}
			return null;
		}
		
		public static void changeStudent(Student sNew,int id) {
			sNew.setStudentId(id);
			subjects.set(id-1, sNew);
		}
		
		public static void delStudent(int id) {
			id--;
			Subject sCurr=new Subject();
			Subject sNew=new Subject();
			for(int i=id+1;i<subjects.size();i++) {
				int stId=i+1;
				sCurr=findByID(stId);
				sNew=sCurr;
				sNew.setSubjectId(sCurr.getSubjectId()-1);
				subjects.set(i, sNew);
			}
			subjects.remove(id);
			Subject.rowNum--;
		}
}
