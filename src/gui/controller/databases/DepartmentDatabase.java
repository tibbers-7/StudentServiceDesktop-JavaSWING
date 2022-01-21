package gui.controller.databases;
import java.util.ArrayList;

import gui.model.Department;

public class DepartmentDatabase extends Department{

	public static ArrayList<Object> katedre=new ArrayList<>();
	public static int rowNum=0;

	public static ArrayList<Object> getListOfEntities(){
		return katedre;
	}


	public static Department findByID(int id) {
		for(Object it:katedre) {
			Department d=(Department) it;
			if (d.getDepartmentId()==id) {
				return d;
			}
		}
		return null;
	}
	
	
	public static void addDepartment(Department d) {
		rowNum++;
		d.setDepartmentId(rowNum);
		katedre.add(d);
	}
	
	public static void addDepartments(ArrayList<Object> depList) {
		for (Object it:depList) {
			Department d=(Department) it;
			addDepartment(d);
		}
	}
};
