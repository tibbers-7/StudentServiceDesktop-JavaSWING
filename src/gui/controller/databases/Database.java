package gui.controller.databases;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import enums.SemesterEnum;
import enums.StatusEnum;
import enums.TitleEnum;
import gui.controller.CheckValidity;
import gui.controller.ClassNameHere;
import gui.model.Address;
import gui.model.Department;
import gui.model.Grade;
import gui.model.Professor;
import gui.model.Student;
import gui.model.Subject;

public class Database {
	private static int i=0;
	private static ArrayList<Grade> gradesPassed=new ArrayList<>();
	private static ArrayList<Grade> gradesFailed=new ArrayList<>();
	public static ArrayList<Integer> id_subj=new ArrayList<Integer>();
	public static ArrayList<Integer> id_prof=new ArrayList<Integer>();
	
	public static void readFromFile() {
//--------------------------------------------------------------------------------		
// STUDENTI
		
		try {
		      File studFile = new File("files/students.txt");
		      Scanner studReader = new Scanner(studFile);
		      String studData="";
		      while (studReader.hasNextLine()) {
		    	  studData = studReader.nextLine();
		    	  readStudent(studData);
		    		i++;
		    	}
		      
		 
		      studReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }

//--------------------------------------------------------------------------------		
// PREDMETI
		i=0;
		try {
			File subjFile = new File("files/subjects.txt");
		      Scanner subjReader = new Scanner(subjFile);
		      String subjData="";
		      while (subjReader.hasNextLine()) {
		    	  subjData = subjReader.nextLine();
		    	  i++;
		    	  readSubject(subjData);
		    		
		    	}
		      
		     subjReader.close();
		} catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
//--------------------------------------------------------------------------------		
//	PROFESORI	
		i=0;
		try {
			File profFile = new File("files/professors.txt");
		      Scanner profReader = new Scanner(profFile);
		      String profData="";
		      while (profReader.hasNextLine()) {
		    	  profData = profReader.nextLine();
		    	  i++;
		    	  readProfessor(profData);
		    		
		    	}
		      
		    
			profReader.close();
		} catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		i=0;
		
//--------------------------------------------------------------------------------		
//	ADRESE
		try {
			File addrFile = new File("files/addresses.txt");
		      Scanner addrReader = new Scanner(addrFile);
		      String addrData="";
		      while (addrReader.hasNextLine()) {
		    	  addrData = addrReader.nextLine();
		    	  i++;
		    	  readAddress(addrData);
		    		
		    	}
		      
		      addrReader.close();
		} catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		

//--------------------------------------------------------------------------------		
//	KATEDRE
		i=0;
		try {
			File depFile = new File("files/departments.txt");
		      Scanner depReader = new Scanner(depFile);
		      String depData="";
		      while (depReader.hasNextLine()) {
		    	  depData = depReader.nextLine();
		    	  i++;
		    	  readDepartment(depData);
		    		
		    	}
		      
		      depReader.close();
		} catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }

		
//--------------------------------------------------------------------------------	
// POLOZENI ISPITI
		
