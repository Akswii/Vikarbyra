import java.util.*;
import java.io.*;

public class Arbeidsforholdregister implements Serializable
{
	private List<Arbeidsforhold> arbforliste = new LinkedList<>();

	public Vikar sokpaVikar(String id)
	{
		Iterator<Arbeidsforhold> iterator = arbforliste.iterator();

		while(iterator.hasNext())
		{
			Arbeidsforhold a = iterator.next();

			if(a.getVikar().getVikarnr().equals(id))
			{
				return a.getVikar();
			}
		}
		return null;
	}

	public Vikariat sokpaVikariat(String id)
	{
		Iterator<Arbeidsforhold> iterator = arbforliste.iterator();

		while(iterator.hasNext())
		{
			Arbeidsforhold a = iterator.next();

			if(a.getVikariat().getNr().equals(id))
			{
				return a.getVikariat();
			}
		}
		return null;
	}

	public List<Arbeidsforhold> sokpaArbvarighet(int t)
	{
		List<Arbeidsforhold> varighetsliste = new LinkedList<>(); //i denne metoden returnerer vi en liste, slik at vi kan vise alle vikarene som har lik alder.
		Iterator<Arbeidsforhold> iterator = arbforliste.iterator();

		while(iterator.hasNext())
		{
			Arbeidsforhold a = iterator.next();

			if(a.getVikariat().getVarighet() == t)
			{
				varighetsliste.add(a); //returnerer ei vikarliste.
			}
		}

		if(varighetsliste != null)
			return varighetsliste;
		else
			return null;
	}
	
	public Arbeidsforhold sokpaArbeidsforhold(String nr)
	{
		Iterator<Arbeidsforhold> iterator = arbforliste.iterator(); //Mulighet til å soke på forskjellige arbeidsforhold ved hjelp av idnummeret deres.

		while(iterator.hasNext())
		{
			Arbeidsforhold a = iterator.next();
			
			if(a.getRegnr().equals(nr))
			{
				return a; //returnerer arbeidsforholdobjektet som er sokt på.
			}
		}
		return null;
	}

	public List<Arbeidsforhold> sokpaFirma(String f)
	{
		List<Arbeidsforhold> firmaliste = new LinkedList<>(); //i denne metoden returnerer vi en liste, slik at vi kan vise alle vikarene som har lik alder.
		Iterator<Arbeidsforhold> iterator = firmaliste.iterator();

		while(iterator.hasNext())
		{
			Arbeidsforhold a = iterator.next();

			if(a.getVikariat().getFirma().equals(f))
			{
				firmaliste.add(a); //returnerer ei vikarliste.
			}
		}

		if(firmaliste != null)
			return firmaliste;
		else
			return null;
	}

	public void settInnArbeidsforhold(Arbeidsforhold a)
	{
		arbforliste.add(a); //Metode for å legge inn nye arbeidsforhold i listen.
	}

	public boolean fjernArbeidsforhold(String nr)
	{
		Iterator<Arbeidsforhold> iterator = arbforliste.iterator(); //Metode for å fjerne et arbeidsforhold fra listen.
		
		while(iterator.hasNext())
		{
			if(iterator.next().getRegnr().equals(nr))
			{
				iterator.remove();
				return true;
			}
		}
		return false;
	}

	public String toString()
	{
		String utskrift = ""; //toString metode; bruker iterator for å gjennomlope objektene og skoyte de til utskriftsfeltet.
		Iterator<Arbeidsforhold> iterator = arbforliste.iterator(); 

		while(iterator.hasNext())
		{
			utskrift += iterator.next()+"\n";
		}
		return utskrift;
	}
}