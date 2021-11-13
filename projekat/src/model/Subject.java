package model;

import java.util.List;

import enums.SemesterEnum;

public class Subject {
	private int subjectId;
	private String subjectKey; // slika 8. ovo je sifra predmeta
	private String name;
	private SemesterEnum semester;
	private int year; // Godina studija u kojoj se predmet izvodi
	private Professor professor;
	private int espbPoints;
	private List<Student> studentsPassed;
	private List<Student> studentsNotPassed;
	
	public Subject() {
		super();
	}

	public Subject(int subjectId, String subjectKey, String name, SemesterEnum semester, int year,
			Professor professor, int espbPoints, List<Student> studentsPassed, List<Student> studentsNotPassed) {
		super();
		this.subjectId = subjectId;
		this.subjectKey = subjectKey;
		this.name = name;
		this.semester = semester;
		this.year = year;
		this.professor = professor;
		this.espbPoints = espbPoints;
		this.studentsPassed = studentsPassed;
		this.studentsNotPassed = studentsNotPassed;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectKey() {
		return subjectKey;
	}

	public void setSubjectKey(String subjectKey) {
		this.subjectKey = subjectKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SemesterEnum getSemester() {
		return semester;
	}

	public void setSemester(SemesterEnum semester) {
		this.semester = semester;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public int getEspbPoints() {
		return espbPoints;
	}

	public void setEspbPoints(int espbPoints) {
		this.espbPoints = espbPoints;
	}

	public List<Student> getStudentsPassed() {
		return studentsPassed;
	}

	public void setStudentsPassed(List<Student> studentsPassed) {
		this.studentsPassed = studentsPassed;
	}

	public List<Student> getStudentsNotPassed() {
		return studentsNotPassed;
	}

	public void setStudentsNotPassed(List<Student> studentsNotPassed) {
		this.studentsNotPassed = studentsNotPassed;
	}
	
	
	
	
	

}
