package manageEntities.subject;

import java.util.ArrayList;

import model.Subject;

public class SubjectDatabase extends Subject{
	
	protected static ArrayList<Object> subjects=new ArrayList<Object>();
		
		public static ArrayList<Object> getListOfEntites() {
			return subjects;
		}
		
		public static void addSubject(Subject s) {
			Subject.rowNum++;
			s.setSubjectId();
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
		
		public static Subject findByKey(String id) {
			for(Object it:subjects) {
				Subject s=(Subject) it;
				if (s.getSubjectKey().equals(id)) {
					return s;
				}
			}
			return null;
		}
		
		public static void changeSubject(Subject sNew,int id) {
			sNew.setSubjectId(id);
			subjects.set(id-1, sNew);
		}
		
		public static void delSubject(int id) {
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
		
		public static Subject findByName(String name) {
			for(Object it:subjects) {
				Subject s=(Subject) it;
				if (s.getName().equals(name)) {
					return s;
				}
			}
			return null;
		}
}
