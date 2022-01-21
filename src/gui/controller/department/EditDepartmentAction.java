package gui.controller.department;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.controller.ShowTable;
import gui.controller.professor.EditProfessorDialogUpdate;
import gui.view.MainFrame;

public class EditDepartmentAction implements ActionListener{

	private static int key;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (MainFrame.selRowDep==-1) return;
		String selVal=(String)ShowTable.getDepTable().getValueAt(MainFrame.selRowDep,0);
		key=Integer.parseInt(selVal);
		System.out.printf("\n"+key);

		DepartmentDialog.ispisDijaloga();
		ShowTable.updateTableDep();
		ShowTable.getDepTable().setRowSelectionAllowed(true);

		MainFrame.refreshTP(4);

	}

}
