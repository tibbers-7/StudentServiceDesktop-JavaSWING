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
import manageEntities.subject.ActionSubject;

public class MyStudentPanel extends JPanel{
	private static MyStudentPanel instance=null;
	
	public static JScrollPane jsp=new JScrollPane();
	public static NewStudentAction aNStud=new NewStudentAction();
	public static EditStudentAction aEStud=new EditStudentAction();
	public static DeleteStudentAction aDStud=new DeleteStudentAction();
	public static JTable studTable=ShowTable.showEntityTable(1);
	public static DefaultTableModel contactTableModel=new DefaultTableModel();

	public static MyStudentPanel getInstance() {
		if (instance==null) {
			instance=new MyStudentPanel();
		}
		return instance;
	}
	
	private MyStudentPanel() {
		
		//Prikaz tabele
		
		studTable=ShowTable.showEntityTable(1);
		contactTableModel=(DefaultTableModel) studTable.getModel();
		add(new JScrollPane(studTable));
		
		
		//Brisanje nepozeljnih akcija
		MainFrame.newButton.removeActionListener(ActionSubject.aNSubj);
		MainFrame.editButton.removeActionListener(ActionSubject.aESubj);
//		MainFrame.deleteButton.removeActionListener(ActionSubject.aDSubj);
		
		MenuBar._new.removeActionListener(ActionSubject.aNSubj);
		MenuBar._edit2.removeActionListener(ActionSubject.aNSubj);
//		MenuBar._delete.removeActionListener(ActionSubject.aDSubj);
		
//----------------------------------------------------------------------
		//Dodavanje novih akcija
		
		
		MainFrame.newButton.addActionListener(aNStud);
		MainFrame.editButton.addActionListener(aEStud);
		MainFrame.deleteButton.addActionListener(aDStud);
		
		MenuBar._new.addActionListener(aNStud);
		MenuBar._edit2.addActionListener(aEStud);
		MenuBar._delete.addActionListener(aDStud);
		
		
	}
	
	public static void updateTable() {
		contactTableModel.fireTableDataChanged();
	}
}
