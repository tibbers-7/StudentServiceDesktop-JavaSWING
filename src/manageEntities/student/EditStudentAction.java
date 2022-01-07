package manageEntities.student;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import gui.MainFrame;
import gui.ShowTable;

public class EditStudentAction implements ActionListener {

	
	@Override
	public void actionPerformed(ActionEvent e) {

		int selRow=MainFrame.selRowStud+1;
		StudentDialog sp=EditStudentDialogUpdate.editClick(selRow);

		if (sp!=null) {
			sp.ispisDijaloga(2);
		}
		
		ShowTable.refreshStudTable();
		MainFrame.updateTableStud();
		

		
	}

}
