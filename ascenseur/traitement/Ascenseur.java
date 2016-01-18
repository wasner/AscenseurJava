import java.util.*;

public class Ascenseur {

    private int nbEtagesDeservis;
   	private int nbPersonneMax;
    private Etage etageCourant;
    
    private int poidMax;
    private String etat; 					//immobileFerme, immobileOuvert, montant, descendant
	
    private boolean bloquer=false;					
   
    private List<Option> options=new LinkedList<Option>();	//liste des etages deservis. (exemple: 1,2,3,6,8,9)
    private List<Utilisateur> utilisateurs=new LinkedList<Utilisateur>();
    private List<Etage> etages=new LinkedList<Etage>();
    
    private List<Requete> requetes=new LinkedList<Requete>();
    
    
    public Ascenseur(int nbPersonneMax, int poidMax,
			List<Etage> etages) {
		super();
		this.nbEtagesDeservis = etages.size();
		this.nbPersonneMax = nbPersonneMax;
		this.poidMax = poidMax;
		this.etages = etages;
	}

    public Ascenseur() {
    }

    public void setEtageCourant(Etage etageCourant) {
		this.etageCourant = etageCourant;
	}
    
    public Etage getEtageCourant() {
		return etageCourant;
    }
    
    

    public List<Requete> getRequetes() {
		return requetes;
	}

	public String getEtat() {
		return etat;
	}
    
    public void setEtat(String etat) {
		this.etat = etat;
	}

	public void bloquer() {
    	bloquer=true;
    }

    public void debloquer() {
        bloquer=false;
    }
    
