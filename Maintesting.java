public class Maintesting
{
	public static void main(String[] args)
	{

		Vikarregister register = new Vikarregister();

		String f = "",e="",k="",ep="",ka="", by="Oslo";
		int a=0,tl=0,lø=0;
		
		Vikar v = new Vikar(f,e,k,a,by,ep,ka,tl,lø);
		
		register.settInnVikar(v);

		// System.out.print(register.toString());

		

		System.out.print(register.toString());
	}
}