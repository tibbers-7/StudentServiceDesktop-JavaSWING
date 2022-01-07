package manageEntities.student;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import manageEntities.ClassNameHere;
import manageEntities.subject.SubjectDatabase;
import model.Grade;
import model.Student;
import model.Subject;

public class PassedPanel extends JPanel{

	private static PassedPanel instance=null;
	private static JTable tableInstance=null;
	
	private static JTable passedTable=new JTable();
	private static JTable failedTable=new JTable();
	private int selRowPassed=-1;
	
	
	
	JButton b=new JButton();
	protected String string;
	protected boolean found=false;
	public static JLabel avgGrade=new JLabel();
	public static JLabel espbSum=new JLabel();
	ActionListener invGrade;
	
	
	public static PassedPanel getInstance(Student s) {
		if (instance==null) {
			instance=new PassedPanel(s);
		}return instance;
	}
	
	public static JTable getInstanceTable(Student s) {
		if (tableInstance==null) {
			tableInstance=Student.getPassedExams(s);
		}return tableInstance;
	}
	
	public static void setTable(JTable table) {
		tableInstance=table;
	}
	
	private PassedPanel(Student s) {
		b=new JButton("Ponisti ocenu");
		   
//		setLayout((LayoutManager) new BoxLayout(BoxLayout.PAGE_AXIS));
		   
		  
		   
		 //Akcija za ponistavanje ocene
		   ActionListener invGrade=new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for(Grade g: s.getPassedExams()) {
					if(g.getGradeId()==StudentDialog.selRowPassed+1) {
						
						//zapamti vrednosti
						int selKeep=StudentDialog.selRowPassed;
						JTable myPTable=StudentDialog.passedTable;
						String hStr=(String)myPTable.getValueAt(selKeep, 0);
						
						//nadji predmet
						Subject subj=SubjectDatabase.findByKey(hStr);
						int size=StudentDialog.failedTable.getRowCount();
						
						//unesi u tabelu nepolozenih
						((DefaultTableModel)StudentDialog.failedTable.getModel()).insertRow(size,new Object[] {myPTable.getValueAt(selKeep, 0),myPTable.getValueAt(selKeep, 1),myPTable.getValueAt(selKeep, 2),subj.getSemester()});

						s.removePassedExam(g);
						string="Uspesno ponisten ispit!";
						ClassNameHere.infoBox(string, "Obavestenje");
						((DefaultTableModel)StudentDialog.passedTable.getModel()).removeRow(selKeep);
						
						found=true;
						
						StudentDialog.updateExamTable();
						break;
					}
				}
				if(!found) {
					string="Nije pronadjen ispit!";
					ClassNameHere.infoBox(string, "Greska");
				}
				
				}
		   };
			   
		   
		   b.addActionListener(invGrade);
		   add(new JScrollPane(StudentDialog.passedTable));
		   
		   add(b);
		   
		   String avg="Prosek: "+s.getAverage();
		   String espb="Ukupno ESPB: "+Integer.toString(s.getEspb());
		   avgGrade=new JLabel(avg);
		   espbSum=new JLabel(espb);
		   add(avgGrade);
		   add(espbSum);
		   

	}
	
	
}
