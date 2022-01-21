package gui.controller.subject;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import gui.controller.CheckValidity;
import gui.controller.ClassNameHere;
import gui.controller.ShowTable;
import gui.controller.databases.ProfessorDatabase;
import gui.controller.databases.SubjectDatabase;
import gui.model.Subject;
import gui.view.MainFrame;


//Dijalog za predmet
// Ako je edit dijalog se menja preko EditSubjectDialogUpdate
public class SubjectDialog extends JFrame{


	private static final long serialVersionUID = 1L;

	public static final String[] semester= {"Zimski","Letnji"};
	private static String[] profList= {};

//polja za popunjavanje
	protected JTextField subjKey=new JTextField();
	protected JTextField name= new JTextField();
	protected JTextField year= new JTextField();
	protected JComboBox<?> prof= new JComboBox<String>();
	protected JTextField espb= new JTextField();
	protected Subject s=new Subject();
	public static JComboBox<?> sem= new JComboBox<String>(semester);

//pomocna polja
	private String string;
	private boolean isEmpty=false;
	private int option=-1;



	public SubjectDialog() {
		super();
	}

	public void ispisDijaloga(int sel) {

		profList=ProfessorDatabase.getProfList();
		prof=new JComboBox<Object>(profList);
			this.dialog(sel);
			 loop: while (option!=1) {

	    			while(isEmpty) {
	    				if(option==0) {
	    				String string="Nisu unesene sve potrebne vrednosti!";
			    		ClassNameHere.infoBox(string, "Greška");
			    		this.dialog(sel);

	    			} else break;
	    			}

				if(isEmpty) return;

					if(CheckValidity.checkValiditySubject(s,subjKey.getText(),
							 name.getText(),year.getText(),(String)prof.getSelectedItem(),
							 espb.getText(),(String)sem.getSelectedItem())) {
					if (option!=0) return;
					switch(sel) {
						//Ako je dugme new
						case 1:
								SubjectDatabase.addSubject(s);
			    				string="Uspešno unet predmet!";
					    		ClassNameHere.infoBox(string, "Obaveštenje");
					    		int size=ShowTable.getSubjTable().getRowCount();
					    		ShowTable.tableModelSubj.insertRow(size,new Object[]{s.getSubjectId(),subjKey.getText(),
					    						name.getText(),espb.getText(),year.getText(),s.getSemester()});
					    		ShowTable.updateTableSubj();
					    		break loop;

					    	//ako je dugme edit
						case 2:
							SubjectDatabase.changeSubject(s,MainFrame.selRowSubj+1);
							string="Uspešno izmenjen predmet!";
				    		ClassNameHere.infoBox(string, "Obaveštenje");
	
							int i = MainFrame.selRowSubj;
							ShowTable.tableModelSubj.setValueAt(s.getSubjectId(), i, 0);
							ShowTable.tableModelSubj.setValueAt(subjKey.getText(), i, 1);
							ShowTable.tableModelSubj.setValueAt(name.getText(), i, 2);
							ShowTable.tableModelSubj.setValueAt(espb.getText(), i, 3);
							ShowTable.tableModelSubj.setValueAt(year.getText(), i, 4);
							ShowTable.tableModelSubj.setValueAt(s.getSemester(), i, 5);
							ShowTable.updateTableSubj();
							break loop;
					 }
				} else break loop;

			 }


		}


	private ArrayList<JTextField> dialog(int sel){
		ArrayList<JTextField> options=new ArrayList<>();

		Object[] message = {
    		    "Šifra predmeta* ", this.subjKey,
    		    "Naziv* ", this.name,
    		    "Semestar* ", SubjectDialog.sem,
    		    "Godina* ",this.year,
    		    "Profesor* ",this.prof,
    		    "ESPB* ",this.espb,

    		};
		options.add(subjKey);
	     options.add(name);
		 options.add(year);
		 options.add(espb);

		 String nazivDijaloga=null;
		 switch(sel) {
		 case 1:
			 nazivDijaloga="Dodavanje Predmeta";
			 break;
		 case 2:
			 nazivDijaloga="Izmena Predmeta";
			 break;
		 }

    	option = JOptionPane.showConfirmDialog(null, message, nazivDijaloga, JOptionPane.OK_CANCEL_OPTION);
    	isEmpty=false;
		for (JTextField tf:options) {

			if(tf.getText().isEmpty()){
	    		isEmpty=true;
			}
		}
		return options;
	}


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

	public JComboBox<?> getProf() {
		return prof;
	}

	public JTextField getEspb() {
		return espb;
	}

	public void setEspb(JTextField espb) {
		this.espb = espb;
	}






	}

