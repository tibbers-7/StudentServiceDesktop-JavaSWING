package gui.controller.department;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import gui.controller.ClassNameHere;
import gui.controller.ShowTable;
import gui.controller.databases.DepartmentDatabase;
import gui.controller.databases.ProfessorDatabase;
import gui.model.Department;
import gui.model.Professor;
import gui.view.MainFrame;

public class DepartmentDialog {
	
	private static String[] profList= {};
	public static JComboBox profesori= new JComboBox();
	private static int option=-1;

	public static void ispisDijaloga() {

		String string;
		Department d=DepartmentDatabase.findByID(MainFrame.selRowDep+1);
		Professor p=dialog(d);
		if (option==0) {
			if(p!=null) {
				d.setDepartmentManager(p);
				String selVal=(String)ShowTable.getDepTable().getValueAt(MainFrame.selRowDep, 0);
				int key=Integer.parseInt(selVal);
				ShowTable.tableModelDep.setValueAt(p.getProfForDep(),MainFrame.selRowDep,3);;
				ShowTable.updateTableDep();
				string="Uspesno unet šef katedre!";
	    		ClassNameHere.infoBox(string, "Obaveštenje");
			}
			else {
				string="Nesto ne valja";
	    		ClassNameHere.infoBox(string, "Greska");
			}
		} 
	}
	
	private static Professor dialog(Department d) {
		
		
		Professor p=new Professor();
		
		profList=ProfessorDatabase.getProfList();
		profesori=new JComboBox(profList);
		
		JPanel panel=new JPanel();
		panel.add(new JLabel("Profesor:"));
		panel.add(profesori);
		panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
		
		String nazivDijaloga="Dodavanje šefa katedre";
		 option = JOptionPane.showConfirmDialog(null, panel, nazivDijaloga, JOptionPane.OK_CANCEL_OPTION);
		
		if (d!=null) {
			String profStr=(String) profesori.getSelectedItem();
			p=ProfessorDatabase.getProfRegex(profStr);
		}
		
		return p;
		
	}
}
