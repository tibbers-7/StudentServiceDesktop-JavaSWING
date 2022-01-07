package manageEntities.student;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import gui.MainFrame;
import gui.ShowTable;

public class EditStudentAction implements ActionListener {
	public static String key;
	
	@Override
	public void actionPerformed(ActionEvent e) {

		int selRow=MainFrame.selRowStud+1;
		key=(String)ShowTable.getStudTable().getValueAt(MainFrame.selRowStud,0);
		System.out.printf("\n"+key);
		StudentDialog sp=EditStudentDialogUpdate.editClick(Integer.parseInt(key));

		if (sp!=null) {
			sp.ispisDijaloga(2);
		}
		
		ShowTable.refreshStudTable();
		MainFrame.updateTableStud();
		

		
	}

}