		i=0;
		try {
			File pGradeFile = new File("files/passedGrades.txt");
		      Scanner pGradeReader = new Scanner(pGradeFile);
		      String pGradeData="";
		      while (pGradeReader.hasNextLine()) {
		    	  pGradeData = pGradeReader.nextLine();
		    	  i++;
		    	  readPGrade(pGradeData);
		    		
		    	}
		      
		      Grade.assignPassedGrades(gradesPassed);
		      pGradeReader.close();
		      
		} catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
//--------------------------------------------------------------------
// NEPOLOZENI ISPITI
		i=0;
		try {
			File fGradeFile = new File("files/failedGrades.txt");
		      Scanner fGradeReader = new Scanner(fGradeFile);
		      String fGradeData="";
		      while (fGradeReader.hasNextLine()) {
		    	  fGradeData = fGradeReader.nextLine();
		    	  i++;
		    	  readFGrade(fGradeData);
		    		
		    	}
		      
			  Grade.assignFailedGrades(gradesFailed);
		      fGradeReader.close();
		      
		} catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		
		
	}
	
	private static void readStudent(String data) {
//		indeks	ime	prezime	godina	datum rodjenja	id_adrese_stanovanja	kontakt telefon	email adresa	status	godina upisa
		
		
		Pattern p = Pattern.compile("^\\d+\\t"
									+ "(\\D+\\s?\\d+/\\d+)\\t"	//1 INDEKS
									+ "(\\D+)\\t"  //2 IME
									+ "(\\D+)\\t"  //3 PREZIME
									+ "(\\d{1})\\t"  //4 GODINA STUDIJA
									+ "(\\d{2}.\\d{2}.\\d{4}.)\\t"  //5 DATUM RODJENJA
									+ "(\\d+|null)\\t?"	//6 ID ADRESE
									+ "(\\d+/?\\d+-?\\d+)" //7 TELEFON
									+ "(\\D+@\\D+)\\t"	//8 MEJL
									+ "([SB])\\t"
									+ "(\\d{4})");		//status	
		Matcher m = p.matcher(data);
		String index,name,surname,phoneNum,mail;
		int year,adId,enrollYear;
		StatusEnum status;
		
		if(m.find()) {
			
			index=m.group(1);
			name=m.group(2);
			surname=m.group(3);
			year=Integer.parseInt(m.group(4));
			Date d=CheckValidity.formatDate(m.group(5));
			Address address=new Address();
			if(m.group(6).equals("null")) {
				adId=0;
			} else {
				adId=Integer.parseInt(m.group(6));
				address=AddressDatabase.findByID(adId);
			}
			
			phoneNum=m.group(7);
			mail=m.group(8);
			if(m.group(9).equals("B")) {
				status=StatusEnum.BUDGET;
			} else status=StatusEnum.SELF_FINANCING;
			
			enrollYear=Integer.parseInt(m.group(10));


			Student s=new Student(surname,name,d,address,phoneNum,mail,index,enrollYear,year,status);
			StudentDatabase.addStudent(s);
			
		} else {
			String string="Greska u studentu "+i;
			ClassNameHere.infoBox(string, "Greska");
		}
		}
	
	private static void readDepartment(String data) {
//id	sifra	naziv	id_sefa_katedre
		String r0="\\d+\\t";
		String r1="(\\w+)\\t";
		String r2="([\\s\\D]+)\\t";
		String r3="(\\d+|null)";
		
			Pattern p=Pattern.compile(r0+r1+r2+r3);
			Matcher m=p.matcher(data);
			int depManager;
			Professor manager=new Professor();
			if(m.find()) {
				if(m.group(3).equals("null")) {
					depManager=0;
				} else {
					depManager=Integer.parseInt(m.group(3));
					manager=ProfessorDatabase.findByID(depManager);
				}
				
				Department d=new Department(m.group(1),m.group(2),manager);
				DepartmentDatabase.addDepartment(d);
			}else {
				String string="\nGreska u katedri "+i;
				System.out.printf(string);
			}
	}

	private static void readAddress(String data) {
//id	Ulica	Broj	Grad	Država
		String r0="\\d+\\t";
		String r1="([\\s\\D]+)\\t";
		String r2="(\\w+)\\t";
		String r3="([\\s\\D]+)\\t";
		String r4="(\\D+)";
		
			Pattern p=Pattern.compile(r0+r1+r2+r3+r4);
			Matcher m=p.matcher(data);
			
			if(m.find()) {
				Address a=new Address(m.group(1),m.group(2),m.group(3),m.group(4));
				AddressDatabase.addAddress(a);
			}else {
				String string="\nGreska u adresi "+i;
				System.out.printf(string);
			}
		
	}


	private static void readProfessor(String data) {
//		1	123123123	Milos	Nikolic	12.12.1965.	1	021/356-785	milos.nikolic@mailinator.com	10	30	REDOVNI_PROFESOR	1
		String r1="\\d+\\t";
		String r2="(\\d+)\\t";
		String r3="(\\D+)\\t";
		String r4="(\\D+)\\t";
		String r5="(\\d{2}.\\d{2}.\\d{4}.)\\t";
		String r6="(\\d+|null)\\t";
		String r7="(\\d+/?\\d+-?\\d+)\\t";
		String r8="(\\D+@\\D+)\\t";
		String r9="(\\d+|null)\\t";
		String r10="(\\d+)\\t";
		String r11="(\\w+)\\t";
		String r12="(\\d+)";
		
			Pattern p=Pattern.compile(r1
									+ r2 //1 licna_karta
									+ r3 //2 ime
									+ r4 //3 prezime
									+ r5 //4 datum rodjenja
									+ r6 //5 id_adrese_stanovanja
									+ r7 //6 kontakt telefon
									+ r8 //7 email adresa
									+ r9 //8 id_adrese_kancelarije
									+ r10 //9 godine staža
									+ r11 //10 zvanje
									+ r12);  //11 id_katedre
			Matcher m=p.matcher(data);									
			int personalId,addressId,officeId,trailYears,depId;
			TitleEnum title;
			
			
			if (m.find()) {
				personalId=Integer.parseInt(m.group(1));
				Date d=CheckValidity.formatDate(m.group(4));
				Address ad=new Address();
				Address adOf=new Address();
				
				if(m.group(5).equals("null")) {
					addressId=0;
				} else {
					addressId=Integer.parseInt(m.group(5));
					ad=AddressDatabase.findByID(addressId);
				}
				
				if(m.group(8).equals("null")){
					officeId=0;
				} else {
					officeId=Integer.parseInt(m.group(8));
					adOf=AddressDatabase.findByID(officeId);
				}
				
				trailYears=Integer.parseInt(m.group(9));
				title=Professor.getTitleEnum(m.group(10));
				
				Department dep=new Department();
				if(m.group(11).equals("null")) {
					depId=0;
				} else {
					depId=Integer.parseInt(m.group(11));
					dep=DepartmentDatabase.findByID(depId);
				}
				Professor prof=new Professor(personalId,m.group(3),m.group(2),d,ad,m.group(6),m.group(7),adOf,title,trailYears,dep);
				ProfessorDatabase.rowNum++;
				
				prof.setProfessorId(ProfessorDatabase.rowNum);
				SubjectDatabase.assignSubjects(prof);
				ProfessorDatabase.addProfessor(prof);

			}else {
				String string="\nGreska u profesoru "+i;
				System.out.printf(string);
			}
	}

	private static void readSubject(String data) {
//		sifra	naziv	godina	espb	id_profesora	semestar
		String r1="^\\d+\\t";
		String r2="(\\w+)\\t";
		String r3="([\\s\\w]+)\\t";
		String r4="(\\d{1})\\t";
		String r5="(\\d+)\\t";
		String r6="(\\d+|null)\\t";
		String r7="(\\D+)";
		Pattern p = Pattern.compile(r1	//  id
									+ r2 // 1.sifra
									+ r3 // 2.naziv
									+ r4 //3. godina
									+ r5//4. espb
									+ r6 //5. idProf
									+ r7); //6. semestar
		Matcher m = p.matcher(data);
		
		int idProf;
		if(m.find()) {
			if(m.group(5).equals("null")) {
				idProf=0;
			} else idProf=Integer.parseInt(m.group(5));

			int year=Integer.parseInt(m.group(3));
			int espb=Integer.parseInt(m.group(4));
			SemesterEnum sem=Subject.semFromString(m.group(6));
			
			Subject s=new Subject(m.group(1),m.group(2),sem,year,idProf,espb);
			SubjectDatabase.addSubject(s);
		}else {
			String string="\nGreska u predmetu "+i;
			System.out.printf(string);
		}
	}

	private static void readPGrade(String data) {
//id_student	id_predmet	vrednost_ocene	datum polaganja
		String r1="(\\d+)\\t";
		String r2="(\\d{2}.\\d{2}.\\d{4}.)";
		
		Pattern p=Pattern.compile(r1+r1+r1+r2);
		Matcher m=p.matcher(data);
		
			if (m.find()) {
				Student s=StudentDatabase.findByID(Integer.parseInt(m.group(1)));
				Subject subj=SubjectDatabase.findByID(Integer.parseInt(m.group(2)));
				Date d=CheckValidity.formatDate(m.group(4));
				Grade g=new Grade(s,subj,Integer.parseInt(m.group(3)),d);
				gradesPassed.add(g);
			}else {
				String string="\nGreska u oceni "+i;
				System.out.printf(string);
			}
	}
	
	private static void readFGrade(String data) {
		//id_studenta	id_predmeta
		String r1=("^(\\d+)\\t");
		String r2=("(\\d+)");
		
		Pattern p=Pattern.compile(r1+r2);
		Matcher m=p.matcher(data);
		
		if(m.find()) {
			Student s=StudentDatabase.findByID(Integer.parseInt(m.group(1)));
			Subject subj=SubjectDatabase.findByID(Integer.parseInt(m.group(2)));
			
			Grade g=new Grade(s,subj);
			gradesFailed.add(g);
		}else {
			String string="\nGreska u oceni "+i;
			System.out.printf(string);
		}
	}

}
