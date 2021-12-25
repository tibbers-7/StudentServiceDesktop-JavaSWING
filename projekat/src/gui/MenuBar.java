package gui;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

import manageEntities.student.ActionStudent;
import manageEntities.subject.ActionSubject;



public class MenuBar extends JMenuBar {
	
	private static final long serialVersionUID = 1L;
	private static int selRow=0;
	
	public static ActionStudent aStud=new ActionStudent();
	public static ActionSubject aSubj=new ActionSubject();
	public static JMenuItem _new = new JMenuItem("New");
	public static JMenuItem _edit2 = new JMenuItem("Edit");
	public static JMenuItem _delete = new JMenuItem("Delete");
	
	//globalni panel da bi mogla da se pamti unesena tabela i kasnije obrise
	public static JScrollPane jsp=new JScrollPane();

	public static int getSelRow() {
		return selRow;
	}

	public static void setSelRow(int selRow) {
		MenuBar.selRow = selRow;
	}

	public MenuBar() {
		
		JMenu _file = new JMenu("File");
		JMenu _edit = new JMenu("Edit");
		JMenu _help = new JMenu("Help");
		
		
		
//FILE 		
		JMenuItem _save = new JMenuItem("Save");
		JMenu _open = new JMenu("Open");	//ima submenu
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
//			_open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
			_close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
	
			
			//Submenu "open" menija
			JMenuItem _studenti = new JMenuItem("Studenti");
			JMenuItem _predmeti = new JMenuItem("Predmeti");
			JMenuItem _profesori = new JMenuItem("Profesori");
			JMenuItem _katedre = new JMenuItem("Katedre");
			
			_studenti.addActionListener(aStud);
			_predmeti.addActionListener(aSubj); 
			
	
			_open.add(_studenti);
			_open.addSeparator();
			_open.add(_predmeti);
			_open.addSeparator();
			_open.add(_profesori);
			_open.addSeparator();
			_open.add(_katedre);
		
			
	//dodavanje itema
			_file.add(_new);
			_file.addSeparator();
			_file.add(_save);
			_file.addSeparator();
			_file.add(_open);
		
			
			_file.addSeparator();
			_file.add(_close);
		
			add(_file);
			
		
		
//EDIT (isto kao i za file sve)
		
		
		
		_edit2.setMnemonic(KeyEvent.VK_E);
		_delete.setMnemonic(KeyEvent.VK_D);
		
		_edit2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		_delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		
			Image _editImg = kit.getImage("src/images/edit.png");
			Image _eeditImg = _editImg.getScaledInstance(20,20, 4);
			Icon _editIcon = new ImageIcon(_eeditImg);
			_edit2.setIcon(_editIcon);
			
			Image _deleteImg = kit.getImage("src/images/delete1.png");
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
			Image _aaboutImg = _aboutImg.getScaledInstance(20,20, 4);
			Icon _aboutIcon = new ImageIcon(_aaboutImg);
			_about.setIcon(_aboutIcon);
		
		
		_help.add(_help2);
		_help.add(_about);
		
		add(_help);
	}
	
	
}
