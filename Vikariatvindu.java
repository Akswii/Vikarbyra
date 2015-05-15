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
	Vikariatregister vikariat = new Vikariatregister();

	public Vikariatvindu()
	{
		super("Vikariatvindu");
		Knappelytter lytter = new Knappelytter();

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
		c.add(new JLabel("Stilling: "));
		c.add(stillingtxt);
		c.add(new JLabel("Arbeidstid: "));
		c.add(arbeidstidtxt);
		c.add(new JLabel("Firma: "));
		c.add(firmatxt);
		c.add(new JLabel("ID: "));
		c.add(idtxt);
		c.add(new JLabel("Varighet: "));
		c.add(varighettxt);
		c.add(new JLabel("Bransje: "));
		c.add(bransjetxt);

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
		  	String s = bransjetxt.getText();
		  	String v = varighettxt.getText();
		  	int x = Integer.parseInt(v);
		  	String f = firmatxt.getText();
		  	String id = idtxt.getText();

		  	String feilmelding = "Det finnes ingen vikarer som passer til disse opplysningene";

		  	utskrift.setText("");
		  	if (s.equals("") && v.equals("") && f.equals("")
		  		 && id.equals(""))
		  	 {
		  		  utskrift.setText("Du ma fylle inn minst ett felt");
		  	 }

		  	if(!id.equals(""))
		  	{

		  		 String sokVikariat = "";
		  		 sokVikariat += vikariat.sokpaVikariat(id).toString();
		  		 if (sokVikariat != "")
		  		 {
		  			  utskrift.setText(sokVikariat);
		  		 }
		  		 else
		  		 {
		  			  utskrift.setText(feilmelding);
				 }
		  	}
		  	if(!s.equals(""))
		  	{
		  		 List<Vikariat> sektor = vikariat.sokpaSektor(s);
		  		 Iterator<Vikariat> iterator = sektor.iterator();
		  		 while(iterator.hasNext())
		  		 {
		  		  Vikariat s1 = iterator.next();
		  		  String f1 = s1.getFirma();
		  		  int v1 = s1.getVarighet();
		  		  if (f.equals(f1) && v.equals(v1))
		  		  {
		  			   utskrift.append(s1.toString() + "\n");
		  		  }
		  		  else
		  		  {
		  		   utskrift.setText(feilmelding);
		  		  }
		  	 }
		  	}
		  	if(!v.equals(""))
		  	{
		  		 List<Vikariat> varighet = vikariat.sokpaVarighet(x);
		  		 Iterator<Vikariat> iterator = varighet.iterator();
		  		 while(iterator.hasNext())
		  		 {
		  			  Vikariat f1 = iterator.next();
		  			  String s1 = f1.getSektor();
		  			  int v1 = f1.getVarighet();
		  			  if (f.equals(s1) && f.equals(v1))
		  			  {
		  				   utskrift.append(v.toString() + "\n");
		  			  }
		  			  else
		  			  {
		  				   utskrift.setText(feilmelding);
		  			  }
		  		 }
		  	}
		  	if(!f.equals(""))
		  	{

		  		 String sokpafirma = "";
		  		 sokpafirma += vikariat.sokpaFirma(f).toString();
		  		 if (sokpafirma != "")
		  		 {
		  			  utskrift.setText(sokpafirma);
		  		 }
		  		 else
		  		 {
		  			  utskrift.setText(feilmelding);
		  		 }
		  	}
		  	else
		  	{
		  		 utskrift.setText("Fyll in firma feltet for aa bruke denne metoden!");
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
			//Metode som viser en liste over de forskjellige vikariatene som man kan soke på
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