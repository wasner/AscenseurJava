import java.util.*;

import affichage.VueAscenseur;

/**
 * 
 */
public abstract class Option implements Ascenseur  {
	/**
	 * Delegue d'ascenseur
	 */
	protected Ascenseur delegue;

	/**
	 * Constructeur d'option avec en paramètre le délégué d'ascenseur
	 * @param delegeu c'est le délégué de l'ascenseur
	 */
	public Option(Ascenseur delegeu) {
		// TODO Auto-generated constructor stub
		this.delegue= delegeu;
	}	
	@Override
	/**
	 * nom de l'action
	 */
	public String action() {
		// TODO Auto-generated method stub
		return delegue.action();
	}

	/**
	 * permet de bloquer l'ascenseur
	 */
	@Override
	public void bloquer() {
		// TODO Auto-generated method stub
		delegue.bloquer();
	}
	@Override
	/**
	 * permet de créer une requête interne à l'ascenseur
	 */
	public void creerRequeteInterne(Etage etage) {
		// TODO Auto-generated method stub
		delegue.creerRequeteInterne(etage);
	}

	/**
	 * permet de définir l'étage courant de l'ascenseur
	 * @param etageCourant c'est l'étage ou se trouve l'ascenseur
	 */
	@Override
	public void setEtageCourant(Etage etageCourant) {
		// TODO Auto-generated method stub
		delegue.setEtageCourant(etageCourant);
	}

	/**
	 * permet de connaitre l'étage courant de l'ascenseur
	 * @return l'étage courant de l'ascenseur
	 */
	@Override
	public Etage getEtageCourant() {
		// TODO Auto-generated method stub
		return delegue.getEtageCourant();
	}

	/**
	 * permet de connaitre l'état de l'ascenseur
	 * @return l'état de l'ascenseur
	 */
	@Override
	public String getEtat() {
		// TODO Auto-generated method stub
		return delegue.getEtat();
	}

	/**
	 * permet de débloquer l'ascenseur
	 */
	@Override
	public void debloquer() {
		// TODO Auto-generated method stub
		delegue.debloquer();
	}

	/**
	 * permet d'avoir la liste des étages
	 * @return Etage
	 */
	@Override
	public List<Etage> getEtages() {
		// TODO Auto-generated method stub
		return delegue.getEtages();
	}

	/**
	 * permet de définir la liste des étages
	 * @param etages la liste d'étages
	 */
	@Override
	public void setEtages(List<Etage> etages) {
		// TODO Auto-generated method stub
		delegue.setEtages(etages);
	}

	/**
	 * permet de définir le nombre de personne max dans l'ascenseur
	 * @param personneMax le nombres de personnes max
	 */
	@Override
	public void setPersonneMax(int personneMax) {
		// TODO Auto-generated method stub
		delegue.setPersonneMax(personneMax);
	}

	/**
	 * permet de définir le poids que peut accueillir l'ascenseur
	 * @param poidMax le poids max
	 */
	@Override
	public void setPoidMax(int poidMax) {
		// TODO Auto-generated method stub
		delegue.setPoidMax(poidMax);
	}
	@Override
	/**
	 * permet de connaitre le poids max pour un ascenseur
	 */
	public int getPoidMax() {
		// TODO Auto-generated method stub
		return delegue.getPoidMax();
	}

	/**
	 * permet de retourner le nombre de personnes max dans l'ascenseur
	 * @return Nombres de personnes max
	 */
	@Override
	public int getPersonneMax() {
		// TODO Auto-generated method stub
		return delegue.getPersonneMax();
	}

	/**
	 * Permet de trie la liste des requêtes de l'ascenseur
	 */
	@Override
	public void triAppel() {
		// TODO Auto-generated method stub
		delegue.triAppel();
	}

	/**
	 * permet d'ajouter des vue pour l'ascenseur(affichage)
	 * @param v vue pour l'ascenseur
	 */
	public void addVue(VueAscenseur v) {
		delegue.addVue(v);
		
	}

	/**
	 * permet de savoir si l'ascenseur est bloqué
	 * @return true si bloqué, false sinon
	 */
	@Override
	public boolean isBloquer() {
		// TODO Auto-generated method stub
		return delegue.isBloquer();
	}

	/**
	 * permet de faire monter l'ascenseur d'un étage
	 */
	@Override
	public void monter() {
		// TODO Auto-generated method stub
		delegue.monter();
	}
	@Override
	/**
	 * permet de faire descendre l'ascenseur d'un étage
	 */
	public void descendre() {
		// TODO Auto-generated method stub
		delegue.descendre();
	}

	/**
	 * permet d'ajouter une requête pour un ascenseur
	 * @param requete requête pour un ascenseur
	 */
	@Override
	public void ajouterRequete(Requete requete) {
		// TODO Auto-generated method stub
		
	}
}
