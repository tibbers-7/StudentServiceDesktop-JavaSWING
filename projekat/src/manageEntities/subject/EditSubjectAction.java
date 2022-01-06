package manageEntities.subject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;

import gui.MainFrame;
import gui.ShowTable;

public class EditSubjectAction implements ActionListener{

	public static int selRow=0;
	private JTable tableNew=new JTable();
	@Override
	public void actionPerformed(ActionEvent e) {
		//Dobavljanje kliknutog reda i dalji rad s njom
		
			selRow=MainFrame.selRowSubj+1;
			System.out.printf("selRow= "+selRow);
			
			SubjectDialog sp=EditSubjectDialogUpdate.editClick(selRow);
			if (sp!=null) {
				sp.ispisDijaloga(2,selRow);
			}
			
			tableNew=ShowTable.showEntityTable(3);
			tableNew.setRowSelectionAllowed(true);
			
			MainFrame.subjTable=tableNew;
			MainFrame.updateTableSubj();
			
	}

}
