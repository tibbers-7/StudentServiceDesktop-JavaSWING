package model;

import java.util.ArrayList;
import java.util.List;

import enums.SemesterEnum;

public class Subject{
	private int subjectId;
	private String subjectKey; // slika 8. ovo je sifra predmeta
	private String name;
	private SemesterEnum semester;
	private int year; // Godina studija u kojoj se predmet izvodi
	private Professor professor;
	private int espbPoints;
	private List<Student> studentsPassed;
	private List<Student> studentsNotPassed;
	
	protected static int rowNum=0;

	
	private ArrayList<Object> subjects= new ArrayList<Object>();

	
	public Subject() {
		super();
	}

	public Subject(String subjectKey, String name, SemesterEnum semester, int year,
			Professor professor, int espbPoints) {
		super();
		this.subjectKey = subjectKey;
		this.name = name;
		this.semester = semester;
		this.year = year;
		this.professor = professor;
		this.espbPoints = espbPoints;
//		this.studentsPassed = studentsPassed;
//		this.studentsNotPassed = studentsNotPassed;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId() {
		this.subjectId = rowNum;
	}
	
	public void setSubjectId(int id) {
		this.subjectId = id;
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



	public Object[] getColumns() {
//		�ifra predmeta subjectKey
//		Naziv predmeta name
//		Broj ESPB bodova espbPoints
//		Godina na kojoj se predmet izvodi year
//		Semestar u kome se predmet izvodi semester
		Object[] cols= {"ID","Sifra","Naziv","ESPB","Godina","Semestar"};

		return cols;
	}

	public static Object[] getData(Object o) {
		Subject s=(Subject) o;
		String id=Integer.toString(s.getSubjectId());
		String sifra=s.getSubjectKey();
		String espb=Integer.toString(s.espbPoints);
		String year=Integer.toString(s.getYear());
		SemesterEnum sem=s.getSemester();
		String semester=sem.name();
		Object[] rowData= {id,sifra,s.getName(),espb,year,semester};
		return rowData;
	}

	public boolean addEntity(Subject s) {
		try {
			subjects.add(s);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	



	
	
	
	
	

}
