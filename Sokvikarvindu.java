import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Iterator;
import java.io.*;

public class Sokvikarvindu extends JFrame implements Serializable
{
 	private JButton sokVikar, fjernVikar;
 	private JTextField fornavntxt, etternavntxt, idtxt, bytxt, eposttxt, aldertxt, kjonntxt;
 	private JTextArea utskrift;

	Vikarregister vikar = new Vikarregister();

 	public Sokvikarvindu()
 	{
 	 super("SokVikarvindu");
 	 Knappelytter lytter = new Knappelytter();
 	 utskrift = new JTextArea(10,30);
 	 utskrift.setEditable(false);

 	 sokVikar = new JButton("Sok Vikar");
 	 fjernVikar = new JButton("Fjern Vikar");

 	 fornavntxt = new JTextField(5);
 	 etternavntxt = new JTextField(5);
 	 idtxt = new JTextField(5);
 	 bytxt = new JTextField(5);
 	 eposttxt = new JTextField(5);
 	 aldertxt = new JTextField(5);
 	 kjonntxt = new JTextField(5);

 	 sokVikar.addActionListener(lytter);
 	 fjernVikar.addActionListener(lytter);

 	 Container c = getContentPane();
 	 c.setLayout(new FlowLayout());

 	 c.add(new JLabel("Fornavn: "));
 	 c.add(fornavntxt);
 	 c.add(new JLabel("Etternavn: "));
 	 c.add(etternavntxt);
 	 c.add(new JLabel("Id: "));
 	 c.add(idtxt);
 	 c.add(new JLabel("By: "));
 	 c.add(bytxt);
 	 c.add(new JLabel("Epost: "));
 	 c.add(eposttxt);
 	 c.add(new JLabel("Alder: "));
 	 c.add(aldertxt);
 	 c.add(new JLabel("Kjonn "));
 	 c.add(kjonntxt);

 	 c.add(sokVikar);
 	 c.add(utskrift);
 	 c.add(fjernVikar);


 	 setSize(500,500);
 	 setVisible(true);
	}


	  public void sokVikar()
	  {
			String fornavn = fornavntxt.getText();
			String etternavn = etternavntxt.getText();
			String id = idtxt.getText();
			String by = bytxt.getText();
			String epost = eposttxt.getText();
			String alder = aldertxt.getText();
			String kjonn = kjonntxt.getText();
			String feilmelding = "Det finnes ingen vikarer som passer til disse opplysningene";

			utskrift.setText("");

			if (fornavntxt.getText().equals("") && etternavntxt.getText().equals("") && kjonntxt.getText().equals("")
				&& aldertxt.getText().equals("") && bytxt.getText().equals("") && eposttxt.getText().equals("")
				&& idtxt.getText().equals(""))
				{
					utskrift.setText("Du ma fylle inn minst ett felt");
					return;
				}

			if (!id.equals(""))
			{
				String sokVikar = "";
				sokVikar += vikar.sokpaVikarnr(id).toString();
				if (sokVikar != "")
				{
					utskrift.setText(sokVikar);
					return;
				}
				else
				{
					utskrift.setText(feilmelding);
					return;
				}

			}
			if (!epost.equals(""))
			{
				String sokEpost = "";
				sokEpost += vikar.sokpaVikarepost(epost).toString();
				if (sokEpost != "")
				{
					utskrift.setText(sokEpost);
					return;
				}
				else
				{
					utskrift.setText(feilmelding);
					return;
				}
			}
			if (!fornavn.equals(""))
			{
				List<Vikar> fornavnliste = vikar.sokpaVikarfornavn(fornavn);
				Iterator<Vikar> iterator = fornavnliste.iterator();
				while(iterator.hasNext())
				{
					Vikar v = iterator.next();
					String etternavn1 = v.getEtternavn();
					String by1 = v.getBy();
					int alder1 = v.getAlder();
					int alderInt = Integer.parseInt(alder);
					String kjonn1 = v.getKjonn();
					if (etternavn == etternavn1 && by == by1 && alderInt == alder1 && kjonn == kjonn1)
					{
						utskrift.append(v.toString() + "\n");
					}
					else
					{
						utskrift.setText(feilmelding);
					}
				}
				return;

	  		}
	  		if (!etternavn.equals(""))
			{
				List<Vikar> etternavnliste = vikar.sokpaVikaretternavn(etternavn);
				Iterator<Vikar> iterator = etternavnliste.iterator();
				while(iterator.hasNext())
				{
					Vikar v = iterator.next();
					String by1 = v.getBy();
					int alder1 = v.getAlder();
					int alderInt = Integer.parseInt(alder);
					String kjonn1 = v.getKjonn();
					if (by == by1 && alderInt == alder1 && kjonn == kjonn1)
					{
						utskrift.append(v.toString() + "\n");
					}
					else
					{
						utskrift.setText(feilmelding);
					}
				}
				return;

	  		}
	  		if (!by.equals(""))
	  		{
				List<Vikar> byliste = vikar.geografiskSted(by);
				Iterator<Vikar> iterator = byliste.iterator();
				while(iterator.hasNext())
				{
					Vikar v = iterator.next();
					int alder1 = v.getAlder();
					int alderInt = Integer.parseInt(alder);
					String kjonn1 = v.getKjonn();
					if (alderInt == alder1 && kjonn == kjonn1)
					{
						utskrift.append(v.toString() + "\n");
					}
					else
					{
						utskrift.setText(feilmelding);
					}
				}
				return;
			}
			if (!alder.equals(""))
			{
				int aar = Integer.parseInt(alder);
				List<Vikar> alderliste = vikar.sokpaVikaralder(aar);
				Iterator<Vikar> iterator = alderliste.iterator();
				while(iterator.hasNext())
				{
					Vikar v = iterator.next();
					String kjonn1 = v.getKjonn();
					if (kjonn == kjonn1)
					{
						utskrift.append(v.toString() + "\n");
					}
					else
					{
						utskrift.setText(feilmelding);
					}
				}
				return;
			}
			if (!kjonn.equals(""))
			{
				List<Vikar> kjonnliste = vikar.sokpaVikarkjonn(kjonn);
				Iterator<Vikar> iterator = kjonnliste.iterator();
				while(iterator.hasNext())
				{
					Vikar v = iterator.next();
					if (kjonnliste != null)
					{
						utskrift.append(v.toString() + "\n");
					}
					else
					{
						utskrift.setText(feilmelding);
					}
				}
			}

	  }
	  public void fjernVikar()
	  {
			String nummer = idtxt.getText();
			if (nummer == null)
			{
				JOptionPane.showMessageDialog(null, "Du ma fylle inn ID nummer for a slette en vikar!\nDu kan soke opp nummer ved hjelp av navn o.l.");
			}
			else
			{
				Vikar x = vikar.sokpaVikarnr(nummer);
				JOptionPane.showMessageDialog(null, "Vikar " + x.toString() + " har blitt slettet");
				vikar.fjernVikar(nummer);
			}
	  }

	  private class Knappelytter implements ActionListener
	  {
	    public void actionPerformed ( ActionEvent e)
	    {
	      if (e.getSource() == sokVikar)
	      {
	   		sokVikar();
	  	  }
	  	  if (e.getSource() == fjernVikar)
	  	  {
			fjernVikar();
		  }
	 	}
	}
}