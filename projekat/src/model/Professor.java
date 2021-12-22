package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tableInterfaces.profTable;
public class Professor implements profTable{
	private int professorId;
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
	
	private ArrayList<Object> professors= new ArrayList<Object>();
	
	public Professor() {
		super();
	}
	public Professor(int professorId, String surname, String name, Date birthDate, Address address, Long phoneNumber,
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
	public int getProfessorId() {
		return professorId;
	}
	public void setProfessorId(int professorId) {
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
	
	
	
	
	public Object[] getData(Object o) {
		
		Object[] rowData= {this.getName(),this.getSurname(),this.getTitle(),this.getEmail()};
		return rowData;
	}
	@Override
	public Object[] getColumns() {

		Object[] cols= {"Ime", "Prezime", "Zvanje", "E-mail"};
		return cols;
	}
	@Override
	public boolean addEntity(Professor p) {
		try {
			professors.add(p);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public ArrayList<Object> getListOfEntites() {
		return professors;
	}

	

}
