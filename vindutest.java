public class vindutest
{
	public static void main (String[] args)
	{
		Arbeidsforholdregister forhregister = new Arbeidsforholdregister();
		Arbeidsregister arbregister = new Arbeidsregister();
		Soknadsregister sokregister = new Soknadsregister();
		Vikariatregister vikregister = new Vikariatregister();
		Vikarregister vikarregister = new Vikarregister();

		Hovedvindu vindu = new Hovedvindu(forhregister, arbregister, sokregister, vikregister, vikarregister);

	}
}