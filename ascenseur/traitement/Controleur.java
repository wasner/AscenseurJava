import java.util.*;

/**
 * Classe contenant toute la partie contrôle du projet
 */
public class Controleur {

	/**
	 * Constructeur par défaut
	 * @param a liste des ascenseurs
	 */
    public Controleur(List<Ascenseur> a) {
    	this.ascenseurs=a;
    	//Constante.setNbAscenseur(nbAscenseur);
    	//Constante.setNbEtage(nbEtage);
    	this.requetes= new Vector<RequeteExterne>();
    }

    /**
     * liste contenant les ascenseurs
     */
    private List<Ascenseur> ascenseurs;

    /**
     * tableau contenant les requêtes externes
     */
    private Vector<RequeteExterne> requetes;


	/**
	 * permet de créer des requête externe dans l'immeuble
	 * @param etage l'étage d'ou vient la requête
	 * @param direction direction dans la qu'elle personne veux allez (monter ou descendre)
	 */
    public void creerRequeteExterne(Etage etage, String direction) {
        // TODO implement here
    	this.requetes.add(new RequeteExterne( direction, etage));
    }

	/**
	 * permet de choisir l'ascenseur de manière optimal pour satisfaire les requêtes
	 */
    public void choisirAscenseur() {
    	//System.out.println(requetes.size());
    	for(RequeteExterne r : this.requetes){
    		//System.out.println(ascenseurs.size());
    		Ascenseur ascenceurChoisie=null;
    		for(Ascenseur a : this.ascenseurs){
    			//System.out.println(a.getEtat()+ " " + a.getEtageCourant().getNumEtage());
    			if(r.getDirection()==a.getEtat()){
    				for (Etage e : a.getEtages()){
    					//System.out.print(e.getNumEtage());
    					if (etagesEgaux(e, r.getEtage())){
    						if(r.getDirection()=="descendant" && etageUnPlusPetit(r.getEtage(),a.getEtageCourant())){
    							ascenceurChoisie=a;
    						}
    						else if (r.getDirection()=="montant" && etageUnPlusGrand(r.getEtage(),a.getEtageCourant())){
    							ascenceurChoisie=a;
    						}
    						break;
    					}
    				}
    				//System.out.println(" ");
    			}
    			else if (ascenceurChoisie==null && a.getEtat()=="immobileFerme"){
    				ascenceurChoisie=a;
    				//System.out.println("eeeeeeS");
    			}
    		}
    		if(ascenceurChoisie != null){
    			ascenceurChoisie.ajouterRequete(r);
    			this.requetes.remove(r);
    			//System.out.println(ascenceurChoisie);
    			break;
    		}
    	}
    }

	/**
	 * permet de séléctionner l'ascenseur
	 * @param ascenseurs ascenseur sélectionner
	 */
    public void setAscenseurs(List<Ascenseur> ascenseurs) {
		this.ascenseurs = ascenseurs;
	}

	/**
	 * Vérifie si deux étages sont égaux
	 * @param e1 première étage
	 * @param e2 deuxième étage
	 * @return si les deux étages sont égaux true sinon false
	 */
	private boolean etagesEgaux(Etage e1, Etage e2){
		
    	return e1.compareEtage(e2)==0;
    	
    }

	/**
	 * permet de savoir si le première étage (e1) comparé est plus petit que le deuxième (e2)
	 * @param e1 première étage
	 * @param e2 deuxième étage
	 * @return true si l'égage 1 est plus petit que le 2
	 */
    private boolean etageUnPlusPetit(Etage e1, Etage e2){
    	return e1.compareEtage(e2)<0;
    }

	/**
	 * permet de savoir si le première étage (e1) comparé est plus grand que le deuxième (e2)
	 * @param e1 première étage
	 * @param e2 deuxième étage
	 * @return true si l'étage 1 est plus grand que le 2
	 */
    private boolean etageUnPlusGrand(Etage e1, Etage e2){
    	return e1.compareEtage(e2)>0;
    }

}
