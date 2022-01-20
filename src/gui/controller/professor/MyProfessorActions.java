package gui.controller.professor;

import gui.view.MainFrame;

public class MyProfessorActions {

	public static void actionsProfessor() {
		MainFrame.toolbar.getBtnNew().removeActionListener(MainFrame.aNSubj);
		MainFrame.toolbar.getBtnEdit().removeActionListener(MainFrame.aESubj);
//		MainFrame.toolbar.getBtnDelete().removeActionListener(MainFrame.aDSubj);
		MainFrame.menu.get_new().removeActionListener(MainFrame.aNSubj);
		MainFrame.menu.get_edit2().removeActionListener(MainFrame.aNSubj);
//		MainFrame.menu._delete.removeActionListener(MainFrame.aDSubj);

		MainFrame.toolbar.getBtnNew().removeActionListener(MainFrame.aNStud);
		MainFrame.toolbar.getBtnEdit().removeActionListener(MainFrame.aEStud);
		MainFrame.toolbar.getBtnDelete().removeActionListener(MainFrame.aDStud);
		MainFrame.menu.get_new().removeActionListener(MainFrame.aNStud);
		MainFrame.menu.get_edit2().removeActionListener(MainFrame.aEStud);
		MainFrame.menu.get_delete().removeActionListener(MainFrame.aDStud);

		//----------------------------------------------------------------------
				//Dodavanje novih akcija


				MainFrame.toolbar.getBtnEdit().addActionListener(MainFrame.aEProf);
			    MainFrame.menu.get_edit2().addActionListener(MainFrame.aEProf);
	}

}
