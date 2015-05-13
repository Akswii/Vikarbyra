import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.io.*;

public class Sokvikariatvindu extends JFrame implements Serializable
{
 private JButton sokvikariat, fjernvikariat;
 private JTextField bransjetxt, idtxt, firmatxt, varighettxt;
 private JTextArea utskrift;

 public Sokvikariatvindu()
 {
  super("Sokvikariatvindu");
  Knappelytter lytter = new Knappelytter();
  utskrift = new JTextArea(10,30);
  utskrift.setEditable(false);

  sokvikariat = new JButton("Sok på vikariat");
  fjernvikariat = new JButton("Fjern vikariat");

  bransjetxt = new JTextField(5);
  idtxt = new JTextField(5);
  firmatxt = new JTextField(5);
  varighettxt = new JTextField(5);

  sokvikariat.addActionListener(lytter);
  fjernvikariat.addActionListener(lytter);

  Container c = getContentPane();
  c.setLayout(new FlowLayout());

  c.add(new JLabel("Bransje: "));
  c.add(bransjetxt);
  c.add(new JLabel("Id: "));
  c.add(idtxt);
  c.add(new JLabel("Firma: "));
  c.add(firmatxt);
  c.add(new JLabel("Varighet: "));
  c.add(varighettxt);

  c.add(sokvikariat);
  c.add(fjernvikariat);

  c.add(utskrift);


  setSize(500,500);
  setVisible(true);
}

 	public void sokVikariat()
 	{
		String s = bransjetxt.toString();
		String v = varighettxt.toString();
		int x = Integer.parseInt(v);
		String f = firmatxt.toString();
		String id = idtxt.toString();

		if(!id.equals(""))
		{
			Vikariatregister idnr = new Vikariatregister();
			Vikariat nummer = idnr.sokpaVikariat(id);
			if ( nummer == null)
			{
				utskrift.setText("Det finnes ingen med det idnummeret");
			}
			else
			{
				utskrift.append(idnr.sokpaVikariat(id).toString());
			}
		}
		else if(!s.equals(""))
		{
			Vikariatregister sektor = new Vikariatregister();

			Vikariat sek = sektor.sokpaVikariat(s);
			if ( sektor == null)
			{
				utskrift.setText("Det er ingen innen denne sektoren");
			}
			else
			{
				utskrift.append(sektor.sokpaSektor(s).toString());
			}
		}
		if(!v.equals(""))
		{
			Vikariatregister tid = new Vikariatregister();
			List<Vikariat> varighet = tid.sokpaVarighet(x);
			if ( varighet == null)
			{
				utskrift.setText("Det er ingen med denne varigheten");
			}
			else
			{
				utskrift.append(tid.sokpaVarighet(x).toString());
			}
		}
		else if(!f.equals(""))
		{
			Vikariatregister firma = new Vikariatregister();

			Vikariat fir = firma.sokpaVikariat(f);
			if ( fir == null)
			{
				utskrift.setText("Det er ingen firma med det navnet");
			}
			else
			{
				utskrift.append(firma.sokpaFirma(f).toString());
		 	}
		}
		else
		{
			utskrift.setText("Fyll in firma feltet for å bruke denne metoden!");
		}
	}

 	public void fjernVikariat()
 	{

	}

 	  private class Knappelytter implements ActionListener
 	  {
 	    public void actionPerformed ( ActionEvent e)
 	    {
 	      if (e.getSource() == sokvikariat)
 	      {
 	   			sokVikariat();
 	  	  }
 		  else if(e.getSource() == fjernvikariat)
 		  {
			  fjernVikariat();
		  }
 	 	}
 	}

}