import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Iterator;
import java.io.*;

public class Soknadvindu extends JFrame implements Serializable
{

	private JButton nySoknad, visSoknad, visVikarer, visVikariat;
	private JTextField vikariattxt, jobbsokertxt;
	private JTextArea utskrift;
	private Soknadsregister soknad;
	private Vikarregister vikar;
	private Vikariatregister vikariat;
	private Arbeidsregister arbeid;
	private Soknaddetails soknaddeets;

	public Soknadvindu(Soknadsregister s, Vikarregister v, Vikariatregister vi, Arbeidsregister a)
	{
		super("Soknadvindu");
		soknad = s;
		vikar = v;
		vikariat = vi;
		arbeid = a;

		utskrift = new JTextArea(10,10);
		utskrift.setEditable(false);
		utskrift.setLineWrap(true);

		Knappelytter lytter = new Knappelytter();
		nySoknad = new JButton("Ny soknad");
		visSoknad = new JButton("Vis alle soknader");
		visVikarer = new JButton("Vis vikarer");
		visVikariat = new JButton("Vis vikariat");

		vikariattxt = new JTextField(6);
		jobbsokertxt = new JTextField(6);

		soknaddeets = new Soknaddetails(vikariattxt, jobbsokertxt);

		vikariattxt.setText("");
		jobbsokertxt.setText("");

		nySoknad.addActionListener(lytter);
		visSoknad.addActionListener(lytter);
		visVikarer.addActionListener(lytter);
		visVikariat.addActionListener(lytter);

	  	JPanel p = new JPanel(new GridLayout(2, 2));
		p.add(nySoknad);
		p.add(visSoknad);
		p.add(visVikarer);
		p.add(visVikariat);

		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(soknaddeets, BorderLayout.WEST);
		c.add(utskrift, BorderLayout.EAST);
		c.add(p, BorderLayout.SOUTH);
		JScrollPane scroll = new JScrollPane(utskrift);
  		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
 	 	c.add(scroll);

		setSize(600,300);
		setVisible(true);
		setResizable(false);
	}
	
	public void nySoknad()
	{
		if (!vikariattxt.getText().equals("") && !jobbsokertxt.getText().equals("") )
		{
			String vikariatID = vikariattxt.getText();
			String jobbsokerID = jobbsokertxt.getText();

			Vikar nyVikar = vikar.sokpaVikarnr(jobbsokerID);
			Vikariat nyVikariat = arbeid.sokpaId(vikariatID);

			if(nyVikar != null && nyVikariat != null)
			{
				Soknad ny = new Soknad(nyVikar, nyVikariat);
				soknad.settInnSoknad(ny);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "ID-en til vikariatet eller vikaren stemmer ikke");
				return;
			}

		    utskrift.append("Soknaden har blitt lagt inn i systemet!\n\n");

		}
		else
		{
			JOptionPane.showMessageDialog(null, "Mangler informasjon om vikariatet! Fyll inn alle feltene!");
		}
	}
	

	public void soknadListe()
	{
		utskrift.setText("Her er alle soknadene vare\n" + vikar.soknadUtskrift());
	}

	public void navnogIdvikar()
	{
		utskrift.setText(vikar.idOgnavn());
	}

	public void navnogIdvikariat()
	{

		utskrift.setText(arbeid.skrivutVikariater());
	}

	private class Knappelytter implements ActionListener
	{
		public void actionPerformed ( ActionEvent e)
		{
			if (e.getSource() == nySoknad)
			{
				nySoknad();
			}
			if (e.getSource() == visSoknad)
			{
				soknadListe();
			}
			if(e.getSource() == visVikarer)
			{
				navnogIdvikar();
			}
			if(e.getSource() == visVikariat)
			{
				navnogIdvikariat();
			}
		}
	}

}