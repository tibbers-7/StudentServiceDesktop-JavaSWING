package manageEntities.student; 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.MainFrame;


public class MenuBarActionStudent implements ActionListener{
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		MainFrame.tp.setSelectedIndex(0);
		MainFrame.updateTableStud();
		
		MyStudentActions.actionsStudent();
		
		
		

		
	}
	
	
};
		
