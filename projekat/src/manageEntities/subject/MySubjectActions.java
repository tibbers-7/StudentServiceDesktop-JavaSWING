package manageEntities.subject;


import gui.MainFrame;
import gui.ShowTable;

public class MySubjectActions{

	
	public static NewSubjectAction aNSubj=new NewSubjectAction();
	public static EditSubjectAction aESubj=new EditSubjectAction();
//	public static DeleteSubjectAction aDSubj=new DeleteSubjectAction();
	
	
	
	public static void actionsSubject() {
		
		MainFrame.subjTable=ShowTable.showEntityTable(3);
		//Brisanje nepozeljnih akcija
		MainFrame.newButton.removeActionListener(MainFrame.aNStud);
		MainFrame.editButton.removeActionListener(MainFrame.aEStud);
		MainFrame.deleteButton.removeActionListener(MainFrame.aDStud);
		
		MainFrame.menu.get_new().removeActionListener(MainFrame.aNStud);
		MainFrame.menu.get_edit2().removeActionListener(MainFrame.aEStud);
		MainFrame.menu.get_delete().removeActionListener(MainFrame.aDStud);
		
//----------------------------------------------------------------------
		//Dodavanje novih akcija
		
		
		MainFrame.newButton.addActionListener(MainFrame.aNSubj);
		MainFrame.editButton.addActionListener(MainFrame.aESubj);
//		MainFrame.deleteButton.addActionListener(MainFrame.aDSubj);
		
		MainFrame.menu.get_new().addActionListener(MainFrame.aNSubj);
		MainFrame.menu.get_edit2().addActionListener(MainFrame.aNSubj);
//		MainFrame.menu._delete.addActionListener(MainFrame.aDSubj);
		
		MainFrame.updateTableSubj();
	}
	
	
}
