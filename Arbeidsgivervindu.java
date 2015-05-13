import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Arbeidsgivervindu extends JFrame implements Serializable
{
	private JButton nyArbeidsgiver;
	private JTextField navntxt, firmatxt, adressetxt, bransjetxt, tlftxt, eposttxt;
	private JTextArea utskrift;
	Arbeidsregister arbeidsgiver = new Arbeidsregister();

	public Arbeidsgivervindu()
	{
		super("Arbeidsgivervindu");
      Knappelytter lytter = new Knappelytter();
      	utskrift = new JTextArea(10,10);
		utskrift.setEditable(false);

	  nyArbeidsgiver = new JButton("Ny arbeidsgiver");

	  navntxt = new JTextField(6);
	  firmatxt = new JTextField(6);
	  adressetxt = new JTextField(6);
	  bransjetxt = new JTextField(6);
	  tlftxt = new JTextField(6);
	  eposttxt = new JTextField(6);

	  nyArbeidsgiver.addActionListener(lytter);

	  Container c = getContentPane();
	  c.setLayout(new FlowLayout());

	  c.add(new JLabel("Navn: "));
	  c.add(navntxt);
	  c.add(new JLabel("Firma: "));
	  c.add(firmatxt);
	  c.add(new JLabel("Adresse: "));
	  c.add(adressetxt);
	  c.add(new JLabel("Bransje: "));
	  c.add(bransjetxt);
	  c.add(new JLabel("Mobilnummer: "));
	  c.add(tlftxt);
	  c.add(new JLabel("Epost: "));
	  c.add(eposttxt);

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
		  if (!navntxt.getText().equals("") && !firmatxt.getText().equals("") && !adressetxt.getText().equals("")
		    && !bransjetxt.getText().equals("") && !tlftxt.getText().equals("") && !eposttxt.getText().equals(""))
		    {
		   String navn = navntxt.getText();
		   String firma = firmatxt.getText();
		   String adresse = adressetxt.getText();
		   String bransje = bransjetxt.getText();
		   int tlf = Integer.parseInt(tlftxt.getText());
		   String epost = eposttxt.getText();

		      utskrift.append( "Arbeidsgiver: " + navn + " har blitt lagt inn i systemet!\n\n");
		  }
		  else
		  {
		   JOptionPane.showMessageDialog(null, "Mangler informasjon om arbeidsgiveren! Fyll inn alle feltene!");
		  }
		  // }
 	}

	private class Knappelytter implements ActionListener
	{
		public void actionPerformed ( ActionEvent e)
		{
			if (e.getSource() == nyArbeidsgiver)
			{
				nyArbeidsgiver();
			}
		}
	}

}

