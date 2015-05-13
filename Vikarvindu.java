import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.io.*;

public class Vikarvindu extends JFrame implements Serializable
{
	private JButton nyVikar;
	private JTextField fornavntxt, etternavntxt, kj�nntxt, aldertxt, bytxt, eposttxt, kategoritxt, tlftxt, l�nnskravtxt;
	private JTextArea utskrift;

	Vikarregister vikar = new Vikarregister();

	public Vikarvindu()
	{
		super("Vikarvindu");
		Knappelytter lytter = new Knappelytter();

		utskrift = new JTextArea(10,10);
		utskrift.setEditable(false);

		nyVikar = new JButton("Opprett Vikar");

		fornavntxt = new JTextField(6);
    	etternavntxt = new JTextField(6);
    	kj�nntxt = new JTextField(6);
    	aldertxt = new JTextField(6);
    	bytxt = new JTextField(6);
    	eposttxt = new JTextField(6);
    	kategoritxt = new JTextField(6);
    	tlftxt = new JTextField(6);
    	l�nnskravtxt = new JTextField(6);

    	nyVikar.addActionListener(lytter);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(nyVikar);

		c.add(new JLabel("Fornavn: "));
		c.add(fornavntxt);
		c.add(new JLabel("Etternavn: "));
		c.add(etternavntxt);
		c.add(new JLabel("Kj�nn: "));
		c.add(kj�nntxt);
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
		c.add(new JLabel("L�nnskrav: "));
		c.add(l�nnskravtxt);

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
		if (!fornavntxt.getText().equals("") && !etternavntxt.getText().equals("") && !kj�nntxt.getText().equals("")
		&& !aldertxt.getText().equals("") && !bytxt.getText().equals("") && !eposttxt.getText().equals("")
		&& !kategoritxt.getText().equals("") && !tlftxt.getText().equals("") && !l�nnskravtxt.getText().equals(""))
		{
			int alder = Integer.parseInt(aldertxt.getText());
			int tlf = Integer.parseInt(tlftxt.getText());
		    int l�nnskrav = Integer.parseInt(l�nnskravtxt.getText());
			String fornavn = fornavntxt.getText();
			String etternavn = etternavntxt.getText();
			String kj�nn = kj�nntxt.getText();
		    String by = bytxt.getText();
		    String epost = eposttxt.getText(); // Kontroll p� at eposten ikke eksisterer
		    String kategori = kategoritxt.getText();

		    utskrift.append( "Vikaren " + fornavn + " " + etternavn + " har blitt lagt inn i systemet!\n\n");


			Vikar v = new Vikar(fornavn, etternavn, kj�nn, alder, by, epost, kategori, tlf, l�nnskrav);
			vikar.settInnVikar(v);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Mangler informasjon om vikaren! Fyll inn alle feltene!");
		}


	}
	private class Knappelytter implements ActionListener
	{
		public void actionPerformed ( ActionEvent e)
		{
			if (e.getSource() == nyVikar)
				{
				 	nyVikar();
	  			}
		}
	}

}
