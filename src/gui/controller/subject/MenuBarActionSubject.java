package gui.controller.subject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.controller.ShowTable;
import gui.view.MainFrame;

public class MenuBarActionSubject implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {

		MainFrame.tp.setSelectedIndex(1);
		ShowTable.updateTableSubj();

		MySubjectActions.actionsSubject();

	}

}
