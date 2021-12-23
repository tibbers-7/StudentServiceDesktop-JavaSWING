package manageEntities.subject;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import manageEntities.ClassNameHere;
import manageEntities.student.StudentDatabase;
import model.Subject;


public class EditSubject extends MouseAdapter{
	
	private static int selection=0;

	public static int rowClick(JTable table,JButton editB) {
		table.addMouseListener(new EditSubject());
		return selection+1;
	}
	
	@Override
    public void mousePressed(MouseEvent e)
    {
        JTable jtable = (JTable) e.getSource();
        selection= jtable.getSelectedRow();

    }

	public static SubjectPane editClick(int subjId) {
		Subject s=SubjectDatabase.findByID(subjId);
		if(s!=null) {
			
			JTextField subjectKey=new JTextField(s.getSubjectKey());
			JTextField name= new JTextField(s.getName());
			JTextField year= new JTextField(Integer.toString(s.getYear()));
			JTextField espb= new JTextField(Integer.toString(s.getEspbPoints()));

			
			
			SubjectPane sSP=new SubjectPane();
			sSP.setSubjKey(subjectKey);
			sSP.setName(name);
			sSP.setYear(year);
			sSP.setEspb(espb);

			return sSP;
			
			
        } else {
        	String string="Predmet nije pronadjen";
			ClassNameHere.infoBox(string, "Greska");
			return null;
        }
	}

};
