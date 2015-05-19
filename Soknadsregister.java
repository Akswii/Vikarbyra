import java.util.*;
import java.io.*;

public class Soknadsregister implements Serializable //Soknadsregister; Serializable for lagring på fil. Her lagres soknadsobjekter.
{
	private List<Soknad> soknadsliste = new LinkedList<>(); //Linkedlist av type soknad for rask gjennomloping av lagrede objekter.
	private final static long serialversionUID = 127L;

	public Soknadsregister(){};

	public Soknad sokpaSoknad(String nr)
	{
		Iterator<Soknad> iterator = soknadsliste.iterator(); //Mulighet til å soke på forskjellige soknader ved hjelp av idnummeret deres.

		while(iterator.hasNext())
		{
			Soknad s = iterator.next();

			if(s.getSoknadsnr().equals(nr))
			{
				return s; //returnerer soknadsobjektet som er sokt på.
			}
		}
		return null;
	}

	public void settInnSoknad(Soknad s)
	{
		soknadsliste.add(s); //Metode for å legge inn nye soknader i listen.
	}

	public boolean fjernSoknad(String nr)
	{
		Iterator<Soknad> iterator = soknadsliste.iterator(); //Metode for å fjerne en soknad fra listen.

		while(iterator.hasNext())
		{
			if(iterator.next().getSoknadsnr().equals(nr))
			{
				iterator.remove();
				return true; //true om fjerningen gjennomfores.
			}
		}
		return false; //false om det ikke gar.
	}

	public String toString()
	{
		String utskrift = ""; //toString metode; bruker iterator for å gjennomlope objektene og skoyte de til utskriftsfeltet.
		Iterator<Soknad> iterator = soknadsliste.iterator();

		while(iterator.hasNext())
		{
			utskrift += iterator.next()+"\n";
		}
		return utskrift;//Returnerer utskrift uansett.
	}
}