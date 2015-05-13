import java.util.*;
import java.io.*;

public class Arbeidsregister implements Serializable //Arbeidsregister; Serializable for lagring på fil. Her lagres arbeidsgiverobjekter.
{
  private List<Arbeidsgiver> arbliste = new LinkedList<>();
  
  public Arbeidsregister(){};

  public List<Arbeidsgiver> sokpaSektor(String b)
  {
    List<Arbeidsgiver> sektorliste = new LinkedList<>();
    Iterator<Arbeidsgiver> iterator = arbliste.iterator(); //Mulighet til å soke på forskjellige vikariat ved hjelp av idnummeret deres.

    while(iterator.hasNext())
    {
      Arbeidsgiver a = iterator.next();
      
      if(a.getSektor().equals(b))
      {
        sektorliste.add(a); //returnerer ei vikarliste.
      }
    }

    if(sektorliste != null)
      return sektorliste;
    else
      return null;
  }

  public List<Arbeidsgiver> sokpaBy(String b)
  {
    List<Arbeidsgiver> geografiliste = new LinkedList<>(); //i denne metoden returnerer vi en liste, slik at vi kan vise alle vikarene som har lik alder.
    Iterator<Arbeidsgiver> iterator = arbliste.iterator(); 

    while(iterator.hasNext())
    {
      Arbeidsgiver a = iterator.next();
      
      if(a.getBy().equals(b))
      {
        geografiliste.add(a); //returnerer ei vikarliste.
      }
    }

    if(geografiliste != null)
      return geografiliste;
    else
      return null;
  }

  public Arbeidsgiver sokpaFirma(String f)
  {
    Iterator<Arbeidsgiver> iterator = arbliste.iterator(); //Mulighet til å soke på forskjellige Arbeidsgiver ved hjelp av idnummeret deres.

    while(iterator.hasNext())
    {
      Arbeidsgiver a = iterator.next();
      
      if(a.getFirma().equals(f))
      {
        return a; //returnerer Arbeidsgiverobjektet som er sokt på.
      }
    }
    return null;
  }
  
  public Arbeidsgiver sokpaArbeidsgiver(String nr)
  {
    Iterator<Arbeidsgiver> iterator = arbliste.iterator(); //Mulighet til å soke på forskjellige Arbeidsgiver ved hjelp av idnummeret deres.
    while(iterator.hasNext())
    {
      Arbeidsgiver v = iterator.next();
      
      if(v.getNr().equals(nr))
        return v; //returnerer arbeidsgiverobjektet som er sokt på.
    }
    return null;
  }

  public List<Arbeidsgiver> sokpaArbfornavn(String fn)
  {
    List<Arbeidsgiver> arbeidsgiverliste = new LinkedList<>(); //i denne metoden returnerer vi en liste, slik at vi kan vise alle vikarene som har lik alder.
    Iterator<Arbeidsgiver> iterator = arbeidsgiverliste.iterator(); 

    while(iterator.hasNext())
    {
      Arbeidsgiver a = iterator.next();
      
      if(a.getFornavn().equals(fn))
      {
        arbeidsgiverliste.add(a); //returnerer ei vikarliste.
      }
    }

    if(arbeidsgiverliste != null)
      return arbeidsgiverliste;
    else
      return null;
  }

  public List<Arbeidsgiver> sokpaArbetternavn(String en)
   {
    List<Arbeidsgiver> etternavnliste = new LinkedList<>();
    Iterator<Arbeidsgiver> iterator = arbliste.iterator();

    while(iterator.hasNext())
    {
     Arbeidsgiver v = iterator.next();

     if(v.getEtternavn().equals(en))
     {
      etternavnliste.add(v);
     }
    }

    if(arbliste != null)
     return arbliste;
    else
     return null;
  }

  public void settInnArbeidsgiver(Arbeidsgiver v)
  {
    arbliste.add(v); //Metode for å legge inn nye arbeidsgivere i listen.
  }

  public boolean fjernArbeidsgiver(String nr)
  {
    Iterator<Arbeidsgiver> iterator = arbliste.iterator(); //Metode for å fjerne en arbeidsgiver fra listen.

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

  public String skrivUtliste(List<Arbeidsgiver> l)
  {
    String utskrift = "";
    Iterator<Arbeidsgiver> iterator = l.iterator(); 

    while(iterator.hasNext())
    {
      utskrift += iterator.next()+"\n";
    }
    return utskrift;
  }

  public String toString()
  {
    String utskrift = ""; //toString metode; bruker iterator for å gjennomlope objektene og skoyte de til utskriftsfeltet.
    Iterator<Arbeidsgiver> iterator = arbliste.iterator();

    while(iterator.hasNext())
    {
    utskrift += iterator.next()+"\n";
    }
    return utskrift;
  }
}