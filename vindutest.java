import java.awt.event.*;

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

		Arbeidsgiver akselen = new Arbeidsgiver("Akselen", "Wiigen", "M", 20, "Oslo", "Pleie", "Aksel hjemmet",  "Epost.com", "Hjemmeveien", 21000);
		Arbeidsgiver markusen = new Arbeidsgiver("Markusen", "Buggeen", "M", 23, "Oslo", "Ingenior", "Borte",  "Epost2.com", "Borteveien", 22000);
		Arbeidsgiver mortenen = new Arbeidsgiver("Mortenen", "Wolden", "M", 20, "Drammen", "Heisgutt", "hjemmet",  "Epost3.com", "Ingensted", 23000);

		Vikariat vikariat = new Vikariat("S", "S", "S", "S", "S", akselen, "S", 0, 0);
		Vikariatregister a = akselen.getVikariat();
		a.regVikariat(vikariat);

		vikarregister.settInnVikar(aksel);
		vikarregister.settInnVikar(markus);
		vikarregister.settInnVikar(morten);
		vikarregister.settInnVikar(dame);

		arbregister.settInnArbeidsgiver(akselen);
		arbregister.settInnArbeidsgiver(markusen);
		arbregister.settInnArbeidsgiver(mortenen);



		Hovedvindu vindu = new Hovedvindu(forhregister, arbregister, sokregister, vikregister, vikarregister);
		vindu.setLocationRelativeTo(null);

		vindu.addWindowListener( new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				vindu.skrivTilFil();
				System.exit(0);
			}
		} );

	}
}