package manageEntities.subject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import gui.MyApp;
import gui.ShowTable;
import manageEntities.student.MenuBarActionStudent;

public class ActionNewSubject implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Ciscenje stare akcije
				MyApp.f.getNewButton().removeActionListener(MenuBarActionStudent.aNStud);
				SubjectPane.sem.setSelectedItem("Zimski");
				//Iskace dijalog za unos studenta
				SubjectPane sSP=new SubjectPane();  
				sSP.ispisDijaloga(1,0);
				
				//Rasciscavanje stare tabele
				MyApp.f.remove(ActionSubject.jsp);
				
				//Prikaz nove tabele s dodatim studentom
				JTable tableNew=ShowTable.showEntityTable(3);
				tableNew.setRowSelectionAllowed(true);
				ActionSubject.subjTableTemp=tableNew;
				
				ActionSubject.jsp=new JScrollPane(tableNew);
				MyApp.f.add(ActionSubject.jsp);
		
	}

}
