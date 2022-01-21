package gui.model;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import enums.TitleEnum;
import gui.controller.databases.AddressDatabase;
import gui.controller.databases.SubjectDatabase;
import gui.controller.professor.ProfessorDialog;

public class Professor {
	protected int professorId;
	protected String surname;
	protected String name;
	protected Date birthDate;
	private Address address;
	private String phoneNumber;
	protected String email;
	private Address officeAddress;
	private TitleEnum title;
	private int trailYears; // godine staza
	private int personalId;
	private ArrayList<Subject> subjects=new ArrayList<>();


	public Professor() {
		super();
	}
	public Professor(int personalId,String surname, String name, Date birthDate, Address address, String phoneNumber,
			String email, Address officeAddress, TitleEnum title, int trailYears) {
		super();
		this.personalId=personalId;
		this.surname = surname;
		this.name = name;
		this.birthDate = birthDate;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.officeAddress = officeAddress;
		this.title = title;
		this.trailYears = trailYears;
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
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	public TitleEnum getTitle() {
		return title;
	}
	public void setTitle(TitleEnum title) {
		this.title = title;
	}
	public int getTrailYears() {
		return trailYears;
	}
	public void setTrailYears(int trailYears) {
		this.trailYears = trailYears;
	}
	public ArrayList<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(ArrayList<Subject> subjects) {
		this.subjects = subjects;
	}

	public void removeSubject(Subject subj) {
		subjects.remove(subj);
	}

	public void addSubject(Subject s) {
		subjects.add(s);
	}


	public static Object[] getData(Object o) {
		Professor p=(Professor) o;
		String titleS=p.getTitleString();
		Object[] rowData= {p.getProfessorId(),p.getName(),p.getSurname(),titleS,p.getEmail()};
		return rowData;
	}

	public Object[] getColumns() {

		Object[] cols= {"ID","Ime", "Prezime", "Zvanje", "E-mail"};
		return cols;
	}

	public JTable getSubjectTable() {
		Object[] cols={"Sifra", "Naziv", "Godina", "Semestar"};
		Object[][] rowData=new Object[this.subjects.size()][4];

		int i=0;
		for (Subject s: this.subjects) {

			rowData[i][0]=s.getSubjectKey();
			rowData[i][1]=s.getName();
			rowData[i][2]=Integer.toString(s.getYear());
			switch(s.getSemester()) {
				case WINTER: {
					rowData[i][3]="Zimski";
					break;
				}
				case SUMMER: {
					rowData[i][3]="Letnji";
				}
			}
			i++;
		}

		ProfessorDialog.dtm=new DefaultTableModel(rowData,cols);
		JTable table=new JTable(ProfessorDialog.dtm);
		return table;
	}
	
	private String getTitleString() {
		String titleS="";
		switch(this.title) {
			case DOCENT:
				titleS="Docent";
				break;
			case REDOVNI_PROFESOR:
				titleS="Redovni profesor";
				break;
			case VANREDNI_PROFESOR:
				titleS="Vanredni profesor";
				break;
		}
		
		return titleS;
	}
	public String[] getUnaffiliatedSubj() {
		ArrayList<Object> subjectsStud=SubjectDatabase.getListOfEntites();
		ArrayList<Subject> subjectsNew=new ArrayList<>();
		ArrayList<Subject> afillSubj=new ArrayList<>(subjects);

		boolean isAffiliated=false;

		int size=subjectsStud.size()-afillSubj.size();
		if(size<1) return null;



		for(Object o:subjectsStud) {
			isAffiliated=false;
			Subject s=(Subject) o;
			for (Subject s1: afillSubj) {
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
	
	public String getProfForDep() {
		String s=Integer.toString(professorId)+". "+name+" "+surname;
		return s;
	}
	
	public static TitleEnum getTitleEnum(String s) {
		TitleEnum title;
		switch(s) {
		case "REDOVNI_PROFESOR":
			title=TitleEnum.REDOVNI_PROFESOR;
			break;
		case "VANREDNI_PROFESOR":
			title=TitleEnum.VANREDNI_PROFESOR;
			break;
		default:
			title=TitleEnum.DOCENT;

		}
		
		return title;
	}
	
	

}
