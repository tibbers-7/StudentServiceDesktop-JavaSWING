package manageEntities.subject;


import gui.MainFrame;
import gui.ShowTable;

public class MySubjectActions{


	public static NewSubjectAction aNSubj=new NewSubjectAction();
	public static EditSubjectAction aESubj=new EditSubjectAction();
//	public static DeleteSubjectAction aDSubj=new DeleteSubjectAction();



	public static void actionsSubject() {


		//Brisanje nepozeljnih akcija
		MainFrame.toolbar.getBtnNew().removeActionListener(MainFrame.aNStud);
		MainFrame.toolbar.getBtnEdit().removeActionListener(MainFrame.aEStud);
		MainFrame.toolbar.getBtnDelete().removeActionListener(MainFrame.aDStud);

		MainFrame.menu.get_new().removeActionListener(MainFrame.aNStud);
		MainFrame.menu.get_edit2().removeActionListener(MainFrame.aEStud);
		MainFrame.menu.get_delete().removeActionListener(MainFrame.aDStud);

//----------------------------------------------------------------------
		//Dodavanje novih akcija


		MainFrame.toolbar.getBtnNew().addActionListener(MainFrame.aNSubj);
		MainFrame.toolbar.getBtnEdit().addActionListener(MainFrame.aESubj);
//		MainFrame.toolbar.getBtnDelete().addActionListener(MainFrame.aDSubj);

		MainFrame.menu.get_new().addActionListener(MainFrame.aNSubj);
		MainFrame.menu.get_edit2().addActionListener(MainFrame.aNSubj);
//		MainFrame.menu._delete.addActionListener(MainFrame.aDSubj);

		ShowTable.updateTableSubj();
	}


}
