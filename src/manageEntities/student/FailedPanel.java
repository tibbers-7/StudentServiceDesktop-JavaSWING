package manageEntities.student;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import manageEntities.ClassNameHere;
import manageEntities.subject.SubjectDatabase;
import model.Grade;
import model.Student;
import model.Subject;

public class FailedPanel extends JPanel{
	private static FailedPanel instance=null;
	public static final String[] gradesS= {"6","7","8","9","10"};

	private static JLabel avgGrade=new JLabel();
	private static JLabel espbSum=new JLabel();
	

	
	public static JPanel controls = new JPanel(new FlowLayout(FlowLayout.CENTER,5,5));
	public static JButton addSubject=new JButton();
	public static JButton delSubject=new JButton();
	public static JButton passSubject=new JButton();
	public static   JPanel addSubj=new JPanel();
	public static JComboBox newSubj=new JComboBox();
	public static ActionListener addSubjAction;
	public static ActionListener delSubjAction;
	public static ActionListener passSubjAction;

	protected String strSubj;
	protected JTable failedTable=new JTable();
	protected String string;
	protected int selRowFailed=-1;
	protected JTextField passDate= new JTextField("01-January-1960");
	public static JComboBox grades=new JComboBox(gradesS);
	private int option;
	
	   
	
	public static FailedPanel getInstance(Student s) {
		if (instance==null) {
			instance=new FailedPanel(s);
		}return instance;
	}
	
	private FailedPanel(Student s) {
//		setLayout((LayoutManager) new BoxLayout(pF, BoxLayout.PAGE_AXIS));
//		   
			
		   controls = new JPanel(new FlowLayout(FlowLayout.CENTER,5,5));
		   addSubject=new JButton("Dodaj");
		   delSubject=new JButton("Obrisi");
		   passSubject=new JButton("Polaganje");
		   
		   //Dijalog za dodavanje predmeta
		   addSubj=new JPanel();
		   String[] subjOptions=s.getUnaffiliatedSubj();
		   newSubj=new JComboBox(subjOptions);
		   addSubj.add(newSubj);
		   System.out.printf("FailedPanel,Linija 83: ");
		   SubjectDatabase.printSubjects();
		  
		   //Akcija za dodavanje predmeta
				   addSubjAction=new ActionListener() {
		
					@Override
					public void actionPerformed(ActionEvent e) {
						String nazivDijaloga="Dodaj Predmet";
						 option = JOptionPane.showConfirmDialog(null, addSubj, nazivDijaloga, JOptionPane.OK_CANCEL_OPTION);
						 if(option==0) {
							 strSubj=(String) newSubj.getSelectedItem();	//Uzmi selektovan string iz comboboxa
							 Grade g=StudentDialog.getSubjRegex(strSubj,s); //Na osnovu njega nadji asociran predmet
							 
							 s.addFailedExam(g);	//dodaj u bazu	
							 
							 Subject subj=g.getSubject();
							 int size=StudentDialog.failedTable.getRowCount(); //dobavi velicinu tabele
							 //i dodaj ga u tabelu nepolozenih
							 StudentDialog.dtm2.insertRow(size,new Object[] {subj.getSubjectKey(),subj.getName(),subj.getEspbPoints(),subj.getSemester()});
							 string="Uspesno dodat predmet";
							ClassNameHere.infoBox(string, "Obavestenje");
							
							//Izmeni combobox
							newSubj.removeItem(strSubj);
							
							StudentDialog.updateExamTable();
						 }
					}
					
						
				   };
			   
		   
				addSubject.addActionListener(addSubjAction);
				

				   //Akcija za brisanje predmeta s studenta
					delSubjAction=new ActionListener() {
		
						@Override
						public void actionPerformed(ActionEvent e) {
							if(StudentDialog.selRowFailed==-1) {
								string="Problem s selekcijom";
								ClassNameHere.infoBox(string, "Obavestenje");
							} else {
								
								//dobavi kljuc iz selektovanog reda tabele nepolozenih
								String subjKey=(String)StudentDialog.failedTable.getValueAt(StudentDialog.selRowFailed,0);
								
								Subject s2=SubjectDatabase.findByKey(subjKey);//dobavi predmet na osnovu kljuca
								//izbaci iz tabele
								((DefaultTableModel)StudentDialog.failedTable.getModel()).removeRow(StudentDialog.selRowFailed);
								
								//Dodaj sada obrisani predmet u combobox da bi ga mogao ponovo dodati
								strSubj=s2.getSubjectKey()+"-"+s2.getName();
								System.out.printf("\n strSbj:"+strSubj+"\n");
								newSubj.addItem(strSubj);
								
								string="Obrisan predmet";
								ClassNameHere.infoBox(string, "Obavestenje");
								StudentDialog.updateExamTable();
		
							}
						
						}
					};
				   
		   delSubject.addActionListener(delSubjAction);
		   
		   JPanel passSubjPanel=new JPanel();
		   passSubjPanel.add(grades);
		   passSubjPanel.add(passDate);
		   

		   	//Akcija za POLAGANJE PREDMETA
				   passSubjAction=new ActionListener() {
		
					@Override
					public void actionPerformed(ActionEvent e) {
						
						String nazivDijaloga="Unesite ocenu i datum:";
						 option = JOptionPane.showConfirmDialog(null, passSubjPanel, nazivDijaloga, JOptionPane.OK_CANCEL_OPTION);
						 int selKeep=StudentDialog.selRowFailed;
						int size=StudentDialog.passedTable.getRowCount();
						JTable myFTable=StudentDialog.failedTable;
						//dobavi predmet na osnovu selektovanog
						String key=(String)StudentDialog.failedTable.getValueAt(selKeep, 0);
						Subject subj=SubjectDatabase.findByKey(key);
						
						//dobavljanje ocene koja vise ne treba da se nalazi u nepolozenim
						Grade g=new Grade(s,subj);
						
						//Dobavljanje novih polja za taj predmet da bi se mogao ubaciti u polozene
						String grade=(String) grades.getSelectedItem();
						String pD= passDate.getText();
						Grade g1=new Grade(s,subj,Integer.parseInt(grade),Student.formatDate(pD));
						 s.addPassedExam(g1);
						 
						 //izmena tabela
						((DefaultTableModel)StudentDialog.passedTable.getModel()).insertRow(size, new Object[] {myFTable.getValueAt(selKeep, 0),myFTable.getValueAt(selKeep, 1),myFTable.getValueAt(selKeep, 2),grades.getSelectedItem(),passDate.getText()});
						((DefaultTableModel)StudentDialog.failedTable.getModel()).removeRow(selKeep);
						s.removeFailedExam(g);
//						s.addPassedExam(g1);
						
						//brisanje iz ponudjenih opcija za dodavanje
						newSubj.removeItem(strSubj);
						
						String avg="Prosek: "+s.getAverage();
						   String espb="Ukupno ESPB: "+Integer.toString(s.getEspb());
						   PassedPanel.avgGrade=new JLabel(avg);
						   PassedPanel.espbSum=new JLabel(espb);
						   
						   StudentDialog.pS.revalidate();
						   StudentDialog.pS.repaint();
						
						   StudentDialog.updateExamTable();
						   
						   
						   };
					
					};
			   
		   
		   
		   passSubject.addActionListener(passSubjAction);
		   
		   
		   controls.add(addSubject);
		   controls.add(delSubject);
		   controls.add(passSubject);
		   
		   
		   
		   
		   add(controls,BorderLayout.SOUTH);
		   add(new JScrollPane(StudentDialog.failedTable));

	}
}
