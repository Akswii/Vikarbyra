public class vindutest
{
	public static void main (String[] args)
	{
		Arbeidsforholdregister forhregister = new Arbeidsforholdregister();
		Arbeidsregister arbregister = new Arbeidsregister();
		Soknadsregister sokregister = new Soknadsregister();
		Vikariatregister vikregister = new Vikariatregister();
		Vikarregister vikarregister = new Vikarregister();

		Vikar aksel = new Vikar("Aksel", "Wiig", "Mann", 20, "Oslo", "Pls", "Ingeniør", 2020, 700000);
		Vikar markus = new Vikar("Markus", "Bugge-Hundere", "Mann", 23, "Oslo", "Pls", "Ingeniør", 2021, 500000);
		Vikar morten = new Vikar("Morten", "Wold", "Kvinne", 20, "Ålesund", "Pingvin@stjelt.com", "Tyv", 2020, 500000);
		Vikar dame = new Vikar("Dame", "Damesen", "Kvinne", 23, "Ålesund", "Pls2", "Blø", 2022, 100000);

		vikarregister.settInnVikar(aksel);
		vikarregister.settInnVikar(markus);
		vikarregister.settInnVikar(morten);
		vikarregister.settInnVikar(dame);

		Hovedvindu vindu = new Hovedvindu(forhregister, arbregister, sokregister, vikregister, vikarregister);

	}
}