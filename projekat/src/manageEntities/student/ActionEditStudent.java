package manageEntities.student;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import gui.MyApp;
import gui.ShowTable;

public class ActionEditStudent implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		int selRow=EditStudent.rowClick(ActionStudent.studTableTemp,MyApp.f.getEditButton());
		StudentPane sp=EditStudent.editClick(selRow);
		if (sp!=null) {
			sp.ispisDijaloga(2,selRow);
		}
		
		MyApp.f.remove(ActionStudent.jsp);
		JTable tableNew=ShowTable.showEntityTable(1);
		tableNew.setRowSelectionAllowed(true);
		ActionStudent.studTableTemp=tableNew;
		
		ActionStudent.jsp=new JScrollPane(tableNew);
		MyApp.f.add(ActionStudent.jsp);
	}

}
