package gui.controller.subject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.controller.ShowTable;
import gui.view.MainFrame;


public class NewSubjectAction implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {

//				SubjectDialog.sem.setSelectedItem("Zimski");
				//Iskace dijalog za unos predmeta
				SubjectDialog sSP=new SubjectDialog();
				sSP.ispisDijaloga(1);


				ShowTable.refreshStudTable();
				ShowTable.updateTableStud();

				MainFrame.refreshTP(2);


	}

}
