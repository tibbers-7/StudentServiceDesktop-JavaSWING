package gui.view;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HelpPanel extends JPanel{
	private static final long serialVersionUID = 4720150675523484423L;

	public HelpPanel() {
		
		JLabel label0=new JLabel("\n");
		JLabel label1=new JLabel("Način korišćenja aplikacije:\n\n ");
		JLabel label2 = new JLabel("OPŠTE:\n");
		JLabel label3 = new JLabel("-PRIKAZ ENTITETA: pritisnuti odgovarajući tab, ili odabrati stavku 'Fajl'-'Otvori'-'Entiteti' u meniju.\n");
		JLabel label4 = new JLabel("-UNOS ENTITETA: pritisnuti dugme za dodavanje u tulbaru, ili odabrati stavku 'Novo' u meniju. Uneti sve vrednosti, obraćajući pažnju na zadati format.\n");
		JLabel label5 = new JLabel("-IZMENA ENTITETA: prvo pritisnuti red u kom se nalazi odgovarajući entitet, a zatim pritisnuti dugme za izmenu u tulbaru, ili odabrati stavku 'Izmena' u meniju. Uneti nove vrednosti, obraćajući pažnju na zadati format.\n");
		JLabel label6 = new JLabel("-BRISANJE ENTITETA: pritisnuti odgovarajući red u tabeli, pa pritisnuti dugme za brisanje u tulbaru, ili odabrati stavku 'Brisanje' u meniju.\n");
		JLabel label7 = new JLabel("\n\nRAD SA STUDENTIMA:\n");
		JLabel label8 = new JLabel("-UNOS PREDMETA STUDENTU: izabrati studenta, kliknuti na izmenu, pa izabrati tab 'Nepoloženi ispiti'. Kliknuti dugme 'Dodaj', pa zatim odabrati predmet koji želite, pod uslovom da je predmet na istoj godini studija kao i student.\n");
		JLabel label9 = new JLabel("-BRISANJE STUDENTA SA PREDMETA:  izabrati studenta, kliknuti na izmenu, pa izabrati tab 'Nepoloženi ispiti'. Kliknuti na odgovarajući predmet, pa zatim na dugme 'Obriši'.\n");
		JLabel label10 = new JLabel("-POLAGANJE ISPITA: izabrati studenta, kliknuti na izmenu, pa izabrati tab 'Nepoloženi ispiti'. Kliknuti na odgovarajući predmet, pa zatim na dugme 'Polaganje'.\n");
		JLabel label11 = new JLabel("-PONIŠTAVANJE OCENE: izabrati studenta, kliknuti na izmenu, pa izabrati tab 'Položeni ispiti'. Kliknuti na odgovarajući predmet, pa zatim na dugme 'Poništi ocenu'.\n");
		JLabel label12 = new JLabel("\n\nRAD SA KATEDROM:\n");
		JLabel label13 = new JLabel("-IZMENA ŠEFA KATEDRE: odabrati tab katedre (ili stavku 'Fajl'-'Otvori'-'Katedre' u meniju). Kliknuti na željenu katedru, pa zatim odabrati željenog profesora kao šefa.");
		
		add(label1);
		add(label0);
		add(label2);
		add(label3);
		add(label4);
		add(label5);
		add(label6);
		add(label0);
		add(label7);
		add(label8);
		add(label9);
		add(label10);
		add(label11);
		add(label12);
		add(label13);
		
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
}
