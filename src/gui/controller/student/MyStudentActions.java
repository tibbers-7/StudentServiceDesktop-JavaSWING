package gui.controller.student;

import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import gui.controller.ShowTable;
import gui.view.MainFrame;


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



		//Brisanje nepozeljnih akcija
		MainFrame.toolbar.getBtnNew().removeActionListener(MainFrame.aNSubj);
		MainFrame.toolbar.getBtnEdit().removeActionListener(MainFrame.aESubj);
//		MainFrame.toolbar.getBtnDelete().removeActionListener(MainFrame.aDSubj);

		MainFrame.menu.get_new().removeActionListener(MainFrame.aNSubj);
		MainFrame.menu.get_edit2().removeActionListener(MainFrame.aNSubj);
//		MainFrame.menu._delete.removeActionListener(MainFrame.aDSubj);

//----------------------------------------------------------------------
		//Dodavanje novih akcija


		MainFrame.toolbar.getBtnNew().addActionListener(MainFrame.aNStud);
		MainFrame.toolbar.getBtnEdit().addActionListener(MainFrame.aEStud);
		MainFrame.toolbar.getBtnDelete().addActionListener(MainFrame.aDStud);

		sorter = new TableRowSorter<>(ShowTable.tableModelStud);
		ShowTable.getStudTable().setRowSorter(sorter);
	     ShowTable.updateTableStud();



	     MainFrame.menu.get_new().addActionListener(MainFrame.aNStud);
	     MainFrame.menu.get_edit2().addActionListener(MainFrame.aEStud);
	     MainFrame.menu.get_delete().addActionListener(MainFrame.aDStud);

		TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(ShowTable.tableModelStud);
	    ShowTable.getStudTable().setRowSorter(rowSorter);


		findStudent=new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				String text = MainFrame.toolbar.getSearch().getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String text = MainFrame.toolbar.getSearch().getText();

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

		MainFrame.toolbar.getSearch().getDocument().addDocumentListener(findStudent);
		ShowTable.updateTableStud();

	}





}
