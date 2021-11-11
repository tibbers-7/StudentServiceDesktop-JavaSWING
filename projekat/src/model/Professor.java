package model;

import java.util.Date;
import java.util.List;

public class Professor {
	private String professorId;
	private String surname;
	private String name;
	private Date birthDate;
	private Address address;
	private Long phoneNumber;
	private String email;
	private Address officeAddress;
	private Long personalNumber;
	private String title;
	private int trailYears; // godine staza
	private List<Subject> subjects;
	public Professor() {
		super();
	}
	public Professor(String professorId, String surname, String name, Date birthDate, Address address, Long phoneNumber,
			String email, Address officeAddress, Long personalNumber, String title, int trailYears,
			List<Subject> subjects) {
		super();
		this.professorId = professorId;
		this.surname = surname;
		this.name = name;
		this.birthDate = birthDate;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.officeAddress = officeAddress;
		this.personalNumber = personalNumber;
		this.title = title;
		this.trailYears = trailYears;
		this.subjects = subjects;
	}
	public String getProfessorId() {
		return professorId;
	}
	public void setProfessorId(String professorId) {
		this.professorId = professorId;
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
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	public Long getPersonalNumber() {
		return personalNumber;
	}
	public void setPersonalNumber(Long personalNumber) {
		this.personalNumber = personalNumber;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getTrailYears() {
		return trailYears;
	}
	public void setTrailYears(int trailYears) {
		this.trailYears = trailYears;
	}
	public List<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
	

}