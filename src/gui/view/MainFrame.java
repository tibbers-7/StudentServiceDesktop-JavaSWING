package gui.view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import gui.MyApp;
import gui.controller.*;
import gui.controller.student.*;
import gui.controller.professor.*;
import gui.controller.subject.*;
import gui.controller.department.*;
import gui.controller.databases.*;
import gui.model.*;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private static MainFrame instance=null;

	public static ToolBar toolbar;
	public static MenuBar menu;
	public static JTabbedPane tp=new JTabbedPane();
	public static StatusBar sb=new StatusBar();
	
	public static JPanel p1=new JPanel();
	public static JPanel p2=new JPanel();
	public static JPanel p3=new JPanel();
	public static JPanel p4=new JPanel();


	public static StudentDialog spEdit;
	public static ProfessorDialog ppEdit;
	public static DepartmentDialog dpEdit;

//------------------------------------------------------------------
	public static NewSubjectAction aNSubj=new NewSubjectAction();
	public static EditSubjectAction aESubj=new EditSubjectAction();
	public static NewStudentAction aNStud=new NewStudentAction();
	public static EditStudentAction aEStud=new EditStudentAction();
	public static DeleteStudentAction aDStud=new DeleteStudentAction();
	public static EditProfessorAction aEProf=new EditProfessorAction();
	public static EditDepartmentAction aEDep=new EditDepartmentAction();

	public static DocumentListener findStudent;

	private static ListSelectionListener lsStudent;
	private static ListSelectionListener lsSubject;
	private static ListSelectionListener lsProfessor;
	private static ListSelectionListener lsDepartment;
//--------------------------------------------------------------------------

	public static int selRowStud=-1;
	public static int selRowSubj=-1;
	public static int selRowProf=-1;
	public static int selRowDep=-1;


	public static MainFrame getInstance() {
		if (instance==null) {
			instance=new MainFrame();
		}
		return instance;
	}


	private MainFrame(){


		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;

		setSize(3*screenWidth / 4, 3*screenHeight / 4);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		//manual dodavanje studenata i predmeta
		Database.readFromFile();


		toolbar= ToolBar.getInstance();
		add(toolbar, BorderLayout.NORTH);

		menu = MenuBar.getInstance();
		setJMenuBar(menu);


//Podesavanja
		ShowTable.updateTableStud(); //update model tabele

		//akcije
		
				lsStudent=new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent e) {
						selRowStud=ShowTable.getStudTable().getSelectedRow();
						Student s=StudentDatabase.findByID(selRowStud+1);
						StudentDialog.updatePassedPanel(s,1);
					}
				};
		
				lsSubject=new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent e) {
						selRowSubj=ShowTable.getSubjTable().getSelectedRow();
					}
				};
		
				lsProfessor=new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent e) {
						selRowProf=ShowTable.getProfTable().getSelectedRow();
						Professor p=ProfessorDatabase.findByID(selRowProf+1);
						ProfessorDialog.updateSubjectPanel(p);
					}
				};
				
				lsDepartment=new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent e) {
						selRowDep=ShowTable.getDepTable().getSelectedRow();
					}
					
				};

		//podesavanje tabele da reaguje na promenu selektovanog reda
		ShowTable.getStudTable().getSelectionModel().addListSelectionListener(lsStudent);
		ShowTable.getSubjTable().getSelectionModel().addListSelectionListener(lsSubject);
		ShowTable.getProfTable().getSelectionModel().addListSelectionListener(lsProfessor);
		ShowTable.getDepTable().getSelectionModel().addListSelectionListener(lsDepartment);
		
		ShowTable.getStudTable().setAutoCreateRowSorter(true);
		ShowTable.getSubjTable().setAutoCreateRowSorter(true);
		ShowTable.getProfTable().setAutoCreateRowSorter(true);
		ShowTable.getDepTable().setAutoCreateRowSorter(true);
		TableSorter.getSorter();

//-------PANELS
		p1.add(new JScrollPane(ShowTable.getStudTable()));
		p2.add(new JScrollPane(ShowTable.getSubjTable()));
		p3.add(new JScrollPane(ShowTable.getProfTable()));
		p4.add(new JScrollPane(ShowTable.getDepTable()));
		


		tp.setBounds(50,50,200,200);
		tp.add("student",p1);
	    tp.add("predmet",p2);
	    tp.add("profesor",p3);
	    tp.add("katedra",p4);


		MyStudentActions.actionsStudent(); //pocetne akcije

	    //sta se desi kad se promeni tab
	    tp.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				if (e.getSource() instanceof JTabbedPane) {
                    JTabbedPane pane = (JTabbedPane) e.getSource();
                    int sel=pane.getSelectedIndex()+1;
                    switchTP(sel);
				}
			}

	    });

		add(tp);
	    add(sb,BorderLayout.SOUTH);
	}




	public static void refreshTP(int entityID) {
		tp.remove(p1);
		tp.remove(p2);
		tp.remove(p3);
		tp.remove(p4);
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();

		ShowTable.getStudTable().getSelectionModel().addListSelectionListener(lsStudent);
		ShowTable.getSubjTable().getSelectionModel().addListSelectionListener(lsSubject);
		ShowTable.getProfTable().getSelectionModel().addListSelectionListener(lsProfessor);
		ShowTable.getDepTable().getSelectionModel().addListSelectionListener(lsDepartment);


		MainFrame.p1.add(new JScrollPane(ShowTable.getStudTable()));
		MainFrame.p2.add(new JScrollPane(ShowTable.getSubjTable()));
		MainFrame.p3.add(new JScrollPane(ShowTable.getProfTable()));
		MainFrame.p4.add(new JScrollPane(ShowTable.getDepTable()));

		tp.add("student",p1);
		tp.add("predmet",p2);
		tp.add("profesor",p3);
		tp.add("katedra",p4);
		tp.revalidate();

		switchTP(entityID);
		
		MyApp.f.repaint();
	}



	//promena taba 
	private static void switchTP(int sel) {
		
		sb.tab.setText("Tab "+sel);
		switch(sel) {
		 
     	case 1:
     		p1.revalidate();
     		p1.repaint();
     		tp.setSelectedIndex(0);
     		MyStudentActions.actionsStudent();
     		ShowTable.updateTableStud();
     		break;
     	case 2:
     		p2.revalidate();
     		p2.repaint();
     		tp.setSelectedIndex(1);
     		MySubjectActions.actionsSubject();
     		ShowTable.updateTableSubj();
     		break;
     	case 3:
     		p3.revalidate();
     		p3.repaint();
     		tp.setSelectedIndex(2);
     		MyProfessorActions.actionsProfessor();
     		ShowTable.updateTableProf();
     		break;
     	case 4:
     		p4.revalidate();
     		p4.repaint();
     		tp.setSelectedIndex(3);
     		MyDepartmentActions.actionsDepartment();
     		ShowTable.updateTableDep();
     		break;
     	default: break;
     }
	}






};
