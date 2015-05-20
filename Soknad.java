import java.io.*;

public class Soknad implements Serializable//Soknadsklassen; vikarene vil sende soknader til forskjellige vikariat. Her lagres info om soknaden.
{
	private Vikar vikar;
	private Vikariat jobbsoker;
	private String nummer;
	private static int REGNR = 1000;

	public Soknad(Vikar v, Vikariat j)
 	{
  		vikar = v;
  		jobbsoker = j;
  		nummer = Integer.toString(REGNR++) + "C"; //Unikt vikariatnummer med "C" som identifikator.
 	}

 	public String getSoknadsnr()
 	{
 		return nummer;
 	}

 	public Vikar getVikar()
 	{
  		return vikar;
 	}

 	public Vikariat getVikariat()
 	{
  		return jobbsoker;
 	}

 	public String toString()
 	{
  		return "Søker: " + vikar.toString2() + "\n" + "Jobb: " + jobbsoker.toString2();
 	}
}