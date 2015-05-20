import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Iterator;
import java.io.*;

public class Arbeidsforholdsvindu extends JFrame implements Serializable
{
	private JButton nyArbeidsforhold, visArbeidsforhold;
	private JTextField vikartxt, vikariattxt, opplevelsetxt, firmatxt;
	private JTextArea utskrift;
	private Arbeidsforholdregister aForhold;
	private Vikarregister vReg;
	private Vikariatregister viReg;
	private Arbeidsforholddetails arbfordeets;
	private Arbeidsregister arbeidsgiver;

	public Arbeidsforholdsvindu(Arbeidsforholdregister a, Vikarregister v, Vikariatregister vi, Arbeidsregister arb)
	{
		super("Arbeidsforholdsvindu");
		aForhold = a;
		vReg = v;
		viReg = vi;
		arbeidsgiver = arb;

		utskrift = new JTextArea(10,30);
		utskrift.setEditable(false);
		utskrift.setLineWrap(true);

		Knappelytter lytter = new Knappelytter();
		nyArbeidsforhold = new JButton("Registrer Arbeidsforhold");
		visArbeidsforhold = new JButton("Vis alle arbeidsforhold");

		vikartxt = new JTextField(6);
		vikariattxt = new JTextField(6);
		opplevelsetxt = new JTextField(12);
		firmatxt = new JTextField(6);

		arbfordeets = new Arbeidsforholddetails(vikartxt, vikariattxt, opplevelsetxt, firmatxt);

		vikartxt.setText("");
		vikariattxt.setText("");
		opplevelsetxt.setText("");
		firmatxt.setText("");

		nyArbeidsforhold.addActionListener(lytter);
		visArbeidsforhold.addActionListener(lytter);

		JPanel p = new JPanel(new GridLayout(2, 1));
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
		setResizable(false);

	}

	public void Arbeidsforhold()
	{

		if (!vikartxt.getText().equals("") && !vikariattxt.getText().equals("") && !opplevelsetxt.getText().equals("")
		&& !firmatxt.getText().equals("") )
		{
			String aVikar = vikartxt.getText();
			Vikar arbVikar = vReg.sokpaVikarnr(aVikar);
			String aVikariat = vikariattxt.getText();
			Vikariat arbVikariat = viReg.sokpaVikariat(aVikariat);
		    String firma = firmatxt.getText();
		    String opplevelse = opplevelsetxt.getText();


			List<Arbeidsgiver> aListe = arbeidsgiver.getArbeidsliste();
			Iterator<Arbeidsgiver> iteratorA = aListe.iterator();
			while(iteratorA.hasNext())
			{
				Arbeidsgiver a = iteratorA.next();
				Vikariatregister test = a.getVikariat();

				if(test != null)
				{
				Vikariat vikariatListe = arbeidsgiver.sokpaId(aVikariat);
					if (arbVikar != null)
					{
					  	Arbeidsforhold arb = new Arbeidsforhold(arbVikar, vikariatListe, opplevelse);
					  	aForhold.settInnArbeidsforhold(arb);
					  	utskrift.setText( "Arbeidsforhold hos " + firma + " fra vikariatet " + vikariattxt.getText() + " har blitt lagt inn i systemet!\n" +
										"Vikariatet har blitt slettet fra registeret\n");
					  	arbeidsgiver.fjernVikariat(aVikariat);
					}
				}

			}


		}
		else
		{
			JOptionPane.showMessageDialog(null, "Mangler informasjon! Fyll inn alle feltene!");
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