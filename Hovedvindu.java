import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Hovedvindu extends JFrame implements Serializable
{
	private DetailsPanel detailsPanel;
	Arbeidsforholdregister afr;
	Arbeidsregister arr;
	Soknadsregister sr;
	Vikariatregister var;
	Vikarregister vikr;

	public Hovedvindu(Arbeidsforholdregister a, Arbeidsregister ar, Soknadsregister s, Vikariatregister v, Vikarregister vik)
	{
		super("Vikarbyraa");
		afr = a;
		arr = ar;
		sr = s;
		var = v;
		vikr = vik;
		lesFil();
		detailsPanel = new DetailsPanel(afr, arr, sr, var, vikr);
		setLayout(new BorderLayout());


		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(detailsPanel, BorderLayout.CENTER);
		//c.add(utskrift, BorderLayout.EAST);

		setSize(500,250);
		setVisible(true);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

	}
	 private void lesFil()
	      {
	       try (ObjectInputStream innfil = new ObjectInputStream(new FileInputStream("arbeidsliste.data")))
	       {
		   		            arr = (Arbeidsregister) innfil.readObject();
		   		            vikr = (Vikarregister) innfil.readObject();
		   		            afr = (Arbeidsforholdregister) innfil.readObject();
		   		            sr = (Soknadsregister) innfil.readObject();
		   		            var = (Vikariatregister) innfil.readObject();
		   		            System.out.println("Kunderegister ble lastet!");
		   		        }
		   		        catch (ClassNotFoundException cnfe)
		   		        {
		   		            arr = new Arbeidsregister();
		   		            vikr = new Vikarregister();
		   		            afr = new Arbeidsforholdregister();
		   		            sr = new Soknadsregister();
		   		            var = new Vikariatregister();

		   		            System.out.println("Nytt kunderegister ble opprettet1!");
		   		        }
		   		        catch (FileNotFoundException fnfe)
		   		        {
							arr = new Arbeidsregister();
							vikr = new Vikarregister();
							afr = new Arbeidsforholdregister();
							sr = new Soknadsregister();
		   		            var = new Vikariatregister();
							System.out.println("Finner ikke filen! nytt register opprettes.");
						}
		   		        catch (IOException ioe)
		   		        {
		   		            arr = new Arbeidsregister();
		   		            vikr = new Vikarregister();
		   		            afr = new Arbeidsforholdregister();
							sr = new Soknadsregister();
		   		            var = new Vikariatregister();
		   		            System.out.println("Nytt kunderegister ble opprettet2!");
		                 }
      }
      public void skrivTilFil()
	   {
	    try ( ObjectOutputStream utfil = new ObjectOutputStream(new FileOutputStream("arbeidsliste.data")))
	    {
	    	  	            utfil.writeObject(arr);
	    	  	            utfil.writeObject(vikr);
	    	  	            utfil.writeObject(afr);
	    	  	            utfil.writeObject(sr);
	    	  	            utfil.writeObject(var);
	    	  	            System.out.println("Kunderegister ble lagret!");
	    	  	            //utskrift.append(arbeidsgiver.toString());
	    	  	        }
	    	  	        catch (NotSerializableException ese)
	    	  	        {
	  					System.out.println("Kunderegister ble ikke lagret!");
	  				}
	    	  	        catch (IOException ioe)
	    	  	        {
	    	  	            System.out.println("Kunderegister ble ikke lagret!");
	    	        }
}
}