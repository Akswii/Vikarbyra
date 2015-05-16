import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Iterator;
import java.io.*;

public class Vikarvindu extends JFrame implements Serializable
{
	private JButton nyVikar, sokVikar, fjernVikar, visVikar;
	private JTextField fornavntxt, etternavntxt, aldertxt, bytxt, eposttxt, kategoritxt, tlftxt, lonnskravtxt, kjonntxt, idtxt;
	private JTextArea utskrift;
	private Vikarregister vikar;

	 public Vikarvindu(Vikarregister v)
	 {
	  	super("Vikarvindu");
		Knappelytter lytter = new Knappelytter();

		vikar = v;

		utskrift = new JTextArea(10,10);
		utskrift.setEditable(false);

		nyVikar = new JButton("Opprett Vikar");
		sokVikar = new JButton("Sok Vikar");
		fjernVikar = new JButton("Fjern Vikar");
		visVikar = new JButton("Vis Vikarregisteret");

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

    	nyVikar.addActionListener(lytter);
		sokVikar.addActionListener(lytter);
		fjernVikar.addActionListener(lytter);
		visVikar.addActionListener(lytter);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(nyVikar);
		c.add(sokVikar);
		c.add(fjernVikar);
		c.add(visVikar);

		c.add(new JLabel("Fornavn: "));
		c.add(fornavntxt);
		c.add(new JLabel("Etternavn: "));
		c.add(etternavntxt);
		c.add(new JLabel("Kjonn: "));
		c.add(kjonntxt);
		c.add(new JLabel("Alder: "));
		c.add(aldertxt);
		c.add(new JLabel("By: "));
		c.add(bytxt);
		c.add(new JLabel("Epost: "));
		c.add(eposttxt);
		c.add(new JLabel("Tlf: "));
		c.add(tlftxt);
		c.add(new JLabel("Kategori: "));
		c.add(kategoritxt);
		c.add(new JLabel("Lonnskrav: "));
		c.add(lonnskravtxt);
		c.add(new JLabel("ID: "));
		c.add(idtxt);

		c.add(utskrift);

    	setSize(500,500);
		setVisible(true);


	}
	private void lesFil()
	   {
	   		 try(ObjectInputStream innfil = new ObjectInputStream(new FileInputStream( "vikarliste.data" )))
	    	{
	    	 vikar = (Vikarregister) innfil.readObject();
	    	}
	    	catch(ClassNotFoundException cnfe)
	    	{
	    	 utskrift.setText(cnfe.getMessage());
	    	 utskrift.append("\nOppretter tom liste.\n");
	    	 vikar = new Vikarregister();
	    	}
	    	catch(FileNotFoundException fne)
	    	{
	    	 utskrift.setText("Finner ikke datafil. Oppretter tom liste.\n");
	         vikar = new Vikarregister();
	    	}
	      	catch(IOException ioe)
	      	{
	         utskrift.setText("Innlesingsfeil. Oppretter tom liste.\n");
	         vikar = new Vikarregister();
	      	}
	   }

	   public void skrivTilFil()
	  {
	  	try (ObjectOutputStream utfil = new ObjectOutputStream(new FileOutputStream("vikarliste.data")))
	  	{
	        utfil.writeObject(vikar);
	  	}
      	catch( NotSerializableException nse )
      	{
      	   JOptionPane.showMessageDialog(this,"Objektet er ikke serialisert!");
      	}
      	catch( IOException ioe )
      	{
      	   JOptionPane.showMessageDialog(this,"Problem med utskrift til fil.");
      	}

       }

	public void nyVikar()
	{

		/* if( Eposten eksisterer i systemet)
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
			    String kategori = kategoritxt.getText();
			    
			    int tlf = 0;
			    if(!tlftxt.getText().equals(""))
					tlf = Integer.parseInt(tlftxt.getText());
				
				int lonnskrav = 0;
				if(!lonnskravtxt.getText().equals(""))
		    		lonnskrav = Integer.parseInt(lonnskravtxt.getText());
		    	
		    	int alderInt = 0;
		    	if(!aldertxt.getText().equals(""))
		    		alderInt = Integer.parseInt(aldertxt.getText());

				String fornavn = fornavntxt.getText();
				String etternavn = etternavntxt.getText();
				String id = idtxt.getText();
				String by = bytxt.getText();
				String epost = eposttxt.getText();
				String kjonn = kjonntxt.getText();

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
				if (!kategoritxt.getText().equals(""))
				{
					List<Vikar> kategoriliste = vikar.sokpaVikarkategori(kategori);
					Iterator<Vikar> iterator = kategoriliste.iterator();

					while(iterator.hasNext())
					{
						Vikar v = iterator.next();
						int lonnskrav1 = v.getLonn();
						int tlf1 = v.getTlf();
						String fornavn1 = v.getFornavn();
						String etternavn1 = v.getEtternavn();
						String by1 = v.getBy();
						int alder1 = v.getAlder();
						String kjonn1 = v.getKjonn();
						if (lonnskrav == lonnskrav1 && tlf1 == tlf && fornavn.equals(fornavn1) && etternavn.equals(etternavn1)
						&& by.equals(by1) && alderInt == alder1 && kjonn.equals(kjonn1))
						{
							utskrift.append(v.toString() + "\nKategori funka");
						}
						else
						{
							utskrift.setText(feilmelding);
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
