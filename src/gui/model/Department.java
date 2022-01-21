package gui.model;

import java.util.List;

public class Department {
	private int departmentId;
	private String departmentKey; //sifra katedre
	private String name;
	private Professor departmentManager; // sef katedre
	private List<Professor> departmentProfessors;
	public Department() {
		super();
	}
	public Department(String departmentKey, String name, Professor departmentManager) {
		super();
		this.departmentKey = departmentKey;
		this.name = name;
		
		this.departmentManager = departmentManager;
		departmentManager.setDep(this);
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentKey() {
		return departmentKey;
	}
	public void setDepartmentKey(String departmentKey) {
		this.departmentKey = departmentKey;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Professor getDepartmentManager() {
		return departmentManager;
	}
	public void setDepartmentManager(Professor departmentManager) {
		this.departmentManager = departmentManager;
	}
	public List<Professor> getDepartmentProfessors() {
		return departmentProfessors;
	}
	public void setDepartmentProfessors(List<Professor> departmentProfessors) {
		this.departmentProfessors = departmentProfessors;
	}

	public static Object[] getData(Object o) {
		Department d=(Department) o;
		Object index=Integer.toString(d.getDepartmentId());
		Object managerName=d.getDepartmentManager().getProfForDep();
		
		Object[] rowData= {index,d.getDepartmentKey(),d.getName(),managerName};
		return rowData;
	}

	public Object[] getColumns() {

		Object[] colNames={"ID", "Šifra", "Ime", "Menadžer"};
		return colNames;
	}

}
