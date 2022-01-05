package manageEntities.subject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import gui.MainFrame;
import gui.MyApp;
import gui.MyStudentPanel;
import gui.MySubjectPanel;
import gui.ShowTable;
import manageEntities.student.MenuBarActionStudent;

public class NewSubjectAction implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
				SubjectDialog.sem.setSelectedItem("Zimski");
				//Iskace dijalog za unos studenta
				SubjectDialog sSP=new SubjectDialog();  
				sSP.ispisDijaloga(1,0);
				
				
				JTable tableNew=ShowTable.showEntityTable(1);
				tableNew.setRowSelectionAllowed(true);
			
				MainFrame.subjTable=tableNew;
				MainFrame.updateTableSubj();
				
		
	}

}
