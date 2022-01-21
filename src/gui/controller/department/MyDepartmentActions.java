package gui.controller.department;

import gui.controller.RemoveActions;
import gui.view.MainFrame;

public class MyDepartmentActions {

	public static void actionsDepartment() {
		// TODO Auto-generated method stub
		RemoveActions.removeActions();
		
		MainFrame.toolbar.getBtnEdit().addActionListener(MainFrame.aEDep);
	    MainFrame.menu.get_edit2().addActionListener(MainFrame.aEDep);
	}

}
