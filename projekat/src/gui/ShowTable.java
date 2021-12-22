package gui;

import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import manageEntities.student.StudentDatabase;
import model.Professor;
import model.Student;
import model.Subject;
public class ShowTable {

	public static JTable showEntityTable(int index) {
		

	    Object cols[]= null;
	    ArrayList<Object> entities= new ArrayList<Object>();
	    Student s= new Student();
	    Professor p=new Professor();
	    Subject subj=new Subject();
	    
	    //Zavisi od toga koja tabela je upaljena
	    switch(index) {
	    case 1: 
	    	entities= StudentDatabase.getListOfEntites();
		    cols= s.getColumns();
		    break;
	    case 2:
	    	entities=p.getListOfEntites();
	    	cols= p.getColumns();
		    break;
		case 3:
			entities=subj.getListOfEntites();
	    	cols=subj.getColumns();
	    	break;
	    }
	    
	    
	    //Potrebno za inicijalizovanje Object[][]
	    int largestRowSize=0;
	    
	    //Stavljanje svih entiteta i njihovih polja u listu
	    ArrayList<ArrayList<Object>> temp=new ArrayList<ArrayList<Object>>();
	    int i=0;
	    for (Object It: entities) {
	    	ArrayList<Object> data=new ArrayList<Object>();
	    	Object[] entityData = Student.getData(It);
	    	int j=0;
		    for (Object It2:entityData) {
		    	data.add(It2);
		    	j++;
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
	    
		JTable table = new JTable(rowData,cols);
//	    JScrollPane scrollPane = new JScrollPane(table);
	    return table;
	}
}
