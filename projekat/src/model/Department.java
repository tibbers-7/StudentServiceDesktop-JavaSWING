package model;

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
	public Department(int departmentId, String departmentKey, String name, Professor departmentManager,
			List<Professor> departmentProfessors) {
		super();
		this.departmentId = departmentId;
		this.departmentKey = departmentKey;
		this.name = name;
		this.departmentManager = departmentManager;
		this.departmentProfessors = departmentProfessors;
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



}
