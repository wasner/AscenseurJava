package ascenseur.traitement;

import java.util.LinkedList;
import java.util.List;

import ascenseur.affichage.VueImmeuble;

public class Immeuble {
	
	private String nom;
	private List<Etage> etages;
	private List<Ascenseur> ascenseurs;
	private List<VueImmeuble> vueImmeuble;
	
	
	public Immeuble(String nom, List<Etage> etages,
			List<Ascenseur> ascenseurs) {
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
	public void setEtages(List<Etage> etages) {
		this.etages = etages;
	}
	public List<Ascenseur> getAscenseurs() {
		return ascenseurs;
	}
	public void setAscenseurs(List<Ascenseur> ascenseurs) {
		this.ascenseurs = ascenseurs;
	}
}
