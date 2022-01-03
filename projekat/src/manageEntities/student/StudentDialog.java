package manageEntities.student;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import manageEntities.CheckValidity;
import manageEntities.ClassNameHere;
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
	private static int option=-1;
	private static boolean isEmpty=true;
	
	public static JComboBox currentStudyYear= new JComboBox(studyYears);
	public static JComboBox status= new JComboBox(finansije);
	
	
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
		    								string="Uspesno unet student! (Klik na File)";
								    		ClassNameHere.infoBox(string, "Obavestenje");
								    		break loop;
		    							}
		    							break;
					    				
							    	//ako je dugme edit
		    						case 2:
		    							StudentDatabase.changeStudent(s,rowClicked);
		    							string="Uspesno izmenjen student! (Klik na File)";
							    		ClassNameHere.infoBox(string, "Obavestenje");
							    		break loop;
		    					}
		    					

		    					
		    				}else this.dialog(sel);
		    				
	
		    		}
		    		
			}


	    		
	    		
	   private ArrayList<JTextField> dialog(int sel) {
		   
		   isEmpty=false;
		   
		   ArrayList<JTextField> options=new ArrayList<JTextField>();
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
		    
		   String nazivDijaloga=null;
			 switch(sel) {
			 case 1:
				 nazivDijaloga="Dodavanje Studenta";
				 break;
			 case 2:
				 nazivDijaloga="Izmena Studenta";
				 break;
			 }
			 
			//Ovde iskace dijalog
	    	option = JOptionPane.showConfirmDialog(null, message, nazivDijaloga, JOptionPane.OK_CANCEL_OPTION);
	    	
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

	
	
	
	
};