import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Iterator;
import java.io.*;

public class Vikariatvindu extends JFrame implements Serializable
{
	private JButton nyttVikariat, sokvikariat, fjernvikariat, visVikariat;
	private JTextField arbeidsstedtxt, stillingtxt, arbeidstidtxt, firmatxt, idtxt, varighettxt, bransjetxt, lonntxt, kontakttxt, stillingBesktxt;
	private JTextArea utskrift;
	private Vikariatregister vikariat;

	 public Vikariatvindu(Vikariatregister v)
	 {
	  	super("Vikariatvindu");
	  	Knappelytter lytter = new Knappelytter();

  		vikariat = v;

		utskrift = new JTextArea(10,10);
		utskrift.setEditable(false);

		nyttVikariat = new JButton("Nytt Vikariat");
		sokvikariat = new JButton("Sok Vikariat");
		fjernvikariat = new JButton("Fjern Vikariat");
		visVikariat = new JButton("Vis alle Vikariat");

		arbeidsstedtxt = new JTextField(6);
		stillingtxt = new JTextField(6);
		arbeidstidtxt = new JTextField(6);
		firmatxt = new JTextField(6);
		idtxt = new JTextField(6);
		varighettxt = new JTextField(6);
		bransjetxt = new JTextField(6);
		lonntxt=  new JTextField(6);
		kontakttxt = new JTextField(6);
		stillingBesktxt = new JTextField(6);

		nyttVikariat.addActionListener(lytter);
		sokvikariat.addActionListener(lytter);
		fjernvikariat.addActionListener(lytter);
		visVikariat.addActionListener(lytter);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(nyttVikariat);
		c.add(sokvikariat);
		c.add(fjernvikariat);
		c.add(visVikariat);

		c.add(new JLabel("Arbeidssted: "));
		c.add(arbeidsstedtxt);
		c.add(new JLabel("Arbeidstid: "));
		c.add(arbeidstidtxt);
		c.add(new JLabel("Stilling: "));
		c.add(stillingtxt);
		c.add(new JLabel("Stillings Beskrivelse: "));
		c.add(stillingBesktxt);
		c.add(new JLabel("Firma: "));
		c.add(firmatxt);
		c.add(new JLabel("Varighet: "));
		c.add(varighettxt);
		c.add(new JLabel("Bransje: "));
		c.add(bransjetxt);
		c.add(new JLabel("Lonn: "));
		c.add(lonntxt);
		c.add(new JLabel("Kontaktperson: "));
		c.add(kontakttxt);
		c.add(new JLabel("ID: "));
		c.add(idtxt);

		c.add(utskrift);

		setSize(500,500);
		setVisible(true);
	}
	private void lesFil()
		   {
		    try(ObjectInputStream innfil = new ObjectInputStream(new FileInputStream( "vikariatliste.data" )))
		    {
		     vikariat = (Vikariatregister) innfil.readObject();
		    }
		    catch(ClassNotFoundException cnfe)
		    {
		     utskrift.setText(cnfe.getMessage());
		     utskrift.append("\nOppretter tom liste.\n");
		     vikariat = new Vikariatregister();
		    }
		    catch(FileNotFoundException fne)
		    {
		     utskrift.setText("Finner ikke datafil. Oppretter tom liste.\n");
		         vikariat = new Vikariatregister();
		      }
		      catch(IOException ioe)
		      {
		         utskrift.setText("Innlesingsfeil. Oppretter tom liste.\n");
		         vikariat = new Vikariatregister();
		      }
		   }

