import java.util.*;
import java.io.*;

public class Vikar extends Person implements Serializable//Vikarklassen, dette er de som vil soke på jobb ol.
{
	private String epost, kategori, vikarnr;
	private Curriculumvitae cv;
	private int tlf, lonnskrav;
	private static int ANSATT_NR = 1000;
	private Date dato = new Date();

	public Vikar(String f, String e, String k, int a, String b, String ep, String ka, int tl, int lo)
	{
		super(f,e,k,a,b);
		epost = ep;
		kategori = ka;
		tlf = tl;
		lonnskrav = lo;
		vikarnr = Integer.toString(ANSATT_NR++) + "C"; //Unikt vikariatnummer med "C" som identifikator.
		cv = null;
	}

	public int getLonn()
	{
		return lonnskrav;
	}

	public String getEpost()
	{
		return epost;
	}
	// public void setEpost(String e)
	// {
	// 	epost = e;
	// }
	public String getKategori()
	{
		return kategori;
	}
	// public void setKategori(String k)
	// {
	// 	kategori = k;
	// }
	public int getTlf()
	{
		return tlf;
	}
	// public void setTlf(int t)
	// {
	// 	tlf = t;
	// }
	public int getLonnskrav()
	{
		return lonnskrav;
	}
	// public void setLonnskrav(int l)
	// {
	// 	lonnskrav = l;
	// }
	public String getVikarnr()
	{
		return vikarnr;
	}

	public void cv(String u, String e, String r)
	{
		new Curriculumvitae(u, e, r); //Her opprettes CV for vikarene, det lagres 3 forskjellige typer informasjon.
	}

	public String toString2()
	{
		return super.toString2() + "Vikarnummer: " + vikarnr+"\n";
	}

	public String toString()
	{
		return super.toString() + "\nVikarnummer: " + vikarnr + "\tEpost: " + epost  + "\nTlf: " + tlf + "\tKategori: " + kategori + "\nLonnskrav: " + lonnskrav + "\n";
	}

}