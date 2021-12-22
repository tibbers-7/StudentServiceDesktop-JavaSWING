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
import manageEntities.ClassNameHere;
import model.Address;
import model.Student;

//Frejm dijaloga za dodavanje studenta
public class NewStudentPane  extends JFrame{
	
	StudentDatabase sdb=new StudentDatabase();
	
	public NewStudentPane(StudentDatabase sdb){
		this.sdb=sdb;
		JPanel panel=new JPanel();
		Student s=new Student();
		ArrayList<JTextField> options=new ArrayList<JTextField>();
		String[] studyYears= {"I (prva)","II (druga)","III (treca)","IV (cetvrta)"};
		String[] finansije= {"Budzet","Samofinansiranje"};
		

		
		JTextField name= new JTextField("Anja");
		
		JTextField surname= new JTextField("Dmitrovic");
		JTextField birthDate= new JTextField("14-April-2001");
		JTextField address= new JTextField("Stevana Sremca,57,Indjija,Srbija");
		JTextField phoneNumber= new JTextField("0691442001");
		JTextField email= new JTextField("anja.dmitrovic@gmail.com");
		JTextField index= new JTextField("41");
		JTextField enrollmentYear= new JTextField("2019");
		
		JComboBox currentStudyYear= new JComboBox(studyYears);
		JComboBox status= new JComboBox(finansije);
		
		
		
	      
	      Object[] message = {
	    		    "Ime* ", name,
	    		    "Prezime* ", surname,
	    		    "Datum rodjenja* ", birthDate,
	    		    "Adresa stanovanja* ",address,
	    		    "Broj telefona* ",phoneNumber,
	    		    "E-mail adresa* ",email,
	    		    "Broj indeksa* ",index,
	    		    "Godina upisa* ",enrollmentYear,
	    		    "Trenutna godina studija* ",currentStudyYear,
	    		    "Nacin finansiranja* ",status
	    		};
	         options.add(name);
		     options.add(surname);
			 options.add(birthDate);
			 options.add(address);
			 options.add(phoneNumber);
			 options.add(email);
			 options.add(index);
			 options.add(enrollmentYear);
			 
			 

	    		int option = JOptionPane.showConfirmDialog(null, message, "Dodavanje Studenta", JOptionPane.OK_CANCEL_OPTION);
	    		
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
	    					
	    					this.sdb.addStudent(s);
		    				String string="Uspesno unet student!";
				    		ClassNameHere.infoBox(string, "Obavestenje");
	    				}

	    			}
	    		}
	    		
	    		
	    		
	}
	
	public StudentDatabase getSdb() {
		return this.sdb;
	}
	
	
};