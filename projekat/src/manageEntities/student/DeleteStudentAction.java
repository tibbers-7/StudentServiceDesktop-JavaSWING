package manageEntities.student;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;

import gui.MainFrame;
import gui.ShowTable;

public class DeleteStudentAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		int selRow=MainFrame.selRowStud+1;
		DeleteStudentDialog.delMessage(selRow);
		
		
		MainFrame.tableModelStud.removeRow(selRow-1);
		StudentDatabase.decrementIDs();
		
		// TODO: ispraviti ovo da se prikazuje izmena id
		ShowTable.refreshStudTable();
		MainFrame.updateTableStud();
	
		
	}

}
