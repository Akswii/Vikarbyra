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

public class Vikardetails extends JPanel
{
	
	public Vikardetails(JTextField fornavntxt, JTextField etternavntxt, JTextField aldertxt, JTextField bytxt, JTextField eposttxt, JTextField kategoritxt, JTextField tlftxt, JTextField lonnskravtxt, JTextField kjonntxt, JTextField idtxt)
	{
		Dimension size = getPreferredSize();
		size.width = 250;
		setPreferredSize(size);
		setBorder(BorderFactory.createTitledBorder("Vikarinformasjon"));

		JTextField fornavntxt1 = fornavntxt;
    	JTextField etternavntxt1 = etternavntxt;
    	JTextField aldertxt1 = aldertxt;
    	JTextField bytxt1 = bytxt;
    	JTextField eposttxt1 = eposttxt;
    	JTextField kategoritxt1 = kategoritxt;
    	JTextField tlftxt1 = tlftxt;
    	JTextField lonnskravtxt1 = lonnskravtxt;
    	JTextField kjonntxt1 = kjonntxt;
    	JTextField idtxt1 = idtxt;
		
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
		add(new JLabel("Alder: "), gc);
		gc.gridx = 0;
		gc.gridy = 3;
		add(new JLabel("By: "), gc);
		gc.gridx = 0;
		gc.gridy = 4;
		add(new JLabel("Epost: "), gc);
		gc.gridx = 0;
		gc.gridy = 5;
		add(new JLabel("Kategori: "), gc);
		gc.gridx = 0;
		gc.gridy = 6;
		add(new JLabel("Telefon: "), gc);
		gc.gridx = 0;
		gc.gridy = 7;
		add(new JLabel("Lonnskrav: "), gc);
		gc.gridx = 0;
		gc.gridy = 8;
		add(new JLabel("Kjonn: "), gc);
		gc.gridx = 0;
		gc.gridy = 9;
		add(new JLabel("ID: "), gc);

		gc.anchor = GridBagConstraints.LINE_START;
		gc.gridx = 1;
		gc.gridy = 0;
		add(fornavntxt1, gc);
		gc.gridx = 1;
		gc.gridy = 1;
		add(etternavntxt1, gc);
		gc.gridx = 1;
		gc.gridy = 2;
		add(aldertxt1, gc);
		gc.gridx = 1;
		gc.gridy = 3;
		add(bytxt1, gc);
		gc.gridx = 1;
		gc.gridy = 4;
		add(eposttxt1, gc);
		gc.gridx = 1;
		gc.gridy = 5;
		add(kategoritxt1, gc);
		gc.gridx = 1;
		gc.gridy = 6;
		add(tlftxt1, gc);
		gc.gridx = 1;
		gc.gridy = 7;
		add(lonnskravtxt1, gc);
		gc.gridx = 1;
		gc.gridy = 8;
		add(kjonntxt1, gc);
		gc.gridx = 1;
		gc.gridy = 9;
		add(idtxt1, gc);

		/*gc.anchor = GridBagConstraints.CENTER;
		//gc.weighty = 5;
		gc.gridx = 0;
		gc.gridy = 10;
		add(p, gc);

		/*gc.weighty = 10;
		gc.anchor = GridBagConstraints.CENTER;

		gc.gridx = 0;
		gc.gridy = 12;
		add(nyVikar, gc);
		gc.gridx = 0;
		gc.gridy = 13;
		add(fjernVikar, gc);

		gc.gridx = 1;
		gc.gridy = 12;
		add(sokVikar, gc);
		gc.gridx = 1;
		gc.gridy = 13;
		add(visVikar, gc);*/
	}
}