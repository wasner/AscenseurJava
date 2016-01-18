import java.util.LinkedList;
import java.util.List;

import affichage.VueImeuble;


/**
 * Classe concernant l'immeuble
 */
public class Immeuble {
	/**
	 * nom de l'immeuble
	 */
	private String nom;
	/**
	 * liste d'étage qui compose l'immeuble
	 */
	private List<Etage> etages;
	/**
	 * liste des ascenseurs présents dans l'immeuble
	 */
	private List<Ascenseur> ascenseurs;
	/**
	 * liste des vues(affichage) de l'immeuble
	 */
	private List<VueImeuble> vueImmeuble;
	/**
	 * spécifie le controleur pour un immeuble (délégué)
	 */
	private Controleur co;

	/**
	 * permet de retourner le contrôleur
	 * @return co
	 */
	public Controleur getCo() {
		return co;
	}

	/**
	 * permet de retourner les vue pour l'immeuble
	 * @return vueImmeuble
	 */
	public List<VueImeuble> getVue() {
		return vueImmeuble;
	}

	/**
	 * constructeur d'immeuble
	 * @param nom nom de l'immeuble
	 * @param etages nombre d'étages pour l'immeuble
	 * @param ascenseurs nombres d'ascenseurs que comporte l'immeuble
	 * @param co qu'elle controleur va le gérer
	 */
	public Immeuble(String nom, List<Etage> etages,
			List<Ascenseur> ascenseurs, Controleur co) {
		super();
		this.co = co;
		this.nom = nom;
		this.etages = etages;
		this.ascenseurs = ascenseurs;
		vueImmeuble= new LinkedList<>();
	}

	/**
	 * retourner le nom de l'immeuble
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * permet de définir le nom de l'immeuble
	 * @param nom nom de l'immeuble
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * permet de retourner la liste des étages de l'immeuble
	 * @return etages
	 */
	public List<Etage> getEtages() {
		return etages;
	}

	/**
	 * permet de définir la liste d'étages de l'immeuble
	 * @param etages liste d'étages
	 */
	public void setEtages(List<Etage> etages) {
		this.etages = etages;
	}

	/**
	 * permet de retourner la liste des ascenseurs pour un immeuble
	 * @return ascenseurs (liste d'ascenseur)
	 */
	public List<Ascenseur> getAscenseurs() {
		return ascenseurs;
	}

	/**
	 * permet de définir la liste des ascenseurs pour un immeuble
	 * @param ascenseurs liste d'ascenseurs
	 */
	public void setAscenseurs(List<Ascenseur> ascenseurs) {
		this.ascenseurs = ascenseurs;
	}

	/**
	 * permet d'ajouter une vue pour l'immeuble (affichage)
	 * @param vue affichage de la vue immeuble
	 */
	public void addVue(VueImeuble vue){
		vueImmeuble.add(vue);
	}
}

