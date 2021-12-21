package gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import enums.*;

import model.Address;
import model.Grade;
import model.Student;
import tableInterfaces.ShowTable;

import java.awt.event.*;
import java.util.Date;
import java.util.List;
import java.util.Vector;


public class MyApp {

	public static void main(String[] args) {
		
		Frame frame = new Frame();
		
		
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setTitle("Studentska služba");
	    
	    frame.add(ShowTable.showEntityTable(2));
//	    JOptionPane.showInputDialog(frame,"Successfully Updated.","Alert",JOptionPane.WARNING_MESSAGE);
//	    
	    frame.setVisible(true);
	}

}
