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
public class StudentOptionPane  extends JFrame{
	
	private static final Pattern p = Pattern.compile("^(\\D+),(\\d+),(\\D+),(\\D+)");
	StudentDatabase sdb=new StudentDatabase();
	
	public StudentOptionPane(StudentDatabase sdb){
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
			 
			 String addressPattern = "(\\D+),(\\d+),(\\D+),(\\D+)";
			 SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
			 

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
	    				s.setName(name.getText());
	    				s.setSurname(surname.getText());
	    				s.setIndex(index.getText());
	    				
	    				//Dobavljanje datuma,provera formata
	    					Date d=Student.formatDate(birthDate.getText());
							if (d!=null) {
								s.setBirthDate(d);
							} else {
								String string="Datum nije dobro unesen (dd-MMM-yyyy)";
					    		ClassNameHere.infoBox(string, "Greska");
							}
							
//						Dobavljanje adrese i provera jel dobro ukucana
//							REGEX provera
							String adresa=address.getText();
							Matcher m = p.matcher(adresa);
							
							if(m.find()) {
								
								int num=Integer.parseInt(m.group(2));
								Address a=new Address(m.group(1),num,m.group(3),m.group(4));
								
								s.setAddress(a);
							} else {
								String string="Format adrese nije dobro unesen (Ulica,Broj,Grad,Zemlja)";
					    		ClassNameHere.infoBox(string, "Greska");
							}
	    					
	    				s.setEmail(email.getText());
	    				s.setIndex(index.getText());
	    				s.setPhoneNumber(Long.parseLong(phoneNumber.getText()));
	    				s.setEnrollmentYear(Integer.parseInt(enrollmentYear.getText()));
	    				
	    				//Dobavljanje statusa
	    				String statVal = (String) status.getSelectedItem();
	    				if(statVal=="Budzet") {
	    					s.setStatus(StatusEnum.BUDGET);
	    				} else s.setStatus(StatusEnum.SELF_FINANCING);
	    					
	    				//Dobavljanje godine studija
	    				String currYear=(String) currentStudyYear.getSelectedItem();
	    				switch(currYear) {
	    					case "I (prva)":
	    						s.setCurrentStudyYear(1);
	    						break;
	    					case "II (druga)":
	    						s.setCurrentStudyYear(2);
	    						break;
	    					case "III (treca)":
	    						s.setCurrentStudyYear(3);
	    						break;
	    					case "IV (cetvrta)":
	    						s.setCurrentStudyYear(4);
	    						break;
	    				}
//	    				
	    				this.sdb.addStudent(s);
	    				
	    				
	    				
	    				String string="Uspesno unet student!";
			    		ClassNameHere.infoBox(string, "Obavestenje");
	    				}
	    		}
	    		
	    		
	    		
	}
	
	public StudentDatabase getSdb() {
		return this.sdb;
	}
};