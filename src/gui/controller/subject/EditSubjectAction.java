package gui.controller.subject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.controller.ShowTable;
import gui.view.MainFrame;

public class EditSubjectAction implements ActionListener{


	public static String key;
	@Override
	public void actionPerformed(ActionEvent e) {
		//Dobavljanje kliknutog reda i dalji rad s njom

		key=(String)ShowTable.getSubjTable().getValueAt(MainFrame.selRowSubj,0);
		System.out.printf("\n"+key);

		SubjectDialog sp=EditSubjectDialogUpdate.editClick(Integer.parseInt(key));
			if (sp!=null) {
				sp.ispisDijaloga(2);
			}

		ShowTable.refreshSubjTable();
		ShowTable.updateTableSubj();

		MainFrame.refreshTP(2);

	}

}
