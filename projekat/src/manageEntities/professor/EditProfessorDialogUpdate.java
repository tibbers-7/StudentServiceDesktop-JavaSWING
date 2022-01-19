package manageEntities.professor;

import javax.swing.JTextField;

import enums.TitleEnum;
import manageEntities.ClassNameHere;
import model.Professor;

public class EditProfessorDialogUpdate {

	public static ProfessorDialog editClick(int profId) {
		Professor p=ProfessorDatabase.findByID(profId);
		if(p!=null) {

			JTextField name= new JTextField(p.getName());
			JTextField surname= new JTextField(p.getSurname());
			JTextField email= new JTextField(p.getEmail());


			TitleEnum title=p.getTitle();
			switch (title){
				case DOCENT:{
					ProfessorDialog.title.setSelectedItem("Docent");
					break;
				}
				case REDOVNI_PROFESOR:{
					ProfessorDialog.title.setSelectedItem("Redovni profesor");
					break;
				}
				case VANREDNI_PROFESOR:{
					ProfessorDialog.title.setSelectedItem("Vanredni profesor");
					break;
				}
			}


			ProfessorDialog pD=new ProfessorDialog();
			pD.setName(name);
			pD.setSurname(surname);
			pD.setEmail(email);


			return pD;


        } else {
        	String string="Profesor nije pronađen";
			ClassNameHere.infoBox(string, "Greška");
			return null;
        }
	}

}
