package gui.model;

import java.util.List;

import enums.SemesterEnum;
import gui.controller.databases.ProfessorDatabase;

public class Subject {
	private int subjectId;
	private String subjectKey;
	private String name;
	private SemesterEnum semester;
	private int year; // Godina studija u kojoj se predmet izvodi
	private Professor professor;
	private int espbPoints;
	private List<Student> studentsPassed;
	private List<Student> studentsNotPassed;
	protected static int numProfs = 0;

	public Subject() {
		super();
	}

	public Subject(String subjectKey, String name, SemesterEnum semester, int year, int professorId, int espbPoints) {
		super();
		this.subjectKey = subjectKey;
		this.name = name;
		this.semester = semester;
		this.year = year;

		if (professorId == 0) {
			numProfs++;
		} else {
			Professor p = ProfessorDatabase.findByID(professorId);

			this.professor = p;
		}
		this.espbPoints = espbPoints;
	}

	public int getSubjectId() {
		return subjectId;
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

	public String getSemesterString() {
		String s;
		if (semester == SemesterEnum.WINTER) {
			s = "Zimski";
		} else
			s = "Letnji";

		return s;
	}

	
	public static SemesterEnum semFromString(String s) {
		
		SemesterEnum sem;
		if (s.equals("ZIMSKI")) {
			sem=SemesterEnum.WINTER;
		} else
			sem=SemesterEnum.SUMMER;
		
		return sem;
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

	public String subjStringified() {
		String s = name + subjectKey;
		return s;
	}

	public Object[] getColumns() {
		Object[] cols = { "ID", "Šifra", "Naziv", "ESPB", "Godina", "Semestar" };

		return cols;
	}

	public static Object[] getData(Object o) {
		Subject s = (Subject) o;
		String id = Integer.toString(s.getSubjectId());
		String sifra = s.getSubjectKey();
		String espb = Integer.toString(s.espbPoints);
		String year = Integer.toString(s.getYear());
		SemesterEnum sem = s.getSemester();
		String semester = sem.name();
		Object[] rowData = { id, sifra, s.getName(), espb, year, semester };
		return rowData;
	}

}
