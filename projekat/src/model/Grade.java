package model;

import java.util.Date;

public class Grade {
	
	private int gradeId;
	private Student student;
	private Subject subject;
	private int grade;
	private Date examDate;
	
	public Grade() {
		super();
	}

	public Grade(int gradeId, Student student, Subject subject, int grade, Date examDate) {
		super();
		this.gradeId = gradeId;
		this.student = student;
		this.subject = subject;
		this.grade = grade;
		this.examDate = examDate;
	}

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
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
		if(grade>=6 && grade<=10) {
			this.grade = grade;
		}
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}
	
	
	
}
