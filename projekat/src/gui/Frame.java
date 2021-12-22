package gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;

import enums.StatusEnum;
import manageEntities.student.StudentDatabase;
import model.*;

public class Frame extends JFrame {
	
	private JButton newButton=new JButton();
	private JButton editButton=new JButton();
	
	
	public Frame() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		
		setSize(3*screenWidth / 4, 3*screenHeight / 4);
		
		StudentDatabase sdb=new StudentDatabase();
		
		String adS="Branka Copica,15,Beograd,Srbija";
		Address a=Address.formatAddress(adS);
		String dS="12-May-1999";
		Date d=Student.formatDate(dS);
		Long l=38162559482L;
		Student s1=new Student(1,"Peric","Pera",d,a,l,"pericpera@gmail.com","RA15/2019",2019,3,StatusEnum.SELF_FINANCING);
		sdb.addStudent(s1);
//		
		
		MenuBar menu = new MenuBar(this,sdb);
		this.setJMenuBar(menu);
		
		ToolBar toolbar= new ToolBar();
		add(toolbar, BorderLayout.NORTH);
		this.newButton=toolbar.getNewButton();
		this.editButton=toolbar.getEditButton();
		
	}
	
	public JButton getNewButton() {
		return this.newButton;
	}
	
	public JButton getEditButton() {
		return this.editButton;
	}
	
	
}
