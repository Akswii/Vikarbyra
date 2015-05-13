import java.util.*;
import java.io.*;

public class Vikariatregister implements Serializable //Vikariatregister; Serializable for lagring på fil. Her lagres vikariatobjekter.
{
	private List<Vikariat> vikariatliste = new LinkedList<>();

	public Vikariatregister(){};

	public void regVikariat(Vikariat v)
	{
		vikariatliste.add(v); //Metode for å legge inn nye vikariat i listen.
	}

	public List<Vikariat> sokpaVarighet(int va)
	{
		List<Vikariat> varighetsliste = new LinkedList<>(); //i denne metoden returnerer vi en liste, slik at vi kan vise alle vikarene som har lik alder.
		Iterator<Vikariat> iterator = vikariatliste.iterator();

		while(iterator.hasNext())
		{
			Vikariat v = iterator.next();

			if(v.getVarighet() == va)
			{
				varighetsliste.add(v); //returnerer ei vikarliste.
			}
		}

		if(varighetsliste != null)
			return varighetsliste;
		else
			return null;
	}


	public List<Vikariat> sokpaSektor(String s)

	{
		List<Vikariat> sektorliste = new LinkedList<>(); //i denne metoden returnerer vi en liste, slik at vi kan vise alle vikarene som har lik alder.
		Iterator<Vikariat> iterator = vikariatliste.iterator();

		while(iterator.hasNext())
		{
			Vikariat v = iterator.next();

			if(v.getSektor().equals(s))
			{
				sektorliste.add(v); //returnerer ei vikarliste.
			}
		}

		if(sektorliste != null)
			return sektorliste;
		else
			return null;
	}

	public Vikariat sokpaFirma(String f)
	{
		Iterator<Vikariat> iterator = vikariatliste.iterator(); //Mulighet til å soke på forskjellige vikariat ved hjelp av idnummeret deres.

		while(iterator.hasNext())
		{
			Vikariat v = iterator.next();

			if(v.getFirma().equals(f))
			{
				return v; //returnerer vikariatobjektet som er sokt på.
			}
		}
		return null;
	}

	public Vikariat sokpaVikariat(String nr)
	{
		Iterator<Vikariat> iterator = vikariatliste.iterator(); //Mulighet til å soke på forskjellige vikariat ved hjelp av idnummeret deres.

		while(iterator.hasNext())
		{
			Vikariat v = iterator.next();

			if(v.getNr().equals(nr))
			{
				return v; //returnerer vikariatobjektet som er sokt på.
			}
		}
		return null;
	}

	public boolean fjernVikariat(String nr)
	{
		Iterator<Vikariat> iterator = vikariatliste.iterator(); //Metode for å fjerne et vikariat fra listen.

		while(iterator.hasNext())
		{
			if(iterator.next().getNr().equals(nr))
			{
				iterator.remove();
				return true;
			}
		}
		return false;
	}

	public String skrivUtliste(List<Vikariat> l)
	{
		String utskrift = "";
		Iterator<Vikariat> iterator = l.iterator();

		while(iterator.hasNext())
		{
			utskrift += iterator.next()+"\n";
		}
		return utskrift;
	}

	public String toString()
	{
		String utskrift = ""; //toString metode; bruker iterator for å gjennomlope objektene og skoyte de til utskriftsfeltet.
		Iterator<Vikariat> iterator = vikariatliste.iterator();

		while(iterator.hasNext())
		{
			utskrift += iterator.next()+"\n";
		}
		return utskrift;
	}
}