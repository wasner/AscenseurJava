package ascenseur.traitement;

import java.util.*;

/**
 * 
 */
public class Ascenseur {

    public Ascenseur(int PoidM, int nbPersM,Etage etages[]) {
    	etat="immobileFermer";
    	poidMax=PoidM;
    	nbPersonneMax=nbPersM;
    	nbEtagesDeservis=etages.length; 	
    }
    
    private int nbEtagesDeservis;
    private int nbPersonneMax;
    private Etage etageCourant;
    
    public Etage getEtageCourant() {
		return etageCourant;
	}

	private int poidMax;
    private String etat;   					//immobileFerme, immobileOuvert, montant, descendant
    private boolean bloquer;
    
    private Utilisateur utilisateurs[];
    private Etage etages[];					//liste des etages deservis. (exemple: 1,2,3,6,8,9)
    private Option options[];
    
    LinkedList<RequeteInterne> requetes=new LinkedList<RequeteInterne>();

    
    public void bloquer() {
    	bloquer=true;
    }

    public void debloquer() {
        bloquer=false;
    }

    public void ajouterRequete(RequeteInterne requete) {
        requetes.add(requete);
    }

    public void creerRequeteInterne(Etage etage) {
    	RequeteInterne requete = new RequeteInterne(etage);
        ajouterRequete(requete);
    }
     
    
    
    
    public void testEtatSuivantImmoFerme(){
    	if((requetes.size()==0) || ((requetes.element()).getEtageDestination())!=etageCourant ){
			etat="immobileFerme";
    	}
    }
    
    
    public void testEtatSuivantImmoOuvert(){
    	if((requetes.size()!=0) && ((requetes.element()).getEtageDestination())==etageCourant ){
    		etat="immobileOuvert";
    	}
    }
    
    
    public void testEtatSuivantMontant(){
    	if((requetes.size()!=0) && ((requetes.element()).getEtageDestination()).compareTo(etageCourant)){
    		etat="montant";
    	}
    }
    
    
    public void testEtatSuivantDescendant(){
    	if((requetes.size()!=0) && ((requetes.element()).getEtageDestination()).compareTo(
    			etageCourant)){
    		etat="descendant";
    	}
    }
    
    

    public LinkedList<RequeteInterne> getRequetes() {
		return requetes;
	}

	public void action() {
        testEtatSuivantImmoOuvert();
        testEtatSuivantImmoFerme();
        testEtatSuivantDescendant();
        testEtatSuivantMontant();
    }

}
