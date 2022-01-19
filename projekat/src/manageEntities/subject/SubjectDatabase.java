package manageEntities.subject;

import java.util.ArrayList;

import model.Professor;
import model.Subject;

public class SubjectDatabase extends Subject{

	private static ArrayList<Object> subjects=new ArrayList<>();
	public static int rowNum=0;
	static Object[][] profSubjList;
	private static ArrayList<Subject> subjWProf=new ArrayList<>();


		public static ArrayList<Object> getListOfEntites() {
			return subjects;
		}

		public static void addSubject(Subject s) {
			rowNum++;
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

		public static void printSubjects() {
			if (subjects==null) {
				System.out.printf("\nPrazna je baza\n");
			} else {
//				System.out.printf("\n*************************************\n");
				System.out.printf("\nNije prazna\n");
//				for (Object o:subjects) {
//					Subject s=(Subject) o;
//					System.out.printf("\n"+s.getSubjectKey());
//				}
//				System.out.printf("\n*************************************\n");
			}
		}

		//NE RADI iz nepoznatih razloga al samo u dijalogu, u mejnu oce
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


		public static Subject findByName(String name) {
			for(Object it:subjects) {
				Subject s=(Subject) it;
				if (s.getName().equals(name)) {
					return s;
				}
			}
			return null;
		}

		public static void addSubjects(ArrayList<Object> subjList) {
			for (Object it:subjList) {
				Subject s=(Subject) it;
				addSubject(s);
			}
		}

		public static void initList() {
			int i=0;
			for (Object o:subjects) {
				Subject subj=(Subject) o;
				if (subj.getProfessor()!=null) {
					subjWProf.add(subj);
				}
			}
//			profSubjList=new String[subjWProf.size()][2];
			for (Subject s:subjWProf) {
				Professor p=s.getProfessor();
//				profSubjList[i][0]=s;
//				profSubjList[i][1]=p;
				p.addSubject(s);
				i++;
			}
		}

}
