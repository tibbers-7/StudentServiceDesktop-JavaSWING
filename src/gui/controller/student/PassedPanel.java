package gui.controller.student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import gui.controller.ClassNameHere;
import gui.controller.databases.SubjectDatabase;
import gui.model.Grade;
import gui.model.Student;
import gui.model.Subject;
//Panel polozenih ispita
public class PassedPanel extends JPanel{

	private static final long serialVersionUID = 1819271889090868805L;
	private static JTable tableInstance=null;

	public static JButton b=new JButton();
	protected String string;
	protected boolean found=false;
	public static JLabel avgGrade=new JLabel();
	public static JLabel espbSum=new JLabel();
	public static JScrollPane jsp=new JScrollPane();


	public static JTable getInstanceTable(Student s) {
		if (tableInstance==null) {
			tableInstance=s.getPassedTable();
		}return tableInstance;
	}

	public static void refreshTable(Student s) {
		tableInstance=s.getPassedTable();
	}

	public static void setTable(JTable table) {
		tableInstance=table;
	}

	public PassedPanel(Student s) {
		b=new JButton("Poništi ocenu");
		jsp=new JScrollPane(StudentDialog.passedTable);
		add(jsp);
		
		s.writePassedGrades();
		 //Akcija za ponistavanje ocene
		   ActionListener invGrade=new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if(StudentDialog.selRowPassed==-1) {
					string="Ispit nije izabran!";
					ClassNameHere.infoBox(string, "Obaveštenje");
					return;
				}
						//zapamti vrednosti
						int selKeep=StudentDialog.selRowPassed;
						JTable myPTable=StudentDialog.passedTable;
						String subjKey=(String)StudentDialog.passedTable.getValueAt(selKeep, 0);

						//nadji predmet
						Subject subj=SubjectDatabase.findByKey(subjKey);
						int size=StudentDialog.failedTable.getRowCount();

						//unesi u tabelu nepolozenih
						((DefaultTableModel)StudentDialog.failedTable.getModel()).insertRow(size,new Object[] {myPTable.getValueAt(selKeep, 0),myPTable.getValueAt(selKeep, 1),myPTable.getValueAt(selKeep, 2),subj.getSemester()});

						//unesi u bazu
						s.removePassedExam(subj);
						Grade fGrade=new Grade(s,subj);
						s.addFailedExam(fGrade);
						

						string="Uspesno poništen ispit!";
						ClassNameHere.infoBox(string, "Obaveštenje");
						((DefaultTableModel)StudentDialog.passedTable.getModel()).removeRow(selKeep);

						
						StudentDialog.updateExamTable();
						StudentDialog.updatePassedPanel(s,1);
//						ShowTable.refreshStudTable();
//						ShowTable.updateTableStud();

					}

//
		   };
		   b.addActionListener(invGrade);
		   

		   add(b);

		   String avg="Prosek: "+Double.toString(s.getAverageGrade());
		   String espb="Ukupno ESPB: "+Integer.toString(s.getEspb());
		   avgGrade=new JLabel(avg);
		   espbSum=new JLabel(espb);
		   add(avgGrade);
		   add(espbSum);


	}


}
