import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Iterator;
import java.io.*;

public class Vikarvindu extends JFrame implements Serializable
{
	private Vikardetails vikardeets;
	private Vikarregister vikar;
	private JTextField fornavntxt, etternavntxt, aldertxt, bytxt, eposttxt, kategoritxt, tlftxt, lonnskravtxt, kjonntxt, idtxt;
	private JButton nyVikar, sokVikarbtn, fjernVikar, visVikar, tomTekst;
	private JTextArea utskrift;

	 public Vikarvindu(Vikarregister v)
	 {
	  	super("Vikarvindu");
	 	vikar = v;

		utskrift = new JTextArea(10,30);
		utskrift.setEditable(false);
		utskrift.setLineWrap(true);

		Knappelytter lytter = new Knappelytter();
	  	nyVikar = new JButton("Opprett Vikar");
		sokVikarbtn = new JButton("Sok Vikar");
		fjernVikar = new JButton("Fjern Vikar");
		visVikar = new JButton("Vikarregisteret");
		tomTekst = new JButton("Nullstill");

		fornavntxt = new JTextField(6);
    	etternavntxt = new JTextField(6);
    	aldertxt = new JTextField(6);
    	bytxt = new JTextField(6);
    	eposttxt = new JTextField(6);
    	kategoritxt = new JTextField(6);
    	tlftxt = new JTextField(6);
    	lonnskravtxt = new JTextField(6);
    	kjonntxt = new JTextField(6);
    	idtxt = new JTextField(6);

    	vikardeets = new Vikardetails(fornavntxt, etternavntxt, aldertxt, bytxt, eposttxt, kategoritxt, tlftxt, lonnskravtxt, kjonntxt, idtxt);

		fornavntxt.setText("");
		etternavntxt.setText("");
		aldertxt.setText("");
		bytxt.setText("");
		eposttxt.setText("");
		kategoritxt.setText("");
		tlftxt.setText("");
		lonnskravtxt.setText("");
		kjonntxt.setText("");
		idtxt.setText("");

		nyVikar.addActionListener(lytter);
		sokVikarbtn.addActionListener(lytter);
		fjernVikar.addActionListener(lytter);
		visVikar.addActionListener(lytter);
		tomTekst.addActionListener(lytter);

	  	JPanel p = new JPanel(new GridLayout(2, 2));
		p.add(nyVikar);
		p.add(fjernVikar);
		p.add(sokVikarbtn);
		p.add(visVikar);
		p.add(tomTekst);

		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(vikardeets, BorderLayout.WEST);
		c.add(utskrift, BorderLayout.EAST);
		c.add(p, BorderLayout.SOUTH);
		JScrollPane scroll = new JScrollPane(utskrift);
  		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
 	 	c.add(scroll);

    	setSize(600,500);
		setVisible(true);
		setResizable(false);
	}


      public void nyVikar()
	{

		/*if( Eposten eksisterer i systemet)
		 {  ikke la personen registrere seg }
		feilmelding og be personen velge ny epost

		else { */
		if (!fornavntxt.getText().equals("") && !etternavntxt.getText().equals("") && !kjonntxt.getText().equals("")
		&& !aldertxt.getText().equals("") && !bytxt.getText().equals("") && !eposttxt.getText().equals("")
		&& !kategoritxt.getText().equals("") && !tlftxt.getText().equals("") && !lonnskravtxt.getText().equals(""))
		{
			int alder = Integer.parseInt(aldertxt.getText());
			int tlf = Integer.parseInt(tlftxt.getText());
		    int lonnskrav = Integer.parseInt(lonnskravtxt.getText());
			String fornavn = fornavntxt.getText();
			String etternavn = etternavntxt.getText();
			String kjonn = kjonntxt.getText();
		    String by = bytxt.getText();
		    String epost = eposttxt.getText(); // Kontroll pa at eposten ikke eksisterer
		    String kategori = kategoritxt.getText();

			Vikar v = new Vikar(fornavn, etternavn, kjonn, alder, by, epost, kategori, tlf, lonnskrav);
			vikar.settInnVikar(v);

			utskrift.append( "Vikaren " + fornavn + " " + etternavn + " ID: " + v.getVikarnr() + " har blitt lagt inn i systemet!\n\n");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Mangler informasjon om vikaren! Fyll inn alle feltene!");
		}
	}

