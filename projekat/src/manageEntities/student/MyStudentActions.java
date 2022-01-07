package manageEntities.student;

import gui.ShowTable;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import gui.MainFrame;


// Podesavanje akcija kad je upaljen tab studenti
// 
// VODITI RACUNA DA SE STARE AKCIJE OBRISU PRE POZIVANJA NOVIH
// (zato sam napravila kao globalno polje, da mogu lako da se obrisu)
public class MyStudentActions{
	
	public static NewStudentAction aNStud=new NewStudentAction();
	public static EditStudentAction aEStud=new EditStudentAction();
	public static DeleteStudentAction aDStud=new DeleteStudentAction();
	public static DocumentListener findStudent;

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
		
		MainFrame.menu.get_new().removeActionListener(MainFrame.aNSubj);
		MainFrame.menu.get_edit2().removeActionListener(MainFrame.aNSubj);
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
		
		
		
		MainFrame.menu.get_new().addActionListener(MainFrame.aNStud);
		MainFrame.menu.get_edit2().addActionListener(MainFrame.aEStud);
		MainFrame.menu.get_delete().addActionListener(MainFrame.aDStud);
		
		TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(MainFrame.tableModelStud);
	    ShowTable.getStudTable().setRowSorter(rowSorter);
		
		
		findStudent=new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				String text = MainFrame.searchField.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String text = MainFrame.searchField.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				throw new UnsupportedOperationException("Not supported yet.");
			}
			
		};
		
		MainFrame.searchField.getDocument().addDocumentListener(findStudent);
		MainFrame.updateTableStud();
		
	}
	
	
	
	
	
};
