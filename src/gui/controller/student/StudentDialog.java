package gui.controller.student;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import gui.controller.CheckValidity;
import gui.controller.ClassNameHere;
import gui.controller.ShowTable;
import gui.controller.subject.SubjectDatabase;
import gui.model.Grade;
import gui.model.Student;
import gui.model.Subject;
import gui.view.MainFrame;


@SuppressWarnings("serial")


//***************************************************************************************
//***************************************************************************************
//***************************************************************************************

	//StudentDialog mi daje: 1. default dijalog za studenta: dialog()  258
	//						 2. ispis dijaloga studenta na osnovu toga da li je new ili edit: ispisDijaloga() 185
	//						 3. regex dobavljanje predmeta na osnovu stringa iz comboboxa (format SifraPr-NazivPr)
	//						 4. panel za informacije studenta
	//						 5. apdejtovanje tabela


	//ispisDijaloga: sel=1 NOVI STUDENT
	//				 sel=2 EDIT STUDENT

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
	protected JTextField birthDate= new JTextField("01.01.1960.");
	protected JTextField passDate= new JTextField("01.01.1960");
	protected JTextField address= new JTextField("Ulica,Broj,Grad,Drzava");
	protected JTextField phoneNumber= new JTextField();
	protected JTextField email= new JTextField();
	protected JTextField index= new JTextField("SMER broj/godina");
	protected JTextField enrollmentYear= new JTextField();
	public  JComboBox currentStudyYear= new JComboBox(studyYears);
	public JComboBox status= new JComboBox(finansije);
	public static JComboBox newSubj=new JComboBox();
	public static JComboBox grades=new JComboBox(gradesS);


	//Tables
	public static JTable passedTable=new JTable();
	public static JTable failedTable=new JTable();
	public static DefaultTableModel dtm=new DefaultTableModel();
	public static DefaultTableModel dtm2=new DefaultTableModel();

	//Pomocna polja
	private static int option=-1;
	private static boolean isEmpty=true;
	public static int selRowPassed=-1;
	public static int selRowFailed=-1;
	private String string;
	public static String newAvg;
	public static String newEspb;


	public static JPanel pS=new JPanel();
	public static JPanel fS=new JPanel();
	private static JTabbedPane tp=new JTabbedPane();



