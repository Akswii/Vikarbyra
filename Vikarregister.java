import java.util.*;
import java.io.*;

public class Vikarregister implements Serializable //Vikarregister; Serializable for lagring på fil. Her lagres vikarobjekter.
{
	private List<Vikar> vikarliste = new LinkedList<>();

	public Vikarregister(){};

	public List<Vikar> sokpaVikarlonn(int l)
	{
		List<Vikar> lonnliste = new LinkedList<>(); //i denne metoden returnerer vi en liste, slik at vi kan vise alle vikarene som har lik alder.
		Iterator<Vikar> iterator = vikarliste.iterator();

		while(iterator.hasNext())
		{
			Vikar v = iterator.next();

			if(v.getLonn() == l)
			{
				lonnliste.add(v); //returnerer ei vikarliste.
			}
		}

		if(lonnliste != null)
			return lonnliste;
		else
			return null;
	}



	public List<Vikar> sokpaVikarkategori(String k)
	{
		List<Vikar> kategoriliste = new LinkedList<>(); //i denne metoden returnerer vi en liste, slik at vi kan vise alle vikarene som har lik alder.
		Iterator<Vikar> iterator = vikarliste.iterator();

		while(iterator.hasNext())
		{
			Vikar v = iterator.next();

			if(v.getKategori().equals(k))
			{
				kategoriliste.add(v); //returnerer ei vikarliste.
			}
		}

		if(kategoriliste != null)
			return kategoriliste;
		else
			return null;
	}

	public List<Vikar> sokpaVikartlf(int t)
	{
		List<Vikar> tlfliste = new LinkedList<>(); //i denne metoden returnerer vi en liste, slik at vi kan vise alle vikarene som har lik alder.
		Iterator<Vikar> iterator = vikarliste.iterator();

		while(iterator.hasNext())
		{
			Vikar v = iterator.next();

			if(v.getTlf() == t)
			{
				tlfliste.add(v); //returnerer ei vikarliste.
			}
		}

		if(tlfliste != null)
			return tlfliste;
		else
			return null;

	}

	public Vikar sokpaVikarepost(String e)
	{
		Iterator<Vikar> iterator = vikarliste.iterator(); //Mulighet til å soke på forskjellige vikarer ved hjelp av idnummeret deres.

		while(iterator.hasNext())
		{
			Vikar v = iterator.next();

			if(v.getEpost().equals(e))
			{
				return v; //returnerer vikarobjektet som er sokt på.
			}
		}
		return null;
	}

	public List<Vikar> sokpaVikaralder(int a)
	{
		List<Vikar> alderliste = new LinkedList<>(); //i denne metoden returnerer vi en liste, slik at vi kan vise alle vikarene som har lik alder.
		Iterator<Vikar> iterator = vikarliste.iterator();

		while(iterator.hasNext())
		{
			Vikar v = iterator.next();

			if(v.getAlder() == (a))
			{
				alderliste.add(v); //returnerer ei vikarliste.
			}
		}

		if(alderliste != null)
			return alderliste;
		else
			return null;
	}

	public List<Vikar> sokpaVikarkjonn(String k)
	{
		List<Vikar> kjonnliste = new LinkedList<>();
		Iterator<Vikar> iterator = vikarliste.iterator();

		while(iterator.hasNext())
		{
			Vikar v = iterator.next();

			if(v.getKjonn().equals(k))
			{
				kjonnliste.add(v);
			}
		}

		if(kjonnliste != null)
			return kjonnliste;
		else
			return null;
	}


	public List<Vikar> sokpaVikarfornavn(String fn)
	 {
	  List<Vikar> fornavnliste = new LinkedList<>();
	  Iterator<Vikar> iterator = vikarliste.iterator();

	  while(iterator.hasNext())
	  {
	   Vikar v = iterator.next();

	   if(v.getFornavn().equals(fn))
	   {
	    fornavnliste.add(v);
	   }
	  }

	  if(fornavnliste != null)
	   return fornavnliste;
	  else
	   return null;
	 }

	 public List<Vikar> sokpaVikaretternavn(String en)
	 {
	  List<Vikar> etternavnliste = new LinkedList<>();
	  Iterator<Vikar> iterator = vikarliste.iterator();

	  while(iterator.hasNext())
	  {
	   Vikar v = iterator.next();

	   if(v.getEtternavn().equals(en))
	   {
	    etternavnliste.add(v);
	   }
	  }

	  if(etternavnliste != null)
	   return etternavnliste;
	  else
	   return null;
 	}

	public Vikar sokpaVikarnr(String nr)
	{
		Iterator<Vikar> iterator = vikarliste.iterator();

		while(iterator.hasNext())
		{
			Vikar v = iterator.next();

			if(v.getVikarnr().equals(nr))
			{
				return v;
			}
		}
		return null;
	}

	public void settInnVikar(Vikar v)
	{
		vikarliste.add(v); //Metode for å legge inn nye vikarer i listen.
	}

	public boolean fjernVikar(String nr)
	{
		Iterator<Vikar> iterator = vikarliste.iterator(); //Metode for å fjerne en vikar fra listen.

		while(iterator.hasNext())
		{
			if(iterator.next().getVikarnr().equals(nr))
			{
				iterator.remove();
				return true;
			}
		}
		return false;
	}

	public List<Vikar> geografiskSted(String by)
	{
		List<Vikar> geografiliste = new LinkedList<>(); //i denne metoden returnerer vi en liste, slik at vi kan vise alle vikarene som har lik alder.
		Iterator<Vikar> iterator = vikarliste.iterator();

		while(iterator.hasNext())
		{
			Vikar v = iterator.next();

			if(v.getBy().equals(by))
			{
				geografiliste.add(v); //returnerer ei vikarliste.
			}
		}

		if(geografiliste != null)
			return geografiliste;
		else
			return null;
	}

	public String skrivUtliste(List<Vikar> l)
	{
		String utskrift = "";
		Iterator<Vikar> iterator = l.iterator();

		while(iterator.hasNext())
		{
			utskrift += iterator.next()+"\n";
		}
		return utskrift;
	}

	public String idOgnavn()
	{
		String utskrift = ""; //toString metode; bruker iterator for å gjennomlope objektene og skoyte de til utskriftsfeltet.
		Iterator<Vikar> iterator = vikarliste.iterator();

		while(iterator.hasNext())
		{
			utskrift += iterator.next().toString2()+"\n";
		}
		return utskrift;
	}

	public String toString()
	{
		String utskrift = ""; //toString metode; bruker iterator for å gjennomlope objektene og skoyte de til utskriftsfeltet.
		Iterator<Vikar> iterator = vikarliste.iterator();

		while(iterator.hasNext())
		{
			utskrift += iterator.next()+"\n";
		}
		return utskrift;
	}
}