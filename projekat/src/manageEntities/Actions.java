package manageEntities;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import manageEntities.student.*;
import manageEntities.subject.EditSubject;
import manageEntities.subject.SubjectPane;
import model.Student;
import gui.Frame;
import gui.ShowTable;


public class Actions {
	
	private static JTable studTableTemp=new JTable();
	private static JTable subjTableTemp=new JTable();
	private static JScrollPane jsp=new JScrollPane();
	
	public static void studentClick(Frame f) {
		f.remove(jsp);
		//Prikaz tabele
		studTableTemp=ShowTable.showEntityTable(1);
		studTableTemp.setRowSelectionAllowed(true);

		
		jsp=new JScrollPane(studTableTemp);
		f.add(jsp);
	}
	public static void newClickStudent(Frame f) {
		StudentPane sOp=new StudentPane();  
		sOp.ispisDijaloga(1,0);
		
		//Rasciscavanje stare tabele
		f.remove(jsp);
		
		//Prikaz nove tabele s dodatim studentom
		JTable tableNew=ShowTable.showEntityTable(1);
		tableNew.setRowSelectionAllowed(true);
		studTableTemp=tableNew;
		
		EditStudent.rowClick(tableNew,f.getEditButton());
		jsp=new JScrollPane(tableNew);
		f.add(jsp);
	}
	
	public static void editClickStudent(Frame f) {
		//Dobavljanje kliknutog reda i dalji rad s njom
		int selRow=EditStudent.rowClick(studTableTemp,f.getEditButton());
		StudentPane sp=EditStudent.editClick(selRow);
		sp.ispisDijaloga(2,selRow);
		
		f.remove(jsp);
		JTable tableNew=ShowTable.showEntityTable(1);
		tableNew.setRowSelectionAllowed(true);
		studTableTemp=tableNew;
		
		EditStudent.rowClick(tableNew,f.getEditButton());
		jsp=new JScrollPane(tableNew);
		f.add(jsp);
	}
	
	public static void delClickStudent(Frame f) {
		int selRow=EditStudent.rowClick(studTableTemp,f.getEditButton());
		System.out.printf("SelRow= %s\n",selRow);
		Student pera=StudentDatabase.findByID(selRow);
		System.out.printf("Ime: %s",pera.getName());
		DeletePane.delMessage(selRow);
		
		JTable tableNew=ShowTable.showEntityTable(1);
		tableNew.setRowSelectionAllowed(true);
		studTableTemp=tableNew;
		
		f.remove(jsp);
		jsp=new JScrollPane(tableNew);
		f.add(jsp);
	}
	
//-------------------------------------------------------------------------
	//SUBJECT
	
	
	public static void predmetiClick(Frame f) {
		f.remove(jsp);
		//Prikaz tabele
		subjTableTemp=ShowTable.showEntityTable(3);
		subjTableTemp.setRowSelectionAllowed(true);
		
		JScrollPane table=new JScrollPane(subjTableTemp);
		jsp=table;
		f.add(jsp);
	}
	
	public static void newClickPred(Frame f) {
		//Iskace dijalog za unos studenta
		SubjectPane sSP=new SubjectPane();  
		sSP.ispisDijaloga(1,0);
		
		//Rasciscavanje stare tabele
		f.remove(jsp);
		
		//Prikaz nove tabele s dodatim studentom
		JTable tableNew=ShowTable.showEntityTable(3);
		tableNew.setRowSelectionAllowed(true);
		subjTableTemp=tableNew;
		
		EditStudent.rowClick(tableNew,f.getEditButton());
		jsp=new JScrollPane(tableNew);
		f.add(jsp);
	}
	
	public static void editClickPred(Frame f) {
		//Dobavljanje kliknutog reda i dalji rad s njom
		int selRow=EditSubject.rowClick(subjTableTemp,f.getEditButton());
		SubjectPane sp=EditSubject.editClick(selRow);
		sp.ispisDijaloga(2,selRow);
		
		f.remove(jsp);
		JTable tableNew=ShowTable.showEntityTable(3);
		tableNew.setRowSelectionAllowed(true);
		subjTableTemp=tableNew;
		
		jsp=new JScrollPane(tableNew);
		
		f.add(jsp);
	}
	
};
		
