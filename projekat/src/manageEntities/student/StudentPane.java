package manageEntities.student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import enums.StatusEnum;
import gui.MenuBar;
import manageEntities.ClassNameHere;
import model.Address;
import model.Student;

//Frejm dijaloga za dodavanje studenta
public class StudentPane  extends JFrame{
	public static final String[] studyYears= {"I (prva)","II (druga)","III (treca)","IV (cetvrta)"};
	public static final String[] finansije= {"Budzet","Samofinansiranje"};
	
	protected Student s=new Student();
	StudentDatabase sdb=new StudentDatabase();
	protected JTextField name=new JTextField();
	protected JTextField surname= new JTextField();
	protected JTextField birthDate= new JTextField();
	protected JTextField address= new JTextField();
	protected JTextField phoneNumber= new JTextField();
	protected JTextField email= new JTextField();
	protected JTextField index= new JTextField();
	protected JTextField enrollmentYear= new JTextField();
	protected JComboBox currentStudyYear= new JComboBox(studyYears);
	protected JComboBox status= new JComboBox(finansije);
	
	
	
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

	
	
	//GLAVNI DEO za prikaz
	//Konstruktor
	public StudentPane(){
		super();
	}
		
		

		//Prihvatanje user inputa i pravljenje novog objekta koji se stavlja u bazu
		public void ispisDijaloga(int sel,int rowClicked) {
			
			this.name= new JTextField("Anja");
//			
			this.surname= new JTextField("Dmitrovic");
			this.birthDate= new JTextField("14-April-2001");
			this.address= new JTextField("Stevana Sremca,57,Indjija,Srbija");
			this.phoneNumber= new JTextField("0691442001");
			this.email= new JTextField("anja.dmitrovic@gmail.com");
			this.index= new JTextField("41");
			this.enrollmentYear= new JTextField("2019");
//			
		
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
		         options.add(name);
			     options.add(surname);
				 options.add(birthDate);
				 options.add(address);
				 options.add(phoneNumber);
				 options.add(email);
				 options.add(index);
				 options.add(enrollmentYear);
				 
				 String nazivDijaloga=null;
				 switch(sel) {
				 case 1:
					 nazivDijaloga="Dodavanje Studenta";
					 break;
				 case 2:
					 nazivDijaloga="Izmena Studenta";
					 break;
				 case 3:
					 nazivDijaloga="Brisanje Studenta";
					 break;
				 }
	
		    		int option = JOptionPane.showConfirmDialog(null, message, nazivDijaloga, JOptionPane.OK_CANCEL_OPTION);
		    		
		    		if (option==0) {
		    			boolean isEmpty=false;
		    			//Proverava jel ima praznih polja
		    			for (JTextField tf:options) {
		    				
		    				if(tf.getText().isEmpty()){
					    		isEmpty=true;
			    			}
			    		}
		    			if(isEmpty) {
		    				String string="Nisu unesene sve potrebne vrednosti!";
				    		ClassNameHere.infoBox(string, "Greska");
		    			} 
		    			
		    			//Ako su sva polja popunjena:
		    			else {
		    				if(CheckValidity.checkValidityStudent(s,name.getText(),surname.getText(),birthDate.getText(),
		    							 address.getText(),phoneNumber.getText(),email.getText(),
		    							 index.getText(),enrollmentYear.getText(),
		    							 (String)currentStudyYear.getSelectedItem(),(String)status.getSelectedItem())) {
		    					
		    					switch(sel) {
		    						case 1:
		    							StudentDatabase.addStudent(s);
					    				String string="Uspesno unet student!";
							    		ClassNameHere.infoBox(string, "Obavestenje");
							    		break;
		    						case 2:
		    							
		    							StudentDatabase.changeStudent(s,rowClicked);
		    					}
		    					
		    				}
	
		    			}
		    		}
			}
	    		
	    		
	    		

	
	
	
	
};