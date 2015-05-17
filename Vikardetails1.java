import java.awt.Dimension;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Iterator;
import java.io.*;

public class Vikardetails extends JPanel
{
	private Vikarregister vikar;
	private JPanel p, u;
	private JButton nyVikar, sokVikar, fjernVikar, visVikar;
	private JTextArea utskrift;
	private JTextField fornavntxt, etternavntxt, aldertxt, bytxt, eposttxt, kategoritxt, tlftxt, lonnskravtxt, kjonntxt, idtxt;

	public Vikardetails(Vikarregister v)
	{
		vikar = v;
		utskrift = new JTextArea(20,20);
		utskrift.setEditable(false);
		utskrift.setLineWrap(true);
		Knappelytter lytter = new Knappelytter();

		Dimension size = getPreferredSize();
		size.width = 250;
		setPreferredSize(size);
		setBorder(BorderFactory.createTitledBorder("Hovedmeny"));

		nyVikar = new JButton("Opprett Vikar");
		sokVikar = new JButton("Sok Vikar");
		fjernVikar = new JButton("Fjern Vikar");
		visVikar = new JButton("Vikarregisteret");

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

    	/*Dimension size2 = getPreferredSize();
		size2.width = 100;
		size2.height = 20;
    	fornavntxt.setMinimumSize(size2);
    	fornavntxt.setMinimumSize(size2);
		etternavntxt.setMinimumSize(size2);
		aldertxt.setMinimumSize(size2);
		bytxt.setMinimumSize(size2);
		eposttxt.setMinimumSize(size2);
		kategoritxt.setMinimumSize(size2);
		tlftxt.setMinimumSize(size2);
		lonnskravtxt.setMinimumSize(size2);
		kjonntxt.setMinimumSize(size2);
		idtxt.setMinimumSize(size2);*/

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
		sokVikar.addActionListener(lytter);
		fjernVikar.addActionListener(lytter);
		visVikar.addActionListener(lytter);

		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.anchor = GridBagConstraints.LINE_END;

		gc.gridx = 0;
		gc.gridy = 0;
		add(new JLabel("Fornavn: "), gc);
		gc.gridx = 0;
		gc.gridy = 1;
		add(new JLabel("Etternavn: "), gc);
		gc.gridx = 0;
		gc.gridy = 2;
		add(new JLabel("Alder: "), gc);
		gc.gridx = 0;
		gc.gridy = 3;
		add(new JLabel("By: "), gc);
		gc.gridx = 0;
		gc.gridy = 4;
		add(new JLabel("Epost: "), gc);
		gc.gridx = 0;
		gc.gridy = 5;
		add(new JLabel("Kategori: "), gc);
		gc.gridx = 0;
		gc.gridy = 6;
		add(new JLabel("Telefon: "), gc);
		gc.gridx = 0;
		gc.gridy = 7;
		add(new JLabel("Lonnskrav: "), gc);
		gc.gridx = 0;
		gc.gridy = 8;
		add(new JLabel("Kjonn: "), gc);
		gc.gridx = 0;
		gc.gridy = 9;
		add(new JLabel("ID: "), gc);

		gc.anchor = GridBagConstraints.LINE_START;
		gc.gridx = 1;
		gc.gridy = 0;
		add(fornavntxt, gc);
		gc.gridx = 1;
		gc.gridy = 1;
		add(etternavntxt, gc);
		gc.gridx = 1;
		gc.gridy = 2;
		add(aldertxt, gc);
		gc.gridx = 1;
		gc.gridy = 3;
		add(bytxt, gc);
		gc.gridx = 1;
		gc.gridy = 4;
		add(eposttxt, gc);
		gc.gridx = 1;
		gc.gridy = 5;
		add(kategoritxt, gc);
		gc.gridx = 1;
		gc.gridy = 6;
		add(tlftxt, gc);
		gc.gridx = 1;
		gc.gridy = 7;
		add(lonnskravtxt, gc);
		gc.gridx = 1;
		gc.gridy = 8;
		add(kjonntxt, gc);
		gc.gridx = 1;
		gc.gridy = 9;
		add(idtxt, gc);

		/*gc.anchor = GridBagConstraints.CENTER;
		//gc.weighty = 5;
		gc.gridx = 0;
		gc.gridy = 10;
		add(p, gc);

		/*gc.weighty = 10;
		gc.anchor = GridBagConstraints.CENTER;

		gc.gridx = 0;
		gc.gridy = 12;
		add(nyVikar, gc);
		gc.gridx = 0;
		gc.gridy = 13;
		add(fjernVikar, gc);

		gc.gridx = 1;
		gc.gridy = 12;
		add(sokVikar, gc);
		gc.gridx = 1;
		gc.gridy = 13;
		add(visVikar, gc);*/
	}
	public JPanel knappeStuff()
	{
		p = new JPanel(new GridLayout(2, 2));
		p.add(nyVikar);
		p.add(fjernVikar);
		p.add(sokVikar);
		p.add(visVikar);

		return p;
	}

