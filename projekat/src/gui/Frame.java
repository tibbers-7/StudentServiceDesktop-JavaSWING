package gui;

import java.awt.*;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Frame extends JFrame {
	
	public Frame() {
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screenSize = kit.getScreenSize();
	int screenHeight = screenSize.height;
	int screenWidth = screenSize.width;
	
	setSize(3*screenWidth / 4, 3*screenHeight / 4);
	
	MenuBar menu = new MenuBar();
	this.setJMenuBar(menu);
	
	}
}
