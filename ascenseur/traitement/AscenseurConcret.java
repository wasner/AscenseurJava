package traitement;
import java.util.*;
import affichage.VueAscenseur;
public class AscenseurConcret implements Ascenseur{
	private int num;
    private int nbEtagesDeservis;
    private int nombreEtages;
   	private int nbPersonneMax;
    private Etage etageCourant;
    
    private int poidMax;
    private String etat; 					//immobileFerme, immobileOuvert, montant, descendant
	
    private boolean bloquer=false;					
   
    private List<Option> options=new LinkedList<Option>();	//liste des etages deservis. (exemple: 1,2,3,6,8,9)
    private List<Utilisateur> utilisateurs=new LinkedList<Utilisateur>();
    private List<Etage> etages=new LinkedList<Etage>();
    
    private List<VueAscenseur> vueAscenseur = new LinkedList<VueAscenseur>();
    
    private List<Requete> requetes=new LinkedList<Requete>();
    
    public AscenseurConcret(int num, int PoidM, int nbPersM,List<Etage> etages) {
    	//New
    	this.num = num;
    	this.etages = etages;
    	this.nombreEtages = etages.size();
    	//Fin New
    	this.etat="immobileFermer";
    	poidMax=PoidM;
    	nbPersonneMax=nbPersM;
    	nbEtagesDeservis=etages.size();	
    }
    
    //NEW
    public void addVue(VueAscenseur vue)
    {
    	vueAscenseur.add(vue);
    }
    
    
    public String toString()
    {
    	return "Num : " + this.num + " " + "Poids maximum : " +Integer.toString(this.poidMax)+ " " +
    	        "Nombre d'etages deservit : " + Integer.toString(this.nbEtagesDeservis);
    }
    
    public int getNombreEtage()
    {
		return this.nombreEtages;
    	
    }
    
    public int getNum() {
		// TODO Auto-generated method stub
		return this.num;
	}
    
    //Fin NEW
    
    public void setEtageCourant(Etage etageCourant) {
		this.etageCourant = etageCourant;
		for(VueAscenseur vue : vueAscenseur){
			vue.miseAJour();
		}
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
    
    
	public List<Etage> getEtages() {
		return etages;
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
    
    public void setEtages(List<Etage> etages) {
    	
		this.etages = etages;
		this.nombreEtages = this.etages.size();
	}
	public List<Requete> getRequetes() {
		return requetes;
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
    	setEtageCourant(new Etage(etageCourant.getNumEtage()+1));	
	}
	
    public void descendre (){
		setEtageCourant(new Etage(etageCourant.getNumEtage()-1));
	}
    
    public boolean etatSuivantImmoFerme(){
    	if((requetes.size()==0) || ((((requetes.get(0))).getEtage()).compareEtage(etageCourant)!=0)&&etat=="immobileOuvert"){
			etat="immobileFerme";
			for(VueAscenseur vue : vueAscenseur){
				vue.miseAJour();
			}
			return true;//l'Ã©tat suivant est ImmoFerme
    	}
    	return false;
    }
    
    
    public boolean etatSuivantImmoOuvert(){
    	if((requetes.size()!=0) && (((requetes.get(0)).getEtage()).compareEtage(etageCourant))==0){
    		etat="immobileOuvert";
    		for(int i=0;i<requetes.size();++i){
    			if((requetes.get(i).getEtage()).compareEtage(etageCourant)==0){
    				requetes.remove(i);
    				System.out.println(i);
    				 //l'Ã©tat suivant est ImmoOuvert
    			}
    			for(VueAscenseur vue : vueAscenseur){
    				vue.miseAJour();
    			}
    			
    		}
    		return true;
    		
    		
    		
    	}
    	return false;
    }
    
    
    public boolean etatSuivantMontant(){
    	if((requetes.size()!=0) && (((requetes.get(0)).getEtage()).compareEtage(etageCourant))==1){
    		etat="montant";
    		monter();
    		return true;//l'Ã©tat suivant est Montant
    	}
    	return false;
    }
    
    
    public boolean etatSuivantDescendant(){
    	if((requetes.size()!=0) && (((requetes.get(0)).getEtage()).compareEtage(
    			etageCourant))==-1){
    		etat="descendant";
    		descendre();//l'Ã©tat suivant est Descendant
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
	public void triAppel() {
        Set<Requete> reqtri = new TreeSet<Requete>(new Comparator<Requete>() {
			@Override
			public int compare(Requete o1, Requete o2) {
				// TODO Auto-generated method stub
				if(etat=="montant" && etageCourant.getNumEtage()<o1.getEtage().getNumEtage()){ //Si l'ascenseur monte et que l'étage ou se trouve l'ascenseur est en dessous de l'étage de la requete
					if(o1.getEtage().getNumEtage()<o2.getEtage().getNumEtage())//Si la première requête est a un étage inférieure, on laplace avant
						return -1;
				else if (o1.getEtage().getNumEtage()>o2.getEtage().getNumEtage())//Sinon si l'étage de la première requête est au dessus de la deuxième, alors on laisse comme c'était
					return 1;
				else if(o1.getEtage().getNumEtage()==o2.getEtage().getNumEtage()) //Si les deux requêtes ont comme destination les mêmes étages alors on les laisse tel quel
					return 0;
					
				}
				if(etat=="descendant" && etageCourant.getNumEtage()>o1.getEtage().getNumEtage()){ //Si l'ascenseur descend et que l'étage ou se trouve l'ascenseur est au dessus de l'étage de la première requete
					if(o1.getEtage().getNumEtage()<o2.getEtage().getNumEtage()) //Si l'étage de la première requête est en dessous de l'étage de la seconde alors on laisse l'ordre tel quel
						return 1;
					else if (o1.getEtage().getNumEtage()>o2.getEtage().getNumEtage())//Si l'étage de la première requête est au dessus de l'étage de la deuxième alors on change l'ordre
						return -1;
					else if(o1.getEtage().getNumEtage()==o2.getEtage().getNumEtage()) //Si les deux étages sont pareil alors on ne touche rien
						return 0;	
				}
				return 1;
			}
		});
        reqtri.addAll(requetes); //On replace toutes les requêtes triées dans la liste des requêtes triées
        requetes =new LinkedList<Requete>(); //On créer une linkedlist de requête (c'est la liste qui va contenir les requêtes pour un ascenseur
        for(Requete re :reqtri){
        	requetes.add(re);//On ajoute dans l'ordre triée les différentes requêtes assigner à un ascenseur.
        }
        
    }

		@Override
		public boolean isBloquer() {
			// TODO Auto-generated method stub
			return bloquer;
		}
}