		   public void skrivTilFil()
		  {
		  try (ObjectOutputStream utfil = new ObjectOutputStream(new FileOutputStream("vikariatliste.data")))
		  {
		        utfil.writeObject(vikariat);
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

	public void nyttVikariat()
	{

		if (!arbeidsstedtxt.getText().equals("") && !stillingtxt.getText().equals("") && !arbeidstidtxt.getText().equals("")
		&& !firmatxt.getText().equals("") && !bransjetxt.getText().equals("") && !lonntxt.getText().equals("") && !kontakttxt.getText().equals("") &&
		!stillingBesktxt.getText().equals("") && !varighettxt.getText().equals("") && !arbeidstidtxt.getText().equals(""))
		{
			String arbeidssted = arbeidsstedtxt.getText();
			String stilling = stillingtxt.getText();
			String arbeidstid = arbeidstidtxt.getText();
		    String firma = firmatxt.getText();
		    String bransje = bransjetxt.getText();
		    String lonn = lonntxt.getText();
		    String kontakt = kontakttxt.getText();
		    String stillingBesk = stillingBesktxt.getText();
		    String varighet = varighettxt.getText();

		    int arbeidstidInt = Integer.parseInt(arbeidstid);
		    int varighetInt = Integer.parseInt(varighet);

		    Vikariat v = new Vikariat(bransje, arbeidssted, firma, stilling, lonn, kontakt, stillingBesk, varighetInt, arbeidstidInt);
			vikariat.regVikariat(v);

			utskrift.append( "Vikariatet hos " + firma + " med kontaktperson " + kontakttxt + " har blitt lagt inn i systemet!\n\n");

		}
		else
		{
			JOptionPane.showMessageDialog(null, "Mangler informasjon om vikariatet! Fyll inn alle feltene!");
		}
	}
		public void sokVikariat()
		  {
			String lonn = "";
			if(!lonntxt.getText().equals(""))
			lonn = lonntxt.getText();

			int varighetInt = -1;
			if(!varighettxt.getText().equals(""))
			varighetInt = Integer.parseInt(varighettxt.getText());

			String arbeidssted = "";
			if(!arbeidsstedtxt.getText().equals(""))
		    arbeidssted = arbeidsstedtxt.getText();

		    String stilling = "";
			if(!stillingtxt.getText().equals(""))
		    stilling = stillingtxt.getText();

		    int arbeidstidInt = -1;
			if(!arbeidstidtxt.getText().equals(""))
		    arbeidstidInt = Integer.parseInt(arbeidstidtxt.getText());

		    String firma = "";
			if(!firmatxt.getText().equals(""))
		    firma = firmatxt.getText();

		    String bransje = "";
			if(!bransjetxt.getText().equals(""))
		    bransje = bransjetxt.getText();

		    String kontakt = "";
		    if(!kontakttxt.getText().equals(""))
		    kontakt = kontakttxt.getText();

		    String stillingBesk = "";
		   	if(!stillingBesktxt.getText().equals(""))
		    stillingBesk = stillingBesktxt.getText();

		    String id = "";
		    if(!idtxt.getText().equals(""))
		    id = idtxt.getText();

		  	String feilmelding = "Det finnes ingen vikarer som passer til disse opplysningene";

		  	utskrift.setText("");
		  	if (arbeidsstedtxt.getText().equals("") && stillingtxt.getText().equals("") && arbeidstidtxt.getText().equals("")
			&& firmatxt.getText().equals("") && bransjetxt.getText().equals("") && lonntxt.getText().equals("")
			&& kontakttxt.getText().equals("") && stillingBesktxt.getText().equals("") && varighettxt.getText().equals("")
			&& idtxt.getText().equals(""))
		  	 {
		  		  utskrift.setText("Du ma fylle inn minst ett felt");
		  	 }
		  	 if(!idtxt.getText().equals(""))
			{
				String sokVikariat;
				Vikariat test = vikariat.sokpaVikariat(id);

				if(test != null)
				{
					sokVikariat = "" + test;

					if (sokVikariat != "")
					{
						utskrift.append(test.toString() + "ID funka");
					}

					else
					{
						utskrift.append(feilmelding);
					}
				}
				return;
 			}
 			if (!arbeidsstedtxt.getText().equals(""))
					{
						List<Vikariat> arbeidsstedliste = vikariat.sokpaArbsted(arbeidssted);
						Iterator<Vikariat> iterator = arbeidsstedliste.iterator();

						while(iterator.hasNext())
						{
							Vikariat v = iterator.next();

							String lonn1 = "";
							if(!lonntxt.getText().equals(""))
							lonn1 = v.getLonn();

							int varighetInt1 = -1;
							if(!varighettxt.getText().equals(""))
							varighetInt1 = v.getVarighet();

						    String stilling1 = "";
							if(!stillingtxt.getText().equals(""))
						    stilling1 = v.getStilling();

						    int arbeidstidInt1 = -1;
							if(!arbeidstidtxt.getText().equals(""))
						    arbeidstidInt1 = v.getArbeidstid();

						    String firma1 = "";
							if(!firmatxt.getText().equals(""))
						    firma1 = v.getFirma();

						    String bransje1 = "";
							if(!bransjetxt.getText().equals(""))
						    bransje1 = v.getSektor();

						    //String kontakt = "";
						    //if(!kontakttxt.getText().equals(""))
						    //kontakt = v.getKontakt();

						    String stillingBesk1 = "";
						   	if(!stillingBesktxt.getText().equals(""))
						    stillingBesk1 = v.getstillingBesk();



							if(lonn.equals(lonn1) && varighetInt1 == varighetInt && stilling.equals(stilling1) && arbeidstidInt == arbeidstidInt1 &&
							firma.equals(firma1) && bransje.equals(bransje1) && stillingBesk.equals(stillingBesk1)) // Legge til kontakt her og
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
		}
	 public void fjernVikariat()
	  {
		  String nummer = idtxt.getText();
		  if (nummer == null)
		  {
			   JOptionPane.showMessageDialog(null, "Du ma fylle inn ID nummer for a slette et vikariat!\nDu kan soke opp nummer ved hjelp av navn o.l.");
		  }
		  else
		  {
			   Vikariat x = vikariat.sokpaVikariat(nummer);
			   JOptionPane.showMessageDialog(null, "Vikariatet " + x.toString() + " har blitt slettet");
			   vikariat.fjernVikariat(nummer);
		  }
 	}
	public void vikariatListe()
		{
			//Metode som viser en liste over de forskjellige vikariatene som man kan soke pa
			utskrift.setText("Her er vikariat lista var\n" + vikariat.toString());
	}
	private class Knappelytter implements ActionListener
	{
		public void actionPerformed ( ActionEvent e)
		{
			if( e.getSource() == nyttVikariat)
			{
				nyttVikariat();
			}
			if (e.getSource() == sokvikariat)
 	      {
 	   			sokVikariat();
 	  	  }
 		  if(e.getSource() == fjernvikariat)
 		  {
			  fjernVikariat();
		  }
		  if (e.getSource() == visVikariat)
			{
				vikariatListe();
	  		}
		}
	}

}