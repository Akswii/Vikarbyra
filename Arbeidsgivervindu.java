import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Iterator;
import java.io.*;

public class Arbeidsgivervindu extends JFrame implements Serializable
{
 private JButton nyArbeidsgiver, sokArbeidsgiver, visArbeidsgiver;
 private JTextField fornavntxt, etternavntxt, firmatxt, adressetxt, bransjetxt, tlftxt, eposttxt, bytxt, nrtxt, kjonntxt, aldertxt;
 private JTextArea utskrift;
 private Arbeidsregister arbeidsgiver;

 public Arbeidsgivervindu(Arbeidsregister a)
 {
  super("Arbeidsgivervindu");
  Knappelytter lytter = new Knappelytter();
  utskrift = new JTextArea(10,10);
  utskrift.setEditable(false);

  arbeidsgiver = a;

   nyArbeidsgiver = new JButton("Ny Arbeidsgiver");
   sokArbeidsgiver = new JButton("Sok Arbeidsgiver");
   visArbeidsgiver = new JButton("Vis alle Arbeidsgivere");

   fornavntxt = new JTextField(6);
   etternavntxt = new JTextField(6);
   firmatxt = new JTextField(6);
   adressetxt = new JTextField(6);
   bransjetxt = new JTextField(6);
   tlftxt = new JTextField(6);
   eposttxt = new JTextField(6);
   bytxt = new JTextField(6);
   nrtxt = new JTextField(6);
   kjonntxt = new JTextField(6);
   aldertxt = new JTextField(6);

   nyArbeidsgiver.addActionListener(lytter);
   sokArbeidsgiver.addActionListener(lytter);
   visArbeidsgiver.addActionListener(lytter);

   Container c = getContentPane();
   c.setLayout(new FlowLayout());

   c.add(new JLabel("Fornavn: "));
   c.add(fornavntxt);
   c.add(new JLabel("Etternavn: "));
   c.add(etternavntxt);
   c.add(new JLabel("Firma: "));
   c.add(firmatxt);
   c.add(new JLabel("Adresse: "));
   c.add(adressetxt);
   c.add(new JLabel("By: "));
   c.add(bytxt);
   c.add(new JLabel("Bransje: "));
   c.add(bransjetxt);
   c.add(new JLabel("Tlf: "));
   c.add(tlftxt);
   c.add(new JLabel("Epost: "));
   c.add(eposttxt);
   c.add(new JLabel("id: "));
   c.add(nrtxt);
   c.add(new JLabel("Kjonn: "));
   c.add(kjonntxt);
   c.add(new JLabel("Alder: "));
   c.add(aldertxt);


   c.add(visArbeidsgiver);
   c.add(sokArbeidsgiver);
   c.add(nyArbeidsgiver);
   c.add(utskrift);


   setSize(500,500);
 setVisible(true);

 }
 private void lesFil()
     {
      try(ObjectInputStream innfil = new ObjectInputStream(new FileInputStream( "arbeidsgiverliste.data" )))
      {
       arbeidsgiver = (Arbeidsregister) innfil.readObject();
      }
      catch(ClassNotFoundException cnfe)
      {
       utskrift.setText(cnfe.getMessage());
       utskrift.append("\nOppretter tom liste.\n");
       arbeidsgiver = new Arbeidsregister();
      }
      catch(FileNotFoundException fne)
      {
       utskrift.setText("Finner ikke datafil. Oppretter tom liste.\n");
           arbeidsgiver = new Arbeidsregister();
        }
        catch(IOException ioe)
        {
           utskrift.setText("Innlesingsfeil. Oppretter tom liste.\n");
           arbeidsgiver = new Arbeidsregister();
        }
     }

