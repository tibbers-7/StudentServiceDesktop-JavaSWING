package manageEntities.subject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import gui.MenuBar;
import gui.MyApp;
import gui.ShowTable;
import manageEntities.student.ActionStudent;

public class ActionSubject implements ActionListener{

	public static JTable subjTableTemp=new JTable();
	public static JScrollPane jsp=new JScrollPane();
	
	public static ActionNewSubject aNSubj=new ActionNewSubject();
	public static ActionEditSubject aESubj=new ActionEditSubject();
//	public static ActionDeleteSubject aDSubj=new ActionDeleteSubject();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		MyApp.f.remove(ActionStudent.jsp);
		//Prikaz tabele
		subjTableTemp=ShowTable.showEntityTable(3);
		subjTableTemp.setRowSelectionAllowed(true);

		//Brisanje nepozeljnih akcija
		MenuBar._new.removeActionListener(ActionStudent.aNStud);
		MenuBar._edit2.removeActionListener(ActionStudent.aEStud);
		MenuBar._delete.removeActionListener(ActionStudent.aDStud);
		
		MyApp.f.getNewButton().removeActionListener(ActionStudent.aNStud);
		MyApp.f.getEditButton().removeActionListener(ActionStudent.aEStud);
		MyApp.f.getDeleteButton().removeActionListener(ActionStudent.aDStud);
		
//-----------------------------------------------------------------------------
		//Dodavanje novih
		
		MyApp.f.getNewButton().addActionListener(aNSubj);
		MyApp.f.getEditButton().addActionListener(aESubj);
//		MyApp.f.getDeleteButton().addActionListener(aDSubj);
		
		MenuBar._new.addActionListener(aNSubj);
		MenuBar._edit2.addActionListener(aESubj);
//		MenuBar._delete.addActionListener(aDSubj);
		
		subjTableTemp.setRowSelectionAllowed(true);
		JScrollPane table=new JScrollPane(subjTableTemp);
		jsp=table;
		MyApp.f.add(jsp);
		
	}

}
