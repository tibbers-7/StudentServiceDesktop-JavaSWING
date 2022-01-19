package manageEntities.subject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.MainFrame;
import gui.ShowTable;

public class MenuBarActionSubject implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {

		MainFrame.tp.setSelectedIndex(1);
		ShowTable.updateTableSubj();

		MySubjectActions.actionsSubject();

	}

}
