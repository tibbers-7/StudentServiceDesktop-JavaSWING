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
import manageEntities.subject.MenuBarActionSubject;


public class MenuBarActionStudent implements ActionListener{
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Prikaz tabele
		
		MainFrame.studTable=ShowTable.showEntityTable(1);
		MainFrame.studTable.setRowSelectionAllowed(true);
		MainFrame.updateTableStud();
		
////------------------------------------------------------------------------
//		
//		//Brisanje nepozeljnih akcija
//		
//		MainFrame.newButton.removeActionListener(MainFrame.aNSubj);
//		MainFrame.editButton.removeActionListener(MainFrame.aESubj);
////		MainFrame.deleteButton.removeActionListener(MainFrame.aDSubj);
//		
//		MainFrame.menu._new.removeActionListener(MainFrame.aNSubj);
//		MainFrame.menu._edit2.removeActionListener(MainFrame.aNSubj);
////		MainFrame.menu._delete.removeActionListener(MainFrame.aDSubj);
//		
////----------------------------------------------------------------------
//		//Dodavanje novih akcija
//		
//		
//		MainFrame.newButton.addActionListener(MainFrame.aNStud);
//		MainFrame.editButton.addActionListener(MainFrame.aEStud);
//		MainFrame.deleteButton.addActionListener(MainFrame.aDStud);
//		
//		MainFrame.menu._new.addActionListener(MainFrame.aNStud);
//		MainFrame.menu._edit2.addActionListener(MainFrame.aEStud);
//		MainFrame.menu._delete.addActionListener(MainFrame.aDStud);
		
		
		

		
	}
	
	
};
		
