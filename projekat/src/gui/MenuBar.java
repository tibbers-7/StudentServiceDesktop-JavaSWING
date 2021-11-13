package gui;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;


import javax.swing.*;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class MenuBar extends JMenuBar {
	

	public MenuBar() {
		
		
		JMenu _file = new JMenu("File");
		JMenu _edit = new JMenu("Edit");
		JMenu _help = new JMenu("Help");
		
		
		
//FILE 		
		JMenuItem _new = new JMenuItem("New");
		JMenuItem _save = new JMenuItem("Save");
		JMenuItem _open = new JMenuItem("Open");
		JMenuItem _close = new JMenuItem("Close");
		
	//Ikone	
		
		Toolkit kit=Toolkit.getDefaultToolkit();
		
			Image _newImg = kit.getImage("src/images/new.png");
			Image _nnewImg = _newImg.getScaledInstance(20,20, 4);
			Icon _newIcon = new ImageIcon(_nnewImg);
			_new.setIcon(_newIcon);
			
			Image _saveImg = kit.getImage("src/images/save.png");
			Image _ssaveImg = _saveImg.getScaledInstance(20,20, 4);
			Icon _saveIcon = new ImageIcon(_ssaveImg);
			_save.setIcon(_saveIcon);
			
			Image _openImg = kit.getImage("src/images/open.png");
			Image _oopenImg = _openImg.getScaledInstance(20,20, 4);
			Icon _openIcon = new ImageIcon(_oopenImg);
			_open.setIcon(_openIcon);
			
			Image _closeImg = kit.getImage("src/images/close.png");
			Image _ccloseImg = _closeImg.getScaledInstance(20,20, 4);
			Icon _closeIcon = new ImageIcon(_ccloseImg);
			_close.setIcon(_closeIcon);
		
		
	//Mnemonici	
			_new.setMnemonic(KeyEvent.VK_N);
			_save.setMnemonic(KeyEvent.VK_S);
			_open.setMnemonic(KeyEvent.VK_O);
			_close.setMnemonic(KeyEvent.VK_C);
		
	//Akceleratori
		
			_new.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
			_save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
			_open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
			_close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
			
			//dodavanje itema
			_file.add(_new);
			_file.addSeparator();
			_file.add(_save);
			_file.addSeparator();
			_file.add(_open);
			_file.addSeparator();
			_file.add(_close);
		
		
		
//Button group NE RADI
//		ButtonGroup _bg = new ButtonGroup();
//		JRadioButtonMenuItem _studenti = new JRadioButtonMenuItem("Studenti");
//		JRadioButtonMenuItem _predmeti = new JRadioButtonMenuItem("Predmeti");
//		JRadioButtonMenuItem _profesori = new JRadioButtonMenuItem("Profesori");
//		JRadioButtonMenuItem _katedre = new JRadioButtonMenuItem("Katedre");
//		_bg.add(_studenti);
//		_bg.add(_predmeti);
//		_bg.add(_profesori);
//		_bg.add(_katedre);
//			
//		add(_file);
		
//EDIT (isto kao i za file sve)
		
		JMenuItem _edit2 = new JMenuItem("Edit");
		JMenuItem _delete = new JMenuItem("Delete");
		
		_edit2.setMnemonic(KeyEvent.VK_E);
		_delete.setMnemonic(KeyEvent.VK_D);
		
		_edit2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		_delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		
			Image _editImg = kit.getImage("src/images/edit.png");
			Image _eeditImg = _closeImg.getScaledInstance(20,20, 4);
			Icon _editIcon = new ImageIcon(_eeditImg);
			_edit2.setIcon(_editIcon);
			
			Image _deleteImg = kit.getImage("src/images/edit.png");
			Image _ddeleteImg = _deleteImg.getScaledInstance(20,20, 4);
			Icon _deleteIcon = new ImageIcon(_ddeleteImg);
			_delete.setIcon(_deleteIcon);
		
		_edit.add(_edit2);
		_edit.addSeparator();
		_edit.add(_delete);
		
		add(_edit);
		
//HELP
		JMenuItem _help2 = new JMenuItem("Help");
		JMenuItem _about = new JMenuItem("About");
		
		_help2.setMnemonic(KeyEvent.VK_H);
		_about.setMnemonic(KeyEvent.VK_A);
		
		_help2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		_about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		
			Image _helpImg = kit.getImage("src/images/help.png");
			Image _hhelpImg = _helpImg.getScaledInstance(20,20, 4);
			Icon _helpIcon = new ImageIcon(_hhelpImg);
			_help2.setIcon(_helpIcon);
			
			Image _aboutImg = kit.getImage("src/images/about.png");
			Image _aaboutImg = _deleteImg.getScaledInstance(20,20, 4);
			Icon _aboutIcon = new ImageIcon(_aaboutImg);
			_about.setIcon(_aboutIcon);
		
		
		_help.add(_help2);
		_help.add(_about);
		
		add(_help);
	}
}
