package manageEntities.subject;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import enums.SemesterEnum;
import manageEntities.ClassNameHere;
import model.Subject;


public class EditSubjectDialogUpdate {
	
	private static int selection=0;

	public static int rowClick(JTable table) {
		selection= table.getSelectedRow();
		
		return selection+1;
	}

	

	public static SubjectDialog editClick(int subjId) {
		Subject s=SubjectDatabase.findByID(subjId);
		if(s!=null) {
			
			JTextField subjectKey=new JTextField(s.getSubjectKey());
			JTextField name= new JTextField(s.getName());
			JTextField year= new JTextField(Integer.toString(s.getYear()));
			JTextField espb= new JTextField(Integer.toString(s.getEspbPoints()));
			
			
			
			SemesterEnum sem=s.getSemester();
			if (sem==SemesterEnum.WINTER) {
				SubjectDialog.sem.setSelectedItem("Zimski");
			} else SubjectDialog.sem.setSelectedItem("Letnji");
			
			SubjectDialog sSP=new SubjectDialog();
			sSP.setSubjKey(subjectKey);
			sSP.setName(name);
			sSP.setYear(year);
			sSP.setEspb(espb);
			sSP.setProf(new JTextField("X"));

			return sSP;
			
			
        } else {
        	String string="Predmet nije pronadjen";
			ClassNameHere.infoBox(string, "Greska");
			return null;
        }
	}

};
