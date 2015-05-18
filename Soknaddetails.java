import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Soknaddetails extends JPanel
{
	public Soknaddetails(JTextField vikariattxt, JTextField jobbsokertxt)
	{
		Dimension size = getPreferredSize();
		size.width = 250;
		setPreferredSize(size);
		setBorder(BorderFactory.createTitledBorder("Soknadsinformasjon"));

		JTextField vikariattxt1 = vikariattxt;
    	JTextField jobbsokertxt1 = jobbsokertxt;

    	setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		gc.weightx = 0.5;
		gc.weighty = 0.5;
		
		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridx = 0;
		gc.gridy = 0;
		add(new JLabel("Vikariat-ID: "), gc);
		gc.gridx = 0;
		gc.gridy = 1;
		add(new JLabel("Jobbsoker-ID: "), gc);

		gc.anchor = GridBagConstraints.LINE_START;
		gc.gridx = 1;
		gc.gridy = 0;
		add(vikariattxt1, gc);
		gc.gridx = 1;
		gc.gridy = 1;
		add(jobbsokertxt1, gc);
	}
}