     public void skrivTilFil()
    {
    try (ObjectOutputStream utfil = new ObjectOutputStream(new FileOutputStream("arbeidsgiverliste.data")))
    {
          utfil.writeObject(arbeidsgiver);
    }
       catch( NotSerializableException nse )
       {
          JOptionPane.showMessageDialog(this,"Objektet er ikke serialisert!");
       }
       catch( IOException ioe )
       {
          JOptionPane.showMessageDialog(this,"Problem med utskrift til fil.");
       }
  }
 public void nyArbeidsgiver()
  {
   /* if( Eposten eksisterer i systemet)
      {  ikke la personen registrere seg }
     feilmelding og be personen velge ny epost

  else { */
    if (!fornavntxt.getText().equals("") && !etternavntxt.getText().equals("") && !firmatxt.getText().equals("") && !adressetxt.getText().equals("")
      && !bransjetxt.getText().equals("") && !tlftxt.getText().equals("") && !eposttxt.getText().equals("") &&
     	!kjonntxt.getText().equals("") && !aldertxt.getText().equals(""))
      {
     String fornavn = fornavntxt.getText();
     String etternavn = etternavntxt.getText();
     String firma = firmatxt.getText();
     String adresse = adressetxt.getText();
     String bransje = bransjetxt.getText();
     int tlf = Integer.parseInt(tlftxt.getText());
     String epost = eposttxt.getText(); // Kontroll pa at eposten ikke eksisterer
     String nr = nrtxt.getText();
     String kjonn = kjonntxt.getText();
     int alder = Integer.parseInt(aldertxt.getText());
     String by = bytxt.getText();

     Arbeidsgiver a = new Arbeidsgiver(fornavn, etternavn, kjonn, alder, by, bransje, firma, epost, adresse, tlf);
     arbeidsgiver.settInnArbeidsgiver(a);

     utskrift.append( "Arbeidsgiver: " + fornavn + " " + etternavn + "med id: " +  a.getNr() + " har blitt lagt inn i systemet!\n\n");
    }
    else
    {
     JOptionPane.showMessageDialog(null, "Mangler informasjon om arbeidsgiveren! Fyll inn alle feltene!");
    }
    // }
  }

