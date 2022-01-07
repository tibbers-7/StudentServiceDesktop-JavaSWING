package tableInterfaces;

import java.util.ArrayList;

public interface GetTableData<T> {
	
	Object[] getColumns();
	boolean addEntity(T t);
	ArrayList<Object> getListOfEntites();
}
