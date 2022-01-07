package manageEntities.student;

import gui.ShowTable;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;

import gui.MainFrame;

public class MyStudentActions{
	
	public static NewStudentAction aNStud=new NewStudentAction();
	public static EditStudentAction aEStud=new EditStudentAction();
	public static DeleteStudentAction aDStud=new DeleteStudentAction();
	public static SearchStudentAction asStud=new SearchStudentAction();
	
	public static TableRowSorter sorter;
	

	
	public static void actionsStudent() {
		
		MainFrame.p1.revalidate();
		MainFrame.p1.repaint();
		
		
		MainFrame.selRowStud=MainFrame.studTable.getSelectedRow();
		MainFrame.studTable=ShowTable.showEntityTable(1);
		
		

		//Brisanje nepozeljnih akcija
		MainFrame.newButton.removeActionListener(MainFrame.aNSubj);
		MainFrame.editButton.removeActionListener(MainFrame.aESubj);
//		MainFrame.deleteButton.removeActionListener(MainFrame.aDSubj);
		
		MainFrame.menu._new.removeActionListener(MainFrame.aNSubj);
		MainFrame.menu._edit2.removeActionListener(MainFrame.aNSubj);
//		MainFrame.menu._delete.removeActionListener(MainFrame.aDSubj);
		
//----------------------------------------------------------------------
		//Dodavanje novih akcija
		
		
		MainFrame.newButton.addActionListener(MainFrame.aNStud);
		MainFrame.editButton.addActionListener(MainFrame.aEStud);
		MainFrame.deleteButton.addActionListener(MainFrame.aDStud);
		
		sorter = new TableRowSorter<>(MainFrame.tableModelStud);
		MainFrame.studTable=new JTable(MainFrame.tableModelStud);
	     MainFrame.studTable.setRowSorter(sorter);
	     MainFrame.updateTableStud();
		MainFrame.searchField.getDocument().addDocumentListener(asStud);
		
		
		MainFrame.menu._new.addActionListener(MainFrame.aNStud);
		MainFrame.menu._edit2.addActionListener(MainFrame.aEStud);
		MainFrame.menu._delete.addActionListener(MainFrame.aDStud);
		
		
		
		MainFrame.updateTableStud();
		
	}
	
	
	
	
	
};
