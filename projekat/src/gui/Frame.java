package gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;

import enums.SemesterEnum;
import enums.StatusEnum;
import manageEntities.student.StudentDatabase;
import manageEntities.subject.SubjectDatabase;
import model.*;

public class Frame extends JFrame {
	
	private JButton newButton=new JButton();
	private JButton editButton=new JButton();
	private JButton deleteButton=new JButton();

	
	public Frame() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		
		setSize(3*screenWidth / 4, 3*screenHeight / 4);
		

		//rucno dodavanje studenata i predmeta

//---------------------------------------------------------------------------
		String adS="Branka Copica,15,Beograd,Srbija";
		Address a=Address.formatAddress(adS);
		String dS="12-May-1999";
		Date d=Student.formatDate(dS);
		Long l=38162559482L;
		Student s1=new Student(1,"Peric","Pera",d,a,l,"pericpera@gmail.com","RA15/2019",2019,3,StatusEnum.SELF_FINANCING);
		StudentDatabase.addStudent(s1);
		
		adS="Milunke Savic,22,Loznica,Srbija";
		a=Address.formatAddress(adS);
		dS="09-December-2001";
		d=Student.formatDate(dS);
		l=3816538882L;
		Student s2=new Student(1,"Stojanovic","Milena",d,a,l,"milenastoj@gmail.com","RA222/2020",2020,3,StatusEnum.BUDGET);
		StudentDatabase.addStudent(s2);
		
		String sifraPr="E328";
		String name="Ruski";
		SemesterEnum sem=SemesterEnum.WINTER;
		int y=2;
		int espb=12;
		Professor p=new Professor();
		Subject subj1=new Subject(1,sifraPr,name,sem,y,p,espb);
		SubjectDatabase.addSubject(subj1);
		
		sifraPr="R58";
		name="Engleski";
		sem=SemesterEnum.SUMMER;
		y=1;
		espb=6;
		Subject subj2=new Subject(1,sifraPr,name,sem,y,p,espb);
		SubjectDatabase.addSubject(subj2);
		
		sifraPr="A85";
		name="Japanski";
		sem=SemesterEnum.WINTER;
		y=4;
		espb=16;
		Subject subj3=new Subject(1,sifraPr,name,sem,y,p,espb);
		SubjectDatabase.addSubject(subj3);
		
//--------------------------------------------------------------------
		
		MenuBar menu = new MenuBar(this);
		this.setJMenuBar(menu);
		
		ToolBar toolbar= new ToolBar();
		add(toolbar, BorderLayout.NORTH);
		this.newButton=toolbar.getNewButton();
		this.editButton=toolbar.getEditButton();
		this.deleteButton=toolbar.getDeleteButton();
		
	}
	
	public JButton getNewButton() {
		return this.newButton;
	}
	
	public JButton getEditButton() {
		return this.editButton;
	}
	
	public JButton getDeleteButton() {
		return this.deleteButton;
	}

	public void setEditButton(JButton editBtn) {
		this.editButton=editBtn;
	}
	public void setNewButton(JButton newBtn) {
		this.newButton=newBtn;
	}

	public void setDeleteButton(JButton delBtn) {
		this.deleteButton=delBtn;
	}
	
	
	
	
};
