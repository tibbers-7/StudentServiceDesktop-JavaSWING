package manageEntities.student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import manageEntities.ClassNameHere;
import manageEntities.subject.SubjectDatabase;
import model.Grade;
import model.Student;
import model.Subject;

public class PassedPanel extends JPanel{

	private static PassedPanel instance=null;
	private static JTable tableInstance=null;

	JButton b=new JButton();
	protected String string;
	protected boolean found=false;
	public static JLabel avgGrade=new JLabel();
	public static JLabel espbSum=new JLabel();
	ActionListener invGrade;
	public static JScrollPane jsp=new JScrollPane();

	public static PassedPanel getInstance(Student s) {
		if(instance==null) {
			instance=new PassedPanel(s);
			
		} return instance;
	}

	public static JTable getInstanceTable(Student s) {
		if (tableInstance==null) {
			tableInstance=Student.getPassedTable(s);
		}return tableInstance;
	}

	public static void refreshTable(Student s) {
		tableInstance=Student.getPassedTable(s);
	}

	public static void setTable(JTable table) {
		tableInstance=table;
	}

	private PassedPanel(Student s) {
		b=new JButton("Poništi ocenu");

		 //Akcija za ponistavanje ocene
		   ActionListener invGrade=new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

						//zapamti vrednosti
						int selKeep=StudentDialog.selRowPassed;
						JTable myPTable=StudentDialog.passedTable;
						String hStr=(String)StudentDialog.passedTable.getValueAt(StudentDialog.selRowPassed, 0);

						//nadji predmet
						Subject subj=SubjectDatabase.findByKey(hStr);
						int size=StudentDialog.failedTable.getRowCount();

						//unesi u tabelu nepolozenih
						((DefaultTableModel)StudentDialog.failedTable.getModel()).insertRow(size,new Object[] {myPTable.getValueAt(selKeep, 0),myPTable.getValueAt(selKeep, 1),myPTable.getValueAt(selKeep, 2),subj.getSemester()});

						//unesi u bazu
						s.removePassedExam(subj);
						Grade fGrade=new Grade(s,subj);
						s.addFailedExam(fGrade);
						

						string="Uspesno ponisten ispit!";
						ClassNameHere.infoBox(string, "Obavestenje");
						((DefaultTableModel)StudentDialog.passedTable.getModel()).removeRow(selKeep);


						StudentDialog.updateExamTable();
						StudentDialog.updatePassedPanel(s,1);

					}

//
		   };
		   b.addActionListener(invGrade);
		   jsp=new JScrollPane(StudentDialog.passedTable);
		   add(jsp);

		   add(b);

		   String avg="Prosek: "+Double.toString(s.getAverageGrade());
		   String espb="Ukupno ESPB: "+Integer.toString(s.getEspb());
		   avgGrade=new JLabel(avg);
		   espbSum=new JLabel(espb);
		   add(avgGrade);
		   add(espbSum);


	}


}
