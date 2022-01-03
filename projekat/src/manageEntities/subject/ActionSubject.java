package manageEntities.subject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import gui.MainFrame;
import gui.MenuBar;
import gui.MyApp;
import gui.ShowTable;
import manageEntities.student.MenuBarActionStudent;

public class ActionSubject implements ActionListener{

	public static JTable subjTableTemp=new JTable();
	public static JScrollPane jsp=new JScrollPane();
	
	public static ActionNewSubject aNSubj=new ActionNewSubject();
	public static ActionEditSubject aESubj=new ActionEditSubject();
//	public static ActionDeleteSubject aDSubj=new ActionDeleteSubject();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		MyApp.f.remove(MenuBarActionStudent.jsp);
		//Prikaz tabele
		subjTableTemp=ShowTable.showEntityTable(3);
		subjTableTemp.setRowSelectionAllowed(true);

		//Brisanje nepozeljnih akcija
		MenuBar._new.removeActionListener(MenuBarActionStudent.aNStud);
		MenuBar._edit2.removeActionListener(MenuBarActionStudent.aEStud);
		MenuBar._delete.removeActionListener(MenuBarActionStudent.aDStud);
		
		MainFrame.newButton.removeActionListener(MenuBarActionStudent.aNStud);
		MainFrame.editButton.removeActionListener(MenuBarActionStudent.aEStud);
		MainFrame.deleteButton.removeActionListener(MenuBarActionStudent.aDStud);
		
//-----------------------------------------------------------------------------
		//Dodavanje novih
		
		MainFrame.newButton.addActionListener(aNSubj);
		MainFrame.editButton.addActionListener(aESubj);
//		MainFrame.deleteButton.addActionListener(aDSubj);
		
		MenuBar._new.addActionListener(aNSubj);
		MenuBar._edit2.addActionListener(aESubj);
//		MenuBar._delete.addActionListener(aDSubj);
		
		subjTableTemp.setRowSelectionAllowed(true);
		JScrollPane table=new JScrollPane(subjTableTemp);
		jsp=table;
		MyApp.f.add(jsp);
		
	}

}
