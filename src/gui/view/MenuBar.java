package gui.view;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import gui.controller.student.MenuBarActionStudent;
import gui.controller.subject.MenuBarActionSubject;



public class MenuBar extends JMenuBar {

	private static MenuBar instance=null;

	private static final long serialVersionUID = 1L;
	private static int selRow=0;

	public static MenuBarActionStudent aStud=new MenuBarActionStudent();
	public static MenuBarActionSubject aSubj=new MenuBarActionSubject();
	private JMenuItem _new = new JMenuItem("New");
	private JMenuItem _edit2 = new JMenuItem("Edit");
	private JMenuItem _delete = new JMenuItem();
	private JMenu _file = new JMenu("File");
	private JMenu _edit = new JMenu("Edit");
	private JMenu _help = new JMenu("Help");
	private JMenuItem _save = new JMenuItem();
	private JMenu _open = new JMenu();	//ima submenu
	private JMenuItem _close = new JMenuItem();

	public JMenu get_file() {
		return _file;
	}

	public void set_file(JMenu _file) {
		this._file = _file;
	}

	public JMenu get_edit() {
		return _edit;
	}

	public void set_edit(JMenu _edit) {
		this._edit = _edit;
	}

	public JMenu get_help() {
		return _help;
	}

	public void set_help(JMenu _help) {
		this._help = _help;
	}

	public JMenuItem get_save() {
		return _save;
	}

	public void set_save(JMenuItem _save) {
		this._save = _save;
	}

	public JMenu get_open() {
		return _open;
	}

	public void set_open(JMenu _open) {
		this._open = _open;
	}

	public JMenuItem get_close() {
		return _close;
	}

	public void set_close(JMenuItem _close) {
		this._close = _close;
	}



	public JMenuItem get_new() {
		return _new;
	}

	public void set_new(JMenuItem _new) {
		this._new = _new;
	}

	public JMenuItem get_edit2() {
		return _edit2;
	}

	public void set_edit2(JMenuItem _edit2) {
		this._edit2 = _edit2;
	}

	public JMenuItem get_delete() {
		return _delete;
	}

	public void set_delete(JMenuItem _delete) {
		this._delete = _delete;
	}



	public static int getSelRow() {
		return selRow;
	}

	public static void setSelRow(int selRow) {
		MenuBar.selRow = selRow;
	}

	public static MenuBar getInstance() {
		if (instance==null) {
			instance=new MenuBar();
		}return instance;
	}

	private MenuBar() {

//FILE


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


			//DODAVANJE AKCIJE
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
