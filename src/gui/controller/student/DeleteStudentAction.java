package gui.controller.student;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.controller.ShowTable;
import gui.view.MainFrame;

public class DeleteStudentAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		DeleteStudentDialog.delMessage(MainFrame.selRowStud+1);


		ShowTable.tableModelStud.removeRow(MainFrame.selRowStud);

		ShowTable.refreshStudTable();
		ShowTable.updateTableStud();

		MainFrame.refreshTP(1);



	}

}
