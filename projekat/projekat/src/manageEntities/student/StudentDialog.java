package manageEntities.student;

import java.awt.LayoutManager;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import gui.MainFrame;
import manageEntities.CheckValidity;
import manageEntities.ClassNameHere;
import model.Grade;
import model.Student;


@SuppressWarnings("serial")


//Frejm dijaloga za dodavanje i izmenu studenta
public class StudentDialog  extends JPanel{
	public static final String[] studyYears= {"I (prva)","II (druga)","III (treca)","IV (cetvrta)"};
	public static final String[] finansije= {"Budzet","Samofinansiranje"};
	
	protected Student s=new Student();
	protected JTextField name=new JTextField();
	protected JTextField surname= new JTextField();
	protected JTextField birthDate= new JTextField("01-January-1000");
	protected JTextField address= new JTextField("Ulica,Broj,Grad,Drzava");
	protected JTextField phoneNumber= new JTextField();
	protected JTextField email= new JTextField();
	protected JTextField index= new JTextField();
	protected JTextField enrollmentYear= new JTextField();
	private static JTable passedTable=new JTable();
	private static JTable failedTable=new JTable();
	public static DefaultTableModel dtm=new DefaultTableModel();
	public static DefaultTableModel dtm2=new DefaultTableModel();
	private static int option=-1;
	private static boolean isEmpty=true;
	private static int selRow=-1;
	private boolean found=false;
	
	
	public static JComboBox currentStudyYear= new JComboBox(studyYears);
	public static JComboBox status= new JComboBox(finansije);
	public static JComboBox subjects= new JComboBox(finansije);
	
	
	
	
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
		public void ispisDijaloga(int sel,int rowClicked) {
					
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
		    					String string;
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
								    		MainFrame.updateTableStud();
								    		break loop;
		    							}
		    							break;
					    				
							    	//ako je dugme edit
		    						case 2:
		    							StudentDatabase.changeStudent(s,MainFrame.selRowStud+1);
		    							string="Uspesno izmenjen student!";
							    		ClassNameHere.infoBox(string, "Obavestenje");
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
		      
		      Student s=StudentDatabase.findByID(EditStudentAction.selRow);
		      JPanel passedSubj=passedSubj(s);
		      tp.add("Polozeni ispiti",passedSubj);
		      
		      JPanel failedSubj=failedExams(s);
		      tp.add("Nepolozeni ispiti",failedSubj);
		      
		    
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
			 
			//Ovde iskace dijalog
	    	
	    	
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
	   
	   private JPanel passedSubj(Student s) {
		   
		   
		   JButton b=new JButton("Ponisti ocenu");
		   passedTable=Student.getPassedExams(s);
		   JPanel pS=new JPanel();
		   pS.setLayout((LayoutManager) new BoxLayout(pS, BoxLayout.PAGE_AXIS));
		   
		   
		   b.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					selRow=passedTable.getSelectedRow()+1;
					for(Grade g: s.getPassedExams()) {
						if(g.getGradeId()==selRow) {
							s.removePassedExam(g);
							String string="Uspesno izbrisan ispit!";
							ClassNameHere.infoBox(string, "Obavestenje");
							found=true;
							passedTable=Student.getPassedExams(s);
							
							
							updateExamTable();
							pS.revalidate();
							pS.repaint();
							break;
						}
					}
					if(!found) {
						String string="Nije pronadjen ispit!";
						ClassNameHere.infoBox(string, "Greska");
					}
					
					
				}
				   
			   });
		   
		   
		   pS.add(new JScrollPane(passedTable));
		   pS.add(b);
		   
		   String avg="Prosek: "+s.getAverage();
		   String espb="Ukupno ESPB: "+Integer.toString(s.getEspb());
		   JLabel avgGrade=new JLabel(avg);
		   JLabel espbSum=new JLabel(espb);
		   pS.add(avgGrade);
		   pS.add(espbSum);
		   
		return pS;
		   
	   }
	   
	   private JPanel failedExams(Student s) {
		   JPanel pF=new JPanel();
		   pF.setLayout((LayoutManager) new BoxLayout(pF, BoxLayout.PAGE_AXIS));
		   
		   JPanel controls = new JPanel(new FlowLayout(FlowLayout.CENTER,5,5));
		   JButton addSubject=new JButton("Dodaj");
		   JButton delSubject=new JButton("Obrisi");
		   JButton passSubject=new JButton("Polaganje");
		   controls.add(addSubject);
		   controls.add(delSubject);
		   controls.add(passSubject);
		   
		   failedTable=Student.getFailedExams(s);
		   
		   pF.add(controls,BorderLayout.SOUTH);
		   pF.add(new JScrollPane(failedTable));
		   
		   return pF;
	   }
	   
	   public static void updateExamTable() {
		   dtm.fireTableDataChanged();
	   }

	
	
	
	
};