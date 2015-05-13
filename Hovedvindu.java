import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Hovedvindu extends JFrame implements Serializable
{
	private JButton nyVikar, nyVikariat, nyArbeidsgiver, regArbeidsforhold, regSoknad, visVikar,
	visVikariat, visSoknader, visArbeidsforhold, visArbeidsgiver, sokVikar, sokVikariat, sokArbeidsgiver;
	private JTextArea utskrift;

	public Hovedvindu()
	{
		super("Hovedvindu");
		Knappelytter lytter = new Knappelytter();

		utskrift = new JTextArea(10,30);
		utskrift.setEditable(false);

		nyVikar = new JButton("Ny Vikar");
		nyVikariat = new JButton("Nytt Vikariat");
		nyArbeidsgiver = new JButton("Ny Arbeidsgiver");
		regArbeidsforhold = new JButton("Registrer Arbeidsforhold");
		regSoknad = new JButton("Registret soknad");

		sokVikar = new JButton("Sok Vikar");
		sokVikariat = new JButton("Sok Vikariat");
		sokArbeidsgiver = new JButton("Sok Arbeidsgiver");

		visVikar = new JButton("Vis alle vikarer");
		visVikariat = new JButton("Vis alle vikariat");
		visSoknader = new JButton("Vis alle soknader");
		visArbeidsforhold = new JButton("Vis alle arbeidsforhold");
		visArbeidsgiver = new JButton("Vis alle arbeidsgivere");

		nyVikar.addActionListener(lytter);
		nyVikariat.addActionListener(lytter);
		nyArbeidsgiver.addActionListener(lytter);
		regArbeidsforhold.addActionListener(lytter);
		regSoknad.addActionListener(lytter);
		visVikar.addActionListener(lytter);
		visVikariat.addActionListener(lytter);
		visSoknader.addActionListener(lytter);
		visArbeidsforhold.addActionListener(lytter);
		visArbeidsgiver.addActionListener(lytter);
		sokVikar.addActionListener(lytter);
		sokVikariat.addActionListener(lytter);
		sokArbeidsgiver.addActionListener(lytter);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(nyVikar);
		c.add(nyVikariat);
		c.add(nyArbeidsgiver);
		c.add(regArbeidsforhold);
		c.add(regSoknad);
		c.add(visVikar);
		c.add(visVikariat);
		c.add(visSoknader);
		c.add(visArbeidsforhold);
		c.add(visArbeidsgiver);
		c.add(utskrift);
		c.add(sokVikar);
		c.add(sokVikariat);
		c.add(sokArbeidsgiver);

		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

	}
	public void vikarListe()
	{
		//Metode som viser en liste over vikarene vare
		Vikarregister vListe = new Vikarregister();
		utskrift.setText("Her er vikar lista var\n" + vListe.toString());
	}
	public void vikariatListe()
	{
		//Metode som viser en liste over de forskjellige vikariatene som man kan soke på
		Vikariatregister vListe = new Vikariatregister();
		utskrift.setText("Her er vikariat lista var\n" + vListe.toString());
	}
	public void arbeidsgiverListe()
	{
		//Metode som vier en liste over arbeidsgiverne vare
		Arbeidsregister aListe = new Arbeidsregister();
		utskrift.setText("Her er arbeidsgiver lista var\n" + aListe.toString());
	}
	public void soknadListe()
	{
		//Metode som viser en liste over alle soknadene på de forskjellige vikariatene
		Soknadsregister sListe = new Soknadsregister();
		utskrift.setText("Her er alle soknadene vare\n" + sListe.toString());
	}
	public void arbeidsforholdsListe()
	{
		//Metode som viser en liste over alle arbeidsforholdene som er registrert på de forskjellige vikariatene
		Arbeidsforholdregister aListe = new Arbeidsforholdregister();
		utskrift.setText("Her er alle registrete arbeidsforhold\n" + aListe.toString());
	}
	private class Knappelytter implements ActionListener
	{
		public void actionPerformed ( ActionEvent e)
		{
			if (e.getSource() == nyVikar)
			{
				Vikarvindu opprettVikar = new Vikarvindu();
	  		}
	  		if (e.getSource() == nyVikariat)
			{
				Vikariatvindu opprettVikariat = new Vikariatvindu();
	  		}
	  		if (e.getSource() == nyArbeidsgiver)
			{
				Arbeidsgivervindu opprettArbeidsgiver = new Arbeidsgivervindu();
	  		}
	  		if (e.getSource() == regArbeidsforhold)
			{
				Arbeidsforholdsvindu opprettArbeidsforhold = new Arbeidsforholdsvindu();
	  		}
	  		if (e.getSource() == regSoknad)
			{
				Soknadvindu opprettSoknad = new Soknadvindu();
	  		}
	  		if (e.getSource() == visVikar)
			{
				vikarListe();
	  		}
	  		if (e.getSource() == visVikariat)
			{
				vikariatListe();
	  		}
	  		if (e.getSource() == visSoknader)
			{
				soknadListe();
	  		}
	  		if (e.getSource() == visArbeidsforhold)
			{
				arbeidsforholdsListe();
	  		}
	  		if (e.getSource() == visArbeidsgiver)
			{
				arbeidsgiverListe();
	  		}
	  		if (e.getSource() == sokVikar)
			{
				Sokvikarvindu vikarSok = new Sokvikarvindu();
	  		}
	  		if (e.getSource() == sokVikariat)
			{
				Sokvikariatvindu vikariatSok = new Sokvikariatvindu();
	  		}
	  		if (e.getSource() == sokArbeidsgiver)
			{
				Sokarbeidsgivervindu arbeidsgiverSok = new Sokarbeidsgivervindu();
	  		}
		}
	}
}