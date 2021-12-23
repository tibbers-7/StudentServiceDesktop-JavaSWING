package manageEntities.student;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.*;
import manageEntities.ClassNameHere;
import model.Student;

public class EditStudent extends MouseAdapter{
	private static int selection=0;
	
	
//	StudentPane sp=new StudentPane();
	public static int rowClick(JTable table,JButton editB) {

		selection=table.getSelectedRow();
		return selection+1;
	}
	

	public static StudentPane editClick(int studentId) {
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
			
			
			StudentPane sOp=new StudentPane();
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
