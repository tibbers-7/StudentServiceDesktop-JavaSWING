package gui.controller.student;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;

import enums.StatusEnum;
import gui.controller.ClassNameHere;
import gui.model.Student;


//Apdejt dijaloga kako bi pamtio vrednosti selektovanog studenta

public class EditStudentDialogUpdate {


	public static StudentDialog editClick(int studentId) {
		Student s=StudentDatabase.findByID(studentId);
		s.writePassedGrades();

		StudentDialog.updatePassedPanel(s, 1);
		StudentDialog sOp=new StudentDialog();

		if(s!=null) {
			DateFormat df = new SimpleDateFormat("dd.mm.yyyy.");
			String dateToStr = df.format(s.getBirthDate());


			JTextField name=new JTextField(s.getName());
			JTextField surname= new JTextField(s.getSurname());
			JTextField birthDate= new JTextField(dateToStr);

			if(s.getAddress()!=null) {
				JTextField address= new JTextField(s.getAddress().addressToStr());
				sOp.setAddress(address);
			}
			JTextField phoneNumber= new JTextField(s.getPhoneNumber());
			JTextField email= new JTextField(s.getEmail());
			JTextField index= new JTextField(s.getIndex());
			JTextField enrollmentYear= new JTextField(Integer.toString(s.getEnrollmentYear()));


			StatusEnum status=s.getStatus();
			if (status==StatusEnum.BUDGET) {
				sOp.status.setSelectedItem("Budzet");
			}else sOp.status.setSelectedItem("Samofinansiranje");

			int year=s.getCurrentStudyYear();

			switch (year){

			case 1:
				sOp.currentStudyYear.setSelectedItem("I (prva)");
				break;
			case 2:
				sOp.currentStudyYear.setSelectedItem("II (druga)");
				break;
			case 3:
				sOp.currentStudyYear.setSelectedItem("III (treca)");
				break;
			case 4:
				sOp.currentStudyYear.setSelectedItem("IV (cetvrta)");
				break;
			}


			sOp.setName(name);
			sOp.setSurname(surname);
			sOp.setBirthDate(birthDate);

			sOp.setPhoneNumber(phoneNumber);
			sOp.setEmail(email);
			sOp.setIndex(index);
			sOp.setEnrollmentYear(enrollmentYear);


			return sOp;


        } else {
        	String string="Student nije pronadjen";
			ClassNameHere.infoBox(string, "Greska");
			return null;
        }
	}





}
