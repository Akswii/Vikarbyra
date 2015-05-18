import java.awt.Dimension;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Iterator;
import java.io.*;

public class Arbeidsgiverdetails extends JPanel
{
	public Arbeidsgiverdetails(JTextField fornavntxt, JTextField etternavntxt, JTextField firmatxt, JTextField adressetxt, JTextField bransjetxt, JTextField tlftxt, JTextField eposttxt, JTextField bytxt, JTextField nrtxt, JTextField kjonntxt, JTextField aldertxt)
	{
		Dimension size = getPreferredSize();
		size.width = 250;
		setPreferredSize(size);
		setBorder(BorderFactory.createTitledBorder("Arbeidsgiverinformasjon"));

		JTextField fornavntxt1 = fornavntxt;
	   	JTextField etternavntxt1 = etternavntxt;
	   	JTextField firmatxt1 = firmatxt;
	   	JTextField adressetxt1 = adressetxt;
	   	JTextField bransjetxt1 = bransjetxt;
	   	JTextField tlftxt1 = tlftxt;
	   	JTextField eposttxt1 = eposttxt;
	   	JTextField bytxt1 = bytxt;
	   	JTextField nrtxt1 = nrtxt;
	   	JTextField kjonntxt1 = kjonntxt;
	   	JTextField aldertxt1 = aldertxt;

	   	setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.anchor = GridBagConstraints.LINE_END;

		gc.gridx = 0;
		gc.gridy = 0;
		add(new JLabel("Fornavn: "), gc);
		gc.gridx = 0;
		gc.gridy = 1;
		add(new JLabel("Etternavn: "), gc);
		gc.gridx = 0;
		gc.gridy = 2;
		add(new JLabel("Firma: "), gc);
		gc.gridx = 0;
		gc.gridy = 3;
		add(new JLabel("Adresse: "), gc);
		gc.gridx = 0;
		gc.gridy = 4;
		add(new JLabel("Bransje: "), gc);
		gc.gridx = 0;
		gc.gridy = 5;
		add(new JLabel("Telefon: "), gc);
		gc.gridx = 0;
		gc.gridy = 6;
		add(new JLabel("Epost: "), gc);
		gc.gridx = 0;
		gc.gridy = 7;
		add(new JLabel("By: "), gc);
		gc.gridx = 0;
		gc.gridy = 8;
		add(new JLabel("ID: "), gc);
		gc.gridx = 0;
		gc.gridy = 9;
		add(new JLabel("Kjonn: "), gc);
		gc.gridx = 0;
		gc.gridy = 10;
		add(new JLabel("Alder: "), gc);

		gc.anchor = GridBagConstraints.LINE_START;
		gc.gridx = 1;
		gc.gridy = 0;
		add(fornavntxt1, gc);
		gc.gridx = 1;
		gc.gridy = 1;
		add(etternavntxt1, gc);
		gc.gridx = 1;
		gc.gridy = 2;
		add(firmatxt1, gc);
		gc.gridx = 1;
		gc.gridy = 3;
		add(adressetxt1, gc);
		gc.gridx = 1;
		gc.gridy = 4;
		add(bransjetxt1, gc);
		gc.gridx = 1;
		gc.gridy = 5;
		add(tlftxt1, gc);
		gc.gridx = 1;
		gc.gridy = 6;
		add(eposttxt1, gc);
		gc.gridx = 1;
		gc.gridy = 7;
		add(bytxt1, gc);
		gc.gridx = 1;
		gc.gridy = 8;
		add(nrtxt1, gc);
		gc.gridx = 1;
		gc.gridy = 9;
		add(kjonntxt1, gc);
		gc.gridx = 1;
		gc.gridy = 10;
		add(aldertxt1, gc);
	}
}