package manageEntities.student;

import javax.swing.JOptionPane;

import model.Student;

public class DeletePane {
	public static void delMessage(int id) {
		String message="Da li ste sigurni da zelite da obrisete oznacenu kolonu?";
		int option = JOptionPane.showConfirmDialog(null, message, "Potvrda", JOptionPane.OK_CANCEL_OPTION);
		if(option==0) {
			
			StudentDatabase.delStudent(id);
		}
	}
}
