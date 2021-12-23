package manageEntities.student;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import gui.MyApp;
import gui.ShowTable;
import model.Student;

public class ActionDeleteStudent implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		int selRow=EditStudent.rowClick(ActionStudent.studTableTemp,MyApp.f.getEditButton());
		System.out.printf("SelRow= %s\n",selRow);
		Student pera=StudentDatabase.findByID(selRow);
		System.out.printf("Ime: %s",pera.getName());
		DeletePane.delMessage(selRow);
		
		JTable tableNew=ShowTable.showEntityTable(1);
		tableNew.setRowSelectionAllowed(true);
		ActionStudent.studTableTemp=tableNew;
		
		MyApp.f.remove(ActionStudent.jsp);
		ActionStudent.jsp=new JScrollPane(tableNew);
		MyApp.f.add(ActionStudent.jsp);
		
	}

}
