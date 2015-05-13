public class Vikariat //Vikariatklassen; dette er arbeidsplassene som vikarene vil soke på, og arbeidsgiverene vil legge ut.
{
	private String sektor, arbeidssted, firma, jobbkategori, stillingstype, krav, lonnsbetingelser, arbeidsvilkar, kontaktinformasjon, stillingsbeskrivelse, vikariatnr;
	private int varighet, arbeidstid;
	private static int MEDNR = 1000;
	private Soknadsregister register = new Soknadsregister();
	private Arbeidsforholdregister arbregister = new Arbeidsforholdregister();

	public Vikariat(String s, String a, String f, String j, String st, String k, String l, String ar, String ko, String sti, int v, int arb)
	{
		sektor = s;
		arbeidssted = a;
		firma = f;
		jobbkategori = j;
		stillingstype = st;
		krav = k;
		lonnsbetingelser = l;
		arbeidsvilkar = ar;
		kontaktinformasjon = ko;
		stillingsbeskrivelse = sti;
		varighet = v;
		arbeidstid = arb;
		vikariatnr = Integer.toString(MEDNR++) + "B"; //Unikt vikariatnummer med "B" som identifikator.
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

	public String toString()
	{
		return "Sektor: " + sektor + "\tArbeidssted: " + arbeidssted + "\nFirma: " + firma + "\tJobbkategori: " + jobbkategori;
	}
}