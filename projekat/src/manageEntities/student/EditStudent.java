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
			
			StatusEnum status=s.getStatus();
			if (status==StatusEnum.BUDGET) {
				StudentPane.status.setSelectedItem("Budzet");
			}else StudentPane.status.setSelectedItem("Samofinansiranje");
			
			int year=s.getCurrentStudyYear();
			switch (year){
			
			case 1:
				StudentPane.currentStudyYear.setSelectedItem("I (prva)");
			case 2:
				StudentPane.currentStudyYear.setSelectedItem("II (druga)");
			case 3:
				StudentPane.currentStudyYear.setSelectedItem("III (treca)");
			case 4:
				StudentPane.currentStudyYear.setSelectedItem("IV (cetvrta)");
			}
			
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
