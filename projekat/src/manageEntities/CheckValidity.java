package manageEntities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import enums.SemesterEnum;
import enums.StatusEnum;
import enums.TitleEnum;
import model.Address;
import model.Professor;
import model.Student;
import model.Subject;

//Proverava jesu li dobro uneseni podaci


public class CheckValidity {

	public static final SimpleDateFormat formatter = new SimpleDateFormat("dd.mm.yyyy.", Locale.ENGLISH);
	private static final Pattern pEmail = Pattern.compile(".+@.+.com{1}");
	private static String string;

	public static boolean checkValidityStudent(Student s,String name,String surname,String birthDate,
			String address,String phoneNumber,String email,
			String index,String enrollmentYear,String currentStudyYear,
			String status) {

				s.setName(name);
				s.setSurname(surname);
				s.setIndex(index);
				s.setStudentId();

				//Dobavljanje datuma,provera formata
				Date d=formatDate(birthDate);
				if (d!=null) {
					s.setBirthDate(d);
				} else {
					string="Datum nije dobro unesen (dd-MMM-yyyy)";
					ClassNameHere.infoBox(string, "Greska");
					return false;
				}

				//Dobavljanje adrese i provera jel dobro ukucana
				Address a=Address.formatAddress(address);

				if(a!=null) {
					s.setAddress(a);
				} else {
					string="Format adrese nije dobro unesen (Ulica,Broj,Grad,Zemlja)";
					ClassNameHere.infoBox(string, "Greska");
					return false;

				}



				Matcher mEmail = pEmail.matcher(email);
				if(mEmail.find()) {
					s.setEmail(email);
				}else {
					string="Pogrešno unet mail!";
					ClassNameHere.infoBox(string, "Greska");
					return false;
				}

				Pattern pIndex = Pattern.compile("^(\\D+)\\s?(\\d+)/(\\d+)");
				Matcher mIndex = pIndex.matcher(index);

				if(mIndex.find()) {
					s.setIndex(index);
				} else {
					string="Pogresno unet index!\nFormat indeksa: RA100-2020";
					ClassNameHere.infoBox(string, "Greska");
					return false;
				}


				if (phoneCheck(phoneNumber)){
					s.setPhoneNumber(phoneNumber);
				} else {
					string="Broj telefona sme da sadrzi samo cifre!";
					ClassNameHere.infoBox(string, "Greska");
					return false;
				}

				s.setEnrollmentYear(Integer.parseInt(enrollmentYear));

				//Dobavljanje statusa

				if(status=="Budzet") {
					s.setStatus(StatusEnum.BUDGET);
				} else s.setStatus(StatusEnum.SELF_FINANCING);

				//Dobavljanje godine studija
				String currYear=currentStudyYear;
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

				return true;
	}

	public static boolean checkValiditySubject(Subject s,String subjectKey,
			   String name,String year, String professor,
			   String espbPoints,String sem) {

			s.setSubjectKey(subjectKey);
			s.setName(name);
			s.setEspbPoints(Integer.parseInt(espbPoints));
			s.setYear(Integer.parseInt(year));

			if (sem=="Zimski") {
				s.setSemester(SemesterEnum.WINTER);
			} else s.setSemester(SemesterEnum.SUMMER);

			Professor p=new Professor();
			//TREBA IMPLEMENTIRATI
			s.setProfessor(p);

			return true;
	}

	public static boolean checkValidityProfessor(Professor p, String name, String surname, String email,
			String title) {
		p.setName(name);
		p.setSurname(surname);
		Matcher mEmail = pEmail.matcher(email);
		if(mEmail.find()) {
			p.setEmail(email);
		}else {
			string="Pogrešno unet mail!";
			ClassNameHere.infoBox(string, "Greska");
			return false;
		}

		switch(title) {
			case "Docent": {
				p.setTitle(TitleEnum.DOCENT);
				break;
			}
			case "Redovni profesor": {
				p.setTitle(TitleEnum.REDOVNI_PROFESOR);
				break;
			}
			case "Vanredni profesor": {
				p.setTitle(TitleEnum.VANREDNI_PROFESOR);
				break;
			}
		}
		return true;
	}


	public static boolean isNumeric(CharSequence cs) {
		if (cs == null) {
            return false;
        }
        int sz = cs.length();
        for (int i = 0; i < sz; i++) {
            if (!Character.isDigit(cs.charAt(i))) {
                return false;
            }
        }
        return true;
	}

	public static boolean phoneCheck(String num) {
		Pattern p = Pattern.compile("^(\\d{3})/(\\d+)-(\\d+)");
		Matcher m = p.matcher(num);

		if(m.find()) {
			return true;

		} else {
			System.out.printf("Ne radi regex");
			return false;
		}
	}

	public static Date formatDate(String s) {

		 try {
			Date d = formatter.parse(s);
			return d;
		} catch (ParseException e) {

			e.printStackTrace();
			return null;
		}

	}





}
