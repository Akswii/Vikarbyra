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
	private Arbeidsregister arbeidsgiver;
	private Vikariatdetails vikariatdeets;

	 public Vikariatvindu(Vikariatregister v, Arbeidsregister a)
	 {
	  	super("Vikariatvindu");
  		vikariat = v;
  		arbeidsgiver = a;

		utskrift = new JTextArea(10,10);
		utskrift.setEditable(false);
		utskrift.setLineWrap(true);

		Knappelytter lytter = new Knappelytter();
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

		vikariatdeets = new Vikariatdetails(arbeidsstedtxt, stillingtxt, arbeidstidtxt, firmatxt, idtxt, varighettxt, bransjetxt, lonntxt, kontakttxt, stillingBesktxt);

		arbeidsstedtxt.setText("");
		stillingtxt.setText("");
		arbeidstidtxt.setText("");
		firmatxt.setText("");
		idtxt.setText("");
		varighettxt.setText("");
		bransjetxt.setText("");
		lonntxt.setText("");
		kontakttxt.setText("");
		stillingBesktxt.setText("");

		nyttVikariat.addActionListener(lytter);
		sokvikariat.addActionListener(lytter);
		fjernvikariat.addActionListener(lytter);
		visVikariat.addActionListener(lytter);

		JPanel p = new JPanel(new GridLayout(2, 2));
		p.add(nyttVikariat);
		p.add(sokvikariat);
		p.add(fjernvikariat);
		p.add(visVikariat);

		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(vikariatdeets, BorderLayout.WEST);
		c.add(utskrift, BorderLayout.EAST);
		c.add(p, BorderLayout.SOUTH);
		JScrollPane scroll = new JScrollPane(utskrift);
  		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
 	 	c.add(scroll);

		setSize(500,500);
		setVisible(true);
		setResizable(false);
	}


	public void nyttVikariat()
	{

		if (!arbeidsstedtxt.getText().equals("") && !stillingtxt.getText().equals("") && !arbeidstidtxt.getText().equals("")
		&& !firmatxt.getText().equals("") && !bransjetxt.getText().equals("") && !lonntxt.getText().equals("") && !kontakttxt.getText().equals("") &&
		!stillingBesktxt.getText().equals("") && !varighettxt.getText().equals("") && !arbeidstidtxt.getText().equals(""))
		{
			String kontakt = kontakttxt.getText();
			if(arbeidsgiver.sokpaArbeidsgiver(kontakt) != null)
			{
			String arbeidssted = arbeidsstedtxt.getText();
			String stilling = stillingtxt.getText();
			String arbeidstid = arbeidstidtxt.getText();
		    String firma = firmatxt.getText();
		    String bransje = bransjetxt.getText();
		    String lonn = lonntxt.getText();
		    Arbeidsgiver kontaktperson = arbeidsgiver.sokpaArbeidsgiver(kontakt);
		    String stillingBesk = stillingBesktxt.getText();
		    String varighet = varighettxt.getText();

		    int arbeidstidInt = Integer.parseInt(arbeidstid);
		    int varighetInt = Integer.parseInt(varighet);

			Vikariatregister kontaktVikariat = kontaktperson.getVikariat();
		    Vikariat v = new Vikariat(bransje, arbeidssted, firma, stilling, lonn, kontaktperson, stillingBesk, varighetInt, arbeidstidInt);
			kontaktVikariat.regVikariat(v);

			utskrift.append( "Vikariatet hos " + firma + " med kontaktperson " + kontakt + " har blitt lagt inn i systemet! ID: " + v.getNr() + "\n\n");
			}
			else
			{
				utskrift.append("Arbeidsgiveren finnes ikke, prov pa nytt");
			}
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

		  	String feilmelding = "Det finnes ingen vikariater som passer til disse opplysningene";

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

				Vikariat riktigID = arbeidsgiver.sokpaId(id);
				String sokVikariat = "";


				if(riktigID != null)
				{
					sokVikariat = "" + riktigID;
					utskrift.append(riktigID.toString() + "ID funka");

				}
				else
				{
					utskrift.append(feilmelding);

				}
				return;
 			}
 			if (!kontakttxt.getText().equals(""))
 			{
						Arbeidsgiver kontakt1 = arbeidsgiver.sokpaArbeidsgiver(kontakt);
						if(!arbeidsgiver.vikariater(kontakt1).equals(""))
						{
							String kontaktliste = arbeidsgiver.vikariater(kontakt1);
							utskrift.setText(kontaktliste + "\nKontakt funka");
						}
						else
						{
							utskrift.append(feilmelding);

						}


					return;

			}
 			if (!arbeidsstedtxt.getText().equals(""))
					{
						List<Arbeidsgiver> aListe1 = arbeidsgiver.getArbeidsliste();
						Iterator<Arbeidsgiver> iteratorA = aListe1.iterator();
						while(iteratorA.hasNext())
						{
							Arbeidsgiver a = iteratorA.next();
							Vikariatregister test = a.getVikariat();

						if(test != null)
						{
						List<Vikariat> arbeidsstedliste = test.sokpaArbsted(arbeidssted);
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

							if(lonn.equals(lonn1) && varighetInt1 == varighetInt && stilling.equals(stilling1) && arbeidstidInt == arbeidstidInt1 &&
							firma.equals(firma1) && bransje.equals(bransje1))
							{
								utskrift.append(v.toString() + "\nArbeidssted funka\n");
							}
							else
							{
								utskrift.append(feilmelding);
							}
						}
					}
					}
						return;
			}
			if (!stillingtxt.getText().equals(""))
			{

						List<Arbeidsgiver> aListe1 = arbeidsgiver.getArbeidsliste();
						Iterator<Arbeidsgiver> iteratorA = aListe1.iterator();
						while(iteratorA.hasNext())
						{
							Arbeidsgiver a = iteratorA.next();
							Vikariatregister test = a.getVikariat();

						if(test != null)
						{

						List<Vikariat> stillingliste = test.sokpaStilling(stilling);
						Iterator<Vikariat> iterator = stillingliste.iterator();

						while(iterator.hasNext())
						{

							Vikariat v = iterator.next();

							String lonn1 = "";
							if(!lonntxt.getText().equals(""))
							lonn1 = v.getLonn();

							int varighetInt1 = -1;
							if(!varighettxt.getText().equals(""))
							varighetInt1 = v.getVarighet();

						    int arbeidstidInt1 = -1;
							if(!arbeidstidtxt.getText().equals(""))
						    arbeidstidInt1 = v.getArbeidstid();

						    String firma1 = "";
							if(!firmatxt.getText().equals(""))
						    firma1 = v.getFirma();

						    String bransje1 = "";
							if(!bransjetxt.getText().equals(""))
						    bransje1 = v.getSektor();

							if(lonn.equals(lonn1) && varighetInt1 == varighetInt && arbeidstidInt == arbeidstidInt1 &&
							firma.equals(firma1) && bransje.equals(bransje1))
							{
								utskrift.append(v.toString() + "\nStilling funka\n");
							}
							else
							{
								utskrift.append(feilmelding);
							}
						}
					}
				}
						return;
			}
			if (!lonntxt.getText().equals(""))
			{
						List<Arbeidsgiver> aListe3 = arbeidsgiver.getArbeidsliste();
						Iterator<Arbeidsgiver> iteratorA = aListe3.iterator();
						while(iteratorA.hasNext())
						{
							Arbeidsgiver a = iteratorA.next();
							Vikariatregister test = a.getVikariat();

						if(test != null)
						{
						List<Vikariat> lonnliste = test.sokpaLonn(lonn);
						Iterator<Vikariat> iterator = lonnliste.iterator();

						while(iterator.hasNext())
						{
							Vikariat v = iterator.next();

							int varighetInt1 = -1;
							if(!varighettxt.getText().equals(""))
							varighetInt1 = v.getVarighet();

						    int arbeidstidInt1 = -1;
							if(!arbeidstidtxt.getText().equals(""))
						    arbeidstidInt1 = v.getArbeidstid();

						    String firma1 = "";
							if(!firmatxt.getText().equals(""))
						    firma1 = v.getFirma();

						    String bransje1 = "";
							if(!bransjetxt.getText().equals(""))
						    bransje1 = v.getSektor();

							if(varighetInt1 == varighetInt && arbeidstidInt == arbeidstidInt1 &&
							firma.equals(firma1) && bransje.equals(bransje1))
							{
								utskrift.append(v.toString() + "\nLonn funka\n");
							}
							else
							{
								utskrift.append(feilmelding);
							}
						}
					}
				}
						return;
			}
			if (!varighettxt.getText().equals(""))
			{
						List<Arbeidsgiver> aListe4 = arbeidsgiver.getArbeidsliste();
						Iterator<Arbeidsgiver> iteratorA = aListe4.iterator();
						while(iteratorA.hasNext())
						{
							Arbeidsgiver a = iteratorA.next();
							Vikariatregister test = a.getVikariat();

						if(test != null)
						{
						List<Vikariat> varighetliste = test.sokpaVarighet(varighetInt);
						Iterator<Vikariat> iterator = varighetliste.iterator();

						while(iterator.hasNext())
						{
							Vikariat v = iterator.next();

						    int arbeidstidInt1 = -1;
							if(!arbeidstidtxt.getText().equals(""))
						    arbeidstidInt1 = v.getArbeidstid();

						    String firma1 = "";
							if(!firmatxt.getText().equals(""))
						    firma1 = v.getFirma();

						    String bransje1 = "";
							if(!bransjetxt.getText().equals(""))
						    bransje1 = v.getSektor();


							if(arbeidstidInt == arbeidstidInt1 &&
							firma.equals(firma1) && bransje.equals(bransje1))
							{
								utskrift.append(v.toString() + "\nVarighet funka\n");
							}
							else
							{
								utskrift.append(feilmelding);
							}
						}
					}
				}
						return;
			}
			if(!arbeidstidtxt.getText().equals(""))
			{
						List<Arbeidsgiver> aListe5 = arbeidsgiver.getArbeidsliste();
						Iterator<Arbeidsgiver> iteratorA = aListe5.iterator();
						while(iteratorA.hasNext())
						{
							Arbeidsgiver a = iteratorA.next();
							Vikariatregister test = a.getVikariat();

						if(test != null)
						{
						List<Vikariat> arbeidstidliste = test.sokpaArbeidstid(arbeidstidInt);
						Iterator<Vikariat> iterator = arbeidstidliste.iterator();

						while(iterator.hasNext())
						{
							Vikariat v = iterator.next();


						    String firma1 = "";
							if(!firmatxt.getText().equals(""))
						    firma1 = v.getFirma();

						    String bransje1 = "";
							if(!bransjetxt.getText().equals(""))
						    bransje1 = v.getSektor();


							if(	firma.equals(firma1) && bransje.equals(bransje1))
							{
								utskrift.append(v.toString() + "\nArbeidstid funka\n");
							}
							else
							{
								utskrift.append(feilmelding);
							}
						}
					}
				}
						return;
			}
			if(!firmatxt.getText().equals(""))
			{
						List<Arbeidsgiver> aListe6 = arbeidsgiver.getArbeidsliste();
						Iterator<Arbeidsgiver> iteratorA = aListe6.iterator();
						while(iteratorA.hasNext())
						{
							Arbeidsgiver a = iteratorA.next();
							Vikariatregister test = a.getVikariat();

						if(test != null)
						{
						List<Vikariat> firmaliste = test.sokpaFirma(firma);
						Iterator<Vikariat> iterator = firmaliste.iterator();

						while(iterator.hasNext())
						{
							Vikariat v = iterator.next();

						    String bransje1 = "";
							if(!bransjetxt.getText().equals(""))
						    bransje1 = v.getSektor();


							if(bransje.equals(bransje1)) // Legge til kontakt her og
							{
								utskrift.append(v.toString() + "\nFirma funka\n");
							}
							else
							{
								utskrift.append(feilmelding);
							}
						}
					}
				}
						return;
			}
			if(bransjetxt.getText().equals(""))
			{
						List<Arbeidsgiver> aListe7 = arbeidsgiver.getArbeidsliste();
						Iterator<Arbeidsgiver> iteratorA = aListe7.iterator();
						while(iteratorA.hasNext())
						{
							Arbeidsgiver a = iteratorA.next();
							Vikariatregister test = a.getVikariat();

						if(test != null)
						{
						List<Vikariat> bransjeliste = test.sokpaSektor(bransje);
						Iterator<Vikariat> iterator = bransjeliste.iterator();

						while(iterator.hasNext())
						{
							Vikariat v = iterator.next();


							if(bransjeliste != null)
							{
								utskrift.append(v.toString() + "\nBransje funka\n");
							}
							else
							{
								utskrift.append(feilmelding);
							}
						}
					}
				}
						return;
			}
		}
	 public void fjernVikariat()
	  {
		  String nummer = idtxt.getText();
		  if (idtxt.getText().equals(""))
		  {
			   JOptionPane.showMessageDialog(null, "Du ma fylle inn ID nummer for a slette et vikariat!\nDu kan soke opp nummer ved hjelp av navn o.l.");
		  }
		  else
		  {
			   Vikariat x = vikariat.sokpaVikariat(nummer);
			   String slett = "Vikariatet " + x.toString() + " har blitt slettet";
				if(vikariat.fjernVikariat(nummer) == true)
				{
						JOptionPane.showMessageDialog(null, slett);
				}
				else
				{
						JOptionPane.showMessageDialog(null, "Vikariatet kunne ikke bli slettet, sjekk informasjonen igjen");
				}
		  }
 	}
	public void vikariatListe()
		{
			String utskrift1 = arbeidsgiver.skrivutVikariater();
			//Metode som viser en liste over de forskjellige vikariatene som man kan soke pa
			utskrift.setText("Her er vikariat lista var\n" + utskrift1 );
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