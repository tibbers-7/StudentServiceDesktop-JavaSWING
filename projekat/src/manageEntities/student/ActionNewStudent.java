package manageEntities.student;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import gui.MyApp;
import gui.ShowTable;

public class ActionNewStudent implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		//Vracam u default stanje
		StudentPane.status.setSelectedItem("Budzet");
		StudentPane.currentStudyYear.setSelectedItem("I (prva)");
		StudentPane sOp=new StudentPane();  
		sOp.ispisDijaloga(1,0);
		
		//Rasciscavanje stare tabele
		MyApp.f.remove(ActionStudent.jsp);
		
		//Prikaz nove tabele s dodatim studentom
		JTable tableNew=ShowTable.showEntityTable(1);
		tableNew.setRowSelectionAllowed(true);
		ActionStudent.studTableTemp=tableNew;
		
		ActionStudent.jsp=new JScrollPane(tableNew);
		MyApp.f.add(ActionStudent.jsp);
		
	}

}
