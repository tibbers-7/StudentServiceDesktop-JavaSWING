package gui.controller.professor;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import gui.controller.CheckValidity;
import gui.controller.ClassNameHere;
import gui.controller.ShowTable;
import gui.controller.databases.ProfessorDatabase;
import gui.controller.databases.SubjectDatabase;
import gui.model.Grade;
import gui.model.Professor;
import gui.model.Student;
import gui.model.Subject;
import gui.view.MainFrame;

public class ProfessorDialog extends JPanel{

	//pomocna polja
	public static final String[] titles= {"Docent","Redovni profesor","Vanredni profesor"};
	private boolean isEmpty=true;
	public static JTabbedPane tp=new JTabbedPane();
	public static JPanel pS=new JPanel();
	private static int option=-1;
	protected Professor p=new Professor();
	private static String string;



	//polja za unos
	protected JTextField name=new JTextField();
	protected JTextField surname= new JTextField();
	public static JComboBox title= new JComboBox(titles);
	protected JTextField email= new JTextField();


	public void setName(JTextField name) {
		this.name = name;
	}

	public JTextField getSurname() {
		return surname;
	}

	public void setSurname(JTextField surname) {
		this.surname = surname;
	}

	public JTextField getEmail() {
		return email;
	}

	public void setEmail(JTextField email) {
		this.email = email;
	}

	//table
	public static JTable subjectTable;
	public static int selRowSubject=-1;
	public static DefaultTableModel dtm=new DefaultTableModel();


	public void ispisDijaloga(int sel) {

		this.dialog(sel);
		loop: while (option!=1) {

			while(isEmpty) {
				if(option==0) {
					string="Nisu unesene sve potrebne vrednosti!";
					ClassNameHere.infoBox(string, "Greska");

					this.dialog(sel);
				}else break;
			}
//
			if (isEmpty) return;
//

			//Ako su sva polja popunjena:

				if(CheckValidity.checkValidityProfessor(p,name.getText(),surname.getText(),email.getText(),(String)title.getSelectedItem())) {

					switch(sel) {
						//Ako je dugme new
						case 1:
								ProfessorDatabase.addProfessor(p);
								string="Uspešno unet profesor!";
					    		ClassNameHere.infoBox(string, "Obaveštenje");
					    		int size=ShowTable.getStudTable().getRowCount();
					    		ShowTable.tableModelProf.insertRow(size,new Object[] {p.getProfessorId(),p.getName(),p.getSurname(),p.getEmail(),(String)title.getSelectedItem()});

					    		ShowTable.updateTableProf();
					    		break loop;

					//ako je dugme edit
						case 2:
				               int key = (int)ShowTable.getProfTable().getValueAt(MainFrame.selRowProf,0);
				               ProfessorDatabase.changeProfessor(p,key-1);

				               string="Uspešno izmenjen profesor!";
					    		ClassNameHere.infoBox(string, "Obavestenje");

					    		ShowTable.tableModelProf.setValueAt(p.getName(), key-1, 1);
					    		ShowTable.tableModelProf.setValueAt(p.getSurname(), key-1, 2);
					    		ShowTable.tableModelProf.setValueAt(title.getSelectedItem(), key-1, 3);
					    		ShowTable.tableModelProf.setValueAt(p.getEmail(), key-1, 4);
					    		ShowTable.updateTableProf();
					    		break loop;
					}



				}else this.dialog(sel);


		}

}

	private ArrayList<JTextField> dialog(int sel) {

		   isEmpty=false;

		   ArrayList<JTextField> options=new ArrayList<>();

//		   Dijalog za dodavanje novog studenta
		      Object[] message = {
		    		    "Ime* ", this.name,
		    		    "Prezime* ", this.surname,
		    		    "Zvanje* ", ProfessorDialog.title,
		    		    "E-mail adresa* ",this.email,
		    		};

		      //Panel za info
		      tp=new JTabbedPane();
		      JPanel info=informations();
		      tp.add("Informacije",info);

		      //Dobavljanje svih potrebnih stvari za edit panel
		      Professor p=ProfessorDatabase.findByID(MainFrame.selRowProf+1);
		      if(p!=null) {
		    	  subjectTable=p.getSubjectTable();
		    	  subjectTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					   @Override
					public void valueChanged(ListSelectionEvent e) {
//						   subjectTable=p.getSubjectTable();
						   selRowSubject=subjectTable.getSelectedRow();
						}
				   });

		    	  pS=new SubjectPanel(p);
		    	  tp.add("Predmeti",pS);

		      }



		   String nazivDijaloga=null;
			 switch(sel) {
			 case 1:
				 nazivDijaloga="Dodavanje Studenta";
				 option = JOptionPane.showConfirmDialog(null, message, nazivDijaloga, JOptionPane.OK_CANCEL_OPTION);
				 break;
			 case 2:
				 nazivDijaloga="Izmena Studenta";
				 option = JOptionPane.showConfirmDialog(null, tp, nazivDijaloga, JOptionPane.OK_CANCEL_OPTION);
				 break;
			 }




	    	//Dodajem u listu da bi proverila jel ima praznih polja
	         options.add(name);
		     options.add(surname);
			 options.add(email);

			 for (JTextField tf:options) {

	 				if(tf.getText().isEmpty()){
				    		isEmpty=true;
		    			}

				 }
			 return options;
	   }

	private JPanel informations() {
		   JPanel subjPan=new JPanel();

		   	subjPan.add(new JLabel("Ime*"));
		   	subjPan.add(this.name);
		   	subjPan.add(new JLabel("Prezime*"));
		   	subjPan.add(this.surname);
		   	subjPan.add(new JLabel("E-mail adresa*"));
		   	subjPan.add(this.email);
		   	subjPan.add(new JLabel("Zvanje*"));
		   	subjPan.add(ProfessorDialog.title);
		   	subjPan.setLayout(new BoxLayout(subjPan, BoxLayout.PAGE_AXIS));

		      return subjPan;
	   }

	public static void updateTable() {
		   dtm.fireTableDataChanged();
	   }

	public static void updateSubjectPanel(Professor p) {
		   tp.remove(pS);
		   
		   if(p==null) return;
		   
		   subjectTable=p.getSubjectTable();
		   subjectTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			   @Override
			public void valueChanged(ListSelectionEvent e) {
					selRowSubject=subjectTable.getSelectedRow();
				}
		   });
		   
		   pS=new SubjectPanel(p);
	       tp.add("Predmeti",pS);
	   }
	
	
	 public static Subject getSubjRegex(String str,Professor prof) {

			Pattern p = Pattern.compile("^(\\D*)(\\d*)-*");
			Matcher m = p.matcher(str);

			if(m.find()) {
				String subjKey=m.group(1)+m.group(2);
				Subject subj=SubjectDatabase.findByKey(subjKey);
				return subj;

			} else {
				String string="REGEX ne valja!";
				ClassNameHere.infoBox(string, "Greska");
				return null;
			}
		}



}
