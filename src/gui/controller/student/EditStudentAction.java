package gui.controller.student;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.controller.ShowTable;
import gui.controller.databases.StudentDatabase;
import gui.model.Student;
import gui.view.MainFrame;

public class EditStudentAction implements ActionListener {
	public static String key;
	public static int selRow=-1;

	@Override
	public void actionPerformed(ActionEvent e) {

		if(MainFrame.selRowStud==-1) {
			return;
		}
		selRow=MainFrame.selRowStud;
		Student s=StudentDatabase.findByID(selRow+1);
		s.writePassedGrades();
		key=(String)ShowTable.getStudTable().getValueAt(MainFrame.selRowStud,0);
		StudentDialog.updatePassedPanel(StudentDatabase.findByID(Integer.parseInt(key)), 1);
		
		
		
		MainFrame.spEdit=EditStudentDialogUpdate.editClick(Integer.parseInt(key));

		if (MainFrame.spEdit!=null) {
			MainFrame.spEdit.ispisDijaloga(2);
		}
		
		s.writePassedGrades();
		ShowTable.updateTableStud();
		ShowTable.getStudTable().setRowSelectionAllowed(true);

		StudentDialog.updatePassedPanel(StudentDatabase.findByID(Integer.parseInt(key)), 0);
		MainFrame.refreshTP(1);



	}

}
