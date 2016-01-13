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

    public Etage[] getEtages()
    {
    	return etages;
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
    
    public void setEtages(Etage etages[])
    {
    	this.etages = etages;
    	this.nbEtagesDeservis=etages.length; 
    }
    
    public void setPersonneMax(int personneMax)
    {
    	this.nbPersonneMax = personneMax;
    }
    
    public void setPoidMax(int poidMax)
    {
    	this.poidMax = poidMax;
    }
    
    public int getPoidMax()
    {
    	return this.poidMax;
    }
    
    public int getPersonneMax()
    {
    	return this.nbPersonneMax;
    }

    public void ajouterRequete(Requete requete) {
        requetes.add(requete);
    }

    public void creerRequeteInterne(Etage etage) {
    	RequeteInterne requete = new RequeteInterne(etage);
        ajouterRequete(requete);
    }    
    
    public void monter (Batiment batiment){
		for (int i = 0; i<batiment.getEtage().length;++i){
			if(batiment.getEtage()[i]==etageCourant){
				etageCourant=batiment.getEtage()[i+1];
			}
		}
		
	}
	
	public void descendre (Batiment batiment){
		for (int i = 0; i<batiment.getEtage().length;++i){
			if(batiment.getEtage()[i]==etageCourant){
				etageCourant=batiment.getEtage()[i-1];
			}
		}
		
	}
    
    public boolean etatSuivantImmoFerme(){
    	if((requetes.size()==0) || (((requetes.getFirst()).getRequeteEtage()).compareEtage(etageCourant))!=0){
			etat="immobileFerme";
			return true;
    	}
    	return false;
    }
    
    
    public boolean etatSuivantImmoOuvert(){
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
    
    
    public boolean etatSuivantMontant(){
    	if((requetes.size()!=0) && (((requetes.getFirst()).getRequeteEtage()).compareEtage(etageCourant))==1){
    		etat="montant";
    		return true;
    		monter(batiment);
    	}
    	return false;
    }
    
    
    public boolean etatSuivantDescendant(){
    	if((requetes.size()!=0) && (((requetes.getFirst()).getRequeteEtage()).compareEtage(
    			etageCourant))==-1){
    		etat="descendant";
    		descendre(batiment);
    		return true;
    	}
    	return false;
    }

	public String action() {
		if (bloquer==false){
	        if(etatSuivantImmoOuvert()){}
	        else if (etatSuivantImmoFerme()){}
	        else if(etatSuivantDescendant()){}
	        else if(etatSuivantMontant()){}
		}
        return etat;
    }

	 private Comparator<Requete> comp1 = new Comparator<Requete>() {
	        @Override
	        public int compare(Requete requete, Requete t1) {
	            if(getEtat() == "montant" ){
	                if(requete.getRequeteEtage().getNumEtage() < t1.getRequeteEtage().getNumEtage())
	                    return -1;
	            }
				if(getEtat() == "descendant"){
					if(requete.getRequeteEtage().getNumEtage() > t1.getRequeteEtage().getNumEtage())
						return 1;
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
			Collections.sort(this.requetes,comp1); //On trie les requï¿½tes
	    }
}
