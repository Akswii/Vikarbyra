public class Arbeidsgiver extends Person //Extends person for å få datafeltene fra den klassen.
{
	private String sektor, epost, adresse, by, nr, firma;
	private int telefon;
	private static int MEDNR = 1000;


	public Arbeidsgiver(String f, String e, String k, int al, String by, String s, String fi, String ep, String ad, int tlf)
	{
		super(f, e, k, al, by);
		sektor = s;
		firma = fi;
		epost = ep;
		adresse = ad;
		telefon = tlf;
		nr = Integer.toString(MEDNR++) + "A"; //Unikt vikariatnummer med "A" som identifikator.
	}
	
	public String getNr()
	{
		return nr;
	}

	public String getFirma()
	{
		return firma;
	}

	public String getSektor()
	{
		return sektor;
	}

	public String getEpost()
	{
		return epost;
	}

	public String getAdresse()
	{
		return adresse;
	}

	public int getTelefon()
	{
		return telefon;
	}

	public void setEpost(String e)
	{
		epost = e;
	}

	public void setTlf(int t)
	{
		telefon = t;
	}

	public String toString()
	{
		return super.toString() + "\nsektor: " + sektor + "\tEpost: " + epost + "\nAdresse: " + adresse + "\tTelefon: " + telefon;
	}
}