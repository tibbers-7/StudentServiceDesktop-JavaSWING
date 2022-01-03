package manageEntities.student; 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import gui.MainFrame;
import gui.MenuBar;
import gui.MyApp;
import gui.MyStudentPanel;
import gui.ShowTable;
import manageEntities.subject.ActionSubject;


public class MenuBarActionStudent implements ActionListener{
	
	public static JScrollPane jsp=new JScrollPane();
	public static NewStudentAction aNStud=new NewStudentAction();
	public static EditStudentAction aEStud=new EditStudentAction();
	public static DeleteStudentAction aDStud=new DeleteStudentAction();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Prikaz tabele
		MyStudentPanel.studTable=ShowTable.showEntityTable(1);
		MyStudentPanel.studTable.setRowSelectionAllowed(true);
		
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
		MyStudentPanel.updateTable();
		
//		MainFrame.tp=new JTabbedPane();
//		MainFrame.tp.invalidate();
//		MainFrame.tp.validate();
//		MainFrame.tp.repaint();
//		ShowTable.updateTable();
		
	}
	
	
};
		