	public void sokVikar()
	{
		int tlf = -1;
		if(!tlftxt.getText().equals(""))
			tlf = Integer.parseInt(tlftxt.getText());
		int lonnskrav = -1;
		if(!lonnskravtxt.getText().equals(""))
		    lonnskrav = Integer.parseInt(lonnskravtxt.getText());
		int alderInt = -1;
		if(!aldertxt.getText().equals(""))
		    alderInt = Integer.parseInt(aldertxt.getText());

		String kategori = "";
		if(!kategoritxt.getText().equals(""))
		    kategori = kategoritxt.getText();
		String fornavn = "";
		if(!fornavntxt.getText().equals(""))
			fornavn = fornavntxt.getText();
		String etternavn = "";
		if(!etternavntxt.getText().equals(""))
			etternavn = etternavntxt.getText();
		String id = "";
		if(!idtxt.getText().equals(""))
			id = idtxt.getText();
		String by = "";
		if(!bytxt.getText().equals(""))
			by = bytxt.getText();
		String epost = "";
		if(!eposttxt.getText().equals(""))
			epost = eposttxt.getText();
		String kjonn = "";
		if(!kjonntxt.getText().equals(""))
			kjonn = kjonntxt.getText();

		String feilmelding = "Det finnes ingen vikarer som passer til disse opplysningene";
		utskrift.setText("");

		if (fornavntxt.getText().equals("") && etternavntxt.getText().equals("") && kjonntxt.getText().equals("")
			&& aldertxt.getText().equals("") && bytxt.getText().equals("") && eposttxt.getText().equals("")
			&& idtxt.getText().equals("") && kategoritxt.getText().equals("") && lonnskravtxt.getText().equals("")
			&& tlftxt.getText().equals(""))
		{
			utskrift.setText("Du ma fylle inn minst ett sokefelt");
		}

		int lonnskrav1 = -1;
		int tlf1 = -1;
		String fornavn1 = "";
		String etternavn1 = "";
		String by1 = "";
		String kjonn1 = "";
		int alder1 = -1;

		if(!idtxt.getText().equals(""))
		{
			String sokVikar;
			Vikar test = vikar.sokpaVikarnr(id);

			if(test != null)
			{
				sokVikar = "" + test;

				if (sokVikar != "")
				{
					fornavntxt.setText("");
					etternavntxt.setText("");
					aldertxt.setText("");
					bytxt.setText("");
					eposttxt.setText("");
					kategoritxt.setText("");
					tlftxt.setText("");
					lonnskravtxt.setText("");
					kjonntxt.setText("");

					utskrift.append(test.toString() + "ID funka");
				}

				else
				{
					utskrift.append(feilmelding);
				}
			}
			return;
		}

		if (!kategoritxt.getText().equals(""))
		{
			List<Vikar> kategoriliste = vikar.sokpaVikarkategori(kategori);
			Iterator<Vikar> iterator = kategoriliste.iterator();

			while(iterator.hasNext())
			{
				Vikar v = iterator.next();

				if(!lonnskravtxt.getText().equals(""))
					lonnskrav1 = v.getLonn();
				if(!tlftxt.getText().equals(""))
					tlf1 = v.getTlf();
				if(!fornavntxt.getText().equals(""))
					fornavn1 = v.getFornavn();
				if(!etternavntxt.getText().equals(""))
					etternavn1 = v.getEtternavn();
				if(!bytxt.getText().equals(""))
					by1 = v.getBy();
				if(!kjonntxt.getText().equals(""))
					kjonn1 = v.getKjonn();
				if(!aldertxt.getText().equals(""))
					alder1 = v.getAlder();

				if(lonnskrav == lonnskrav1 && tlf1 == tlf && fornavn.equals(fornavn1) && etternavn.equals(etternavn1) && by.equals(by1) && alderInt == alder1 && kjonn.equals(kjonn1))
				{
					utskrift.append(v.toString() + "\nKategori funka\n");
				}
				else
				{
					utskrift.append(feilmelding);
				}
			}
			return;
		}

		if(!lonnskravtxt.getText().equals(""))
		{
			List<Vikar> lonnliste = vikar.sokpaVikarlonn(lonnskrav);
			Iterator<Vikar> iterator = lonnliste.iterator();

			while(iterator.hasNext())
			{
				Vikar v = iterator.next();

				if(!tlftxt.getText().equals(""))
					tlf1 = v.getTlf();
				if(!fornavntxt.getText().equals(""))
					fornavn1 = v.getFornavn();
				if(!etternavntxt.getText().equals(""))
					etternavn1 = v.getEtternavn();
				if(!bytxt.getText().equals(""))
					by1 = v.getBy();
				if(!kjonntxt.getText().equals(""))
					kjonn1 = v.getKjonn();
				if(!aldertxt.getText().equals(""))
					alder1 = v.getAlder();

				if (tlf1 == tlf && fornavn.equals(fornavn1) && etternavn.equals(etternavn1)
					&& by.equals(by1) && alderInt == alder1 && kjonn.equals(kjonn1))
				{
					utskrift.append(v.toString() + "\nLonnskrav funka");
				}
				else
				{
					utskrift.append(feilmelding);
				}
			}
			return;
		}

		if (!tlftxt.getText().equals(""))
		{
			List<Vikar> tlfliste = vikar.sokpaVikartlf(tlf);
			Iterator<Vikar> iterator = tlfliste.iterator();

			while(iterator.hasNext())
			{
				Vikar v = iterator.next();

				if(!fornavntxt.getText().equals(""))
					fornavn1 = v.getFornavn();
				if(!etternavntxt.getText().equals(""))
					etternavn1 = v.getEtternavn();
				if(!bytxt.getText().equals(""))
					by1 = v.getBy();
				if(!kjonntxt.getText().equals(""))
					kjonn1 = v.getKjonn();
				if(!aldertxt.getText().equals(""))
					alder1 = v.getAlder();

				if (fornavn.equals(fornavn1) && etternavn.equals(etternavn1) && by.equals(by1) && alderInt == alder1 && kjonn.equals(kjonn1))
				{
					utskrift.append(v.toString() + "\ntlf funka");
				}
				else
				{
					utskrift.append(feilmelding);
				}
			}
			return;
		}

		if (!fornavntxt.getText().equals(""))
		{
			List<Vikar> fornavnliste = vikar.sokpaVikarfornavn(fornavn);
			Iterator<Vikar> iterator = fornavnliste.iterator();

			while(iterator.hasNext())
			{
				Vikar v = iterator.next();
				if(!etternavntxt.getText().equals(""))
					etternavn1 = v.getEtternavn();
				if(!bytxt.getText().equals(""))
					by1 = v.getBy();
				if(!kjonntxt.getText().equals(""))
					kjonn1 = v.getKjonn();
				if(!aldertxt.getText().equals(""))
					alder1 = v.getAlder();

				if (etternavn.equals(etternavn1) && by.equals(by1) && alderInt == alder1 && kjonn.equals(kjonn1))
				{
					utskrift.append(v.toString() + "\nfornavn funka");
				}
				else
				{
					utskrift.append(feilmelding);
				}
			}
			return;
		}

		if (!etternavntxt.getText().equals(""))
		{
			List<Vikar> etternavnliste = vikar.sokpaVikaretternavn(etternavn);
			Iterator<Vikar> iterator = etternavnliste.iterator();
			while(iterator.hasNext())
			{
				Vikar v = iterator.next();
				if(!bytxt.getText().equals(""))
					by1 = v.getBy();
				if(!kjonntxt.getText().equals(""))
					kjonn1 = v.getKjonn();
				if(!aldertxt.getText().equals(""))
					alder1 = v.getAlder();

				if (by.equals(by1) && alderInt == alder1 && kjonn.equals(kjonn1))
				{
					utskrift.append(v.toString() + "\nEtternavn funka");
				}
				else
				{
					utskrift.append(feilmelding);
				}
			}
			return;
		}

		if (!bytxt.getText().equals(""))
		{
			List<Vikar> byliste = vikar.geografiskSted(by);
			Iterator<Vikar> iterator = byliste.iterator();
			while(iterator.hasNext())
			{
				Vikar v = iterator.next();
				if(!kjonntxt.getText().equals(""))
					kjonn1 = v.getKjonn();
				if(!aldertxt.getText().equals(""))
					alder1 = v.getAlder();

				if (alderInt == alder1 && kjonn.equals(kjonn1))
				{
					utskrift.append(v.toString() + "\nBy funka");
				}
				else
				{
					utskrift.append(feilmelding);
				}
			}
			return;
		}

		if (!aldertxt.getText().equals(""))
		{
			List<Vikar> alderliste = vikar.sokpaVikaralder(alderInt);
			Iterator<Vikar> iterator = alderliste.iterator();
			while(iterator.hasNext())
			{
				Vikar v = iterator.next();
				if(!kjonntxt.getText().equals(""))
					kjonn1 = v.getKjonn();

				if (kjonn.equals(kjonn1))
				{
					utskrift.append(v.toString() + "\nAlder funka");
				}
				else
				{
					utskrift.append(feilmelding);
				}
			}
			return;
		}

		if (!kjonntxt.getText().equals(""))
		{
			List<Vikar> kjonnliste = vikar.sokpaVikarkjonn(kjonn);
			Iterator<Vikar> iterator = kjonnliste.iterator();
			while(iterator.hasNext())
			{
				Vikar v = iterator.next();
				if (kjonnliste != null)
				{
					utskrift.append(v.toString() + "\nKjonn funka");
				}
				else
				{
					utskrift.append(feilmelding);
				}
			}
			return;
		}

		if (!eposttxt.getText().equals(""))
		{
			String sokEpost;
			Vikar testepost = vikar.sokpaVikarepost(epost);
			if (testepost != null)
			{
				sokEpost = "" + testepost;

				if (sokEpost != "")
				{
					utskrift.append(testepost.toString() + "\nEpost funka");
				}
				else
				{
					utskrift.append(feilmelding);

				}
			}
			return;
		}
	}

