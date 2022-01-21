package gui.controller.student;

import javax.swing.JOptionPane;

import gui.controller.ClassNameHere;
import gui.controller.databases.StudentDatabase;


public class DeleteStudentDialog {
	public static void delMessage(int id) {
		String message="Da li ste sigurni da zelite da obrisete oznaceni red? (Klik na File)";
		int option = JOptionPane.showConfirmDialog(null, message, "Potvrda", JOptionPane.OK_CANCEL_OPTION);
		if(option==0) {
			if (StudentDatabase.idExists(id)) {
				StudentDatabase.delStudent(id);
			} else {
				String msg="Student ne postoji! (Klik na File)";
				ClassNameHere.infoBox(msg, "Greska");			}
		}
	}
}
