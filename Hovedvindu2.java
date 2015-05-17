import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Hovedvindu2 extends JFrame implements Serializable
{
	private DetailsPanel detailsPanel;

	public Hovedvindu2(Arbeidsforholdregister a, Arbeidsregister ar, Soknadsregister s, Vikariatregister v, Vikarregister vik)
	{
		super("Vikarbyraa");
		detailsPanel = new DetailsPanel(a, ar, s, v, vik);
		setLayout(new BorderLayout());

		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(detailsPanel, BorderLayout.CENTER);
		//c.add(utskrift, BorderLayout.EAST);

		setSize(500,250);
		setVisible(true);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
}