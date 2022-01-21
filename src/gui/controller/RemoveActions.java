package gui.controller;

import gui.view.MainFrame;

public class RemoveActions {

	public static void removeActions() {
		
		//PREDMET
		MainFrame.toolbar.getBtnNew().removeActionListener(MainFrame.aNSubj);
		MainFrame.toolbar.getBtnEdit().removeActionListener(MainFrame.aESubj);
//		MainFrame.toolbar.getBtnDelete().removeActionListener(MainFrame.aDSubj);
		MainFrame.menu.get_new().removeActionListener(MainFrame.aNSubj);
		MainFrame.menu.get_edit2().removeActionListener(MainFrame.aNSubj);
//		MainFrame.menu._delete.removeActionListener(MainFrame.aDSubj);
		
		//STUDENT
		MainFrame.toolbar.getBtnNew().removeActionListener(MainFrame.aNStud);
		MainFrame.toolbar.getBtnEdit().removeActionListener(MainFrame.aEStud);
		MainFrame.toolbar.getBtnDelete().removeActionListener(MainFrame.aDStud);
		MainFrame.menu.get_new().removeActionListener(MainFrame.aNStud);
		MainFrame.menu.get_edit2().removeActionListener(MainFrame.aEStud);
		MainFrame.menu.get_delete().removeActionListener(MainFrame.aDStud);
		
		//PROFESOR
		MainFrame.toolbar.getBtnEdit().removeActionListener(MainFrame.aEProf);
		MainFrame.menu.get_edit2().removeActionListener(MainFrame.aEProf);
		
		//KATEDRA
		MainFrame.toolbar.getBtnEdit().removeActionListener(MainFrame.aEDep);
		MainFrame.menu.get_edit2().removeActionListener(MainFrame.aEDep);
	}
}
