import java.util.*;
import java.io.*;

public class Arbeidsregister implements Serializable //Arbeidsregister; Serializable for lagring på fil. Her lagres arbeidsgiverobjekter.
{
  private List<Arbeidsgiver> arbliste = new LinkedList<>();

  public List<Arbeidsgiver> getArbeidsliste()
  {
    return arbliste;
  }

  public Vikariat sokpaId(String vid)
  {
    Iterator<Arbeidsgiver> iterator = arbliste.iterator();
    while(iterator.hasNext())
    {
      Arbeidsgiver v = iterator.next();
      Vikariatregister vik = v.getVikariat();
      Vikariat vikariat = vik.sokpaVikariat(vid);

      if(vikariat != null)
      {
        if(vikariat.getNr().equals(vid))
          return vikariat;
      }
    }
    return null;
  }

  public List<Arbeidsgiver> sokpaKjonn(String k)
  {
    List<Arbeidsgiver> kjonnliste = new LinkedList<>();
    Iterator<Arbeidsgiver> iterator = arbliste.iterator();

    while(iterator.hasNext())
    {
      Arbeidsgiver v = iterator.next();

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

  public List<Arbeidsgiver> sokpaAdresse(String t)
  {
    List<Arbeidsgiver> adresseliste = new LinkedList<>(); //i denne metoden returnerer vi en liste, slik at vi kan vise alle vikarene som har lik alder.
    Iterator<Arbeidsgiver> iterator = arbliste.iterator();

    while(iterator.hasNext())
    {
      Arbeidsgiver v = iterator.next();

      if(v.getAdresse().equals(t))
      {
        adresseliste.add(v); //returnerer ei vikarliste.
      }
    }

    if(adresseliste != null)
      return adresseliste;
    else
      return null;

  }

  public List<Arbeidsgiver> sokpaArbfornavn(String fn)
  {
    List<Arbeidsgiver> arbeidsgiverliste = new LinkedList<>(); //i denne metoden returnerer vi en liste, slik at vi kan vise alle vikarene som har lik alder.
    Iterator<Arbeidsgiver> iterator = arbliste.iterator();

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

    if(etternavnliste != null)
     return etternavnliste;
    else
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

  public List<Arbeidsgiver> sokpaAlder(int a)
  {
    List<Arbeidsgiver> alderliste = new LinkedList<>(); //i denne metoden returnerer vi en liste, slik at vi kan vise alle vikarene som har lik alder.
    Iterator<Arbeidsgiver> iterator = arbliste.iterator();

    while(iterator.hasNext())
    {
      Arbeidsgiver v = iterator.next();

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

  public List<Arbeidsgiver> sokpaMobil(int t)
  {
    List<Arbeidsgiver> tlfliste = new LinkedList<>(); //i denne metoden returnerer vi en liste, slik at vi kan vise alle vikarene som har lik alder.
    Iterator<Arbeidsgiver> iterator = arbliste.iterator();

    while(iterator.hasNext())
    {
      Arbeidsgiver v = iterator.next();

      if(v.getTelefon() == t)
      {
        tlfliste.add(v); //returnerer ei vikarliste.
      }
    }

    if(tlfliste != null)
      return tlfliste;
    else
      return null;
  }

  public Arbeidsgiver sokpaEpost(String e)
  {
    Iterator<Arbeidsgiver> iterator = arbliste.iterator(); //Mulighet til å soke på forskjellige Arbeidsgiver ved hjelp av idnummeret deres.

    while(iterator.hasNext())
    {
      Arbeidsgiver a = iterator.next();

      if(a.getEpost().equals(e))
      {
        return a; //returnerer Arbeidsgiverobjektet som er sokt på.
      }
    }
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

  public String idOgnavn()
  {
    String utskrift = ""; //toString metode; bruker iterator for å gjennomlope objektene og skoyte de til utskriftsfeltet.
    Iterator<Arbeidsgiver> iterator = arbliste.iterator();

    while(iterator.hasNext())
    {
      utskrift += iterator.next().toString2()+"\n";
    }
    return utskrift;
  }

  public String vikariater(Arbeidsgiver a)
  {
    String utskrift = "";

    Vikariatregister v = a.getVikariat();

    utskrift = v.toString();
    return utskrift;
  }

  public String skrivutVikariater()
  {
    String utskrift = "";
    Iterator<Arbeidsgiver> iterator = arbliste.iterator();

    while(iterator.hasNext())
    {
      Arbeidsgiver arb = iterator.next();

      utskrift += arb.getVikariat().toString()+"\n";
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