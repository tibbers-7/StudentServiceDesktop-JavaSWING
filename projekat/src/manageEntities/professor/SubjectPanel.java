package manageEntities.professor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import manageEntities.ClassNameHere;
import manageEntities.student.StudentDialog;
import manageEntities.subject.SubjectDatabase;
import model.Professor;
import model.Student;
import model.Subject;

public class SubjectPanel extends JPanel{

	private static JTable tableInstance=null;

	JButton bAdd=new JButton();
	JButton bDlt=new JButton();

	protected String string;
	protected boolean found=false;
	public static JLabel avgGrade=new JLabel();
	public static JLabel espbSum=new JLabel();
	ActionListener invGrade;



	public static JTable getInstanceTable(Student s) {
		if (tableInstance==null) {
			tableInstance=Student.getPassedTable(s);
		}return tableInstance;
	}

	public static void setTable(JTable table) {
		tableInstance=table;
	}

	public
	SubjectPanel(Professor p) {
		bAdd=new JButton("Dodaj predmet");
		bDlt=new JButton("Obriši predmet");


		 //Akcija za ponistavanje ocene
		   ActionListener invSubject=new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

						//zapamti vrednosti
						ProfessorDialog.subjectTable=p.getSubjectTable();
						int selKeep=ProfessorDialog.selRowSubject;
						JTable myPTable=ProfessorDialog.subjectTable;
						String hStr=(String)myPTable.getValueAt(selKeep, 0);

						//nadji predmet
						Subject subj=SubjectDatabase.findByKey(hStr);

						//izbrisi iz tabele
						((DefaultTableModel)ProfessorDialog.subjectTable.getModel()).removeRow(selKeep);

						//TODO: unesi u opcije


						//unesi u bazu
						p.removeSubject(subj);

						string="Uspesno poništen predmet!";
						ClassNameHere.infoBox(string, "Obaveštenje");



						ProfessorDialog.updateExamTable();
						ProfessorDialog.updateSubjectPanel(p);

					}

//
		   };


		   bDlt.addActionListener(invGrade);
		   add(new JScrollPane(StudentDialog.passedTable));

		   add(bDlt);


	}

}
