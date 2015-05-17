public class vindutest
{
	public static void main (String[] args)
	{
		Arbeidsforholdregister forhregister = new Arbeidsforholdregister();
		Arbeidsregister arbregister = new Arbeidsregister();
		Soknadsregister sokregister = new Soknadsregister();
		Vikariatregister vikregister = new Vikariatregister();
		Vikarregister vikarregister = new Vikarregister();

		Vikar aksel = new Vikar("Aksel", "Wiig", "M", 20, "Oslo", "Pls", "Ingenior", 2020, 700000);
		Vikar markus = new Vikar("Markus", "Bugge-Hundere", "M", 23, "Oslo", "Pls", "Ingenior", 2021, 500000);
		Vikar morten = new Vikar("Morten", "Wold", "K", 20, "Alesund", "Pingvin@stjelt.com", "Tyv", 2020, 500000);
		Vikar dame = new Vikar("Dame", "Damesen", "K", 23, "Alesund", "Pls2", "Blo", 2022, 100000);

		vikarregister.settInnVikar(aksel);
		vikarregister.settInnVikar(markus);
		vikarregister.settInnVikar(morten);
		vikarregister.settInnVikar(dame);

		Hovedvindu2 vindu = new Hovedvindu2(forhregister, arbregister, sokregister, vikregister, vikarregister);
	}
}