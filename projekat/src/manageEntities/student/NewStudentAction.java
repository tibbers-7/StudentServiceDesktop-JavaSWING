package manageEntities.student;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import gui.MainFrame;
import gui.MyApp;
import gui.MyStudentPanel;
import gui.ShowTable;

public class NewStudentAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		//Vracam u default stanje
		StudentDialog.status.setSelectedItem("Budzet");
		StudentDialog.currentStudyYear.setSelectedItem("I (prva)");
		StudentDialog sOp=new StudentDialog();
		sOp.ispisDijaloga(1,0);
		

		
		//Prikaz nove tabele s dodatim studentom
		
		JTable tableNew=ShowTable.showEntityTable(1);
		tableNew.setRowSelectionAllowed(true);
	
		MainFrame.studTable=tableNew;
		MainFrame.updateTableStud();
		
	}

}
