import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Hovedvindu extends JFrame implements Serializable
{
	private JButton nyVikar, nyVikariat, nyArbeidsgiver, regArbeidsforhold, regSoknad;
	private JTextArea utskrift;
	private Arbeidsforholdregister forhregister;
	private Arbeidsregister arbreg;
	private Soknadsregister sokreg;
	private Vikariatregister vikariatreg;
	private Vikarregister vikreg;


	public Hovedvindu(Arbeidsforholdregister a, Arbeidsregister ar, Soknadsregister s, Vikariatregister v, Vikarregister vik)
	{
		super("Hovedvindu");
		Knappelytter lytter = new Knappelytter();

		forhregister = a;
		arbreg = ar;
		sokreg = s;
		vikariatreg = v;
		vikreg = vik;

		utskrift = new JTextArea(10,30);
		utskrift.setEditable(false);

		nyVikar = new JButton("Ny Vikar");
		nyVikariat = new JButton("Nytt Vikariat");
		nyArbeidsgiver = new JButton("Ny Arbeidsgiver");
		regArbeidsforhold = new JButton("Registrer Arbeidsforhold");
		regSoknad = new JButton("Registret soknad");

		nyVikar.addActionListener(lytter);
		nyVikariat.addActionListener(lytter);
		nyArbeidsgiver.addActionListener(lytter);
		regArbeidsforhold.addActionListener(lytter);
		regSoknad.addActionListener(lytter);


		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(nyVikar);
		c.add(nyVikariat);
		c.add(nyArbeidsgiver);
		c.add(regArbeidsforhold);
		c.add(regSoknad);
		c.add(utskrift);


		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

	}
	private class Knappelytter implements ActionListener
	{
		public void actionPerformed ( ActionEvent e)
		{
			if (e.getSource() == nyVikar)
			{
				Vikarvindu opprettVikar = new Vikarvindu(vikreg);
	  		}
	  		if (e.getSource() == nyVikariat)
			{
				Vikariatvindu opprettVikariat = new Vikariatvindu(vikariatreg);
	  		}
	  		if (e.getSource() == nyArbeidsgiver)
			{
				Arbeidsgivervindu opprettArbeidsgiver = new Arbeidsgivervindu(arbreg);
	  		}
	  		if (e.getSource() == regArbeidsforhold)
			{
				Arbeidsforholdsvindu opprettArbeidsforhold = new Arbeidsforholdsvindu(forhregister);
	  		}
	  		if (e.getSource() == regSoknad)
			{
				Soknadvindu opprettSoknad = new Soknadvindu(sokreg, vikreg, vikariatreg);
	  		}
		}
	}
}