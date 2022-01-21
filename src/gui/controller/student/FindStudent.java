package gui.controller.student;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import gui.view.MainFrame;

public class FindStudent implements DocumentListener{
	@Override
	public void insertUpdate(DocumentEvent e) {
		String text = MainFrame.toolbar.getSearch().getText();

        if (text.trim().length() == 0) {
            TableSorter.sorter1.setRowFilter(null);
        } else {
        	TableSorter.sorter1.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		String text = MainFrame.toolbar.getSearch().getText();

        if (text.trim().length() == 0) {
        	TableSorter.sorter1.setRowFilter(null);
        } else {
        	TableSorter.sorter1.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }

	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
