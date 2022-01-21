package gui.controller.student;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.controller.ShowTable;
import gui.controller.databases.StudentDatabase;
import gui.view.MainFrame;

public class EditStudentAction implements ActionListener {
	public static String key;

	@Override
	public void actionPerformed(ActionEvent e) {


//		ShowTable.refreshStudTable();
		if(MainFrame.selRowStud==-1) {
			return;
		}
		key=(String)ShowTable.getStudTable().getValueAt(MainFrame.selRowStud,0);
		StudentDialog.updatePassedPanel(StudentDatabase.findByID(MainFrame.selRowStud), 1);
		
		
		
		MainFrame.spEdit=EditStudentDialogUpdate.editClick(Integer.parseInt(key));

		if (MainFrame.spEdit!=null) {
			MainFrame.spEdit.ispisDijaloga(2);
		}
//		//1
		System.out.printf("\n EditStudentAction l30:");
		StudentDatabase.findByID(Integer.parseInt(key)).writePassedGrades();
	
		ShowTable.updateTableStud();
		ShowTable.getStudTable().setRowSelectionAllowed(true);

		StudentDialog.updatePassedPanel(StudentDatabase.findByID(Integer.parseInt(key)), 0);
		MainFrame.refreshTP(1);



	}

}