	public JPanel utskrift()
	{
		u = new JPanel(new FlowLayout());

		/*Dimension size2 = getPreferredSize();
		size2.width = 370;
		u.setPreferredSize(size2);*/
		u.add(utskrift);
		
		return u;
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

			utskrift.setText( "Vikaren " + fornavn + " " + etternavn + " ID: " + v.getVikarnr() + " har blitt lagt inn i systemet!\n\n");
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
		if(!fornavntxt.getText().equals(""))
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

		if(!idtxt.getText().equals(""))
		{
			String sokVikar;
			Vikar test = vikar.sokpaVikarnr(id);
		
			if(test != null)
			{
				sokVikar = "" + test;

				if (sokVikar != "")
				{
					utskrift.setText(test.toString() + "ID funka");
				}
				
				else
				{
					utskrift.setText(feilmelding);
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

				int lonnskrav1 = -1;
				if(!lonnskravtxt.getText().equals(""))
					lonnskrav1 = v.getLonn();
							
				int tlf1 = -1;
				if(!tlftxt.getText().equals(""))
					tlf1 = v.getTlf();
							
				String fornavn1 = "";
				if(!fornavntxt.getText().equals(""))
					fornavn1 = v.getFornavn();
							
				String etternavn1 = "";
				if(!etternavntxt.getText().equals(""))
					etternavn1 = v.getEtternavn();
							
				String by1 = "";
				if(!bytxt.getText().equals(""))
					by1 = v.getBy();

				String kjonn1 = "";
				if(!kjonntxt.getText().equals(""))
					kjonn1 = v.getKjonn();
							
				int alder1 = -1;
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
				int tlf1 = v.getTlf();
				String fornavn1 = v.getFornavn();
				String etternavn1 = v.getEtternavn();
				String by1 = v.getBy();
				int alder1 = v.getAlder();
				String kjonn1 = v.getKjonn();
				if (tlf1 == tlf && fornavn.equals(fornavn1) && etternavn.equals(etternavn1)
					&& by.equals(by1) && alderInt == alder1 && kjonn.equals(kjonn1))
				{
					utskrift.append(v.toString() + "\nLonnskrav funka");
				}
				else
				{
					utskrift.setText(feilmelding);
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
				String fornavn1 = v.getFornavn();
				String etternavn1 = v.getEtternavn();
				String by1 = v.getBy();
				int alder1 = v.getAlder();
				String kjonn1 = v.getKjonn();
				if (fornavn.equals(fornavn1) && etternavn.equals(etternavn1) && by.equals(by1) && alderInt == alder1 && kjonn.equals(kjonn1))
				{
					utskrift.append(v.toString() + "\ntlf funka");
				}
				else
				{
					utskrift.setText(feilmelding);
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
				String etternavn1 = v.getEtternavn();
				String by1 = v.getBy();
				int alder1 = v.getAlder();
				String kjonn1 = v.getKjonn();
				
				if (etternavn.equals(etternavn1) && by.equals(by1) && alderInt == alder1 && kjonn.equals(kjonn1))
				{
					utskrift.append(v.toString() + "\nfornavn funka");
				}
				else
				{
					utskrift.setText(feilmelding);
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
				String by1 = v.getBy();
				int alder1 = v.getAlder();
				String kjonn1 = v.getKjonn();
				if (by.equals(by1) && alderInt == alder1 && kjonn.equals(kjonn1))
				{
					utskrift.append(v.toString() + "\nEtternavn funka");
				}
				else
				{
					utskrift.setText(feilmelding);
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
				int alder1 = v.getAlder();
				String kjonn1 = v.getKjonn();
				if (alderInt == alder1 && kjonn.equals(kjonn1))
				{
					utskrift.append(v.toString() + "\nBy funka");
				}
				else
				{
					utskrift.setText(feilmelding);
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
				String kjonn1 = v.getKjonn();
				if (kjonn.equals(kjonn1))
				{
					utskrift.append(v.toString() + "\nAlder funka");
				}
				else
				{
					utskrift.setText(feilmelding);
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
					utskrift.setText(feilmelding);
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
					utskrift.setText(testepost.toString() + "\nEpost funka");
				}
				else
				{
					utskrift.setText(feilmelding);

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
	  	utskrift.setText("Her er vikar lista var\n" + vikar.toString());
	}

	private class Knappelytter implements ActionListener
	{
		public void actionPerformed ( ActionEvent e)
		{
			if (e.getSource() == nyVikar)
			{
				nyVikar();
	  		}
	  		if (e.getSource() == sokVikar)
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
		}
	}
}