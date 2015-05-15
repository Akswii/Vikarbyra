public class Vikariat //Vikariatklassen; dette er arbeidsplassene som vikarene vil soke på, og arbeidsgiverene vil legge ut.
{
	private String varighet, sektor, arbeidssted, firma, stillingstype, lonnsbetingelser, kontaktinformasjon, stillingsbeskrivelse, vikariatnr;
	private int arbeidstid;
	private static int MEDNR = 1000;
	private Soknadsregister register = new Soknadsregister();
	private Arbeidsforholdregister arbregister = new Arbeidsforholdregister();

	public Vikariat(String s, String a, String f, String st, String l, String ko, String sti, String v, int arb)
	{
		sektor = s;
		arbeidssted = a;
		firma = f;
		stillingstype = st;
		lonnsbetingelser = l;
		kontaktinformasjon = ko;
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

	public String getVarighet()
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

	public String toString()
	{
		return "Sektor: " + sektor + "\tArbeidssted: " + arbeidssted + "\nFirma: " + firma;
	}
}