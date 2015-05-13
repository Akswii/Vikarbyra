import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.io.*;

public class Soknadvindu extends JFrame implements Serializable
{

	private JButton nySoknad;
	private JTextField vikariattxt, jobbsokertxt;
	private JTextArea utskrift;
	Soknadsregister soknad = new Soknadsregister();

	public Soknadvindu()
	{
		super("Soknadvindu");
		Knappelytter lytter = new Knappelytter();

		utskrift = new JTextArea(10,10);
		utskrift.setEditable(false);

		nySoknad = new JButton("Ny Soknad");
		vikariattxt = new JTextField(6);
		jobbsokertxt = new JTextField(6);

		nySoknad.addActionListener(lytter);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(nySoknad);

		c.add(new JLabel("Vikariat: "));
		c.add(vikariattxt);
		c.add(new JLabel("Jobbsoker: "));
		c.add(jobbsokertxt);

		c.add(utskrift);

		setSize(500,500);
		setVisible(true);
	}
	private void lesFil()
		   {
		    try(ObjectInputStream innfil = new ObjectInputStream(new FileInputStream( "soknadsliste.data" )))
		    {
		     soknad = (Soknadsregister) innfil.readObject();
		    }
		    catch(ClassNotFoundException cnfe)
		    {
		     utskrift.setText(cnfe.getMessage());
		     utskrift.append("\nOppretter tom liste.\n");
		     soknad = new Soknadsregister();
		    }
		    catch(FileNotFoundException fne)
		    {
		     utskrift.setText("Finner ikke datafil. Oppretter tom liste.\n");
		         soknad = new Soknadsregister();
		      }
		      catch(IOException ioe)
		      {
		         utskrift.setText("Innlesingsfeil. Oppretter tom liste.\n");
		         soknad = new Soknadsregister();
		      }
		   }

		   public void skrivTilFil()
		  {
		  try (ObjectOutputStream utfil = new ObjectOutputStream(new FileOutputStream("soknadsliste.data")))
		  {
		        utfil.writeObject(soknad);
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
	public void nySoknad()
	{

		if (!vikariattxt.getText().equals("") && !jobbsokertxt.getText().equals("") )
		{
			String vikariat = vikariattxt.getText();
			String jobbsoker = jobbsokertxt.getText();

		    utskrift.append( "Soknaden på " + vikariat + " vikariatet av " + jobbsoker + " har blitt lagt inn i systemet!\n\n");

		}
		else
		{
			JOptionPane.showMessageDialog(null, "Mangler informasjon om vikariatet! Fyll inn alle feltene!");
		}
	}
	private class Knappelytter implements ActionListener
	{
		public void actionPerformed ( ActionEvent e)
		{
			if (e.getSource() == nySoknad)
			{
				nySoknad();
			}
		}
	}

}