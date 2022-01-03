package manageEntities.student;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import gui.MainFrame;
import gui.MyApp;
import gui.MyStudentPanel;
import gui.ShowTable;
import model.Student;

public class DeleteStudentAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		int selRow=EditStudentDialogUpdate.rowClick(MyStudentPanel.studTable);
		DeleteStudentDialog.delMessage(selRow);
		
		JTable tableNew=ShowTable.showEntityTable(1);
		tableNew.setRowSelectionAllowed(true);
		
		MyStudentPanel.studTable=tableNew;
		MyStudentPanel.updateTable();
	
		
	}

}
