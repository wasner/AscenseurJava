package ascenseur.traitement;

import java.util.LinkedList;
import java.util.List;

import ascenseur.affichage.VueImmeuble;

public class Immeuble {
	
	private String nom;
	private List<Etage> etages;
	private List<Ascenseur> ascenseurs;
	private List<VueImmeuble> vueImmeuble;
	
	
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
	public List<Etage> getEtages() {
		return etages;
	}
	public void setEtages(LinkedList<Etage> etages) {
		this.etages = etages;
	}
	public List<Ascenseur> getAscenseurs() {
		return ascenseurs;
	}
	public void setAscenseurs(LinkedList<Ascenseur> ascenseurs) {
		this.ascenseurs = ascenseurs;
	}
}
