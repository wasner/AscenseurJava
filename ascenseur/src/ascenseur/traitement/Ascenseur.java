package ascenseur.traitement;

import java.util.*;

public class Ascenseur {

    private int nbEtagesDeservis;
   	private int nbPersonneMax;
    private Etage etageCourant;
    
    private int poidMax;
    private String etat; 					//immobileFerme, immobileOuvert, montant, descendant
	
    private boolean bloquer=false;					
   
    private LinkedList<Option> options=new LinkedList<Option>();	//liste des etages deservis. (exemple: 1,2,3,6,8,9)
    private LinkedList<Utilisateur> utilisateurs=new LinkedList<Utilisateur>();
    private LinkedList<Etage> etages=new LinkedList<Etage>();
    
    private LinkedList<Requete> requetes=new LinkedList<Requete>();
    
    public Ascenseur(int PoidM, int nbPersM,Etage etages[]) {
    	etat="immobileFermer";
    	poidMax=PoidM;
    	nbPersonneMax=nbPersM;
    	nbEtagesDeservis=etages.length;	
    }
    
    public void setEtageCourant(Etage etageCourant) {
		this.etageCourant = etageCourant;
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
    
    public LinkedList<Etage> getEtages() {
		return etages;
	}

	public void setEtages(LinkedList<Etage> etages) {
		this.etages = etages;
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
    
    private void monter (){
    	int i =this.etageCourant.getNumEtage();
    	this.etageCourant.setNumEtage(i+1);		
	}
	
	private void descendre (){
		int i = this.etageCourant.getNumEtage();
		this.etageCourant.setNumEtage(i+1);
	}
    
	private boolean etatSuivantImmoFerme(){
    	if((requetes.size()==0) || (((requetes.getFirst()).getRequeteEtage()).compareEtage(etageCourant))!=0){
			etat="immobileFerme";
			return true;//l'état suivant est ImmoFerme
    	}
    	return false;
    }
    
    
    private boolean etatSuivantImmoOuvert(){
    	if((requetes.size()!=0) && (((requetes.getFirst()).getRequeteEtage()).compareEtage(etageCourant))==0){
    		etat="immobileOuvert";
    		for(int i=0;i<requetes.size();++i){
    			if((requetes.get(i).getRequeteEtage()).compareEtage(etageCourant)==0){
    				requetes.remove(i);
    			}
    		}
    		return true; //l'état suivant est ImmoOuvert
    	}
    	return false;
    }
    
    
    private boolean etatSuivantMontant(){
    	if((requetes.size()!=0) && (((requetes.getFirst()).getRequeteEtage()).compareEtage(etageCourant))==1){
    		etat="montant";
    		monter();
    		return true;//l'état suivant est Montant
    	}
    	return false;
    }
    
    
    private boolean etatSuivantDescendant(){
    	if((requetes.size()!=0) && (((requetes.getFirst()).getRequeteEtage()).compareEtage(
    			etageCourant))==-1){
    		etat="descendant";
    		descendre();//l'état suivant est Descendant
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
