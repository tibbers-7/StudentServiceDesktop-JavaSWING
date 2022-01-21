package gui.controller.professor;

import gui.controller.RemoveActions;
import gui.view.MainFrame;

public class MyProfessorActions {

	public static void actionsProfessor() {
		
		RemoveActions.removeActions();

		//----------------------------------------------------------------------
				//Dodavanje novih akcija


				MainFrame.toolbar.getBtnEdit().addActionListener(MainFrame.aEProf);
			    MainFrame.menu.get_edit2().addActionListener(MainFrame.aEProf);
	}

}
