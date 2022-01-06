package model;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import enums.StatusEnum;
import manageEntities.student.StudentDialog;
import manageEntities.subject.SubjectDatabase;

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
	private ArrayList<Grade> passedExams=new ArrayList<Grade>();
	private ArrayList<Grade> failedExams=new ArrayList<Grade>();
	
	protected int passedGradeID=1;
	protected static int rowNum=0;
	private static final SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
	 private static final DecimalFormat df = new DecimalFormat("0.00");
	
	public Student() {
		super();
		
	}
	
	public Student(String surname, String name, Date birthDate, Address address, Long phoneNumber,
			String email, String index, int enrollmentYear, int currentStudyYear, StatusEnum status) {
		super();
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

	public Student( String surname, String name, Date birthDate, Address address, Long phoneNumber,
			String email, String index, int enrollmentYear, int currentStudyYear, StatusEnum status,
			double averageGrade, ArrayList<Grade> passedExams, ArrayList<Grade> failedExams) {
		super();
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

	public ArrayList<Grade> getPassedExams() {
		return passedExams;
	}

	public void setPassedExams(ArrayList<Grade> passedExams) {
		this.passedExams = passedExams;
	}

	public ArrayList<Grade> getFailedExams() {
		return failedExams;
	}

	public void setFailedExams(ArrayList<Grade> failedExams) {
		this.failedExams = failedExams;
	}
	
	public void addPassedExam(Grade g) {
		passedGradeID++;
		this.passedExams.add(g);
		
	}
	
	public void addFailedExam(Grade g) {
		
		this.failedExams.add(g);
		
	}
	
	
	public String getAverage() {
		float cnt=0;
		float sum=0;
		for (Grade g: this.passedExams) {
			cnt++;
			sum+=g.getGrade();
		}
		String res=df.format(sum/cnt);
		return res;
	}
	
	public int getEspb() {
		int sum=0;
		for (Grade g: this.passedExams) {
			Subject subj=g.getSubject();
			int espb=subj.getEspbPoints();
			sum+=espb;
		}
		return sum;
	}
	
	public void removePassedExam(Grade g) {
		passedGradeID--;
		Grade gCurr=new Grade();
		Grade gNew=new Grade();
		for(int i=passedGradeID+1;i<this.passedExams.size();i++) {
			int gId=i+1;
			gCurr=findGradeByID(g.getGradeId());
			gNew=gCurr;
			gNew.setGradeId(gCurr.getGradeId()-1);
			this.passedExams.set(i, gNew);
		}
		this.passedExams.remove(g);
		
	}
	
	public Grade findGradeByID(int id) {
		for (Grade g: this.passedExams) {
			if (g.getGradeId()==id) {
				return g;
			}
		}
		return null;
	}
	
	public String[] getUnaffiliatedSubj() {
		
		//Pravim listu svih asociranih predmeta
		ArrayList<Object> subjects=SubjectDatabase.getListOfEntites();
		ArrayList<Object> subjectsNew=subjects;
		ArrayList<Grade> grades=new ArrayList<Grade>(failedExams);
		grades.addAll(passedExams);
		
		int size=subjects.size()-grades.size();
		String[] res=new String[size];
		
		//Cistim listu od asociranih predmeta
		for(Iterator<Object> itr = subjects.iterator();
                itr.hasNext();){   
			
			Subject s=(Subject) itr.next();
		
			for (Grade g: grades) {
				Subject s1=g.getSubject();
				if (s1.getSubjectKey()==s.getSubjectKey()) {
					itr.remove();
				}
				
			}
		}
		
		//Stavljanje u string
		int i=0;
		for (Object o: subjects) {
			Subject s=(Subject) o;
			String currSubj=s.getSubjectKey()+"-"+s.getName();
			res[i]=currSubj;
			i++;
		}
		
		
		
		return res;
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

		Object[] colNames={"StID", "Indeks", "Ime", "Prezime", "Godina Studija", "Status","Prosek"};
		return colNames;
	}


	public static Date formatDate(String s) {
		 
		 try {
			Date d = formatter.parse(s);
			return d;
		} catch (ParseException e) {
			
			e.printStackTrace();
			return null;
		}
		 
	}
	
	public static JTable getPassedExams(Object o) {
		Student s=(Student) o;
		Object[] cols={"Sifra", "Naziv", "ESPB", "Ocena", "Datum"};
		Object[][] rowData=new Object[s.getPassedExams().size()][5];
		
		
		
		int i=0;
		for (Grade g: s.getPassedExams()) {
			Subject subj=g.getSubject();
			rowData[i][0]=subj.getSubjectKey();
			rowData[i][1]=g.getSubject().getName();
			
			rowData[i][2]=Integer.toString(subj.getEspbPoints());
			rowData[i][3]=Integer.toString(g.getGrade());
			rowData[i][4]=formatter.format(g.getExamDate());
			i++;
		}
		
		StudentDialog.dtm=new DefaultTableModel(rowData,cols);
		JTable table=new JTable(StudentDialog.dtm);
		return table;
	}
	
	public static JTable getFailedExams(Object o) {
		Student s=(Student) o;
		Object[] cols={"Sifra", "Naziv", "ESPB","Semestar"};
		Object[][] rowData=new Object[s.getFailedExams().size()][4];
		
		int i=0;
		for (Grade g: s.getFailedExams()) {
			Subject subj=g.getSubject();
			rowData[i][0]=subj.getSubjectKey();
			rowData[i][1]=g.getSubject().getName();
			
			rowData[i][2]=Integer.toString(subj.getEspbPoints());
			rowData[i][3]=subj.getSemester();
			i++;
		}
		
		StudentDialog.dtm2=new DefaultTableModel(rowData,cols);
		JTable table=new JTable(StudentDialog.dtm2);
		return table;
	}
	
	
	




	
	
	
	
	

}
