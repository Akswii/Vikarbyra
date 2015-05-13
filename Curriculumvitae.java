public class Curriculumvitae //klasse for lagring av informasjon 
							 //som vikarer vil trenge på soknadene sine
{
	private String utdannelse, erfaring, referanser;
	
 	public Curriculumvitae(String u, String e, String r)
 	{
 		utdannelse = u;
 		erfaring = e;
 		referanser = r;
 	}

 	public String getUtdannelse()
 	{
 		return utdannelse;
 	}

 	public String getErfaring()
 	{
 		return erfaring;
 	}

 	public String getReferanser()
 	{
 		return referanser;
 	}
	
 	public String toString()
 	{
 		return "\nUtdannelse:  " + utdannelse + "\nErfaring: " + erfaring + "\nReferanser " + referanser;
 	}
}