package gui.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import enums.StatusEnum;
import gui.controller.CheckValidity;
import gui.controller.databases.AddressDatabase;
import gui.controller.databases.StudentDatabase;
import gui.controller.databases.SubjectDatabase;
import gui.controller.student.StudentDialog;

public class Student{
	protected int studentId;
	private String surname;
	private String name;
	private Date birthDate;
	private Address address;
	private String phoneNumber;
	private String email;
	private String index;
	private int enrollmentYear;
	private int currentStudyYear;
	private StatusEnum status;
	private double averageGrade;
	private ArrayList<Grade> passedExams=new ArrayList<>();
	private ArrayList<Grade> failedExams=new ArrayList<>();

	protected int passedGradeID=1;

	public Student() {
		super();

	}

	public Student(String surname, String name, Date birthDate, Address address, String phoneNumber,
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

	public Student( String surname, String name, Date birthDate, Address address, String phoneNumber,
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


	public void addPassedExam(Grade g) {
		passedGradeID++;
		this.passedExams.add(g);

	}

	public void addFailedExam(Grade g) {
		passedGradeID--;
		this.failedExams.add(g);

	}

	// Ukupno ESPB
	public int getEspb() {
		int sum=0;
		int i=1;
		for (Grade g: this.passedExams) {
			Subject subj=g.getSubject();
			int espb=subj.getEspbPoints();
			sum+=espb;
//			System.out.printf("\nIndex:"+i+" espb:"+espb+" ocena:"+g.getGrade()+" avg="+averageGrade);
			i++;
		}
		return sum;
	}

	// Izbrisi ispit iz polozenih
	public void removePassedExam(Subject subj) {
		Grade g1 = null;
		for (Grade g: passedExams) {
			if(g.getSubject()==subj) {
				g1=g;
			}
		}
		passedExams.remove(g1);

	}

	// Izbrisi ispit iz nepolozenih
	public void removeFailedGrade(Subject subj) {
		Grade g1 = null;
		for (Grade g: failedExams) {
			if(g.getSubject()==subj) {
				g1=g;
			}
		} failedExams.remove(g1);
	}




	// Nadji ocenu
	public Grade findGradeByID(int id) {
		for (Grade g: this.passedExams) {
			if (g.getGradeId()==id) {
				return g;
			}
		}
		return null;
	}

	// Dobavi sve ispite koji nisu ni polozeni ni nepolozeni
	public String[] getUnaffiliatedSubj() {

		//Svi predmeti i privremena lista
		ArrayList<Object> subjAll=SubjectDatabase.getListOfEntites();
		ArrayList<Object> subjectsStud=new ArrayList<>();
		
		//filtriranje onih koji nisu na trenutnoj godini studija
		for(Object o:subjAll) {
			Subject ss=(Subject) o;
			if (ss.getYear()==this.currentStudyYear) {
				subjectsStud.add(ss);
			}
		}
		
		//krajnja lista i ocene
		ArrayList<Subject> subjectsNew=new ArrayList<>();
		ArrayList<Grade> grades=new ArrayList<>(failedExams);
		grades.addAll(passedExams);

		boolean isAffiliated=false;

		int size=subjectsStud.size()-grades.size();
		if(size<1) return null;



		for(Object o:subjectsStud) {
			isAffiliated=false;
			Subject s=(Subject) o;
			for (Grade g: grades) {
				Subject s1=g.getSubject();
				if (s1.getSubjectKey()==s.getSubjectKey()) {
					isAffiliated=true;
					break;
				}
			}

			if(!isAffiliated) {
				subjectsNew.add(s);
			}
		}

		String[] res=new String[subjectsNew.size()];
		//Stavljanje u string
		int i=0;
		for (Subject s2: subjectsNew) {
			String currSubj=s2.getSubjectKey()+"-"+s2.getName();
			res[i]=currSubj;
			i++;
		}
		return res;
	}

	// Dobavi sve potrebne info o studentu za formiranje tabele
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

		Object[] colNames={"ID", "Indeks", "Ime", "Prezime", "Godina Studija", "Status","Prosek"};
		return colNames;
	}



	//Dobavi mi tabelu svih polozenih ispita
	public JTable getPassedTable() {

//		if(s==null) {
//			return null;
//		}
		Object[] cols={"Sifra", "Naziv", "ESPB", "Ocena", "Datum"};
		Object[][] rowData=new Object[passedExams.size()][5];

//		System.out.printf("\nbr ocena:"+this.passedExams.size());


		int i=0;
		for (Grade g: passedExams) {
//			System.out.printf("\nocena:"+g.getGrade());
			Subject subj=g.getSubject();
			rowData[i][0]=subj.getSubjectKey();
			rowData[i][1]=g.getSubject().getName();

			rowData[i][2]=Integer.toString(subj.getEspbPoints());
			rowData[i][3]=Integer.toString(g.getGrade());
			rowData[i][4]=CheckValidity.formatter.format(g.getExamDate());
			i++;
		}

		StudentDialog.dtm=new DefaultTableModel(rowData,cols);
		JTable table=new JTable(StudentDialog.dtm);
		return table;
	}

	//Dobavi mi tabelu svih nepolozenih ispita
	public JTable getFailedTable() {
		Object[] cols={"Sifra", "Naziv", "ESPB","Semestar"};
		Object[][] rowData=new Object[failedExams.size()][4];

		int i=0;
		for (Grade g: failedExams) {
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

	public Long formatNum(String phoneNum) {
		Pattern p = Pattern.compile("^(\\d{3})/(\\d+)-(\\d+)");
		Matcher m = p.matcher(phoneNum);

		if(m.find()) {
			String numS=m.group(1)+m.group(2)+m.group(3);
			Long num=Long.parseLong(numS);
			return num;

		} else {
			System.out.printf("Ne radi regex");
			return null;
		}
	}

	public void writePassedGrades() {
		if (passedExams.isEmpty()) {
			System.out.printf("Obrisalo se");
//			System.out.printf("\nStudent="+name);

		} else {
			System.out.printf("Ima ispita");
		}
//		for (Grade g:passedExams) {
//			System.out.printf("\nStudent="+name+"Ocena="+g.getGrade());
//		}
	}
	
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId() {
		this.studentId = StudentDatabase.rowNum;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
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
		int gradeSum=0;
		int count=0;
		for(Grade g:passedExams) {
			gradeSum+=g.getGrade();
			count++;
		}
		if(count==0) {
			this.averageGrade=0.0;
		} else
			this.averageGrade=(double)gradeSum/(double)count;
		return averageGrade;
	}

	public void setAverageGrade(double averageGrade) {
		this.averageGrade = averageGrade;
	}

	public ArrayList<Grade> getPassedExams() {
		return passedExams;
	}

//	public void setPassedExams(ArrayList<Grade> passedExams) {
//		this.passedExams = passedExams;
//	}

	public ArrayList<Grade> getFailedExams() {
		return failedExams;
	}

//	public void setFailedExams(ArrayList<Grade> failedExams) {
//		this.failedExams = failedExams;
//	}

}
