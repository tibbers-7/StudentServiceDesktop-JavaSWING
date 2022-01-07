package gui;

import javax.swing.JFrame;


public class MyApp {
	
	public static MainFrame f=MainFrame.getInstance();

	public static void main(String[] args) {

	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setTitle("Studentska služba");
	    

	    f.setVisible(true);
	}

};
