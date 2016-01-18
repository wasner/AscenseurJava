package traitement;
import java.util.*;

/**
 * 
 */
public class Controleur {

    /**
     * Default constructor
     */
    public Controleur(List<Ascenseur> a) {
    	this.ascenseurs=a;
    	//Constante.setNbAscenseur(nbAscenseur);
    	//Constante.setNbEtage(nbEtage);
    	this.requetes= new Vector<RequeteExterne>();
    }

    /**
     * 
     */
    private List<Ascenseur> ascenseurs;

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
     * @param AscenseurConcret ascenseur
     */
    public void choisirAscenseur() {
        // TODO implement here
    	//System.out.println("eeeeeeee");
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
    public void setAscenseurs(List<Ascenseur> ascenseurs) {
		this.ascenseurs = ascenseurs;
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
