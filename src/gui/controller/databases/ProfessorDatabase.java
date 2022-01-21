package gui.controller.databases;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import gui.model.Professor;

public class ProfessorDatabase extends Professor{
	public static ArrayList<Object> profesori=new ArrayList<>();
	public static int rowNum=0;

	public static ArrayList<Object> getListOfEntities(){
		return profesori;
	}

	public static void addProfessor(Professor p) {
		rowNum++;
		p.setProfessorId(rowNum);
		profesori.add(p);
	}

	public static void addProfessors(ArrayList<Object> profList) {
		for (Object it:profList) {
			Professor p=(Professor) it;
			addProfessor(p);
		}
	}

	public static Professor findByID(int id) {
		for(Object it:profesori) {
			Professor p=(Professor) it;
			if (p.getProfessorId()==id) {
				return p;
			}
		}
		return null;
	}


	public static void changeProfessor(Professor pNew,int id) {
		pNew.setProfessorId(id+1);
		profesori.set(id, pNew);
	}

	public static void delProfessor(int id) {
		id--;
		Professor pCurr=new Professor();
		Professor pNew=new Professor();
		for(int i=id+1;i<profesori.size();i++) {
			int stId=i+1;
			pCurr=findByID(stId);
			pNew=pCurr;
			pNew.setProfessorId(pCurr.getProfessorId()-1);
			profesori.set(i, pNew);
		}

		profesori.remove(id);
		rowNum--;
	}
	
	public static String[] getProfList() {
		String[] profs=new String[profesori.size()];
		String data;
		
		int i=0;
		for(Object o:profesori) {
			Professor p=(Professor) o;
			data=p.getProfForDep();
			profs[i]=data;
			i++;
		}
		
		return profs;
	}
	
	public static Professor getProfRegex(String s) {
		Pattern p = Pattern.compile("^(\\d+).*");
		Matcher m = p.matcher(s);

		if(m.find()) {
			int index=Integer.parseInt(m.group(1));
			Professor prof=ProfessorDatabase.findByID(index);
			return prof;

		} else {
			System.out.printf("Ne radi regex");
			return null;
		}
	}



}
