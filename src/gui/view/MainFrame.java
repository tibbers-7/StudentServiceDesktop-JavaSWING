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

import gui.*;
import gui.MyApp;
import gui.controller.ShowTable;
import gui.controller.databases.Database;
import gui.controller.professor.EditProfessorAction;
import gui.controller.professor.MyProfessorActions;
import gui.controller.professor.ProfessorDialog;
import gui.controller.student.DeleteStudentAction;
import gui.controller.student.EditStudentAction;
import gui.controller.student.MyStudentActions;
import gui.controller.student.NewStudentAction;
import gui.controller.student.StudentDatabase;
import gui.controller.student.StudentDialog;
import gui.controller.subject.EditSubjectAction;
import gui.controller.subject.MySubjectActions;
import gui.controller.subject.NewSubjectAction;
import gui.model.Student;

public class MainFrame extends JFrame {

	private static MainFrame instance=null;

	private static final long serialVersionUID = 1L;

	public static ToolBar toolbar;

	public static JPanel p1=new JPanel();
	public static JPanel p2=new JPanel();
	public static JPanel p3=new JPanel();

	public static StudentDialog spEdit;
	public static ProfessorDialog ppEdit;


	public static NewSubjectAction aNSubj=new NewSubjectAction();
	public static EditSubjectAction aESubj=new EditSubjectAction();
//	public static ActionDeleteSubject aDSubj=new ActionDeleteSubject();

	public static NewStudentAction aNStud=new NewStudentAction();
	public static EditStudentAction aEStud=new EditStudentAction();
	public static DeleteStudentAction aDStud=new DeleteStudentAction();

	public static EditProfessorAction aEProf=new EditProfessorAction();
	public static DocumentListener findStudent;

	private static ListSelectionListener lsStudent;
	private static ListSelectionListener lsSubject;
	private static ListSelectionListener lsProfessor;


	public static int selRowStud=-1;
	public static int selRowSubj=-1;
	public static int selRowProf=-1;


	public static MenuBar menu;
	public static JTabbedPane tp=new JTabbedPane();

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

//
		//rucno dodavanje studenata i predmeta
		Database.insertValues();


		toolbar= ToolBar.getInstance();
		add(toolbar, BorderLayout.NORTH);

		menu = MenuBar.getInstance();
		setJMenuBar(menu);

//-------PANELS

		MyStudentActions.actionsStudent(); //podesava akcije za sve dugmadi i brise stare
		ShowTable.updateTableStud(); //update model tabele

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
			}
		};

		//podesavanje tabele da reaguje na promenu selektovanog reda
		ShowTable.getStudTable().getSelectionModel().addListSelectionListener(lsStudent);
		ShowTable.getSubjTable().getSelectionModel().addListSelectionListener(lsSubject);
		ShowTable.getProfTable().getSelectionModel().addListSelectionListener(lsProfessor);

		ShowTable.getStudTable().setAutoCreateRowSorter(true);
		ShowTable.getSubjTable().setAutoCreateRowSorter(true);

		p1.add(new JScrollPane(ShowTable.getStudTable()));
		p2.add(new JScrollPane(ShowTable.getSubjTable()));
		p3.add(new JScrollPane(ShowTable.getProfTable()));

		tp.setBounds(50,50,200,200);
		tp.add("student",p1);
	    tp.add("predmet",p2);
	    tp.add("profesor",p3);


	    //sta se desi kad se promeni tab
	    tp.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				if (e.getSource() instanceof JTabbedPane) {
                    JTabbedPane pane = (JTabbedPane) e.getSource();
                    int sel=pane.getSelectedIndex();
                    switch(sel) {
                    	case 0:
                    		p1.revalidate();
                    		p1.repaint();
                    		MyStudentActions.actionsStudent();
                    		ShowTable.updateTableStud();
                    		break;
                    	case 1:
                    		p2.revalidate();
                    		p2.repaint();
                    		MySubjectActions.actionsSubject();
                    		ShowTable.updateTableSubj();
                    		break;
                    	case 2:
                    		p3.revalidate();
                    		p3.repaint();
                    		MyProfessorActions.actionsProfessor();
                    		ShowTable.updateTableProf();
                    		break;
                    }
				}
			}

	    });


		add(tp);

	}




	public static void refreshTP(int entityID) {
//		MyApp.f.remove(tp);
		tp.remove(p1);
		tp.remove(p2);
		tp.remove(p3);
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();

		ShowTable.getStudTable().getSelectionModel().addListSelectionListener(lsStudent);
		ShowTable.getSubjTable().getSelectionModel().addListSelectionListener(lsSubject);
		ShowTable.getProfTable().getSelectionModel().addListSelectionListener(lsProfessor);


		MainFrame.p1.add(new JScrollPane(ShowTable.getStudTable()));
		MainFrame.p2.add(new JScrollPane(ShowTable.getSubjTable()));
		MainFrame.p3.add(new JScrollPane(ShowTable.getProfTable()));

		tp.add("student",p1);
		tp.add("predmet",p2);
		tp.add("profesor",p3);
		tp.revalidate();


		switch(entityID) {
			case 1:
				tp.setSelectedIndex(0);
				MyStudentActions.actionsStudent();
				break;
			case 2:
				tp.setSelectedIndex(1);
				MySubjectActions.actionsSubject();
				break;
			case 3:
				tp.setSelectedIndex(2);
				MyProfessorActions.actionsProfessor();
				break;
		}
		MyApp.f.repaint();
	}









}
