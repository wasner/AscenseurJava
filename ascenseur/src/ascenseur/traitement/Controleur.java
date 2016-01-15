package ascenseur.traitement;
import java.util.*;

/**
 * 
 */
public class Controleur {

    /**
     * Default constructor
     */
    public Controleur(Ascenseur[] a) {
    	this.ascenseurs=a;
    	//Constante.setNbAscenseur(nbAscenseur);
    	//Constante.setNbEtage(nbEtage);
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
    public void creerRequeteExterne(Etage etage, String direction) {
        // TODO implement here
    	this.requetes.add(new RequeteExterne( direction, etage));
    }

    /**
     * @param Ascenseur ascenseur
     */
    public void choisirAscenseur() {
        // TODO implement here
    	for(RequeteExterne r : this.requetes){
    		Ascenseur ascenceurChoisie=null;
    		for(Ascenseur a : this.ascenseurs){
    			if(r.getDirection()==a.getEtat()){
    				for (Etage e : a.getEtages()){
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
    			}
    			else if (ascenceurChoisie==null && a.getEtat()=="immobileFerme"){
    				ascenceurChoisie=a;
    			}
    		}
    		ascenceurChoisie.ajouterRequete(r);
    	}
    }
    private boolean etagesEgaux(Etage e1, Etage e2){
		
    	return e1.compareEtage(e2)==0;
    	
    }
    private boolean etageUnPlusPetit(Etage e1, Etage e2){
    	return e1.compareEtage(e2)<0;
    }
    private boolean etageUnPlusGrand(Etage e1, Etage e2){
    	return e1.compareEtage(e2)>0;
    }

}
