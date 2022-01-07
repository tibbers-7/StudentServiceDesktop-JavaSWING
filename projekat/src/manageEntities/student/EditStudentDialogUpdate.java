package manageEntities.student;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JTextField;

import enums.StatusEnum;
import manageEntities.ClassNameHere;
import model.Student;


//Apdejt dijaloga kako bi pamtio vrednosti selektovanog studenta

public class EditStudentDialogUpdate {
	

	public static StudentDialog editClick(int studentId) {
		Student s=StudentDatabase.findByID(studentId);

		if(s!=null) {
			DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
			String dateToStr = df.format(s.getBirthDate());
			
			
			JTextField name=new JTextField(s.getName());
			JTextField surname= new JTextField(s.getSurname());
			JTextField birthDate= new JTextField(dateToStr);
			JTextField address= new JTextField(s.getAddress().addressToStr());
			JTextField phoneNumber= new JTextField(Long.toString(s.getPhoneNumber()));
			JTextField email= new JTextField(s.getEmail());
			JTextField index= new JTextField(s.getIndex());
			JTextField enrollmentYear= new JTextField(Integer.toString(s.getEnrollmentYear()));
			
			StudentDialog sOp=new StudentDialog();
			StatusEnum status=s.getStatus();
			if (status==StatusEnum.BUDGET) {
				sOp.status.setSelectedItem("Budzet");
			}else sOp.status.setSelectedItem("Samofinansiranje");
			
			int year=s.getCurrentStudyYear();
			
			
			switch (year){
			
			case 1:
				sOp.currentStudyYear.setSelectedIndex(0);
			case 2:
				sOp.currentStudyYear.setSelectedIndex(1);
			case 3:
				sOp.currentStudyYear.setSelectedIndex(2);
			case 4:
				sOp.currentStudyYear.setSelectedIndex(3);
			}
			
			
			sOp.setName(name);
			sOp.setSurname(surname);
			sOp.setBirthDate(birthDate);
			sOp.setAddress(address);
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