	public void fjernVikar()
	{
		String nummer = idtxt.getText();
		if (idtxt.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "Du ma fylle inn ID nummer for a slette en vikar!\nDu kan soke opp nummer ved hjelp av navn o.l.");
		}
		else
		{
			Vikar x = vikar.sokpaVikarnr(nummer);
			String slett = "Vikar " + x.toString() + " har blitt slettet";
			if(vikar.fjernVikar(nummer) == true)
			{
				JOptionPane.showMessageDialog(null, slett);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Vikaren kunne ikke bli slettet, sjekk informasjonen igjen");
			}
		}
	}

	public void vikarListe()
	{
	  	//Metode som viser en liste over vikarene vare
	  	utskrift.setText(vikar.toString());
	}

	public void tomTekstfelt()
	{
		fornavntxt.setText("");
		etternavntxt.setText("");
		aldertxt.setText("");
		bytxt.setText("");
		eposttxt.setText("");
		kategoritxt.setText("");
		tlftxt.setText("");
		lonnskravtxt.setText("");
		kjonntxt.setText("");
		idtxt.setText("");
	}

	private class Knappelytter implements ActionListener
	{
		public void actionPerformed ( ActionEvent e)
		{
			if (e.getSource() == nyVikar)
			{
				nyVikar();
	  		}
	  		if (e.getSource() == sokVikarbtn)
		    {
			   	sokVikar();
		  	}
	  	  	if (e.getSource() == fjernVikar)
		  	{
				fjernVikar();
		  	}
			if (e.getSource() == visVikar)
			{
				vikarListe();
	  		}
	  		if (e.getSource() == tomTekst)
	  		{
	  			tomTekstfelt();
	  		}
		}
	}
}
