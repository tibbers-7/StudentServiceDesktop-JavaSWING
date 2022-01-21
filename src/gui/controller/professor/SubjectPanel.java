package gui.controller.professor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import gui.controller.ClassNameHere;
import gui.controller.databases.SubjectDatabase;
import gui.controller.student.StudentDialog;
import gui.model.Grade;
import gui.model.Professor;
import gui.model.Student;
import gui.model.Subject;

public class SubjectPanel extends JPanel{

	private static JTable tableInstance=null;

	JButton bAdd=new JButton();
	JButton bDlt=new JButton();
	public static JComboBox newSubj=new JComboBox();


	protected String string;
	protected boolean found=false;
	public static JLabel avgGrade=new JLabel();
	public static JLabel espbSum=new JLabel();
	ActionListener invGrade;
	
	private static JPanel addSubj=new JPanel();



	public static JTable getInstanceTable(Student s) {
		if (tableInstance==null) {
			tableInstance=s.getPassedTable();
		}return tableInstance;
	}

	public static void setTable(JTable table) {
		tableInstance=table;
	}

	public
	SubjectPanel(Professor p) {
		bAdd=new JButton("Dodaj predmet");
		bDlt=new JButton("Obriši predmet");


		 //Akcija za brisanje predmeta s prof
		   ActionListener invSubject=new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
		
								//zapamti vrednosti
		//						ProfessorDialog.subjectTable=p.getSubjectTable();
								int selKeep=ProfessorDialog.selRowSubject;
								JTable myPTable=ProfessorDialog.subjectTable;
								String hStr=(String)ProfessorDialog.subjectTable.getValueAt(selKeep, 0);
		
								//nadji predmet
								Subject subj=SubjectDatabase.findByKey(hStr);
		
								//izbrisi iz tabele
								((DefaultTableModel)ProfessorDialog.subjectTable.getModel()).removeRow(selKeep);
		
								//TODO: unesi u opcije
		
		
								//unesi u bazu
								p.removeSubject(subj);
		
								string="Uspesno poništen predmet!";
								ClassNameHere.infoBox(string, "Obaveštenje");
		
								ProfessorDialog.updateTable();
		
							}


		   };
		   
		   //Dijalog za dodavanje
		   addSubj=new JPanel();
		   String[] subjOptions=p.getUnaffiliatedSubj();
		   newSubj=new JComboBox(subjOptions);
		   addSubj.add(newSubj);

		   
		   //Akcija za dodavanje predmeta
		   ActionListener addSubjAction=new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						String nazivDijaloga="Dodaj Predmet";
						int option = JOptionPane.showConfirmDialog(null, addSubj, nazivDijaloga, JOptionPane.OK_CANCEL_OPTION);
						
						if(option==0) {
							 String strSubj=(String) newSubj.getSelectedItem();	//Uzmi selektovan string iz comboboxa
							 Subject subj=ProfessorDialog.getSubjRegex(strSubj,p); //Na osnovu njega nadji asociran predmet

							 p.addSubject(subj);	//dodaj u bazu

							 
							 //dodaj ga u tabelu
							 int size=ProfessorDialog.subjectTable.getRowCount(); //dobavi velicinu tabele
							((DefaultTableModel)ProfessorDialog.subjectTable.getModel()).insertRow(size,new Object[] {subj.getSubjectKey(),subj.getName(),subj.getYear(),subj.getSemester()});
							 string="Uspešno dodat predmet";
							ClassNameHere.infoBox(string, "Obaveštenje");

							//Izmeni combobox
							newSubj.removeItem(strSubj);
							ProfessorDialog.updateTable();

							
						}
					}
			   
		   };

		   bAdd.addActionListener(addSubjAction);
		   bDlt.addActionListener(invSubject);
		   add(new JScrollPane(ProfessorDialog.subjectTable));

		   add(bAdd);
		   add(bDlt);


	}

}
