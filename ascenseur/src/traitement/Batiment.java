package ascenceur.traitement;

public class Batiment {
	private String nomBat;
	private Etage etages[];
	private Ascenseur ascenseurs[];
	public Batiment(String nomBat, Etage[] etages, Ascenseur[] ascenseurs) {
		super();
		this.nomBat = nomBat;
		this.etages = etages;
		this.ascenseurs = ascenseurs;
	}
	
	public void monter(Ascenseur ascenseur){
		for (Etage check : etages){
			if(this.==ascenseur.getEtageCourant())
		}
	}

}
