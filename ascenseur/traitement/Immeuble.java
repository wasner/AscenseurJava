package traitement;

import java.util.LinkedList;
import java.util.List;

import affichage.VueImeuble;



public class Immeuble {
	
	private String nom;
	private List<Etage> etages;
	private List<Ascenseur> ascenseurs;
	private List<VueImeuble> vueImmeuble;
	private Controleur co;
	
	public Controleur getCo() {
		return co;
	}


	public List<VueImeuble> getVue() {
		return vueImmeuble;
	}


	public Immeuble(String nom, List<Etage> etages,
			List<Ascenseur> ascenseurs, Controleur co) {
		super();
		this.co = co;
		this.nom = nom;
		this.etages = etages;
		this.ascenseurs = ascenseurs;
		vueImmeuble= new LinkedList<>();
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
	public void addVue(VueImeuble vue){
		vueImmeuble.add(vue);
	}
}

