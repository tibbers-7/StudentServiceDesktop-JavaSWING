package manageEntities.student;
import java.awt.event.MouseAdapter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

import enums.StatusEnum;
import manageEntities.ClassNameHere;
import model.Student;

public class EditStudentDialogUpdate {
	private static int selection=0;
	
	
//	StudentDialog sp=new StudentDialog();
	public static int rowClick(JTable table) {

		selection=table.getSelectedRow();
		return selection+1;
	}
	

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
			
			StatusEnum status=s.getStatus();
			if (status==StatusEnum.BUDGET) {
				StudentDialog.status.setSelectedItem("Budzet");
			}else StudentDialog.status.setSelectedItem("Samofinansiranje");
			
			int year=s.getCurrentStudyYear();
			switch (year){
			
			case 1:
				StudentDialog.currentStudyYear.setSelectedItem("I (prva)");
			case 2:
				StudentDialog.currentStudyYear.setSelectedItem("II (druga)");
			case 3:
				StudentDialog.currentStudyYear.setSelectedItem("III (treca)");
			case 4:
				StudentDialog.currentStudyYear.setSelectedItem("IV (cetvrta)");
			}
			
			StudentDialog sOp=new StudentDialog();
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
	
	public static int getSel() {
		return selection;
	}
	
	
	
  
    
}
