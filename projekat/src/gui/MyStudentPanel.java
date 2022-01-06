package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import gui.MenuBar;
import gui.MyApp;
import gui.ShowTable;
import manageEntities.student.DeleteStudentAction;
import manageEntities.student.EditStudentAction;
import manageEntities.student.NewStudentAction;
import manageEntities.subject.MenuBarActionSubject;

@SuppressWarnings("serial")
public class MyStudentPanel extends JPanel{
	private static MyStudentPanel instanceStud=null;
	
	public static NewStudentAction aNStud=new NewStudentAction();
	public static EditStudentAction aEStud=new EditStudentAction();
	public static DeleteStudentAction aDStud=new DeleteStudentAction();
	
	
	
	

	public static MyStudentPanel getInstance() {
		if (instanceStud==null) {
			instanceStud=new MyStudentPanel();
		}
		return instanceStud;
	}
	
	private MyStudentPanel() {
		
		//Prikaz tabele
		
		MainFrame.studTable=ShowTable.showEntityTable(1);
		
		actionsStudent();
		add(new JScrollPane(MainFrame.studTable));
		MainFrame.updateTableStud();
		
		
	}
	
	public static void actionsStudent() {
		MainFrame.studTable=ShowTable.showEntityTable(1);
		//Brisanje nepozeljnih akcija
		MainFrame.newButton.removeActionListener(MainFrame.aNSubj);
		MainFrame.editButton.removeActionListener(MainFrame.aESubj);
//		MainFrame.deleteButton.removeActionListener(MainFrame.aDSubj);
		
		MainFrame.menu._new.removeActionListener(MainFrame.aNSubj);
		MainFrame.menu._edit2.removeActionListener(MainFrame.aNSubj);
//		MainFrame.menu._delete.removeActionListener(MainFrame.aDSubj);
		
//----------------------------------------------------------------------
		//Dodavanje novih akcija
		
		
		MainFrame.newButton.addActionListener(MainFrame.aNStud);
		MainFrame.editButton.addActionListener(MainFrame.aEStud);
		MainFrame.deleteButton.addActionListener(MainFrame.aDStud);
		
		MainFrame.menu._new.addActionListener(MainFrame.aNStud);
		MainFrame.menu._edit2.addActionListener(MainFrame.aEStud);
		MainFrame.menu._delete.addActionListener(MainFrame.aDStud);
		
		MainFrame.updateTableStud();
		
	}
	
	
	
	
	
}
