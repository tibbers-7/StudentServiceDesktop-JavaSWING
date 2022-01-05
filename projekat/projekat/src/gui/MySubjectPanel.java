package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import manageEntities.student.DeleteStudentAction;
import manageEntities.student.EditStudentAction;
import manageEntities.student.MenuBarActionStudent;
import manageEntities.student.NewStudentAction;
import manageEntities.subject.MenuBarActionSubject;
import manageEntities.subject.EditSubjectAction;
import manageEntities.subject.NewSubjectAction;

public class MySubjectPanel extends JPanel{

	private static MySubjectPanel instanceSubj=null;
	
	public static NewSubjectAction aNSubj=new NewSubjectAction();
	public static EditSubjectAction aESubj=new EditSubjectAction();
//	public static DeleteSubjectAction aDSubj=new DeleteSubjectAction();
	
	
	
	
	
	public static MySubjectPanel getInstance() {
		if (instanceSubj==null) {
			instanceSubj=new MySubjectPanel();
		}
		return instanceSubj;
	}
	
	private MySubjectPanel() {
		MainFrame.subjTable=ShowTable.showEntityTable(3);
		add(new JScrollPane(MainFrame.subjTable));
		actionsSubject();
		MainFrame.updateTableSubj();
		
	}
	
	
	public static void actionsSubject() {
		
		MainFrame.subjTable=ShowTable.showEntityTable(3);
		//Brisanje nepozeljnih akcija
		MainFrame.newButton.removeActionListener(MainFrame.aNStud);
		MainFrame.editButton.removeActionListener(MainFrame.aEStud);
		MainFrame.deleteButton.removeActionListener(MainFrame.aDStud);
		
		MainFrame.menu._new.removeActionListener(MainFrame.aNStud);
		MainFrame.menu._edit2.removeActionListener(MainFrame.aEStud);
		MainFrame.menu._delete.removeActionListener(MainFrame.aDStud);
		
//----------------------------------------------------------------------
		//Dodavanje novih akcija
		
		
		MainFrame.newButton.addActionListener(MainFrame.aNSubj);
		MainFrame.editButton.addActionListener(MainFrame.aESubj);
//		MainFrame.deleteButton.addActionListener(MainFrame.aDSubj);
		
		MainFrame.menu._new.addActionListener(MainFrame.aNSubj);
		MainFrame.menu._edit2.addActionListener(MainFrame.aNSubj);
//		MainFrame.menu._delete.addActionListener(MainFrame.aDSubj);
	}
	
	
}
