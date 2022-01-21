package gui.controller.databases;

import java.util.ArrayList;

import gui.model.Professor;
import gui.model.Subject;

public class SubjectDatabase extends Subject{

	private static ArrayList<Object> subjects=new ArrayList<>();
	public static int rowNum=0;
	static Object[][] profSubjList;
	public static ArrayList<Subject> subjWProf=new ArrayList<>();


		public static ArrayList<Object> getListOfEntites() {
			return subjects;
		}

		public static void addSubject(Subject s) {
			rowNum++;
			s.setSubjectId(rowNum);
	   	 	subjects.add(s);
	   	 	
	   	 	if(s.getProfessorId()!=0) {
	   	 		Database.id_subj.add(rowNum);
	   	 		Database.id_prof.add(s.getProfessorId());
	   	 	}
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

		
		public static void assignSubjects(Professor p) {
			ArrayList<Integer> subjList=Database.id_subj;
			ArrayList<Integer> profList=Database.id_prof;
			int subjIndex;
			int profIndex;
			for(int i=0;i<subjList.size();i++) {
				subjIndex=subjList.get(i);
				profIndex=profList.get(i);
				if(p.getProfessorId()==profIndex) {
					p.addSubject(SubjectDatabase.findByID(subjIndex));
				}
			}
			
			
		}

}
