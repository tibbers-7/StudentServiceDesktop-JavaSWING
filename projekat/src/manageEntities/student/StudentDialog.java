package manageEntities.student;

import java.awt.LayoutManager;
import java.awt.*;

import model.Subject;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import gui.MainFrame;
import gui.ShowTable;
import manageEntities.CheckValidity;
import manageEntities.ClassNameHere;
import manageEntities.subject.SubjectDatabase;
import model.Grade;
import model.Student;


@SuppressWarnings("serial")


//***************************************************************************************
//***************************************************************************************
//***************************************************************************************

	//StudentDialog mi daje: 1. panel za novog studenta: dialog()  258
	//						 2. dijalog za prihvatanje novog studenta: ispisDijaloga() 185
	//						 3. regex dobavljanje predmeta na osnovu stringa iz comboboxa (format SifraPr-NazivPr)
	//						 4. panela za informacije studenta
	//						 5. apdejtovanje tabela
	



//***************************************************************************************
//***************************************************************************************
//***************************************************************************************



//Panel za rukovanje studentima
public class StudentDialog  extends JPanel{
	public static final String[] studyYears= {"I (prva)","II (druga)","III (treca)","IV (cetvrta)"};
	public static final String[] finansije= {"Budzet","Samofinansiranje"};
	public static final String[] gradesS= {"6","7","8","9","10"};
	
	protected Student s=new Student();
	
	//TextFields
	protected JTextField name=new JTextField();
	protected JTextField surname= new JTextField();
	protected JTextField birthDate= new JTextField("01-January-1960");
	protected JTextField passDate= new JTextField("01-January-1960");
	protected JTextField address= new JTextField("Ulica,Broj,Grad,Drzava");
	protected JTextField phoneNumber= new JTextField();
	protected JTextField email= new JTextField();
	protected JTextField index= new JTextField();
	protected JTextField enrollmentYear= new JTextField();
	
	//Tables
	public static JTable passedTable=new JTable();
	public static JTable failedTable=new JTable();
	public static DefaultTableModel dtm=new DefaultTableModel();
	public static DefaultTableModel dtm2=new DefaultTableModel();
	
	//Pomocna polja
	private static StudentDialog instance=null;
	private static int option=-1;
	private static boolean isEmpty=true;
	public static int selRowPassed=-1;
	public static int selRowFailed=-1;
	private String string;
	public static JPanel pS=new JPanel();
	public static JPanel fS=new JPanel();
	
	
	public  JComboBox currentStudyYear= new JComboBox(studyYears);
	public JComboBox status= new JComboBox(finansije);
	public static JComboBox newSubj=new JComboBox();
	public static JComboBox grades=new JComboBox(gradesS);
	

	
	
	public static StudentDialog getInstance() {
		if(instance==null) {
			instance=new StudentDialog();
		}
		return instance;
	}
	
	//Konstruktor
		public StudentDialog(){
			super();
		}
			
	public JTextField getNameS() {
		return name;
	}

	public void setName(JTextField name) {
		this.name = name;
	}

	public JTextField getSurname() {
		return surname;
	}

	public void setSurname(JTextField surname) {
		this.surname = surname;
	}

	public JTextField getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(JTextField birthDate) {
		this.birthDate = birthDate;
	}

	public JTextField getAddress() {
		return address;
	}

	public void setAddress(JTextField address) {
		this.address = address;
	}

