package manageEntities.subject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import gui.MainFrame;
import gui.MenuBar;
import gui.MyApp;
import gui.MyStudentPanel;
import gui.MySubjectPanel;
import gui.ShowTable;
import manageEntities.student.MenuBarActionStudent;

public class MenuBarActionSubject implements ActionListener{

	public static JTable subjTableTemp=new JTable();
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Prikaz tabele
		MainFrame.subjTable=ShowTable.showEntityTable(3);
		MainFrame.subjTable.setRowSelectionAllowed(true);
	

//		//Brisanje nepozeljnih akcija
//		MainFrame.menu._new.removeActionListener(MainFrame.aNStud);
//		MainFrame.menu._edit2.removeActionListener(MainFrame.aEStud);
//		MainFrame.menu._delete.removeActionListener(MainFrame.aDStud);
//		
//		MainFrame.newButton.removeActionListener(MainFrame.aNStud);
//		MainFrame.editButton.removeActionListener(MainFrame.aEStud);
//		MainFrame.deleteButton.removeActionListener(MainFrame.aDStud);
//		
////-----------------------------------------------------------------------------
//		//Dodavanje novih
//		
//		MainFrame.newButton.addActionListener(MainFrame.aNSubj);
//		MainFrame.editButton.addActionListener(MainFrame.aESubj);
////		MainFrame.deleteButton.addActionListener(MainFrame.aDSubj);
//		
//		MainFrame.menu._new.addActionListener(MainFrame.aNSubj);
//		MainFrame.menu._edit2.addActionListener(MainFrame.aESubj);
////		MainFrame._delete.addActionListener(MainFrame.aDSubj);
		
	}

}