   public void sokArbeidsgiver()
   {
	   String fornavn = fornavntxt.getText();
	   String etternavn = etternavntxt.getText();
	   String firma = firmatxt.getText();
	   String adresse = adressetxt.getText();
	   String bransje = bransjetxt.getText();
	   int tlf = Integer.parseInt(tlftxt.getText());
	   String epost = eposttxt.getText(); // Kontroll pa at eposten ikke eksisterer
	   String nr = nrtxt.getText();
	   String kjonn = kjonntxt.getText();
	   int alder = Integer.parseInt(aldertxt.getText());
       String by = bytxt.getText();
	   String feilmelding = "Det finnes ingen vikarer som passer til disse opplysningene";

	   utskrift.setText("");

	   if (fornavntxt.getText().equals("") && etternavntxt.getText().equals("") && firmatxt.getText().equals("") && adressetxt.getText().equals("")
	         && bransjetxt.getText().equals("") && tlftxt.getText().equals("") && eposttxt.getText().equals("") &&
	         nrtxt.getText().equals("") && kjonntxt.getText().equals("") && aldertxt.getText().equals(""))
	   {
	  		utskrift.setText("Du ma fylle inn minst ett felt");
	   		return;
	   }

	   if (!nr.equals(""))
	   {
	   	String sokarbeidsgiver = "";
	   	Arbeidsgiver test = arbeidsgiver.sokpaArbeidsgiver(nr);
		if(test != null)
		{
			sokarbeidsgiver = "" + test;

	   	if (sokarbeidsgiver != "")
	   	{
	   		utskrift.setText(sokarbeidsgiver + "\nnr funka");
	   	}
	   	else
	   	{
	   		utskrift.setText(feilmelding);
	   	}
		}
		return;
	   }

	   if (!fornavn.equals(""))
	   	{
	   		List<Arbeidsgiver> fornavnliste = arbeidsgiver.sokpaArbfornavn(fornavn);
	   		Iterator<Arbeidsgiver> iterator = fornavnliste.iterator();
	   		while(iterator.hasNext())
	   		{
	   			Arbeidsgiver v = iterator.next();
	   			String by1 = v.getBy();
	   			String epost1 = v.getEpost();
	   			if (by == by1 && epost == epost1)
	   			{
	   				utskrift.append(v.toString() + "\nfornavn funka");
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
	   			List<Arbeidsgiver> etternavnliste = arbeidsgiver.sokpaArbetternavn(etternavn);
	   			Iterator<Arbeidsgiver> iterator = etternavnliste.iterator();
	   			while(iterator.hasNext())
	   			{
	   				Arbeidsgiver v = iterator.next();
	   				String by1 = v.getBy();
	   				String epost1 = v.getEpost();
	   				if (by == by1 && epost == epost1)
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
	   			List<Arbeidsgiver> byliste = arbeidsgiver.sokpaBy(by);
	   			Iterator<Arbeidsgiver> iterator = byliste.iterator();
	   			while(iterator.hasNext())
	   			{
	   				Arbeidsgiver v = iterator.next();
	   				String adresse1 = v.getAdresse();
	   				String epost1 = v.getEpost();
	   				if (adresse == adresse1 && epost == epost1)
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

	if (!firma.equals(""))
	{
		String sokFirma = "";
		Arbeidsgiver test = arbeidsgiver.sokpaFirma(firma);
		if(test != null)
		{
			sokFirma = "" + test;

		   	if (sokFirma != "")
		   	{
		   		utskrift.setText(sokFirma);
		   	}
		 	else
		   	{
		   		utskrift.setText(feilmelding);
		   	}
		}
		   	return;
	}

	if (!bransje.equals(""))
	{
		List<Arbeidsgiver> bransjeliste = arbeidsgiver.sokpaSektor(bransje);
		Iterator<Arbeidsgiver> iterator = bransjeliste.iterator();
		while(iterator.hasNext())
		{
			Arbeidsgiver v = iterator.next();
		  	String adresse1 = v.getAdresse();
		  	String epost1 = v.getEpost();
		   	if (adresse == adresse1 && epost == epost1)
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
		List<Arbeidsgiver> kjonnliste = arbeidsgiver.sokpaKjonn(kjonn);
		Iterator<Arbeidsgiver> iterator = kjonnliste.iterator();
		while(iterator.hasNext())
		{
			Arbeidsgiver v = iterator.next();
		 	String adresse1 = v.getAdresse();
		   	String epost1 = v.getEpost();
		   	if (adresse == adresse1 && epost == epost1)
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

	if (!aldertxt.getText().equals(""))
	{
		 List<Arbeidsgiver> alderliste = arbeidsgiver.sokpaAlder(alder);
		 Iterator<Arbeidsgiver> iterator = alderliste.iterator();
		 while(iterator.hasNext())
		 {
		  	Arbeidsgiver v = iterator.next();
		   	String adresse1 = v.getAdresse();
		   	String epost1 = v.getEpost();
		   	if (adresse == adresse1 && epost == epost1)
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

	if (!adresse.equals(""))
	{
		List<Arbeidsgiver> adresseliste = arbeidsgiver.sokpaAdresse(adresse);
		Iterator<Arbeidsgiver> iterator = adresseliste.iterator();
		while(iterator.hasNext())
		{
		 	Arbeidsgiver v = iterator.next();
		  	String by1 = v.getBy();
		  	String epost1 = v.getEpost();
		  	if (by == by1 && epost == epost1)
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

	if (!epost.equals(""))
	{
		String sokEpost = "";
		Arbeidsgiver test = arbeidsgiver.sokpaEpost(epost);
		if(test != null)
		{
			sokEpost = "" + test;

		if (sokEpost != "")
		{
			utskrift.setText(sokEpost);
		}
		else
		{
			utskrift.setText(feilmelding);
		}
		}
		return;
	}

	if (!tlftxt.getText().equals("") )
		{
			 List<Arbeidsgiver> tlfliste = arbeidsgiver.sokpaMobil(tlf);
			 Iterator<Arbeidsgiver> iterator = tlfliste.iterator();
			 while(iterator.hasNext())
			 {
			  	Arbeidsgiver v = iterator.next();
			   	String adresse1 = v.getAdresse();
			   	String epost1 = v.getEpost();
			   	if (adresse == adresse1 && epost == epost1)
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

    /*String fornavn = fornavntxt.getText();
    String etternavn = etternavntxt.getText();

    if (!fornavn.equals("") && !etternavn.equals(""))
    {
     List<Arbeidsgiver> navn = arbeidsgiver.sokpaArbeidsgiver(fornavn, etternavn);
     utskrift.setText("Resultat: \n" + navn.toString());
    }*/
   //Arbeidsregister arbeid = new Arbeidsregister();
   //Arbeidsgiver a = arbeid.sokpaBransje(bransjetxt.getText());
   //utskrift.setText("Resultat: \n" + a.toString());*/

   }
   public void arbeidsgiverListe()
 {
   //Metode som vier en liste over arbeidsgiverne vare
   utskrift.setText("Her er arbeidsgiver lista var\n" + arbeidsgiver.toString());
 }

 private class Knappelytter implements ActionListener
 {
  public void actionPerformed ( ActionEvent e)
  {
   if (e.getSource() == nyArbeidsgiver)
   {
    nyArbeidsgiver();
   }
   if (e.getSource() == sokArbeidsgiver)
   {
       sokArbeidsgiver();
     }
     if (e.getSource() == visArbeidsgiver)
   {
    arbeidsgiverListe();
     }
  }
 }

}