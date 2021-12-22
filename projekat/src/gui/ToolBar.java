package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class ToolBar extends JToolBar {

	private JButton btnNew=new JButton();
	private JButton btnEdit=new JButton();;
	public ToolBar() {
		super(SwingConstants.HORIZONTAL);
		

	//New
		this.btnNew.setToolTipText("New");
		this.btnNew.setPreferredSize(new Dimension(25,25));
		this.btnNew.setIcon(new ImageIcon("src/images/new1.png"));
		add(this.btnNew);
		addSeparator();
	//Edit
		this.btnEdit.setToolTipText("Edit");
		this.btnEdit.setPreferredSize(new Dimension(25,25));
		this.btnEdit.setIcon(new ImageIcon("src/images/edit1.png"));
		add(this.btnEdit);
		addSeparator();
	//Delete
		JButton btnDelete = new JButton();
		btnDelete.setToolTipText("Delete");
		btnDelete.setPreferredSize(new Dimension(25,25));
		btnDelete.setIcon(new ImageIcon("src/images/delete1.png"));
		add(btnDelete);
		
        add(Box.createHorizontalGlue()); 
	
	//Tekstualno polje -search
		JTextField search = new JTextField();
		search.setColumns(30);
		search.setMaximumSize(new Dimension(100,35));
		add(search);
		
	//Search
		JButton btnSearch = new JButton();
		btnSearch.setToolTipText("Search");
		btnSearch.setPreferredSize(new Dimension(25,25));
		btnSearch.setIcon(new ImageIcon("src/images/search1.png"));
		add(btnSearch);
		
		
		setFloatable(false);
		setBackground(new Color(204,204,204)); 
		
	}
	
	public JButton getNewButton() {
		return this.btnNew;
	}
	
	public JButton getEditButton() {
		return this.btnEdit;
	}

}
