package ascenseur.traitement;

import java.util.LinkedList;

public class Immeuble {
	
	
	private String nom;
	private LinkedList<Etage> etages;
	private LinkedList<Ascenseur> ascenseurs;
	
	
	
	public Immeuble(String nom, LinkedList<Etage> etages,
			LinkedList<Ascenseur> ascenseurs) {
		super();
		this.nom = nom;
		this.etages = etages;
		this.ascenseurs = ascenseurs;
	}
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public LinkedList<Etage> getEtages() {
		return etages;
	}
	public void setEtages(LinkedList<Etage> etages) {
		this.etages = etages;
	}
	public LinkedList<Ascenseur> getAscenseurs() {
		return ascenseurs;
	}
	public void setAscenseurs(LinkedList<Ascenseur> ascenseurs) {
		this.ascenseurs = ascenseurs;
	}

}
