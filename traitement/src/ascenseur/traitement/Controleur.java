package traitement;
import java.util.*;

/**
 * 
 */
public class Controleur {

    /**
     * Default constructor
     */
    public Controleur(int nbAscenseur, int nbEtage) {
    	this.ascenseurs=new Ascenseur[nbAscenseur];
    	Constante.setNbAscenseur(nbAscenseur);
    	Constante.setNbEtage(nbEtage);
    	this.requetes= new Vector<RequeteExterne>();
    }

    /**
     * 
     */
    private Ascenseur ascenseurs[];

    /**
     * 
     */
    private Vector<RequeteExterne> requetes;




    /**
     * @param int etage 
     * @param String direction
     */
    public void creerRequeteExterne(int etage, String direction) {
        // TODO implement here
    	this.requetes.add(new RequeteExterne(etage, direction));
    }

    /**
     * @param Ascenseur ascenseur
     */
    public void choisirAscenseur(Ascenseur ascenseur) {
        // TODO implement here
    	for(RequeteExterne r : this.requetes){
    		Ascenseur ascenceurChoisie=null;
    		for(Ascenseur a : this.ascenseurs){
    			if(r.getDirection()==a.getEtat()){
    				for (Etage e : a.getEtages()){
    					if (etagesEgaux(e, r.getEtage())){
    						if(r.getDirection()=="Dessend" && etageUnPlusPetit(r.getEtage(),a.getEtageCourant()){
    							ascenceurChoisie=a;
    						}
    						else if (r.getDirection()=="Monter" && r.getEtage().compareTo(a.getEtageCourant())>0){
    							ascenceurChoisie=a;
    						}
    					}
    				}
    			}
    			else if (ascenceurChoisie==null && a.getEtat()=="Immobile Fermer"){
    				ascenceurChoisie=a;
    			}
    		}
    		ascenceurChoisie.ajouterRequete(r);
    	}
    }
    private boolean etagesEgaux(Etage e1, Etage e2){
		
    	return e1.compareTo(e2)==0;
    	
    }
    private boolean etageUnPlusPetit(Etage e1, Etage e2){
    	return e1.compareTo(e2)<0;
    }
    private boolean etageUnPlusGrand(Etage e1, Etage e2){
    	return e1.compareTo(e2)>0;
    }

}
