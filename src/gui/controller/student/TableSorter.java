package gui.controller.student;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import gui.controller.ShowTable;

public class TableSorter {
	 public static TableRowSorter<TableModel> sorter1 = new TableRowSorter<TableModel>();
	    public static void getSorter() {
	    	
	    	//sortiranje prema ciframa
	    	Comparator<?> cID=new Comparator<Object>() {

				@Override
				public int compare(Object oo1, Object oo2) {
		                String o1 = oo1.toString(), o2 = oo2.toString();
		                return Integer.valueOf(o1).compareTo(Integer.valueOf(o2));
				}
	    		
	    	};
	    	
	    	//sortiranje prema ciframa u indeksu
	    	Comparator<?> cIndex=new Comparator<Object>() {

				@Override
				public int compare(Object oo1, Object oo2) {
					int retVal=-1;
					String o1 = oo1.toString(), o2 = oo2.toString();
					Pattern p = Pattern.compile("^\\D+\\s?(\\d*)");
					Matcher m1 = p.matcher(o1);
					Matcher m2 = p.matcher(o2);
					if(m1.find()) {
						if(m2.find()) {
							retVal=Integer.valueOf(m1.group(1)).compareTo(Integer.valueOf(m2.group(1)));
						}
						
					}
					return retVal;
				}
	    		
	    	};
	    	
	    	
	    	ShowTable.getStudTable().setRowSorter(sorter1);
	    	sorter1.setModel(ShowTable.getStudTable().getModel());
	    	sorter1.setComparator(0,cID);
	    	sorter1.setComparator(1, cIndex);
	    	
	    	TableRowSorter<TableModel> sorter2 = new TableRowSorter<TableModel>();
	    	ShowTable.getSubjTable().setRowSorter(sorter2);
	    	sorter2.setModel(ShowTable.getSubjTable().getModel());
	    	sorter2.setComparator(0,cID);
			
	    	TableRowSorter<TableModel> sorter3 = new TableRowSorter<TableModel>();
			ShowTable.getProfTable().setRowSorter(sorter3);
			sorter3.setModel(ShowTable.getProfTable().getModel());
			sorter3.setComparator(0,cID);
	    }
}
