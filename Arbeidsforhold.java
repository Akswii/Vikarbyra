import java.util.*;

public class Arbeidsforhold
{
	private Vikar vikaren;
	private Vikariat vikariatet;
	private String opplevelse, regnr;
	private Date dato;
	private static int ARBFOR_NR = 1000;

	public Arbeidsforhold(Vikar v, Vikariat vi, String o, String r)
	{
		vikaren = v;
		vikariatet = vi;
		opplevelse = o;
		regnr = Integer.toString(ARBFOR_NR++) + "D";
	}

	public Vikar getVikar()
	{
		return vikaren;
	}

	public Vikariat getVikariat()
	{
		return vikariatet;
	}

	public String getRegnr()
	{
		return regnr;
	}

	public String toString()
	{
		return vikaren + "\n" + vikariatet + "\n" + opplevelse;
	}
}