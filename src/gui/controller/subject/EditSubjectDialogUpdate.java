package gui.controller.subject;
import javax.swing.JTextField;

import gui.controller.ClassNameHere;
import gui.model.Subject;


public class EditSubjectDialogUpdate {



	public static SubjectDialog editClick(int subjId) {
		Subject s=SubjectDatabase.findByID(subjId);
		if(s!=null) {

			JTextField subjectKey=new JTextField(s.getSubjectKey());
			JTextField name= new JTextField(s.getName());
			JTextField year= new JTextField(Integer.toString(s.getYear()));
			JTextField espb= new JTextField(Integer.toString(s.getEspbPoints()));



			SubjectDialog.sem.setSelectedItem(s.getSemesterString());

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

}
