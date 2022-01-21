package gui;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.WindowConstants;

import gui.controller.databases.Database;
import gui.view.MainFrame;


public class MyApp {

	public static MainFrame f=MainFrame.getInstance();

	public static void main(String[] args) {

		
	    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    f.setTitle("Studentska služba");
	    
	    Properties properties = new Properties();
	    try {
	      properties.load(new FileInputStream("src/gui/config.properties"));
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }

	    f.setVisible(true);
	}

}
