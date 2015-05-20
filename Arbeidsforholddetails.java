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

public class Arbeidsforholddetails extends JPanel
{
	public Arbeidsforholddetails(JTextField vikartxt, JTextField vikariattxt, JTextField opplevelsetxt, JTextField firmatxt)
	{
		Dimension size = getPreferredSize();
		size.width = 250;
		setPreferredSize(size);
		setBorder(BorderFactory.createTitledBorder("Arbeidsforholdinformasjon"));

		JTextField vikartxt1 = vikartxt;
    	JTextField vikariattxt1 = vikariattxt;
    	JTextField opplevelse1 = opplevelsetxt;
    	JTextField firmatxt1 = firmatxt;

    	setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		gc.weightx = 0.5;
		gc.weighty = 0.5;

		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridx = 0;
		gc.gridy = 0;
		add(new JLabel("Vikar-ID: "), gc);
		gc.gridx = 0;
		gc.gridy = 1;
		add(new JLabel("Vikariat-ID: "), gc);
		gc.gridx = 0;
		gc.gridy = 2;
		add(new JLabel("Opplevelse: "), gc);
		gc.gridx = 0;
		gc.gridy = 3;
		add(new JLabel("Firma: "), gc);

		gc.anchor = GridBagConstraints.LINE_START;
		gc.gridx = 1;
		gc.gridy = 0;
		add(vikartxt1, gc);
		gc.gridx = 1;
		gc.gridy = 1;
		add(vikariattxt1, gc);
		gc.gridx = 1;
		gc.gridy = 2;
		add(opplevelse1, gc);
		gc.gridx = 1;
		gc.gridy = 3;
		add(firmatxt1, gc);

		/*c.add(new JLabel("Vikar: "));
		c.add(vikartxt);
		c.add(new JLabel("Vikariat "));
		c.add(vikariattxt);
		c.add(new JLabel("Arbeidstid "));
		c.add(arbeidstidtxt);
		c.add(new JLabel("Firma "));
		c.add(firmatxt);*/
	}
}