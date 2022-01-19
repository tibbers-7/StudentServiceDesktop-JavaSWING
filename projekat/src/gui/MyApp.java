package gui;

import javax.swing.WindowConstants;


public class MyApp {

	public static MainFrame f=MainFrame.getInstance();

	public static void main(String[] args) {

	    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    f.setTitle("Studentska služba");


	    f.setVisible(true);
	}

}
