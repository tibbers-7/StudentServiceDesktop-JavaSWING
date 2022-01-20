package gui.controller.student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.controller.ShowTable;
import gui.view.MainFrame;

// Sta se desi kad se klikne na meni->student (upali se tab)

public class MenuBarActionStudent implements ActionListener{



	@Override
	public void actionPerformed(ActionEvent e) {

		MainFrame.tp.setSelectedIndex(0);
		ShowTable.updateTableStud();

		MyStudentActions.actionsStudent();





	}


}

