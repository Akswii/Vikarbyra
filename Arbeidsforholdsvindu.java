import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Iterator;
import java.io.*;

public class Arbeidsforholdsvindu extends JFrame implements Serializable
{
	private JButton nyArbeidsforhold, visArbeidsforhold;
	private JTextField vikartxt, vikariattxt, arbeidstidtxt, firmatxt;
	private JTextArea utskrift;
	private Arbeidsforholdregister aForhold;
	private Arbeidsforholddetails arbfordeets;

	public Arbeidsforholdsvindu(Arbeidsforholdregister a)
	{
		super("Arbeidsforholdsvindu");
		aForhold = a;

		utskrift = new JTextArea(10,30);
		utskrift.setEditable(false);
		utskrift.setLineWrap(true);

		Knappelytter lytter = new Knappelytter();
		nyArbeidsforhold = new JButton("Registrer Arbeidsforhold");
		visArbeidsforhold = new JButton("Vis alle arbeidsforhold");

		vikartxt = new JTextField(6);
		vikariattxt = new JTextField(6);
		arbeidstidtxt = new JTextField(6);
		firmatxt = new JTextField(6);

		arbfordeets = new Arbeidsforholddetails(vikartxt, vikariattxt, arbeidstidtxt, firmatxt);

		vikartxt.setText("");
		vikariattxt.setText("");
		arbeidstidtxt.setText("");
		firmatxt.setText("");

		nyArbeidsforhold.addActionListener(lytter);
		visArbeidsforhold.addActionListener(lytter);

		JPanel p = new JPanel(new GridLayout(2, 2));
		p.add(nyArbeidsforhold);
		p.add(visArbeidsforhold);

		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(arbfordeets, BorderLayout.WEST);
		c.add(p, BorderLayout.SOUTH);
		c.add(utskrift, BorderLayout.EAST);
		JScrollPane scroll = new JScrollPane(utskrift);
  		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
 	 	c.add(scroll);

		setSize(600,300);
		setVisible(true);

	}
	private void lesFil()
		   {
		    try(ObjectInputStream innfil = new ObjectInputStream(new FileInputStream( "arbeidsforholdliste.data" )))
		    {
		     aForhold = (Arbeidsforholdregister) innfil.readObject();
		    }
		    catch(ClassNotFoundException cnfe)
		    {
		     utskrift.setText(cnfe.getMessage());
		     utskrift.append("\nOppretter tom liste.\n");
		     aForhold = new Arbeidsforholdregister();
		    }
		    catch(FileNotFoundException fne)
		    {
		     utskrift.setText("Finner ikke datafil. Oppretter tom liste.\n");
		         aForhold = new Arbeidsforholdregister();
		      }
		      catch(IOException ioe)
		      {
		         utskrift.setText("Innlesingsfeil. Oppretter tom liste.\n");
		         aForhold = new Arbeidsforholdregister();
		      }
		   }

		   public void skrivTilFil()
		  {
		  try (ObjectOutputStream utfil = new ObjectOutputStream(new FileOutputStream("arbeidsforholdliste.data")))
		  {
		        utfil.writeObject(aForhold);
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
	public void Arbeidsforhold()
	{

		if (!vikartxt.getText().equals("") && !vikariattxt.getText().equals("") && !arbeidstidtxt.getText().equals("")
		&& !firmatxt.getText().equals("") )
		{
			String vikar = vikartxt.getText();
			String vikariat = vikariattxt.getText();
			String arbeidstid = arbeidstidtxt.getText();
		    String firma = firmatxt.getText();

		     utskrift.append( "Arbeidsforhold hos " + firma + " fra vikariatet " + vikariat	 + " har blitt lagt inn i systemet!\n\n");

		}
		else
		{
			JOptionPane.showMessageDialog(null, "Mangler informasjon om vikariatet! Fyll inn alle feltene!");
		}

	}
	public void arbeidsforholdsListe()
	{
			//Metode som viser en liste over alle arbeidsforholdene som er registrert pa de forskjellige vikariatene
			utskrift.setText("Her er alle registrete arbeidsforhold\n" + aForhold.toString());
	}
	private class Knappelytter implements ActionListener
	{
		public void actionPerformed ( ActionEvent e)
		{
			if( e.getSource() == nyArbeidsforhold)
			{
				Arbeidsforhold();
			}
			if( e.getSource() == visArbeidsforhold)
			{
				arbeidsforholdsListe();
			}

		}
	}

}