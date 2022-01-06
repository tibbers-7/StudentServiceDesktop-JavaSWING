package manageEntities.student;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import gui.MainFrame;
import gui.MyApp;
import gui.MyStudentPanel;
import gui.ShowTable;
import model.Student;

public class DeleteStudentAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		int selRow=EditStudentDialogUpdate.rowClick(MainFrame.studTable);
		DeleteStudentDialog.delMessage(selRow);
		
		MainFrame.tableModelStud.removeRow(selRow-1);
		JTable tableNew=ShowTable.showEntityTable(1);
		tableNew.setRowSelectionAllowed(true);
		
		MainFrame.studTable=tableNew;
		MainFrame.updateTableStud();
	
		
	}

}
