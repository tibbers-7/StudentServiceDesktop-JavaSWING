package gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import enums.SemesterEnum;
import enums.StatusEnum;
import manageEntities.student.StudentDatabase;
import manageEntities.subject.SubjectDatabase;
import model.Address;
import model.Professor;
import model.Student;
import model.Subject;

public class MainFrame extends JFrame {
	
	private static MainFrame instance=null;
	private static final long serialVersionUID = 1L;
	public static JButton newButton=new JButton();
	public static JButton editButton=new JButton();
	public static JButton deleteButton=new JButton();
	public static JPanel p1=new JPanel();
	public static JPanel p2=new JPanel();
	public static JPanel p3=new JPanel();
	
	
	
	public MainFrame(){
		
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		
		setSize(3*screenWidth / 4, 3*screenHeight / 4);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		
		    p2=new JPanel();  
		    p3=new JPanel();  
		     
		    
		    
		

		//rucno dodavanje studenata i predmeta

//---------------------------------------------------------------------------
		Student s1=new Student("Peric","Pera",Student.formatDate("12-May-1999"),Address.formatAddress("Branka Copica,15,Beograd,Srbija"),38162559482L,"pericpera@gmail.com","RA15/2019",2019,3,StatusEnum.BUDGET);
		Student s2=new Student("Mirkovic","Aleksa",Student.formatDate("15-July-1998"),Address.formatAddress("Jug Bogdana,22,Novi Sad,Srbija"),38162473882L,"amirkovic@yahoo.com","EE12/2017",2017,4,StatusEnum.SELF_FINANCING);
		Student s3=new Student("Gajic","Katarina",Student.formatDate("31-April-2002"),Address.formatAddress("Njegoseva,45,Pozarevac,Srbija"),38162559482L,"katarinag@gmail.com","GG154/2021",2021,1,StatusEnum.SELF_FINANCING);
		Student s4=new Student("Stojanovic","Milena",Student.formatDate("09-December-2001"),Address.formatAddress("Milunke Savic,22,Loznica,Srbija"),3816538882L,"milenastoj@gmail.com","RA222/2020",2020,3,StatusEnum.BUDGET);
		Subject subj1=new Subject("E328","Ruski",SemesterEnum.WINTER,2,new Professor(),12);
		Subject subj2=new Subject("R58","Engleski",SemesterEnum.SUMMER,1,new Professor(),12);
		Subject subj3=new Subject("A85","Japanski",SemesterEnum.WINTER,4,new Professor(),16);
		
		
		StudentDatabase.addStudent(s1);
		StudentDatabase.addStudent(s2);
		StudentDatabase.addStudent(s3);
		StudentDatabase.addStudent(s4);
		SubjectDatabase.addSubject(subj1);
		SubjectDatabase.addSubject(subj2);
		SubjectDatabase.addSubject(subj3);
//-------------------------------------------------------------------- 
//	
		
		
		ToolBar toolbar= new ToolBar();
		add(toolbar, BorderLayout.NORTH);
		newButton=toolbar.getNewButton();
		editButton=toolbar.getEditButton();
		deleteButton=toolbar.getDeleteButton();
		
		MenuBar menu = new MenuBar();
		setJMenuBar(menu);
		

		p1=MyStudentPanel.getInstance();
		JTabbedPane tp=MyTabbedPane.getInstance(); 
		tp.setBounds(50,50,200,200); 
	    tp.add("student",p1);  
	    tp.add("profesor",p2);  
	    tp.add("predmet",p3); 
		add(tp);
				
		
		
	}
	



	
	
	
};
