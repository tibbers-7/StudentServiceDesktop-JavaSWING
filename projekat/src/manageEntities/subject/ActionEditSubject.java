package manageEntities.subject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import gui.MyApp;
import gui.ShowTable;

public class ActionEditSubject implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		//Dobavljanje kliknutog reda i dalji rad s njom
		
				int selRow=EditSubject.rowClick(ActionSubject.subjTableTemp,MyApp.f.getEditButton());
				
				SubjectPane sp=EditSubject.editClick(selRow);
				if (sp!=null) {
					sp.ispisDijaloga(2,selRow);
				}
				
				
				MyApp.f.remove(ActionSubject.jsp);
				JTable tableNew=ShowTable.showEntityTable(3);
				tableNew.setRowSelectionAllowed(true);
				ActionSubject.subjTableTemp=tableNew;
				
				ActionSubject.jsp=new JScrollPane(tableNew);
				
				MyApp.f.add(ActionSubject.jsp);
		
	}

}
