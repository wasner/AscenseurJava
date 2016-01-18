import traitement.Ascenseur;
import traitement.Etage;

public class VueAscenseurPosition implements VueAscenseur {

	private Ascenseur asc;
	private Etage et;
	private VueImeuble vue;

	/**
	 * Constructeur pour la vue de la position des ascenseur
	 * @param ascens l'ascenseur
	 * @param vue la vue associé
	 */
	public VueAscenseurPosition(Ascenseur ascens, VueImeuble vue) {
		// TODO Auto-generated constructor stub
		this.asc = ascens;
		et=asc.getEtageCourant();
		this.vue=vue;
	}

	/**
	 * fonction de mise à jour de la vue
	 */
	@Override
	public void miseAJour() {
		// TODO Auto-generated method stub
		et= asc.getEtageCourant();
		vue.miseAJour();
	}

	/**
	 * permet de connaitre l'étage
	 * @return
	 */
	public Etage getEtage(){
		return et;
	}

	/**
	 * permet de connaitre l'état de l'ascenseur
	 * @return
	 */
	public String getEtat(){
		return asc.getEtat();
	}

}
