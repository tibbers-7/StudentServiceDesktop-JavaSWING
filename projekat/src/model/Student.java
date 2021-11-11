package model;

import java.util.Date;
import java.util.List;

import enums.StatusEnum;

public class Student {
	private String studentId;
	private String surname;
	private String name;
	private Date birthDate;
	private Address address;
	private Long phoneNumber;
	private String email;
	private String index;
	private int enrollmentYear;
	private int currentStudyYear;
	private StatusEnum status;
	private double averageGrade;
	private List<Grade> passedExam;
	private List<Subject> failedExam;
	
	public Student() {
		super();
	}

	public Student(String studentId, String surname, String name, Date birthDate, Address address, Long phoneNumber,
			String email, String index, int enrollmentYear, int currentStudyYear, StatusEnum status,
			double averageGrade, List<Grade> passedExam, List<Subject> failedExam) {
		super();
		this.studentId = studentId;
		this.surname = surname;
		this.name = name;
		this.birthDate = birthDate;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.index = index;
		this.enrollmentYear = enrollmentYear;
		this.currentStudyYear = currentStudyYear;
		this.status = status;
		this.averageGrade = averageGrade;
		this.passedExam = passedExam;
		this.failedExam = failedExam;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public int getEnrollmentYear() {
		return enrollmentYear;
	}

	public void setEnrollmentYear(int enrollmentYear) {
		this.enrollmentYear = enrollmentYear;
	}

	public int getCurrentStudyYear() {
		return currentStudyYear;
	}

	public void setCurrentStudyYear(int currentStudyYear) {
		this.currentStudyYear = currentStudyYear;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public double getAverageGrade() {
		return averageGrade;
	}

	public void setAverageGrade(double averageGrade) {
		this.averageGrade = averageGrade;
	}

	public List<Grade> getPassedExam() {
		return passedExam;
	}

	public void setPassedExam(List<Grade> passedExam) {
		this.passedExam = passedExam;
	}

	public List<Subject> getFailedExam() {
		return failedExam;
	}

	public void setFailedExam(List<Subject> failedExam) {
		this.failedExam = failedExam;
	}
	
	
	
	
	

}
