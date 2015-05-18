import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Vikariatdetails extends JPanel
{
	public Vikariatdetails(JTextField arbeidsstedtxt, JTextField stillingtxt, JTextField arbeidstidtxt, JTextField firmatxt, JTextField idtxt, JTextField varighettxt, JTextField bransjetxt, JTextField lonntxt, JTextField kontakttxt, JTextField stillingBesktxt)
	{
		Dimension size = getPreferredSize();
		size.width = 250;
		setPreferredSize(size);
		setBorder(BorderFactory.createTitledBorder("Vikarinformasjon"));

		JTextField arbeidsstedtxt1 = arbeidsstedtxt;
    	JTextField stillingtxt1 = stillingtxt;
    	JTextField arbeidstidtxt1 = arbeidstidtxt;
    	JTextField firmatxt1 = firmatxt;
    	JTextField idtxt1 = idtxt;
    	JTextField varighettxt1 = varighettxt;
    	JTextField bransjetxt1 = bransjetxt;
    	JTextField lonntxt1 = lonntxt;
    	JTextField kontakttxt1 = kontakttxt;
    	JTextField stillingBesktxt1 = stillingBesktxt;

    	setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		gc.weightx = 0.5;
		gc.weighty = 0.5;
		
		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridx = 0;
		gc.gridy = 0;
		add(new JLabel("Arbeidssted: "), gc);
		gc.gridx = 0;
		gc.gridy = 1;
		add(new JLabel("Arbeidstid: "), gc);
		gc.gridx = 0;
		gc.gridy = 2;
		add(new JLabel("Stilling: "), gc);
		gc.gridx = 0;
		gc.gridy = 3;
		add(new JLabel("Firma: "), gc);
		gc.gridx = 0;
		gc.gridy = 4;
		add(new JLabel("Stillingsbeskrivelse: "), gc);
		gc.gridx = 0;
		gc.gridy = 5;
		add(new JLabel("Varighet: "), gc);
		gc.gridx = 0;
		gc.gridy = 6;
		add(new JLabel("Bransje: "), gc);
		gc.gridx = 0;
		gc.gridy = 7;
		add(new JLabel("Lonn: "), gc);
		gc.gridx = 0;
		gc.gridy = 8;
		add(new JLabel("Kontaktperson: "), gc);
		gc.gridx = 0;
		gc.gridy = 9;
		add(new JLabel("ID: "), gc);

		gc.anchor = GridBagConstraints.LINE_START;
		gc.gridx = 1;
		gc.gridy = 0;
		add(arbeidsstedtxt1, gc);
		gc.gridx = 1;
		gc.gridy = 1;
		add(arbeidstidtxt1, gc);
		gc.gridx = 1;
		gc.gridy = 2;
		add(stillingtxt1, gc);
		gc.gridx = 1;
		gc.gridy = 3;
		add(stillingBesktxt1, gc);
		gc.gridx = 1;
		gc.gridy = 4;
		add(firmatxt1, gc);
		gc.gridx = 1;
		gc.gridy = 5;
		add(varighettxt1, gc);
		gc.gridx = 1;
		gc.gridy = 6;
		add(bransjetxt1, gc);
		gc.gridx = 1;
		gc.gridy = 7;
		add(lonntxt1, gc);
		gc.gridx = 1;
		gc.gridy = 8;
		add(kontakttxt1, gc);
		gc.gridx = 1;
		gc.gridy = 9;
		add(idtxt1, gc);
	}
}