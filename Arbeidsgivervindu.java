import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Iterator;
import java.io.*;

public class Arbeidsgivervindu extends JFrame implements Serializable
{
	private JButton nyArbeidsgiver, sokArbeidsgiver, visArbeidsgiver;
	private JTextField fornavntxt, etternavntxt, firmatxt, adressetxt, bransjetxt, tlftxt, eposttxt, bytxt;
	private JTextArea utskrift;
	Arbeidsregister arbeidsgiver = new Arbeidsregister();

	public Arbeidsgivervindu()
	{
		super("Arbeidsgivervindu");
      Knappelytter lytter = new Knappelytter();
      	utskrift = new JTextArea(10,10);
		utskrift.setEditable(false);

	  nyArbeidsgiver = new JButton("Ny Arbeidsgiver");
	  sokArbeidsgiver = new JButton("Sok Arbeidsgiver");
	  visArbeidsgiver = new JButton("Vis alle Arbeidsgivere");

	  fornavntxt = new JTextField(6);
	  etternavntxt = new JTextField(6);
	  firmatxt = new JTextField(6);
	  adressetxt = new JTextField(6);
	  bransjetxt = new JTextField(6);
	  tlftxt = new JTextField(6);
	  eposttxt = new JTextField(6);
	  bytxt = new JTextField(6);

	  nyArbeidsgiver.addActionListener(lytter);
	  sokArbeidsgiver.addActionListener(lytter);
	  visArbeidsgiver.addActionListener(lytter);

	  Container c = getContentPane();
	  c.setLayout(new FlowLayout());

	  c.add(new JLabel("Fornavn: "));
	  c.add(fornavntxt);
	  c.add(new JLabel("Etternavn: "));
	  c.add(etternavntxt);
	  c.add(new JLabel("Firma: "));
	  c.add(firmatxt);
	  c.add(new JLabel("Adresse: "));
	  c.add(adressetxt);
	  c.add(new JLabel("By: "));
	  c.add(bytxt);
	  c.add(new JLabel("Bransje: "));
	  c.add(bransjetxt);
	  c.add(new JLabel("Tlf: "));
	  c.add(tlftxt);
	  c.add(new JLabel("Epost: "));
	  c.add(eposttxt);


	  c.add(visArbeidsgiver);
	  c.add(sokArbeidsgiver);
	  c.add(nyArbeidsgiver);
	  c.add(utskrift);


	  setSize(500,500);
	setVisible(true);

	}
	private void lesFil()
		   {
		    try(ObjectInputStream innfil = new ObjectInputStream(new FileInputStream( "arbeidsgiverliste.data" )))
		    {
		     arbeidsgiver = (Arbeidsregister) innfil.readObject();
		    }
		    catch(ClassNotFoundException cnfe)
		    {
		     utskrift.setText(cnfe.getMessage());
		     utskrift.append("\nOppretter tom liste.\n");
		     arbeidsgiver = new Arbeidsregister();
		    }
		    catch(FileNotFoundException fne)
		    {
		     utskrift.setText("Finner ikke datafil. Oppretter tom liste.\n");
		         arbeidsgiver = new Arbeidsregister();
		      }
		      catch(IOException ioe)
		      {
		         utskrift.setText("Innlesingsfeil. Oppretter tom liste.\n");
		         arbeidsgiver = new Arbeidsregister();
		      }
		   }

		   public void skrivTilFil()
		  {
		  try (ObjectOutputStream utfil = new ObjectOutputStream(new FileOutputStream("arbeidsgiverliste.data")))
		  {
		        utfil.writeObject(arbeidsgiver);
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
	public void nyArbeidsgiver()
	 {
		 /* if( Eposten eksisterer i systemet)
		 		 {  ikke la personen registrere seg }
		 		feilmelding og be personen velge ny epost

		else { */
		  if (!fornavntxt.getText().equals("") && !etternavntxt.getText().equals("") && !firmatxt.getText().equals("") && !adressetxt.getText().equals("")
		    && !bransjetxt.getText().equals("") && !tlftxt.getText().equals("") && !eposttxt.getText().equals(""))
		    {
		   String fornavn = fornavntxt.getText();
		   String etternavn = etternavntxt.getText();
		   String firma = firmatxt.getText();
		   String adresse = adressetxt.getText();
		   String bransje = bransjetxt.getText();
		   int tlf = Integer.parseInt(tlftxt.getText());
		   String epost = eposttxt.getText(); // Kontroll på at eposten ikke eksisterer

		      utskrift.append( "Arbeidsgiver: " + fornavn + " " + etternavn + " har blitt lagt inn i systemet!\n\n");
		  }
		  else
		  {
		   JOptionPane.showMessageDialog(null, "Mangler informasjon om arbeidsgiveren! Fyll inn alle feltene!");
		  }
		  // }
 	}

 	 public void sokArbeidsgiver()
	  {
		  String fornavn = fornavntxt.getText();
		  String etternavn = etternavntxt.getText();

		  if (!fornavn.equals("") && !etternavn.equals(""))
		  {
			  List<Arbeidsgiver> navn = arbeidsgiver.sokpaArbeidsgiver(fornavn, etternavn);
			  utskrift.setText("Resultat: \n" + navn.toString());
		  }
			//Arbeidsregister arbeid = new Arbeidsregister();
			//Arbeidsgiver a = arbeid.sokpaBransje(bransjetxt.getText());
			//utskrift.setText("Resultat: \n" + a.toString());

  	}
  	public void arbeidsgiverListe()
	{
			//Metode som vier en liste over arbeidsgiverne vare
			Arbeidsregister aListe = new Arbeidsregister();
			utskrift.setText("Her er arbeidsgiver lista var\n" + aListe.toString());
	}

	private class Knappelytter implements ActionListener
	{
		public void actionPerformed ( ActionEvent e)
		{
			if (e.getSource() == nyArbeidsgiver)
			{
				nyArbeidsgiver();
			}
			if (e.getSource() == sokArbeidsgiver)
			{
		   		sokArbeidsgiver();
 	 		}
 	 		if (e.getSource() == visArbeidsgiver)
			{
				arbeidsgiverListe();
	  		}
		}
	}

}

