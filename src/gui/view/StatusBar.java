package gui.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class StatusBar extends JPanel{
	private static final long serialVersionUID = -3154738235640121450L;
	public JLabel tab;

	public StatusBar() {
		JLabel name=new JLabel("Studentska služba");
		tab=new JLabel("Tab "+1);
		
		JLabel time=new JLabel();
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		time.setText(dtf.format(LocalDateTime.now()).toString());
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		add(name);
		add(Box.createGlue());
		add(tab);
		add(Box.createGlue());
		add(time);
		
		ActionListener taskPerformer = new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  time.setText(dtf.format(LocalDateTime.now()).toString());
		      }
		  };
		  new Timer(30, taskPerformer).start();
	}
}
