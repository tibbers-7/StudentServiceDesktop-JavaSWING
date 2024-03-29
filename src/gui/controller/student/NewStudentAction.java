package gui.controller.student;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.controller.ShowTable;
import gui.view.MainFrame;

public class NewStudentAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		//Dobavljanje dijaloga za novog studenta
		StudentDialog sD=new StudentDialog();
		sD.status.setSelectedItem("Budzet"); 			//refresh comboboxeva
		sD.currentStudyYear.setSelectedItem("I (prva)");

		sD.ispisDijaloga(1);

		ShowTable.refreshStudTable();
		ShowTable.updateTableStud();

		MainFrame.refreshTP(1);

	}

}
