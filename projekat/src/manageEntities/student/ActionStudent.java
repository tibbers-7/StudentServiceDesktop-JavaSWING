package manageEntities.student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import gui.MenuBar;
import gui.MyApp;
import gui.ShowTable;
import manageEntities.subject.ActionSubject;


public class ActionStudent implements ActionListener{
	
	public static JTable studTableTemp=new JTable();
	public static JScrollPane jsp=new JScrollPane();
	public static ActionNewStudent aNStud=new ActionNewStudent();
	public static ActionEditStudent aEStud=new ActionEditStudent();
	public static ActionDeleteStudent aDStud=new ActionDeleteStudent();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		MyApp.f.remove(ActionSubject.jsp);
		//Prikaz tabele
		studTableTemp=ShowTable.showEntityTable(1);
		studTableTemp.setRowSelectionAllowed(true);
		
		//Brisanje nepozeljnih akcija
		MyApp.f.getNewButton().removeActionListener(ActionSubject.aNSubj);
		MyApp.f.getEditButton().removeActionListener(ActionSubject.aESubj);
//		MyApp.f.getDeleteButton().removeActionListener(ActionSubject.aDSubj);
		
		MenuBar._new.removeActionListener(ActionSubject.aNSubj);
		MenuBar._edit2.removeActionListener(ActionSubject.aNSubj);
//		MenuBar._delete.removeActionListener(ActionSubject.aDSubj);
		
//----------------------------------------------------------------------
		//Dodavanje novih akcija
		
		
		MyApp.f.getNewButton().addActionListener(aNStud);
		MyApp.f.getEditButton().addActionListener(aEStud);
		MyApp.f.getDeleteButton().addActionListener(aDStud);
		
		MenuBar._new.addActionListener(aNStud);
		MenuBar._edit2.addActionListener(aEStud);
		MenuBar._delete.addActionListener(aDStud);
		
		studTableTemp.setRowSelectionAllowed(true);
		jsp=new JScrollPane(studTableTemp);
		MyApp.f.add(jsp);
//		ShowTable.updateTable();
		
	}
	
	
};
		