	public JTextField getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(JTextField phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public JTextField getEmail() {
		return email;
	}

	public void setEmail(JTextField email) {
		this.email = email;
	}

	public JTextField getIndex() {
		return index;
	}

	public void setIndex(JTextField index) {
		this.index = index;
	}

	public JTextField getEnrollmentYear() {
		return enrollmentYear;
	}

	public void setEnrollmentYear(JTextField enrollmentYear) {
		this.enrollmentYear = enrollmentYear;
	}
	

		//Prihvatanje user inputa i pravljenje novog objekta koji se stavlja u bazu
		public void ispisDijaloga(int sel) {
					
					this.dialog(sel);
		    		loop: while (option!=1) {
		    			
		    			while(isEmpty) {
		    				if(option==0) {
		    					String string="Nisu unesene sve potrebne vrednosti!";
		    					ClassNameHere.infoBox(string, "Greska");
		    					
		    					this.dialog(sel);
		    				}else break;
		    			} 
//		    			
		    			if (isEmpty) return;
//		    		
		    			
		    			//Ako su sva polja popunjena:
		    			
		    				if(CheckValidity.checkValidityStudent(s,name.getText(),surname.getText(),birthDate.getText(),
		    							 address.getText(),phoneNumber.getText(),email.getText(),
		    							 index.getText(),enrollmentYear.getText(),
		    							 (String)currentStudyYear.getSelectedItem(),(String)status.getSelectedItem())) {
		    					
		    					switch(sel) {
		    						//Ako je dugme new
		    						case 1:
		    							if(StudentDatabase.indexExists(s.getIndex())){
		    								string="Vec postoji student sa unetim indeksom!";
		    					    		ClassNameHere.infoBox(string, "Greska");
		    					    		this.dialog(sel);
		    					    		
		    							} else {
		    								StudentDatabase.addStudent(s);
		    								string="Uspesno unet student!";
								    		ClassNameHere.infoBox(string, "Obavestenje");
								    		int size=MainFrame.studTable.getRowCount();
								    		MainFrame.tableModelStud.insertRow(size,new Object[] {s.getStudentId(),index.getText(),name.getText(),surname.getText()
								    				,s.getCurrentStudyYear(),s.getStatus()});
								    		
								    		MainFrame.updateTableStud();
								    		break loop;
		    							}
		    							break;
					    				
							    	//ako je dugme edit
		    						case 2:
		    							
		    							
							    		
							    		//Kad se sortira ne moze vise da se trazi preko oznacenog reda nego mora da se dobavlja kljuc (studID)
							               String key1 = (String)ShowTable.getStudTable().getValueAt(MainFrame.selRowStud,0);
							               int key=Integer.parseInt(key1);
							               System.out.printf("\nkey=%d\n",key);
							               
							               int keyStud=0;
							               
							               for (int i = MainFrame.tableModelStud.getRowCount() - 1; i >= 0; --i) {
							                       if (MainFrame.tableModelStud.getValueAt(i, 0).equals(Integer.toString(key))) {
							                           // what if value is not unique?
							                           keyStud= i;
							                       }
							                   
							               }
							               StudentDatabase.changeStudent(s,key-1);
							               System.out.printf("\nrow=%d\n",keyStud);
							               
							               string="Uspesno izmenjen student!";
								    		ClassNameHere.infoBox(string, "Obavestenje");
								    		
							               MainFrame.tableModelStud.setValueAt(key1, keyStud, 0);
							               MainFrame.tableModelStud.setValueAt(index.getText(), keyStud, 1);
							               MainFrame.tableModelStud.setValueAt(name.getText(), keyStud, 2);
							               MainFrame.tableModelStud.setValueAt(surname.getText(), keyStud, 3);
							               MainFrame.tableModelStud.setValueAt(s.getCurrentStudyYear(), keyStud, 4);
							               MainFrame.tableModelStud.setValueAt(s.getStatus(), keyStud, 5);
							    		MainFrame.updateTableStud();
							    		break loop;
		    					}
		    					

		    					
		    				}else this.dialog(sel);
		    				
	
		    		}
		    		
			}


	    		
	    		
	   private ArrayList<JTextField> dialog(int sel) {
		   
		   isEmpty=false;
		   
		   ArrayList<JTextField> options=new ArrayList<JTextField>();
		   
		   //Panel za dodavanje novog studenta
		      Object[] message = {
		    		    "Ime* ", this.name,
		    		    "Prezime* ", this.surname,
		    		    "Datum rodjenja* ", this.birthDate,
		    		    "Adresa stanovanja* ",this.address,
		    		    "Broj telefona* ",this.phoneNumber,
		    		    "E-mail adresa* ",this.email,
		    		    "Broj indeksa* ",this.index,
		    		    "Godina upisa* ",this.enrollmentYear,
		    		    "Trenutna godina studija* ",this.currentStudyYear,
		    		    "Nacin finansiranja* ",this.status
		    		};
		      
		      //Panel za edit
		      JTabbedPane tp=new JTabbedPane();
		      JPanel info=informations();
		      tp.add("Informacije",info);
		      
		      Student s=StudentDatabase.findByID(MainFrame.selRowStud+1);
		      if(s!=null) {
		    	  passedTable=Student.getPassedExams(s);
		    	  passedTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					   public void valueChanged(ListSelectionEvent e) {
							selRowPassed=passedTable.getSelectedRow();
						}
				   });
		    	  
		    	  pS=PassedPanel.getInstance(s);
		    	  tp.add("Polozeni ispiti",pS);
		    	  failedTable=Student.getFailedExams(s);
		    	  failedTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					   public void valueChanged(ListSelectionEvent e) {
							selRowFailed=failedTable.getSelectedRow();
						}
				   });
		    	  fS=FailedPanel.getInstance(s);
			      tp.add("Nepolozeni ispiti",fS);
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
			 options.add(birthDate);
			 options.add(address);
			 options.add(phoneNumber);
			 options.add(email);
			 options.add(index);
			 options.add(enrollmentYear);
			 
			 for (JTextField tf:options) {
	 				
	 				if(tf.getText().isEmpty()){
				    		isEmpty=true;
		    			}
				 	
				 }
			 return options;
	   }
	   
	   private JPanel informations() {
		   JPanel studPan=new JPanel();
		      studPan.add(new JLabel("Ime*"));
		      studPan.add(this.name);
		      studPan.add(new JLabel("Prezime*"));
		      studPan.add(this.surname);
		      studPan.add(new JLabel("Datum rodjenja*"));
		      studPan.add(this.birthDate);
		      studPan.add(new JLabel("Adresa stanovanja*"));
		      studPan.add(this.address);
		      studPan.add(new JLabel("Broj telefona*"));
		      studPan.add(this.phoneNumber);
		      studPan.add(new JLabel("E-mail adresa*"));
		      studPan.add(this.email);
		      studPan.add(new JLabel("Broj indeksa*"));
		      studPan.add(this.index);
		      studPan.add(new JLabel("Godina upisa*"));
		      studPan.add(this.enrollmentYear);
		      studPan.add(new JLabel("Trenutna godina studija*"));
		      studPan.add(this.currentStudyYear);
		      studPan.add(new JLabel("Nacin finansiranja*"));
		      studPan.add(this.status);
		      studPan.setLayout((LayoutManager) new BoxLayout(studPan, BoxLayout.PAGE_AXIS));
		      
		      return studPan;
	   }
	   
	   
	   
	   
	   
	 	   
	   
	   public static void updateExamTable() {
		   dtm.fireTableDataChanged();
		   dtm2.fireTableDataChanged();
	   }
	   
	   //Dobavljanje predmeta na osnovu odabrane stavke u JComboBox dodavanje predmeta
	   public static Grade getSubjRegex(String str,Student stud) {
			
			Pattern p = Pattern.compile("^([0-Z]*)-*");
			Matcher m = p.matcher(str);
			
			if(m.find()) {
				String subjKey=m.group(1);
				Subject subj=SubjectDatabase.findByKey(subjKey);
				System.out.printf(subj.subjStringified());
				Grade g=new Grade(stud,subj);
				return g;
				
			} else {
				String string="REGEX ne valja!";
				ClassNameHere.infoBox(string, "Greska");
				return null;
			}
		}
	   
	
};