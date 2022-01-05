package manageEntities;

import java.util.*;

import org.apache.commons.lang3.StringUtils;
import enums.SemesterEnum;
import enums.StatusEnum;
import model.Address;
import model.Professor;
import model.Student;
import model.Subject;

public class CheckValidity {
	public static boolean checkValidityStudent(Student s,String name,String surname,String birthDate,
			String address,String phoneNumber,String email, 
			String index,String enrollmentYear,String currentStudyYear, 
			String status) {
				String string;
				s.setName(name);
				s.setSurname(surname);
				s.setIndex(index);
				s.setStudentId();
				
				//Dobavljanje datuma,provera formata
				Date d=Student.formatDate(birthDate);
				if (d!=null) {
					s.setBirthDate(d);
				} else {
					string="Datum nije dobro unesen (dd-MMM-yyyy)";
					ClassNameHere.infoBox(string, "Greska");
					return false;
				}
				
				//Dobavljanje adrese i provera jel dobro ukucana
				//poziva se kreirana metoda u klasi adresa
				Address a=Address.formatAddress(address);
				
				if(a!=null) {
					s.setAddress(a);
				} else {
					string="Format adrese nije dobro unesen (Ulica,Broj,Grad,Zemlja)";
					ClassNameHere.infoBox(string, "Greska");
					return false;

				}
				
				s.setEmail(email);
				s.setIndex(index);
				
				if (StringUtils.isNumeric(phoneNumber)){
					s.setPhoneNumber(Long.parseLong(phoneNumber));
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
				String currYear=(String) currentStudyYear;
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
	
	
	
};
