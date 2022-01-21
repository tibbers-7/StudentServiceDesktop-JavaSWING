package gui.controller.student;

import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import gui.controller.RemoveActions;
import gui.controller.ShowTable;
import gui.view.MainFrame;


// Podesavanje akcija kad je upaljen tab studenti

public class MyStudentActions{

	public static NewStudentAction aNStud=new NewStudentAction();
	public static EditStudentAction aEStud=new EditStudentAction();
	public static DeleteStudentAction aDStud=new DeleteStudentAction();
	public static DocumentListener findStudent;

	public static TableRowSorter<DefaultTableModel> sorter;



	public static void actionsStudent() {

		MainFrame.p1.revalidate();
		MainFrame.p1.repaint();



		//Brisanje nepozeljnih akcija
		RemoveActions.removeActions();

//----------------------------------------------------------------------
		//Dodavanje novih akcija


		MainFrame.toolbar.getBtnNew().addActionListener(MainFrame.aNStud);
		MainFrame.toolbar.getBtnEdit().addActionListener(MainFrame.aEStud);
		MainFrame.toolbar.getBtnDelete().addActionListener(MainFrame.aDStud);
	     MainFrame.menu.get_new().addActionListener(MainFrame.aNStud);
	     MainFrame.menu.get_edit2().addActionListener(MainFrame.aEStud);
	     MainFrame.menu.get_delete().addActionListener(MainFrame.aDStud);

		sorter = new TableRowSorter<>(ShowTable.tableModelStud);
		ShowTable.getStudTable().setRowSorter(sorter);
		ShowTable.updateTableStud();
	    TableSorter.getSorter();
		findStudent=new FindStudent();

		MainFrame.toolbar.getSearch().getDocument().addDocumentListener(findStudent);
		ShowTable.updateTableStud();

	}





}
