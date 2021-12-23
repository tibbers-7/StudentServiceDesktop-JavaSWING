package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import enums.StatusEnum;

public class Student{
	private int studentId;
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
	private List<Grade> passedExams;
	private List<Grade> failedExams;
	
	protected static int rowNum=0;
	
	public Student() {
		super();
		
	}
	
	public Student(int studentId, String surname, String name, Date birthDate, Address address, Long phoneNumber,
			String email, String index, int enrollmentYear, int currentStudyYear, StatusEnum status) {
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
		
	}

	public Student(int studentId, String surname, String name, Date birthDate, Address address, Long phoneNumber,
			String email, String index, int enrollmentYear, int currentStudyYear, StatusEnum status,
			double averageGrade, List<Grade> passedExams, List<Grade> failedExams) {
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
		this.passedExams = passedExams;
		this.failedExams = failedExams;
		
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId() {
		this.studentId = rowNum;
	}
	
	public void setStudentId(int id) {
		this.studentId = id;
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

	public List<Grade> getPassedExams() {
		return passedExams;
	}

	public void setPassedExams(List<Grade> passedExams) {
		this.passedExams = passedExams;
	}

	public List<Grade> getFailedExams() {
		return failedExams;
	}

	public void setFailedExams(List<Grade> failedExams) {
		this.failedExams = failedExams;
	}

	
	public static Object[] getData(Object o) {
		
		Student s= (Student) o;
		Object index=s.getIndex();
		Object currStudyYear=Integer.toString(s.getCurrentStudyYear());
		Object status= s.getStatus().name();
		Object avgGrade=Double.toString(s.getAverageGrade());
		Object sID=Integer.toString(s.getStudentId());
		
		
		Object[] rowData={sID,index,s.getName(), s.getSurname(), currStudyYear,status,avgGrade};
		return rowData;
	}

	//nazivi kolona
	public Object[] getColumns() {

//		Indeks studentId
//		Ime name
//		Prezime surname
//		Godina studija currentStudyYear
//		Status status
//		Prosek averageGrade

		Object[] colNames={"StID", "Indeks", "Ime", "Prezime", "Godina Studija", "Status","Prosek"};
		return colNames;
	}


	public static Date formatDate(String s) {
		 SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
		 try {
			Date d = formatter.parse(s);
			return d;
		} catch (ParseException e) {
			
			e.printStackTrace();
			return null;
		}
		 
	}




	
	
	
	
	

}
