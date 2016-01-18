package traitement;
import java.util.*;

import affichage.VueAscenseur;

/**
 * 
 */
public abstract class Option implements Ascenseur  {
	protected Ascenseur delegue;
	public Option(Ascenseur delegeu) {
		// TODO Auto-generated constructor stub
		this.delegue= delegeu;
	}	
	@Override
	public String action() {
		// TODO Auto-generated method stub
		return delegue.action();
	}
	@Override
	public void bloquer() {
		// TODO Auto-generated method stub
		delegue.bloquer();
	}
	@Override
	public void creerRequeteInterne(Etage etage) {
		// TODO Auto-generated method stub
		delegue.creerRequeteInterne(etage);
	}
	@Override
	public void setEtageCourant(Etage etageCourant) {
		// TODO Auto-generated method stub
		delegue.setEtageCourant(etageCourant);
	}
	@Override
	public Etage getEtageCourant() {
		// TODO Auto-generated method stub
		return delegue.getEtageCourant();
	}
	@Override
	public String getEtat() {
		// TODO Auto-generated method stub
		return delegue.getEtat();
	}
	@Override
	public void debloquer() {
		// TODO Auto-generated method stub
		delegue.debloquer();
	}
	@Override
	public List<Etage> getEtages() {
		// TODO Auto-generated method stub
		return delegue.getEtages();
	}
	@Override
	public void setEtages(List<Etage> etages) {
		// TODO Auto-generated method stub
		delegue.setEtages(etages);
	}
	@Override
	public void setPersonneMax(int personneMax) {
		// TODO Auto-generated method stub
		delegue.setPersonneMax(personneMax);
	}
	@Override
	public void setPoidMax(int poidMax) {
		// TODO Auto-generated method stub
		delegue.setPoidMax(poidMax);
	}
	@Override
	public int getPoidMax() {
		// TODO Auto-generated method stub
		return delegue.getPoidMax();
	}
	@Override
	public int getPersonneMax() {
		// TODO Auto-generated method stub
		return delegue.getPersonneMax();
	}
	@Override
	public void triAppel() {
		// TODO Auto-generated method stub
		delegue.triAppel();
	}
	public void addVue(VueAscenseur v) {
		delegue.addVue(v);
		
	}
	@Override
	public boolean isBloquer() {
		// TODO Auto-generated method stub
		return delegue.isBloquer();
	}
	@Override
	public void monter() {
		// TODO Auto-generated method stub
		delegue.monter();
	}
	@Override
	public void descendre() {
		// TODO Auto-generated method stub
		delegue.descendre();
	}
	@Override
	public void ajouterRequete(Requete requete) {
		// TODO Auto-generated method stub
		
	}
}
