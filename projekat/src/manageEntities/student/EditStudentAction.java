package manageEntities.student;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import gui.MainFrame;
import gui.MyApp;
import gui.MyStudentPanel;
import gui.ShowTable;

public class EditStudentAction implements ActionListener {

	public static int selRow=0;
	private JTable tableNew=new JTable();
	
	public static JPanel pSubj=new JPanel();
	@Override
	public void actionPerformed(ActionEvent e) {

		
		selRow=MainFrame.selRowStud+1;
		StudentDialog sp=EditStudentDialogUpdate.editClick(selRow);

		
		System.out.printf("\n selRow= "+selRow);
		if (sp!=null) {
			sp.ispisDijaloga(2,selRow);
		}
		
		tableNew=ShowTable.showEntityTable(1);
		tableNew.setRowSelectionAllowed(true);
		
		MainFrame.studTable=tableNew;
		MainFrame.updateTableStud();
		

		
	}

}
