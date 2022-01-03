package gui;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MyTabbedPane extends JTabbedPane{
	private static MyTabbedPane instance=null;

	public static MyTabbedPane getInstance() {
		if (instance==null) {
			instance=new MyTabbedPane();
		}
		return instance;
	}
	
	private MyTabbedPane() {
		addTab("Studenti",MyStudentPanel.getInstance());
	}
}
