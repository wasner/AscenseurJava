package traitement;

import java.util.LinkedList;
import java.util.List;

import affichage.VueAscenseur;

public interface Ascenseur {
	public String toString();
	public void setEtageCourant(Etage etageCourant) ;
	public Etage getEtageCourant();
	public String getEtat();
	public void bloquer();
	public void debloquer();
	public List<Etage> getEtages();
	public void setEtages(List<Etage> etages);
	public void setPersonneMax(int personneMax);
	public void setPoidMax(int poidMax);
	public int getPoidMax();
	public int getPersonneMax();
	public void creerRequeteInterne(Etage etage);
	public String action();
	public void triAppel();
	public void addVue(VueAscenseur v);
	public boolean isBloquer();
	public void monter ();
	public void descendre ();
	public void ajouterRequete(Requete requete);
}
