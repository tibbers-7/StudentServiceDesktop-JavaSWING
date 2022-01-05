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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import enums.SemesterEnum;
import enums.StatusEnum;
import manageEntities.student.DeleteStudentAction;
import manageEntities.student.EditStudentAction;
import manageEntities.student.NewStudentAction;
import manageEntities.student.StudentDatabase;
import manageEntities.subject.EditSubjectAction;
import manageEntities.subject.NewSubjectAction;
import manageEntities.subject.SubjectDatabase;
import model.Address;
import model.Grade;
import model.Professor;
import model.Student;
import model.Subject;

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	public static JButton newButton=new JButton();
	public static JButton editButton=new JButton();
	public static JButton deleteButton=new JButton();
	public static JPanel p1=new JPanel();
	public static JPanel p2=new JPanel();
	public static JPanel p3=new JPanel();
	
	public static NewSubjectAction aNSubj=new NewSubjectAction();
	public static EditSubjectAction aESubj=new EditSubjectAction();
//	public static ActionDeleteSubject aDSubj=new ActionDeleteSubject();
	
	public static NewStudentAction aNStud=new NewStudentAction();
	public static EditStudentAction aEStud=new EditStudentAction();
	public static DeleteStudentAction aDStud=new DeleteStudentAction();
	
	public static MenuBar menu = new MenuBar();
	
	public static JTable studTable=ShowTable.showEntityTable(1);
	public static DefaultTableModel tableModelStud=new DefaultTableModel();
	public static JTable subjTable=ShowTable.showEntityTable(3);
	public static DefaultTableModel tableModelSubj=new DefaultTableModel();
	public static int selRowStud=0;
	public static int selRowSubj=0;
	
	private static JTabbedPane tp=new JTabbedPane(); 
	
	
	
	public MainFrame(){
		
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		
		setSize(3*screenWidth / 4, 3*screenHeight / 4);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		     

		//rucno dodavanje studenata i predmeta

//---------------------------------------------------------------------------
		
		
		
		
		Student s1=new Student("Peric","Pera",Student.formatDate("12-May-1999"),Address.formatAddress("Branka Copica,15,Beograd,Srbija"),38162559482L,"pericpera@gmail.com","RA15/2019",2019,3,StatusEnum.BUDGET);
		Student s2=new Student("Mirkovic","Aleksa",Student.formatDate("15-July-1998"),Address.formatAddress("Jug Bogdana,22,Novi Sad,Srbija"),38162473882L,"amirkovic@yahoo.com","EE12/2017",2017,4,StatusEnum.SELF_FINANCING);
		Student s3=new Student("Gajic","Katarina",Student.formatDate("31-April-2002"),Address.formatAddress("Njegoseva,45,Pozarevac,Srbija"),38162559482L,"katarinag@gmail.com","GG154/2021",2021,1,StatusEnum.SELF_FINANCING);
		Student s4=new Student("Stojanovic","Milena",Student.formatDate("09-December-2001"),Address.formatAddress("Milunke Savic,22,Loznica,Srbija"),3816538882L,"milenastoj@gmail.com","RA222/2020",2020,3,StatusEnum.BUDGET);
		Subject subj1=new Subject("E328","Ruski",SemesterEnum.WINTER,2,new Professor(),12);
		Subject subj2=new Subject("R58","Engleski",SemesterEnum.SUMMER,1,new Professor(),12);
		Subject subj3=new Subject("A85","Japanski",SemesterEnum.WINTER,4,new Professor(),16);
		Subject subj4=new Subject("E08","Nemacki",SemesterEnum.SUMMER,3,new Professor(),6);
		Subject subj5=new Subject("P90","Korejski",SemesterEnum.SUMMER,2,new Professor(),15);
		
		Grade g1=new Grade(s1, subj1, 8, Student.formatDate("18-July-2019"));
		Grade g2=new Grade(s1, subj2, 10, Student.formatDate("12-June-2019"));
		Grade g3=new Grade(s2, subj3, 6, Student.formatDate("29-September-2018"));
		Grade g4=new Grade(s2, subj4, 7, Student.formatDate("31-March-2020"));
		Grade g5=new Grade(s3, subj2, 9, Student.formatDate("1-April-2021"));
		Grade g6=new Grade(s4, subj2, 10, Student.formatDate("7-October-2019"));
		Grade g7=new Grade(s4, subj1, 7, Student.formatDate("10-May-2021"));
		Grade g8=new Grade(s4, subj4, 6, Student.formatDate("31-March-2020"));
		
		Grade g9=new Grade(s1, subj3);
		Grade g10=new Grade(s1, subj4);
		
		
		s1.addPassedExam(g1);
		s1.addPassedExam(g2);
		s2.addPassedExam(g3);
		s2.addPassedExam(g4);
		s3.addPassedExam(g5);
		s4.addPassedExam(g6);
		s4.addPassedExam(g7);
		s4.addPassedExam(g8);
		
		s1.addFailedExam(g9);
		s1.addFailedExam(g10);
		
		StudentDatabase.addStudent(s1);
		StudentDatabase.addStudent(s2);
		StudentDatabase.addStudent(s3);
		StudentDatabase.addStudent(s4);
		SubjectDatabase.addSubject(subj1);
		SubjectDatabase.addSubject(subj2);
		SubjectDatabase.addSubject(subj3);
		SubjectDatabase.addSubject(subj4);
		SubjectDatabase.addSubject(subj5);
//-------------------------------------------------------------------- 
//	
		
		
		ToolBar toolbar= new ToolBar();
		add(toolbar, BorderLayout.NORTH);
		newButton=toolbar.getNewButton();
		editButton=toolbar.getEditButton();
		deleteButton=toolbar.getDeleteButton();
		
		menu = new MenuBar();
		setJMenuBar(menu);
		
//-------PANELS		
//		p1=MyStudentPanel.getInstance();
		studTable=ShowTable.showEntityTable(1);
		MyStudentPanel.actionsStudent();
		updateTableStud();
		studTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				selRowStud=studTable.getSelectedRow();
			}
			
		});
		p1.add(new JScrollPane(studTable));
		
		
		
//		p2=MySubjectPanel.getInstance();
		subjTable=ShowTable.showEntityTable(3);
		updateTableSubj();
		subjTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				selRowSubj=subjTable.getSelectedRow();
			}
			
		});
		p2.add(new JScrollPane(subjTable));
		
		
		
		
		tp.setBounds(50,50,200,200); 
	  
		tp.add("student",p1);  
	    tp.add("predmet",p2); 
	    
	    
	    tp.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				if (e.getSource() instanceof JTabbedPane) {
                    JTabbedPane pane = (JTabbedPane) e.getSource();
                    int sel=pane.getSelectedIndex();
                    System.out.println("Selected paneNo : " + sel);
                    switch(sel) {
                    	case 0:
                    		MyStudentPanel.actionsStudent();
                    		updateTableStud();
                    		break;
                    	case 1:
                    		MySubjectPanel.actionsSubject();
                    		updateTableSubj();
                    		break;
                    }
				}
			}
	    	
	    });
	    
	    
		add(tp);
				
		
		
	}
	
	public static void updateTableStud() {
		tableModelStud.fireTableDataChanged();
		tableModelStud.fireTableStructureChanged();
		p1.revalidate();
		p1.repaint();
		tp.revalidate();
		tp.repaint();
	}
	
	public static void updateTableSubj() {
		tableModelSubj.fireTableDataChanged();
		tableModelSubj.fireTableStructureChanged();
		p2.revalidate();
		p2.repaint();
		tp.revalidate();
		tp.repaint();
	}

	
	



	
	
	
};