//	public static StudentDialog getInstance() {
//		if(instance==null) {
//			instance=new StudentDialog();
//		}
//		return instance;
//	}

	//Konstruktor
		public StudentDialog(){
			super();
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
								    		int size=ShowTable.getStudTable().getRowCount();
								    		ShowTable.tableModelStud.insertRow(size,new Object[] {s.getStudentId(),index.getText(),name.getText(),surname.getText()
								    				,s.getCurrentStudyYear(),s.getStatus()});

								    		ShowTable.updateTableStud();
								    		break loop;
		    							}
		    							break;

							    	//ako je dugme edit
		    						case 2:



							    		//Kad se sortira ne moze vise da se trazi preko oznacenog reda nego mora da se dobavlja kljuc (studID)
							               String key1 = (String)ShowTable.getStudTable().getValueAt(MainFrame.selRowStud,0);
							               int key=Integer.parseInt(key1);

							               int keyStud=0;

							               for (int i = ShowTable.tableModelStud.getRowCount() - 1; i >= 0; --i) {
							                       if (ShowTable.tableModelStud.getValueAt(i, 0).equals(Integer.toString(key))) {
							                           // what if value is not unique?
							                           keyStud= i;
							                       }

							               }
							               StudentDatabase.changeStudent(s,key-1);

							               string="Uspesno izmenjen student!";
								    		ClassNameHere.infoBox(string, "Obavestenje");

								    		ShowTable.tableModelStud.setValueAt(key1, keyStud, 0);
								    		ShowTable.tableModelStud.setValueAt(index.getText(), keyStud, 1);
								    		ShowTable.tableModelStud.setValueAt(name.getText(), keyStud, 2);
								    		ShowTable.tableModelStud.setValueAt(surname.getText(), keyStud, 3);
								    		ShowTable.tableModelStud.setValueAt(s.getCurrentStudyYear(), keyStud, 4);
								    		ShowTable.tableModelStud.setValueAt(s.getStatus(), keyStud, 5);
								    		ShowTable.updateTableStud();
							    		break loop;
		    					}



		    				}else this.dialog(sel);


		    		}

			}




	   private ArrayList<JTextField> dialog(int sel) {

		   isEmpty=false;

		   ArrayList<JTextField> options=new ArrayList<>();

		   //Dijalog za dodavanje novog studenta
		      Object[] message = {
		    		    "Ime* ", this.name,
		    		    "Prezime* ", this.surname,
		    		    "Datum rođenja* ", this.birthDate,
		    		    "Adresa stanovanja* ",this.address,
		    		    "Broj telefona* ",this.phoneNumber,
		    		    "E-mail adresa* ",this.email,
		    		    "Broj indeksa* ",this.index,
		    		    "Godina upisa* ",this.enrollmentYear,
		    		    "Trenutna godina studija* ",this.currentStudyYear,
		    		    "Način finansiranja* ",this.status
		    		};

		      //Panel za edit
		      tp=new JTabbedPane();
		      JPanel info=informations();
		      tp.add("Informacije",info);

		      //Panel za polozene ispite
		      Student s=StudentDatabase.findByID(MainFrame.selRowStud+1);
		    	  passedTable=s.getPassedTable();
		    	  passedTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					   @Override
					public void valueChanged(ListSelectionEvent e) {
							selRowPassed=passedTable.getSelectedRow();
							System.out.printf("\n\nselRowPassed="+selRowPassed+"\n\n");
						}
				   });

		    	  pS=new PassedPanel(s);
		    	  tp.add("Položeni ispiti",pS);


		    	  //Panel za nepolozene ispite
		    	  failedTable=s.getFailedTable();
		    	  failedTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					   @Override
					public void valueChanged(ListSelectionEvent e) {
							selRowFailed=failedTable.getSelectedRow();
						}
				   });
		    	  fS=new FailedPanel(s);
			      tp.add("Nepoloženi ispiti",fS);
		      



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
		      studPan.add(new JLabel("Datum rođenja*"));
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
		      studPan.add(new JLabel("Način finansiranja*"));
		      studPan.add(this.status);
		      studPan.setLayout(new BoxLayout(studPan, BoxLayout.PAGE_AXIS));

		      return studPan;
	   }






	   //Apdejtujem obe istovremeno jer su povezane
	   public static void updateExamTable() {
		   dtm.fireTableDataChanged();
		   dtm2.fireTableDataChanged();
	   }

	   //Dobavljanje predmeta na osnovu odabrane stavke u JComboBox dodavanje predmeta
	   // (Ponudjeni odgovori u comboboxu su formata SIFRA-NAZIVpredmeta
	   //  ova metoda sluzi da mi nadje u bazi taj predmet i na osnovu njega formira ocenu)
	   public static Grade getSubjRegex(String str,Student stud) {

			Pattern p = Pattern.compile("^(\\D*)(\\d*)-*");
			Matcher m = p.matcher(str);

			if(m.find()) {
				String subjKey=m.group(1)+m.group(2);
				Subject subj=SubjectDatabase.findByKey(subjKey);
				Grade g=new Grade(stud,subj);
				return g;

			} else {
				String string="REGEX ne valja!";
				ClassNameHere.infoBox(string, "Greska");
				return null;
			}
		}

	   //apdejt espba i proseka
	   public static void updatePassedPanel(Student s,int sel) {
		   if(s==null) {
			   return;
		   }
		   System.out.printf("\nStudentDialog 359: ");
		   s.writePassedGrades();
		   tp.remove(pS);
		   tp.remove(fS);

		   
		   PassedPanel.refreshTable(s);
		   System.out.printf("\nStudentDialog 364: ");
		   s.writePassedGrades();
		   pS=new PassedPanel(s);
		   pS.remove(PassedPanel.b);
		   pS.remove(PassedPanel.avgGrade);
		   pS.remove(PassedPanel.espbSum);
		   pS.remove(PassedPanel.jsp);
		   newAvg=Double.toString(s.getAverageGrade());
		   newEspb=Integer.toString(s.getEspb());
		   PassedPanel.avgGrade=new JLabel("Prosek: "+newAvg);
		   PassedPanel.espbSum=new JLabel("Ukupno ESPB: "+newEspb);

		   passedTable=s.getPassedTable();
		   passedTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			   @Override
			public void valueChanged(ListSelectionEvent e) {
					selRowPassed=passedTable.getSelectedRow();
				}
		   });


		   PassedPanel.jsp=new JScrollPane(passedTable);
		   pS.add(PassedPanel.jsp);
		   pS.add(PassedPanel.b);
		   pS.add(PassedPanel.avgGrade);
		   pS.add(PassedPanel.espbSum);

	       tp.add("Položeni ispiti",pS);
	       tp.add("Nepoloženi ispiti",fS);

	       tp.setSelectedIndex(sel);
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



}