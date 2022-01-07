package manageEntities.student;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.MainFrame;
import gui.ShowTable;

public class NewStudentAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		//Vracam u default stanje
		StudentDialog.status.setSelectedItem("Budzet");
		StudentDialog.currentStudyYear.setSelectedItem("I (prva)");
		StudentDialog sOp=new StudentDialog();
		sOp.ispisDijaloga(1);
		
		ShowTable.refreshStudTable();
		MainFrame.updateTableStud();
		
	}

}
