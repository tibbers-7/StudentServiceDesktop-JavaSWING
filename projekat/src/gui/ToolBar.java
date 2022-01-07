package gui;


import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ToolBar extends JToolBar {

	private static ToolBar instance=null;
	private JButton btnNew=new JButton();
	private JButton btnEdit=new JButton();
	private JButton btnDelete=new JButton();
	public JTextField search = new JTextField();
	public JButton btnSearch = new JButton();
	
	public JButton getBtnNew() {
		return btnNew;
	}
	public void setBtnNew(JButton btnNew) {
		this.btnNew = btnNew;
	}
	public JButton getBtnEdit() {
		return btnEdit;
	}
	public void setBtnEdit(JButton btnEdit) {
		this.btnEdit = btnEdit;
	}
	public JButton getBtnDelete() {
		return btnDelete;
	}
	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public JTextField getSearch() {
		return search;
	}
	public void setSearch(JTextField search) {
		this.search = search;
	}
	public JButton getBtnSearch() {
		return btnSearch;
	}
	public void setBtnSearch(JButton btnSearch) {
		this.btnSearch = btnSearch;
	}
	

	public static ToolBar getInstance() {
		if (instance==null) {
			instance=new ToolBar();
		}
		return instance;
	}
	
	private ToolBar() {
		super(SwingConstants.HORIZONTAL);
		

	//New
		
		btnNew.setPreferredSize(new Dimension(25,25));
		btnNew.setIcon(new ImageIcon("src/images/new1.png"));
		add(this.btnNew);
		addSeparator();
	//Edit
		
		btnEdit.setPreferredSize(new Dimension(25,25));
		btnEdit.setIcon(new ImageIcon("src/images/edit1.png"));
		add(btnEdit);
		addSeparator();
	//Delete
		
	
		this.btnDelete.setPreferredSize(new Dimension(25,25));
		this.btnDelete.setIcon(new ImageIcon("src/images/delete1.png"));
		add(btnDelete);
		
        add(Box.createHorizontalGlue()); 
	
	//Tekstualno polje -search
		
		search.setColumns(30);
		search.setMaximumSize(new Dimension(100,35));
		add(search);
		
	//Search
		
		btnSearch.setPreferredSize(new Dimension(25,25));
		btnSearch.setIcon(new ImageIcon("src/images/search1.png"));
		add(btnSearch);
		
		
		setFloatable(false);
		setBackground(new Color(204,204,204)); 
		
	}
	
	

};
