package manageEntities.subject;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import gui.MainFrame;
import manageEntities.CheckValidity;
import manageEntities.ClassNameHere;
import model.Subject;


public class SubjectDialog extends JFrame{


	private static final long serialVersionUID = 1L;

	public static final String[] semester= {"Zimski","Letnji"};
	
	protected JTextField subjKey=new JTextField();
	protected JTextField name= new JTextField();
	protected JTextField year= new JTextField();
	protected JTextField prof= new JTextField();
	protected JTextField espb= new JTextField();
	protected Subject s=new Subject();
	public static JComboBox sem= new JComboBox(semester);

	
	public JTextField getSubjKey() {
		return subjKey;
	}

	public void setSubjKey(JTextField subjKey) {
		this.subjKey = subjKey;
	}

	public JTextField getNameS() {
		return name;
	}

	public void setName(JTextField name) {
		this.name = name;
	}

	public JTextField getYear() {
		return year;
	}

	public void setYear(JTextField year) {
		this.year = year;
	}

	public JTextField getProf() {
		return prof;
	}

	public void setProf(JTextField prof) {
		this.prof = prof;
	}

	public JTextField getEspb() {
		return espb;
	}

	public void setEspb(JTextField espb) {
		this.espb = espb;
	}

	
	
	
	public SubjectDialog() {
		super();
	}

	public void ispisDijaloga(int sel,int rowClicked) {
		ArrayList<JTextField> options=new ArrayList<JTextField>();
	      Object[] message = {
	    		    "Sifra Predmeta* ", this.subjKey,
	    		    "Naziv* ", this.name,
	    		    "Semestar* ", this.sem,
	    		    "Godina* ",this.year,
	    		    "Profesor* ",this.prof,
	    		    "ESPB* ",this.espb,
	    		    
	    		};
	      
	      String nazivDijaloga=null;
			 switch(sel) {
			 case 1:
				 nazivDijaloga="Dodavanje Predmeta";
				 break;
			 case 2:
				 nazivDijaloga="Izmena Predmeta";
				 break;
			 }
			 
	    	int option = JOptionPane.showConfirmDialog(null, message, nazivDijaloga, JOptionPane.OK_CANCEL_OPTION);

	      
	      	 options.add(subjKey);
		     options.add(name);
			 options.add(year);
			 options.add(prof);
			 options.add(espb);
			 
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
	    			} else {
	    				if(CheckValidity.checkValiditySubject(s,subjKey.getText(),
	 							 name.getText(),year.getText(),prof.getText(),
	 							 espb.getText(),(String)sem.getSelectedItem())) {
			
	 					switch(sel) {
	 						//Ako je dugme new
	 						case 1:
	 								SubjectDatabase.addSubject(s);
				    				String string="Uspesno unet predmet! (Klik na File)";
						    		ClassNameHere.infoBox(string, "Obavestenje");
						    		MainFrame.updateTableSubj();
						    		break;
						    	//ako je dugme edit
	 						case 2:
	 							String string1="Uspesno izmenjen predmet! (Klik na File)";
					    		ClassNameHere.infoBox(string1, "Obavestenje");
	 							SubjectDatabase.changeSubject(s,rowClicked);
	 							MainFrame.updateTableSubj();
	 							break;
	 					 }
	    			}
		
			 }
			 
		
		}
	}
	
	
	};

