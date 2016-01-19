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

	/**
	 * Constructeur de l'ascenseur
	 * @param num numéros d'ascenseur
	 * @param PoidM poids maximum
	 * @param nbPersM nombres de personnes maximum
	 * @param etages etages qu'il déssert
	 */
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

	/**
	 * Fonction permettant d'ajouter une vue pour l'ascenseur
	 * @param vue vue de l'ascenseur
	 */
    public void addVue(VueAscenseur vue)
    {
    	vueAscenseur.add(vue);
    }

	/**
	 * fonction toString qui permet d'affichez proprement le numéros de l'ascenseur, le poids maximum et le nombres d'étages déservie
	 * @return une phrase contenant les informations sur l'ascenseur
	 */
    public String toString()
    {
    	return "Num : " + this.num + " " + "Poids maximum : " +Integer.toString(this.poidMax)+ " " +
    	        "Nombre d'etages deservit : " + Integer.toString(this.nbEtagesDeservis);
    }

	/**
	 * fonction qui permet de savoir le nombres d'étages
	 * @return le nombres d'étages
	 */
    public int getNombreEtage()
    {
		return this.nombreEtages;
    	
    }

	/**
	 * retourne le numéro de l'ascenseur
	 * @return (int) numéros de l'ascenseur
	 */
    public int getNum() {
		// TODO Auto-generated method stub
		return this.num;
	}

	/**
	 * permet de choisir a qu'elle étage se trouve l'ascenseur
	 * @param etageCourant l'étage ou se trouve l'ascenseur
	 */
    public void setEtageCourant(Etage etageCourant) {
		this.etageCourant = etageCourant;
		for(VueAscenseur vue : vueAscenseur){
			vue.miseAJour();
		}
	}

	/**
	 * permet de connaitre l'étage ou se trouve l'ascenseur
	 * @return l'étage courant de l'ascenseur
	 */
    public Etage getEtageCourant() {
		return etageCourant;
    }

	/**
	 * permet de connaitre l'état de l'ascenseur
	 * @return String (immobileFerme, immobileOuvert, montant, descendant)
	 */
    public String getEtat() {
		return etat;
	}

	/**
	 * permet de bloquer l'ascenseur
	 */
    public void bloquer() {
    	bloquer=true;
    }

	/**
	 * permet de débloquer l'ascenseur
	 */
    public void debloquer() {
        bloquer=false;
    }

	/**
	 * permet d'avoir la liste des étages que désert l'ascenseur
	 * @return list d'étage contenant les différents étages
	 */
	public List<Etage> getEtages() {
		return etages;
	}

	/**
	 * permet de fixer le nombres de personnes max dans l'ascenseur
	 * @param personneMax le nombres de personnes maximum qu'accepte l'ascenseur
	 */
	public void setPersonneMax(int personneMax)
    {
    	this.nbPersonneMax = personneMax;
    }

	/**
	 * permet de définir le poids maximum accepter dans l'ascenseur
	 * @param poidMax poids maximum qu'accepte l'ascenseur
	 */
    public void setPoidMax(int poidMax)
    {
    	this.poidMax = poidMax;
    }

	/**
	 * permet de retourner le poids total accepter pour un ascenseur
	 * @return le poids maximum accepter dans un ascenseur
	 */
    public int getPoidMax()
    {
    	return this.poidMax;
    }

	/**
	 * permet de retourner le nombres de personnes max dans un ascenseur
	 * @return nbPersonneMax
	 */
    public int getPersonneMax()
    {
    	return this.nbPersonneMax;
    }

	/**
	 * permet de fixer la liste des étages que désert l'ascenseur
	 * @param etages liste des étages que dessert l'ascenseur
	 */
    public void setEtages(List<Etage> etages) {
    	
		this.etages = etages;
		this.nombreEtages = this.etages.size();
	}

	/**
	 * permet de retourner la liste des requêtes affecté à un ascenseur
	 * @return liste de requêtes
	 */
	public List<Requete> getRequetes() {
		return requetes;
	}

	/**
	 * permet de fixer la liste des requêtes à un ascenseur
	 * @param requetes liste des requêtes attribué à un ascenseur
	 */
	public void setRequetes(List<Requete> requetes) {
		this.requetes = requetes;
	}

	/**
	 * permet d'ajouter des requêtes à un ascenseur
	 * @param requete une requête pour un ascenseur
	 */
	public void ajouterRequete(Requete requete) {
        requetes.add(requete);
    }

	/**
	 * permet de créer des requêtes interne à l'ascenseur
	 * @param etage requête interne à un ascenseur
	 */
    public void creerRequeteInterne(Etage etage) {
    	RequeteInterne requete = new RequeteInterne(etage);
        ajouterRequete(requete);
    }

	/**
	 * permet de faire monter l'ascenseur d'un étage
	 */
    public void monter (){
    	setEtageCourant(new Etage(etageCourant.getNumEtage()+1));	
	}

	/**
	 * permet de faire descendre l'ascenseur d'un étage
	 */
    public void descendre (){
		setEtageCourant(new Etage(etageCourant.getNumEtage()-1));
	}

	/**
	 * permet de fixer le prochaine état de l'ascenseur à immobile et porte fermé
	 * @return true si il y a plus de requêtes pour cette étage false sinon
	 */
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

	/**
	 * permet de fixer le prochaine état de l'ascenseur à immobile et porte ouverte
	 * @return true si il reste des requêtes à satisfaire false sinon
	 */
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

	/**
	 * permet de fixer l'état suivant de l'ascenseur à montant
	 * @return S'il y a des requêtes et que c'est requête proviennent de plus haut return true; false sinon
	 */
    public boolean etatSuivantMontant(){
    	if((requetes.size()!=0) && (((requetes.get(0)).getEtage()).compareEtage(etageCourant))==1){
    		etat="montant";
    		monter();
    		return true;//l'Ã©tat suivant est Montant
    	}
    	return false;
    }

	/**
	 * permet de fixer l'état de l'ascenseur à descendant
	 * @return s'il y a des requêtes et que c'est requêtes proviennent de plus bas return true; false sinon
	 */
    public boolean etatSuivantDescendant(){
    	if((requetes.size()!=0) && (((requetes.get(0)).getEtage()).compareEtage(
    			etageCourant))==-1){
    		etat="descendant";
    		descendre();//l'Ã©tat suivant est Descendant
    		return true;
    	}
    	return false;
    }

	/**
	 * permet de définir l'action de l'ascenseur, si celui-ci n'est pas bloquer
	 * @return dépends de la situation, soit immobileOuvert, immobileFerme, descendant, montant
	 */
	public String action() {
		if (bloquer==false){
	        if(etatSuivantImmoOuvert()){}
	        else if (etatSuivantImmoFerme()){}
	        else if(etatSuivantDescendant()){}
	        else if(etatSuivantMontant()){}
		}
        return etat;
    }

	/**
	 * permet de triées les requêtes attribuées à un ascenseur
	 */
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
				else if(o1.getEtage().getNumEtage()==o2.getEtage().getNumEtage()) //on supprime la requete
					return 0;
					
				}
				if(etat=="descendant" && etageCourant.getNumEtage()>o1.getEtage().getNumEtage()){ //Si l'ascenseur descend et que l'étage ou se trouve l'ascenseur est au dessus de l'étage de la première requete
					if(o1.getEtage().getNumEtage()<o2.getEtage().getNumEtage()) //Si l'étage de la première requête est en dessous de l'étage de la seconde alors on laisse l'ordre tel quel
						return 1;
					else if (o1.getEtage().getNumEtage()>o2.getEtage().getNumEtage())//Si l'étage de la première requête est au dessus de l'étage de la deuxième alors on change l'ordre
						return -1;
					else if(o1.getEtage().getNumEtage()==o2.getEtage().getNumEtage()) //Si les deux étages sont pareil alors on supprime la requête
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

	/**
	 * permet de savoir si l'ascenseur est bloquer ou non
	 * @return la variable contenant true si l'ascenseur est bloqué, false sinon
	 */
		@Override
		public boolean isBloquer() {
			// TODO Auto-generated method stub
			return bloquer;
		}
}
