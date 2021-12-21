package gui;
import java.awt.*;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;

public class Frame extends JFrame {
	
	private JButton newButton=new JButton();
	
	
	
	public Frame() {
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screenSize = kit.getScreenSize();
	int screenHeight = screenSize.height;
	int screenWidth = screenSize.width;
	
	setSize(3*screenWidth / 4, 3*screenHeight / 4);
	
	MenuBar menu = new MenuBar();
	this.setJMenuBar(menu);
	
	ToolBar toolbar= new ToolBar();
	add(toolbar, BorderLayout.NORTH);
	
	this.newButton=toolbar.getNewButton();
	}
	
	
	//Treba mi za prosledjivanje dugmadi iz frejma
	public JButton getNewButton() {
		return this.newButton;
	}
}
