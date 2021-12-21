package manageEntities;
import java.awt.event.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import model.*;

public class AddEntity {
	private ArrayList<Object> students= new ArrayList<Object>();
	private ArrayList<Object> professors= new ArrayList<Object>();
	private ArrayList<Object> subjects= new ArrayList<Object>();
	
	
	//Na ovome ja radim-Anja
	public boolean addStudent(Student s, JButton newButton) {
		
		newButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 students.add(s);
	        	 //DIJALOG
	         }
		});
		return false;
		
	}
	
	
	//Treba implementirati
	
	public boolean addProfessor(Professor p) {
		
		
		try {
			professors.add(p);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	public boolean addSubject(Subject subj) {
		try {
			subjects.add(subj);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	
	
}
