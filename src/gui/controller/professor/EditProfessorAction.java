package gui.controller.professor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.controller.ShowTable;
import gui.view.MainFrame;

public class EditProfessorAction implements ActionListener {
	private static int key;

	@Override
	public void actionPerformed(ActionEvent e) {
		if (MainFrame.selRowProf==-1) return;
		key=(int) ShowTable.getProfTable().getValueAt(MainFrame.selRowProf,0);
		System.out.printf("\n"+key);
		MainFrame.ppEdit=EditProfessorDialogUpdate.editClick(key);

		if (MainFrame.ppEdit!=null) {
			MainFrame.ppEdit.ispisDijaloga(2);
		}
		ShowTable.updateTableStud();
		ShowTable.getStudTable().setRowSelectionAllowed(true);

		MainFrame.refreshTP(3);




	}

}