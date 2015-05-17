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

public class Vikardetails2 extends JPanel
{
	
	public Vikardetails2(JTextField fornavntxt, JTextField etternavntxt, JTextField aldertxt, JTextField bytxt, JTextField eposttxt, JTextField kategoritxt, JTextField tlftxt, JTextField lonnskravtxt, JTextField kjonntxt, JTextField idtxt)
	{
		Dimension size = getPreferredSize();
		size.width = 250;
		setPreferredSize(size);
		setBorder(BorderFactory.createTitledBorder("Hovedmeny"));

		fornavntxt = new JTextField(6);
    	etternavntxt = new JTextField(6);
    	aldertxt = new JTextField(6);
    	bytxt = new JTextField(6);
    	eposttxt = new JTextField(6);
    	kategoritxt = new JTextField(6);
    	tlftxt = new JTextField(6);
    	lonnskravtxt = new JTextField(6);
    	kjonntxt = new JTextField(6);
    	idtxt = new JTextField(6);

    	/*Dimension size2 = getPreferredSize();
		size2.width = 100;
		size2.height = 20;
    	fornavntxt.setMinimumSize(size2);
    	fornavntxt.setMinimumSize(size2);
		etternavntxt.setMinimumSize(size2);
		aldertxt.setMinimumSize(size2);
		bytxt.setMinimumSize(size2);
		eposttxt.setMinimumSize(size2);
		kategoritxt.setMinimumSize(size2);
		tlftxt.setMinimumSize(size2);
		lonnskravtxt.setMinimumSize(size2);
		kjonntxt.setMinimumSize(size2);
		idtxt.setMinimumSize(size2);*/

    	fornavntxt.setText("");
		etternavntxt.setText("");
		aldertxt.setText("");
		bytxt.setText("");
		eposttxt.setText("");
		kategoritxt.setText("");
		tlftxt.setText("");
		lonnskravtxt.setText("");
		kjonntxt.setText("");
		idtxt.setText("");
		
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
		add(fornavntxt, gc);
		gc.gridx = 1;
		gc.gridy = 1;
		add(etternavntxt, gc);
		gc.gridx = 1;
		gc.gridy = 2;
		add(aldertxt, gc);
		gc.gridx = 1;
		gc.gridy = 3;
		add(bytxt, gc);
		gc.gridx = 1;
		gc.gridy = 4;
		add(eposttxt, gc);
		gc.gridx = 1;
		gc.gridy = 5;
		add(kategoritxt, gc);
		gc.gridx = 1;
		gc.gridy = 6;
		add(tlftxt, gc);
		gc.gridx = 1;
		gc.gridy = 7;
		add(lonnskravtxt, gc);
		gc.gridx = 1;
		gc.gridy = 8;
		add(kjonntxt, gc);
		gc.gridx = 1;
		gc.gridy = 9;
		add(idtxt, gc);

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