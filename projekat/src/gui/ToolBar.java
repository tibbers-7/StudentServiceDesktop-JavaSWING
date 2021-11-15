package gui;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import java.awt.event.*;

import org.w3c.dom.events.MouseEvent;

public class ToolBar extends JToolBar {

	public ToolBar() {
		super(SwingConstants.HORIZONTAL);
		

		
		JButton btnNew = new JButton();
		btnNew.setToolTipText("New");
		btnNew.setIcon(new ImageIcon("src/images/new1.png"));
		add(btnNew);


		JButton btnOpen = new JButton();
		btnOpen.setToolTipText("Edit");
		btnOpen.setIcon(new ImageIcon("src/images/edit1.png"));
		add(btnOpen);

		

		JButton btnDelete = new JButton();
		btnDelete.setToolTipText("Delete");
		btnDelete.setIcon(new ImageIcon("src/images/delete1.png"));
		add(btnDelete);

		
		JTextField textField = new JTextField("search");
		
		
		//Trebalo da obrise "search" kad se klikne (ali ne radi)
			textField.addMouseListener(new MouseAdapter() {
				  @SuppressWarnings("unused")
				public void mouseClicked(MouseEvent e) {
				    textField.setText("");
				  }
				});
			
		add(textField);
		
		
		
		
		JButton btnSearch = new JButton();
		btnSearch.setToolTipText("Search");
		btnSearch.setIcon(new ImageIcon("src/images/search1.png"));
		add(btnSearch);
		
		setFloatable(true);
		setBackground(new Color(0, 0, 0));
		
	}

}
