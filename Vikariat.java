public class Vikariat //Vikariatklassen; dette er arbeidsplassene som vikarene vil soke på, og arbeidsgiverene vil legge ut.
{
	private String sektor, arbeidssted, firma, stillingstype, lonnsbetingelser, kontaktinformasjon, stillingsbeskrivelse, vikariatnr;
	private int varighet, arbeidstid;
	private static int MEDNR = 1000;
	private Soknadsregister register = new Soknadsregister();
	private Arbeidsforholdregister arbregister = new Arbeidsforholdregister();
	private Arbeidsgiver arbeid;

	public Vikariat(String s, String a, String f, String st, String l, Arbeidsgiver ar, String sti, int v, int arb)
	{
		sektor = s;
		arbeidssted = a;
		firma = f;
		stillingstype = st;
		lonnsbetingelser = l;
		arbeid = ar;
		stillingsbeskrivelse = sti;
		varighet = v;
		arbeidstid = arb;
		vikariatnr = Integer.toString(MEDNR++) + "B"; //Unikt vikariatnummer med "B" som identifikator.
	}

	public String getArbsted()
	{
		return arbeidssted;
	}

	public String getStilling()
	{
		return stillingsbeskrivelse;
	}

	public String getNr()
	{
		return vikariatnr;
	}

	public int getVarighet()
	{
		return varighet;
	}

	public String getSektor()
	{
		return sektor;
	}

	public String getFirma()
	{
		return firma;
	}

	public String getstillingBesk()
	{
		return stillingsbeskrivelse;
	}

	public String getLonn()
	{
		return lonnsbetingelser;
	}

	public int getArbeidstid()
	{
		return arbeidstid;
	}

	public String toString()
	{
		return "Sektor: " + sektor + "\tArbeidssted: " + arbeidssted + "\nFirma: " + firma;
	}
}