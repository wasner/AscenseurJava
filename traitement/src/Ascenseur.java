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
    private int poidMax;
    private String etat;   					//immobileFerme, immobileOuvert, montant, descendant
    private boolean bloquer;
    
    private Utilisateur utilisateurs[];
    private Etage etages[];					//liste des étages déservis. (exemple: 1,2,3,6,8,9)
    private Option options[];
    
    LinkedList<Requete> requetes=new LinkedList<Requete>();

    
    public void bloquer() {
    	bloquer=true;
    }

    public void debloquer() {
        bloquer=false;
    }

    public void ajouterRequete(Requete requete) {
        requetes.add(requete);
    }

    public void creerRequeteInterne(Etage etage) {
        Requete requete = new Requete(etage);
        ajouterRequete(requete);
    }
     
    
    
    
    public void testEtatSuivantImmoFerme(){
    	if((requetes.size()==0) || ((requetes.element()).getEtageAsc())!=etageCourant ){
			etat="immobileFerme";
    	}
    }
    
    
    public void testEtatSuivantImmoOuvert(){
    	if((requetes.size()!=0) && ((requetes.element()).getEtageAsc())==etageCourant ){
    		etat="immobileOuvert";
    	}
    }
    
    
    public void testEtatSuivantMontant(){
    	if((requetes.size()!=0) && ((requetes.element()).getEtageAsc())>etageCourant  ){
    		etat="montant";
    	}
    }
    
    
    public void testEtatSuivantDescendant(){
    	if((requetes.size()!=0) && ((requetes.element()).getEtageAsc())<etageCourant  ){
    		etat="descendant";
    	}
    }
    
    

    public void action() {
        // TODO implement here
    }

}
