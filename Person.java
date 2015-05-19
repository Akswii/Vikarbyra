import java.io.*;

public class Person implements Serializable//Personklassen, denne blir extended i vikar og arbeidsgiver
					//inneholder informasjon som er felles for alle personer.
{
	private String fornavn, etternavn, kjonn, by;
	private int alder;

	public Person(String f, String e, String k, int a, String b)
	{
		fornavn = f;
		etternavn = e;
		kjonn = k;
		alder = a;
		by = b;
	}

	public String getFornavn()
	{
		return fornavn;
	}

	public String getEtternavn()
	{
		return etternavn;
	}

	public String getKjonn()
	{
		return kjonn;
	}

	public int getAlder()
	{
		return alder;
	}

	public void setEtternavn(String e)
	{
		etternavn = e;
	}

	public void setAlder(int a)
	{
		alder = a;
	}

	public String getBy()
	{
		return by;
	}

	public String toString2()
	{
		return "Fornavn: " + fornavn + "   Etternavn: " + etternavn + "\n";
	}

	public String toString()
	{
		return "Fornavn: " + fornavn + "   Etternavn: " + etternavn + "\nKjonn: " + kjonn + "\tAlder: " + alder;
	}
}