package gui;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Localisation {
	
	public static void serbianLoc() {
		ToolBar tb=ToolBar.getInstance();
		tb.getBtnNew().setToolTipText("Novo");
		tb.getBtnEdit().setToolTipText("Izmena");
		tb.getBtnDelete().setToolTipText("Brisanje");
		tb.getBtnSearch().setToolTipText("Pretraga");
		
		MenuBar mb=MenuBar.getInstance();
		
		mb.set_new(new JMenuItem("Novo"));
		mb.set_edit2(new JMenuItem("Izmena"));
		mb.set_delete(new JMenuItem("Brisanje"));
		
		JMenu fajl=new JMenu("Fajl");
		mb.set_file(fajl);
		mb.set_edit(new JMenu("Izmena"));
		mb.set_help(new JMenu("Pomoc"));
		mb.set_save(new JMenu("Snimi"));
		mb.set_open(new JMenu("Otvori"));
		mb.set_close(new JMenu("Zatvori"));
	}
}
