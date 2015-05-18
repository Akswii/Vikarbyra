import java.awt.Dimension;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;


public class DetailsPanel extends JPanel
{
	private JButton nyVikar, nyVikariat, nyArbeidsgiver, regArbeidsforhold, regSoknad;
	private Arbeidsforholdregister forhregister;
	private Arbeidsregister arbreg;
	private Soknadsregister sokreg;
	private Vikariatregister vikariatreg;
	private Vikarregister vikreg;

	public DetailsPanel(Arbeidsforholdregister a, Arbeidsregister ar, Soknadsregister s, Vikariatregister v, Vikarregister vik)
	{
		forhregister = a;
		arbreg = ar;
		sokreg = s;
		vikariatreg = v;
		vikreg = vik;

		setBorder(BorderFactory.createTitledBorder("Hovedmeny"));
		Dimension size = getPreferredSize();
		size.width = 250;
		setPreferredSize(size);

		Knappelytter lytter = new Knappelytter();
		
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

		setLayout(new GridLayout(3, 2));
		
		add(nyVikar);
		add(nyVikariat);
		add(nyArbeidsgiver);
		add(regArbeidsforhold);
		add(regSoknad);
	}

	private class Knappelytter implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == nyVikar)
			{
				Vikarvindu opprettVikar = new Vikarvindu(vikreg);		
				opprettVikar.setLocationRelativeTo(null);
	  		}
	  		if (e.getSource() == nyVikariat)
			{
				Vikariatvindu opprettVikariat = new Vikariatvindu(vikariatreg);
				opprettVikariat.setLocationRelativeTo(null);
	  		}
	  		if (e.getSource() == nyArbeidsgiver)
			{
				Arbeidsgivervindu opprettArbeidsgiver = new Arbeidsgivervindu(arbreg);
				opprettArbeidsgiver.setLocationRelativeTo(null);
	  		}
	  		if (e.getSource() == regArbeidsforhold)
			{
				Arbeidsforholdsvindu opprettArbeidsforhold = new Arbeidsforholdsvindu(forhregister);
				opprettArbeidsforhold.setLocationRelativeTo(null);
	  		}
	  		if (e.getSource() == regSoknad)
			{
				Soknadvindu opprettSoknad = new Soknadvindu(sokreg, vikreg, vikariatreg);
				opprettSoknad.setLocationRelativeTo(null);
	  		}
		}
	}
}