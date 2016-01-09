package ascenceur.traitement;

import java.util.*;

public class Ascenseur {

	private int nbEtagesDeservis;
    private int nbPersonneMax;
    private Etage etageCourant;
    
	private int poidMax;
    private String etat; 					//immobileFerme, immobileOuvert, montant, descendant
	
    private boolean bloquer=false;
    
    private Utilisateur utilisateurs[];
    private Etage etages[];					//liste des etages deservis. (exemple: 1,2,3,6,8,9)
    private Option options[];
    
    LinkedList<Requete> requetes=new LinkedList<Requete>();
    
    public Ascenseur(int PoidM, int nbPersM,Etage etages[]) {
    	etat="immobileFermer";
    	poidMax=PoidM;
    	nbPersonneMax=nbPersM;
    	nbEtagesDeservis=etages.length; 	
    }
    
    public Etage getEtageCourant() {
		return etageCourant;
	}


    public String getEtat() {
		return etat;
	}
    
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
    	RequeteInterne requete = new RequeteInterne(etage);
        ajouterRequete(requete);
    }    
    
    public boolean testEtatSuivantImmoFerme(){
    	if((requetes.size()==0) || (((requetes.getFirst()).getRequeteEtage()).compareEtage(etageCourant))!=0){
			etat="immobileFerme";
			return true;
    	}
    	return false;
    }
    
    
    public boolean testEtatSuivantImmoOuvert(){
    	if((requetes.size()!=0) && (((requetes.getFirst()).getRequeteEtage()).compareEtage(etageCourant))==0){
    		etat="immobileOuvert";
    		for(int i=0;i<requetes.size();++i){
    			if((requetes.get(i).getRequeteEtage()).compareEtage(etageCourant)==0){
    				requetes.remove(i);
    			}
    		}
    		return true;
    	}
    	return false;
    }
    
    
    public boolean testEtatSuivantMontant(){
    	if((requetes.size()!=0) && (((requetes.getFirst()).getRequeteEtage()).compareEtage(etageCourant))==1){
    		etat="montant";
    		return true;
    	}
    	return false;
    }
    
    
    public boolean testEtatSuivantDescendant(){
    	if((requetes.size()!=0) && (((requetes.getFirst()).getRequeteEtage()).compareEtage(
    			etageCourant))==-1){
    		etat="descendant";
    		return true;
    	}
    	return false;
    }

	public String action() {
		if (bloquer==false){
	        if(testEtatSuivantImmoOuvert()){}
	        else if (testEtatSuivantImmoFerme()){}
	        else if(testEtatSuivantDescendant()){}
	        else if(testEtatSuivantMontant()){}
		}
        return etat;
    }

	 private Comparator<Requete> comp1 = new Comparator<Requete>() {
	        @Override
	        public int compare(Requete requete, Requete t1) {
	            if(getEtat() == "montant" ){
	                if(requete.getRequeteEtage().getNumEtage()<t1.getRequeteEtage().getNumEtage())
	                    return -1;
	            }
	                return 0;
	        }
	    };

	    public void triAppel() {
	        //Fonction triant les appels en attente
	        //remplissage d'un tableau avec les destinations des appels
	        for(Requete re : this.requetes)
	            //this.requetes.add(Requete.getRequeteEtage());
	            if(re.getRequeteEtage().compareEtage(this.getEtageCourant())!=0) //Si l'ï¿½tage ou se trouve l'ascenceur n'est pas l'ï¿½tage ou il y a une requï¿½te
	                this.requetes.add(re);//On ajoute l'ï¿½tage ou il y a une requï¿½te dans la file d'attente

	        //Algorithme de tri du precedent tableau
	        //Si on monte
	        if(this.etat == "montant") {
	            Collections.sort(this.requetes,comp1); //On trie les requï¿½tes dans l'ordre croissant (c'est ï¿½ dire que les requï¿½tes provenant d'ï¿½tage les plus proches de l'ascenceur vont arrivï¿½ en premiï¿½re)
	        }
	        else{ //Si on descend
	            // create comparator for reverse order
	            Comparator cmp = Collections.reverseOrder();
	            Collections.sort(requetes,cmp); //On trie les requï¿½tes dans l'ordre dï¿½croissant (cad que les requï¿½tes provenant des ï¿½tages les plus proches seront en premier)
	        }
	    }
}