    public List<Etage> getEtages() {
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

    public void setRequetes(List<Requete> requetes) {
		this.requetes = requetes;
	}

	public void ajouterRequete(Requete requete) {
        requetes.add(requete);
    }

    public void creerRequeteInterne(Etage etage) {
    	RequeteInterne requete = new RequeteInterne(etage);
        ajouterRequete(requete);
    }    
    
    public void monter (){
    	int i =this.etageCourant.getNumEtage();
    	this.etageCourant.setNumEtage(i+1);		
	}
	
	public void descendre (){
		int i = this.etageCourant.getNumEtage();
		this.etageCourant.setNumEtage(i-1);
	}
    
	public boolean etatSuivantImmoFerme(){
    	if((requetes.size()==0) || (((requetes.get(0)).getEtage()).compareEtage(etageCourant))!=0){
			etat="immobileFerme";
			return true;//l'état suivant est ImmoFerme
    	}
    	return false;
    }
    
    
    public boolean etatSuivantImmoOuvert(){
    	if((requetes.size()!=0) && (((requetes.get(0)).getEtage()).compareEtage(etageCourant))==0){
    		etat="immobileOuvert";
    		for(int i=0;i<requetes.size();++i){
    			if((requetes.get(i).getEtage()).compareEtage(etageCourant)==0){
    				requetes.remove(i);
    			}
    		}
    		return true; //l'état suivant est ImmoOuvert
    	}
    	return false;
    }
    
    
    public boolean etatSuivantMontant(){
    	if((requetes.size()!=0) && (((requetes.get(0)).getEtage()).compareEtage(etageCourant))==1){
    		etat="montant";
    		System.out.println((requetes.get(0)).getEtage().getNumEtage());
    		monter();
    		return true;//l'état suivant est Montant
    	}
    	return false;
    }
    
    
    public boolean etatSuivantDescendant(){
    	if((requetes.size()!=0) && (((requetes.get(0)).getEtage()).compareEtage(
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

	 private Comparator<Requete> comparateurIntelligent = new Comparator<Requete>() {
	        @Override
	        public int compare(Requete requete, Requete requete1) {
                System.out.println("Etat de l'ascenseur : " + getEtat());
	            if(getEtat() == "montant" ){ //Si l'ascenseur monte et que
                    if(requete.getEtage().getNumEtage() > getEtageCourant().getNumEtage())//L'étage d'ou provient la requête est au dessus de l'étage ou se trouve l'ascenseur
                    {
                        if (requete1.getDirection() == "montant")//et que la personne veux monter
                            return -1; //Alors je le place au début de la liste
                        else
                            return 1; // Si la personne veux descendre, je la met dans la file d'attente
                    }
                    else // Si l'étage d'ou provient la requete est au dessous de l'étage de l'ascenseur et que
                    {
                        if (requete1.getDirection() == "descendant")// la personne veux descendre
                            return 1; //Je la met en file d'attente
                        else  //Si la personne veux monter
                            return 1; // je la met en file d'attente sinon sa obligerais l'ascenseur à descendre puis remonter
                    }
	            }// Sinon si l'ascenseur descend
				if(getEtat() == "descendant"){
                    if(requete.getEtage().getNumEtage() > getEtageCourant().getNumEtage())//L'étage d'ou provient la requête est au dessus de l'étage ou se trouve l'ascenseur
                    {
                        if (requete1.getDirection() == "montant")//et que la personne veux monter
                            return 1; //Alors je le place en file d'attente
                        else
                            return 1; // Si la personne veux descendre, je la met dans la file d'attente, sinon sa obligerais l'ascenseur à monter pour redescendre
                    }
                    else // Si l'étage d'ou provient la requete est au dessous de l'étage de l'ascenseur et que
                    {
                        if (requete1.getDirection() == "descendant")// la personne veux descendre
                            return -1; //Je la met en premier
                        else  //Si la personne veux monter
                            return 1; // je la met en file d'attente
                    }
				}
	                return 0;
	        }
	    };
    private Comparator<Requete> comparateurClassique = new Comparator<Requete>() {
        @Override
        public int compare(Requete requete1, Requete requete2) {
            if (getEtat() == "montant") { //Si l'ascenseur monte
                if (requete1.getEtage().getNumEtage() < getEtageCourant().getNumEtage()) //Que la requêtes est au dessous de la ou se trouve l'ascenseur
                    if (requete1.getEtage().getNumEtage() < requete2.getEtage().getNumEtage())//et que l'étage ou se trouve la première requête se trouve en dessous de la deuxième
                        return 1; //file d'attente
                    else
                        return -1; //Je la fais remonter
                else //Si la requête est au dessus d'ou se trouve l'ascenseur
                    if (requete1.getEtage().getNumEtage() < requete2.getEtage().getNumEtage()) //et que l'étage ou se trouve la 1er requete se trouve au dessous de la deuxième
                        return 1;
                    else
                        return -1;
            }
            if (getEtat() == "descendant") {
                if (requete1.getEtage().getNumEtage() < getEtageCourant().getNumEtage()) //Que la requêtes est au dessous de la ou se trouve l'ascenseur
                    if (requete1.getEtage().getNumEtage() < requete2.getEtage().getNumEtage())//et que l'étage ou se trouve la première requête se trouve en dessous de la deuxième
                        return -1; //Je la fais remonter
                    else
                        return 1; //file d'attente
                else //Si la requête est au dessus d'ou se trouve l'ascenseur
                    if (requete1.getEtage().getNumEtage() < requete2.getEtage().getNumEtage()) //et que l'étage ou se trouve la 1er requete se trouve au dessous de la deuxième
                        return -1;
                    else
                        return 1;
            }
            return 0;
        }
    };
    public void trieRequete(){
        Vector<Integer> etageDest = null;
        for(Requete re : requetes)
        {
            etageDest.add(re.getEtage().getNumEtage());
        }

    }


        public void triAppel() {
	        //Fonction triant les appels en attente
	        //remplissage d'un tableau avec les destinations des appels
	        /*for(Requete re : this.requetes)
	            //this.requetes.add(Requete.getRequeteEtage());
	            if(re.getEtage().compareEtage(this.getEtageCourant())!=0) //Si l'ï¿½tage ou se trouve l'ascenceur n'est pas l'ï¿½tage ou il y a une requï¿½te
	                this.requetes.add(re);//On ajoute l'ï¿½tage ou il y a une requï¿½te dans la file d'attente

	        *///Algorithme de tri du precedent tableau
			Collections.sort(this.requetes, comparateurClassique); //On trie les requï¿½tes
	    }
}
