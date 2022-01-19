
package gui;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import manageEntities.professor.ProfessorDatabase;
import manageEntities.student.StudentDatabase;
import manageEntities.subject.SubjectDatabase;
import model.Professor;
import model.Student;
import model.Subject;

//*********************************************************************************
//*********************************************************************************
//*********************************************************************************

		//Klasa za dobavljanje potrebne tabele putem metode showEntityTable(int sel)
		// sel=1 - STUDENT
		// sel=2 - PROFESOR (napravi iste metode za dobavljanje podataka za tabelu kao u klasi student i predmet
		// sel=3 - PREDMET

		// Tabele se instanciraju da bi se koristila samo jedna kroz ceo kod

//*********************************************************************************
//*********************************************************************************
//*********************************************************************************
public class ShowTable{

	public static JTable table=new JTable();
	private static JTable studInstance=null;
	private static JTable subjInstance=null;
	private static JTable profInstance=null;


	public static DefaultTableModel tableModelStud=new DefaultTableModel();
	public static DefaultTableModel tableModelSubj=new DefaultTableModel();
	public static DefaultTableModel tableModelProf=new DefaultTableModel();

	public static JTable getStudTable() {
		if (studInstance==null) {
			studInstance=showEntityTable(1);
		} return studInstance;
	}

	public static JTable getSubjTable() {
		if (subjInstance==null) {
			subjInstance=showEntityTable(2);
		} return subjInstance;
	}

	public static JTable getProfTable() {
		if (profInstance==null) {
			profInstance=showEntityTable(3);
		} return profInstance;
	}

	public static void refreshStudTable() {
		studInstance=showEntityTable(1);
	}

	public static void refreshSubjTable() {
		subjInstance=showEntityTable(2);
	}
	public static void refreshProfTable() {
		profInstance=showEntityTable(3);
	}

	public static JTable showEntityTable(int index) {

		table=new JTable();

	    Object cols[]= null;
	    ArrayList<Object> entities= new ArrayList<>();
	    Student s= new Student();
	    Professor p=new Professor();
	    Subject subj=new Subject();

	    //Zavisi od toga koja tabela je upaljena
	    switch(index) {
	    case 1: //STUDENT
	    	entities= StudentDatabase.getListOfEntites();
		    cols= s.getColumns();

		    break;
	    case 2: //PREDMET
	    	entities=SubjectDatabase.getListOfEntites();
	    	cols=subj.getColumns();
	    	break;
		case 3: //PROFESOR
	    	entities=ProfessorDatabase.getListOfEntities();
	    	cols= p.getColumns();
		    break;
	    }


	    //Potrebno za inicijalizovanje Object[][]
	    int largestRowSize=0;

	    //Stavljanje svih entiteta i njihovih polja u listu
	    ArrayList<ArrayList<Object>> temp=new ArrayList<>();
	    int i=0;
	    for (Object It: entities) {
	    	ArrayList<Object> data=new ArrayList<>();

	    	Object[] entityData=null;
	    	switch(index) {
	    		case 1:
	    			entityData = Student.getData(It);
	    			break;
	    		case 2:
	    			entityData=Subject.getData(It);
	    			break;
	    		case 3:
	    			entityData=Professor.getData(It);
	    	}


		    for (Object It2:entityData) {
		    	data.add(It2);
		    	if (data.size()>largestRowSize) {
		    		largestRowSize=data.size();
		    	}
		    }
		    temp.add(data);
		    i++;
	    }

	  //Stavljanje cele ArrayList u Object[][] (potrebno za tabelu)
	    Object[][] rowData= new Object[temp.size()][largestRowSize];
	    i=0;
	    for (ArrayList<Object> listO:temp) {
	    	int j=0;
	    	for (Object o:listO) {
	    		rowData[i][j]=o;
	    		j++;
	    	}
	    	i++;
	    }
	    switch(index) {
	    case 1: //STUDENT
	    	tableModelStud=new DefaultTableModel(rowData,cols);
	    	table.setModel(tableModelStud);
		    break;
	    case 2: //PREDMET
		    tableModelSubj=new DefaultTableModel(rowData,cols);
	    	table.setModel(tableModelSubj);
	    	break;
		case 3: //PROFESOR
			tableModelProf=new DefaultTableModel(rowData,cols);
	    	table.setModel(tableModelProf);
		    break;
	    }
	    table.setRowSelectionAllowed(true);
		return table;

	}

	public static void updateTableStud() {
		tableModelStud.fireTableDataChanged();
	}

	public static void updateTableSubj() {
		tableModelSubj.fireTableDataChanged();
	}

	public static void updateTableProf() {
		tableModelProf.fireTableDataChanged();
	}



}
