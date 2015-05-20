import java.util.*;
import java.io.*;

public class Vikariatregister implements Serializable //Vikariatregister; Serializable for lagring på fil. Her lagres vikariatobjekter.
{
	private List<Vikariat> vikariatliste = new LinkedList<>();
	private final static long serialversionUID = 126L;

	public Vikariatregister(){};

	public List<Vikariat> getList()
	{
		return vikariatliste;
	}

	public void regVikariat(Vikariat v)
	{
		vikariatliste.add(v); //Metode for å legge inn nye vikariat i listen.
	}

	public String skrivUtsoknad()
	{
		String utskrift = "";
		Iterator<Vikariat> iterator = vikariatliste.iterator();

		while(iterator.hasNext())
		{
			Vikariat vik = iterator.next();
			Soknadsregister test = vik.getSok();
			
			utskrift += test.toString()+"\n";
		}
		return utskrift;
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
	public List<Vikariat> sokpaArbeidstid(int a)
		{
			List<Vikariat> arbeidstidliste = new LinkedList<>(); //i denne metoden returnerer vi en liste, slik at vi kan vise alle vikarene som har lik alder.
			Iterator<Vikariat> iterator = vikariatliste.iterator();

			while(iterator.hasNext())
			{
				Vikariat v = iterator.next();

				if(v.getVarighet() == a)
				{
					arbeidstidliste.add(v); //returnerer ei vikarliste.
				}
			}

			if(arbeidstidliste != null)
				return arbeidstidliste;
			else
				return null;
	}

	public List<Vikariat> sokpaStilling(String s)
	{
		List<Vikariat> stillingsliste = new LinkedList<>(); //i denne metoden returnerer vi en liste, slik at vi kan vise alle vikarene som har lik alder.
		Iterator<Vikariat> iterator = vikariatliste.iterator();

		while(iterator.hasNext())
		{
			Vikariat v = iterator.next();

			if(v.getStilling().equals(s))
			{
				stillingsliste.add(v); //returnerer ei vikarliste.
			}
		}

		if(stillingsliste != null)
			return stillingsliste;
		else
			return null;
	}


	public List<Vikariat> sokpaSektor(String s)

	{
		List<Vikariat> sektorliste = new LinkedList<>();
		Iterator<Vikariat> iterator = vikariatliste.iterator();

		while(iterator.hasNext())
		{
			Vikariat v = iterator.next();

			if(v.getSektor().equals(s))
			{
				sektorliste.add(v);
			}
		}

		if(sektorliste != null)
			return sektorliste;
		else
			return null;
	}
	public List<Vikariat> sokpaLonn(String l)

		{
			List<Vikariat> lonnliste = new LinkedList<>();
			Iterator<Vikariat> iterator = vikariatliste.iterator();

			while(iterator.hasNext())
			{
				Vikariat v = iterator.next();

				if(v.getLonn().equals(l))
				{
					lonnliste.add(v);
				}
			}

			if(lonnliste != null)
				return lonnliste;
			else
				return null;
	}

	public List<Vikariat> sokpaFirma(String f)
	{
		List<Vikariat> firmaliste = new LinkedList<>();
		Iterator<Vikariat> iterator = vikariatliste.iterator();

		while(iterator.hasNext())
		{
			Vikariat v = iterator.next();

			if(v.getFirma().equals(f))
			{
				firmaliste.add(v);
			}
		}

		if(firmaliste != null)
			return firmaliste;
		else
			return null;
	}

	public List<Vikariat> sokpaArbsted(String a)
	{
		List<Vikariat> stedsliste = new LinkedList<>();
		Iterator<Vikariat> iterator = vikariatliste.iterator();

		while(iterator.hasNext())
		{
			Vikariat v = iterator.next();

			if(v.getArbsted().equals(a))
			{
				stedsliste.add(v);
			}
		}

		if(stedsliste != null)
			return stedsliste;
		else
			return null;
	}

	public Vikariat sokpaVikariat(String nr)
	{
		Iterator<Vikariat> iterator = vikariatliste.iterator();

		while(iterator.hasNext())
		{
			Vikariat v = iterator.next();

			if(v.getNr().equals(nr))
			{
				return v;
			}
		}
		return null;
	}

	public boolean fjernVikariat(String nr)
	{
		Iterator<Vikariat> iterator = vikariatliste.iterator();

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

	public String idogNavn()
	{
		String utskrift = "";
		Iterator<Vikariat> iterator = vikariatliste.iterator();

		while(iterator.hasNext())
		{
			Vikariat vik = iterator.next();
			utskrift += vik+"\n";
		}
		return utskrift;
	}

	public String toString()
	{
		String utskrift = "";
		Iterator<Vikariat> iterator = vikariatliste.iterator();

		while(iterator.hasNext())
		{
			utskrift += iterator.next()+"\n";
		}
		return utskrift;
	}
}