package manageEntities.student;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;

import gui.MainFrame;


public class SearchStudentAction implements DocumentListener{

	@Override
	public void insertUpdate(DocumentEvent e) {
		search(MainFrame.searchField.getText());
		
	}
	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		search(MainFrame.searchField.getText());
	}
	@Override
	public void changedUpdate(DocumentEvent e) {
		search(MainFrame.searchField.getText());
		
	}
	
	protected void search(String str) {
		if (str.length() == 0) {
               MyStudentActions.sorter.setRowFilter(null);
            } else {
            	MyStudentActions.sorter.setRowFilter(RowFilter.regexFilter(str));
            }
	}
	

}
