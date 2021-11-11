package model;

import java.util.Date;

public class Grade {
	
	private String gradeId;
	private Student student;
	private Subject subject;
	private int grade;
	private Date examDate;
	
	public Grade() {
		super();
	}

	public Grade(String gradeId, Student student, Subject subject, int grade, Date examDate) {
		super();
		this.gradeId = gradeId;
		this.student = student;
		this.subject = subject;
		this.grade = grade;
		this.examDate = examDate;
	}

	public String getGradeId() {
		return gradeId;
	}

	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}
	
	
	
}
