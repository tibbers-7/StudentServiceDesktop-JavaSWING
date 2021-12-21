package tableInterfaces;

import java.util.ArrayList;

import javax.swing.JScrollPane;

import model.Professor;
import model.Student;

public interface GetTableData<T> {
	
	Object[] getColumns();
	boolean addEntity(T t);
	ArrayList<Object> getListOfEntites();
}
