import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;


import ascenseur.traitement.Ascenseur;
import ascenseur.traitement.Etage;
import ascenseur.traitement.Requete;
import ascenseur.traitement.RequeteInterne;
import ascenseur.traitement.RequeteExterne;


public class TestAscenseur {
	
	

    @Test
    public static void testMonterDescendre() { //valid�

        Etage etage02=new Etage(-2);
        Etage etage01=new Etage(-1); //creation des Etages
        Etage etage0=new Etage(0);
        Etage etage1=new Etage(1);
        Etage etage2=new Etage(2);
        Etage etage3=new Etage(3);

        List<Etage> etages=new LinkedList<Etage>();

        etages.add(etage02);
        etages.add(etage01);
        etages.add(etage0);
        etages.add(etage1);
        etages.add(etage2);	//on ajoute ces Etages dans la liste
        etages.add(etage3);
        

        Ascenseur ascenseur1 =new Ascenseur(600, 3, etages );//creation d'un Ascenseur

        ascenseur1.setEtageCourant(etage2);	//d�finition de l'�tage courant



        Etage etageCourant=ascenseur1.getEtageCourant();//affectation d'une variable local etageCourant qui prend comme valeur celle de l'objet ascenseur1

        Etage etageArriveMonte=new Etage(3);	//resultat attendu apr�s la mont�
        
        System.out.println("monter");
        ascenseur1.monter();		//l'acsenseur monte

        if(ascenseur1.getEtageCourant().compareEtage(etageArriveMonte)==0){
            System.out.println(true);
            //System.out.println(etageArriveMonte.getNumEtage());
        }
        else{
            System.out.println(ascenseur1.getEtageCourant().getNumEtage());
            System.out.println(etageArriveMonte.getNumEtage());
            System.out.println(false);
        }
        
        Etage etageArriveDesc=new Etage(2);		//r�sultat attendu apr�s la descente

        
        System.out.println("descend");
        ascenseur1.descendre(); //l'ascenseur descend

        if(ascenseur1.getEtageCourant().compareEtage(etageArriveDesc)==0){
            System.out.println(true);

        }
        else{
            System.out.println(ascenseur1.getEtageCourant().getNumEtage());
            System.out.println(etageArriveDesc.getNumEtage());
            System.out.println(false);
        }
    }
    
    
    

    @Test
    public static void testEtatSuivant() {//valide

    	 Etage etage02=new Etage(-2);
         Etage etage01=new Etage(-1); //creation des Etages
         Etage etage0=new Etage(0);
         Etage etage1=new Etage(1);
         Etage etage2=new Etage(2);
         Etage etage3=new Etage(3);
         Etage etage4=new Etage(4);

         List<Etage> etages=new LinkedList<Etage>();

         etages.add(etage02);
         etages.add(etage01);
         etages.add(etage0);
         etages.add(etage1);
         etages.add(etage2);	//on ajoute ces Etages dans la liste
         etages.add(etage3);
         etages.add(etage4);

        Ascenseur ascenseur1 =new Ascenseur(600, 3, etages );

        Requete requete1 = new RequeteInterne(etage3); //nouvelle Requete etage 3
        Requete requete2 = new RequeteInterne(etage4);
        Requete requete3 = new RequeteInterne(etage02);
       

        ascenseur1.ajouterRequete(requete1);	// on l'ajoute � une list
        ascenseur1.ajouterRequete(requete2);

        ascenseur1.setEtageCourant(etage2);
       
        Etage etageCourant=ascenseur1.getEtageCourant();//etage courant = 2
        
      //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        String etatAttendu="montant";		//resultat attendu
        
        System.out.println("valeur etatSuivantMontant");		//suivantMontant

        
        System.out.print("descendant: ");
        System.out.println(ascenseur1.etatSuivantDescendant());
        System.out.print("ouvert: ");
        System.out.println(ascenseur1.etatSuivantImmoOuvert());
        System.out.print("ferme: ");
        System.out.println(ascenseur1.etatSuivantImmoFerme());
        System.out.print("montant: ");
        System.out.println(ascenseur1.etatSuivantMontant());
        
              
        ascenseur1.etatSuivantMontant();

        
        
        String etat=ascenseur1.getEtat();

        if(etat==etatAttendu){
            //System.out.println(etat);
            //System.out.println("etatSuivant Montant ");
        }
        else{
            System.out.println("false");
            System.out.println(etat);
            System.out.println(etatAttendu);
        }
       
      //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        etageCourant=ascenseur1.getEtageCourant();

        System.out.println("valeur etatsuivantImmoOUvert");		//immoOuvert
        
        
        System.out.print("montant: ");
        System.out.println(ascenseur1.etatSuivantMontant());
        System.out.print("descendant: ");
        System.out.println(ascenseur1.etatSuivantDescendant());
        System.out.print("ferme: ");
        System.out.println(ascenseur1.etatSuivantImmoFerme());
        System.out.print("ouvert: ");
        System.out.println(ascenseur1.etatSuivantImmoOuvert());
        
        etatAttendu="immobileOuvert";
        
        ascenseur1.etatSuivantImmoOuvert();
        
        
        etat=ascenseur1.getEtat();
        for (Requete r:ascenseur1.getRequetes())
            //System.out.println(r.getRequeteEtage().getNumEtage());

        if(etat==etatAttendu){
           // System.out.println(etat);
        }
        
        else{
            System.out.println("false");
            System.out.println(etat);
            System.out.println(etatAttendu);
        }
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        ascenseur1.etatSuivantMontant();		//on vide la list de Requete
        ascenseur1.etatSuivantImmoOuvert();
        
      //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        etageCourant=ascenseur1.getEtageCourant();

        System.out.println("valeur etatsuivantImmoFerme");		//immoFerme
        
        
        System.out.print("montant: ");
        System.out.println(ascenseur1.etatSuivantMontant());
        System.out.print("descendant: ");
        System.out.println(ascenseur1.etatSuivantDescendant());
        System.out.print("ouvert: ");
        System.out.println(ascenseur1.etatSuivantImmoOuvert());
        System.out.print("ferme: ");
        System.out.println(ascenseur1.etatSuivantImmoFerme());
        
        ascenseur1.etatSuivantImmoFerme();
        
        etatAttendu="immobileFerme";    
        
        etat=ascenseur1.getEtat();
        
        
        if(etat==etatAttendu){
        	//System.out.println(etat);
        }
        else{
        	System.out.printf("etat",etat);
        	System.out.printf("etatattendu",etatAttendu);
        }
        
      //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        ascenseur1.ajouterRequete(requete3);
       
        etageCourant=ascenseur1.getEtageCourant();
        //System.out.println(ascenseur1.getEtageCourant().getNumEtage());

        System.out.println("valeur etatsuivantDescendant");		//Suivant descendant
        
        
        System.out.print("montant: ");
        System.out.println(ascenseur1.etatSuivantMontant());
        System.out.print("ouvert: ");
        System.out.println(ascenseur1.etatSuivantImmoOuvert());
        System.out.print("ferme: ");
        System.out.println(ascenseur1.etatSuivantImmoFerme());
        System.out.print("descendant: ");
        System.out.println(ascenseur1.etatSuivantDescendant());
        
        
        ascenseur1.etatSuivantDescendant();
        
        
        for (Requete r:ascenseur1.getRequetes())
            //System.out.println(r.getRequeteEtage().getNumEtage());
        
        etatAttendu="descendant";    
        
        etat=ascenseur1.getEtat();
        
        
        if(etat==etatAttendu){
        	//System.out.println(etat);
        }
        else{
        	System.out.println(etat);
        	System.out.println(etatAttendu);
        }
        
    }
    
    @Test
    public static void testAction() {
    	
    	Etage etage02=new Etage(-2);
        Etage etage01=new Etage(-1); //creation des Etages
        Etage etage0=new Etage(0);
        Etage etage1=new Etage(1);
        Etage etage2=new Etage(2);
        Etage etage3=new Etage(3);
        Etage etage4=new Etage(4);

        List<Etage> etages=new LinkedList<Etage>();

        etages.add(etage02);
        etages.add(etage01);
        etages.add(etage0);
        etages.add(etage1);
        etages.add(etage2);	//on ajoute ces Etages dans la liste
        etages.add(etage3);
        etages.add(etage4);

       Ascenseur ascenseur1 =new Ascenseur(600, 3, etages );

       Requete requete1 = new RequeteInterne(etage3); //nouvelle Requete etage 3
       Requete requete2 = new RequeteInterne(etage4);
       Requete requete3 = new RequeteInterne(etage02);
      

       ascenseur1.ajouterRequete(requete1);	// on l'ajoute � une list
       ascenseur1.ajouterRequete(requete2);
       ascenseur1.ajouterRequete(requete3);

       ascenseur1.setEtageCourant(etage2);
       Etage etageCourant=ascenseur1.getEtageCourant();//etage courant = 2
       
      // for (Requete r:ascenseur1.getRequetes())
        //   System.out.println(r.getRequeteEtage().getNumEtage());
       
       System.out.println("3 requetes");
       System.out.println("3,4,-2");
       
       for(int i=0;i<15;++i){
    	   System.out.println();
    	   System.out.print("Etage actuel: ");
    	   System.out.println(ascenseur1.getEtageCourant().getNumEtage());
    	   System.out.println(ascenseur1.action());
    	   System.out.print("Etage actuel: ");
    	   System.out.println(ascenseur1.getEtageCourant().getNumEtage());
           
       }
       
    }
    
    @Test
    public static void testBloquerDebloquer() { //valid�
    	Etage etage02=new Etage(-2);
        Etage etage01=new Etage(-1); //creation des Etages
        Etage etage0=new Etage(0);
        Etage etage1=new Etage(1);
        Etage etage2=new Etage(2);
        Etage etage3=new Etage(3);
        Etage etage4=new Etage(4);

        List<Etage> etages=new LinkedList<Etage>();

        etages.add(etage02);
        etages.add(etage01);
        etages.add(etage0);
        etages.add(etage1);
        etages.add(etage2);	//on ajoute ces Etages dans la liste
        etages.add(etage3);
        etages.add(etage4);

       Ascenseur ascenseur1 =new Ascenseur(600, 3, etages );
       
       boolean bloquerTest=true;
       ascenseur1.bloquer();
       
       if (bloquerTest== ascenseur1.isBloquer()){
    	   System.out.println("true");
       }
       else{
    	   System.out.println("false");
       }
       
       ascenseur1.debloquer();
       bloquerTest=false;
       
       if (bloquerTest== ascenseur1.isBloquer()){
    	   System.out.println("true");
       }
       else{
    	   System.out.println("false");
       }
    }
    
    @Test
    public static void testTriAppel() {
    	
    	Etage etage02=new Etage(-2);
        Etage etage01=new Etage(-1); //creation des Etages
        Etage etage0=new Etage(0);
        Etage etage1=new Etage(1);
        Etage etage2=new Etage(2);
        Etage etage3=new Etage(3);
        Etage etage4=new Etage(4);
        Etage etage5=new Etage(5);

        List<Etage> etages=new LinkedList<Etage>();

        etages.add(etage02);
        etages.add(etage01);
        etages.add(etage0);
        etages.add(etage1);
        etages.add(etage2);	//on ajoute ces Etages dans la liste
        etages.add(etage3);
        etages.add(etage4);

       Ascenseur ascenseur1 =new Ascenseur(600, 3, etages );
       

       Requete requete1 = new RequeteInterne(etage3); //nouvelle Requete etage 3
       Requete requete2 = new RequeteInterne(etage4);
       Requete requete3 = new RequeteInterne(etage02);
       Requete requete4 = new RequeteExterne("descendant", etage5);
       Requete requete5 = new RequeteExterne("montant", etage3);
       
       
       										// on l'ajoute � une list
       ascenseur1.ajouterRequete(requete1);//3
       ascenseur1.ajouterRequete(requete4);//5
       ascenseur1.ajouterRequete(requete3);//-2
       ascenseur1.ajouterRequete(requete5);//3
       ascenseur1.ajouterRequete(requete2);//4
       

       ascenseur1.setEtageCourant(etage2);
       Etage etageCourant=ascenseur1.getEtageCourant();//etage courant = 2
       System.out.println("etage courant: "+ etageCourant.getNumEtage());
       
       ascenseur1.setEtat("montant");
       
       for (Requete r:ascenseur1.getRequetes()){
    	   System.out.print(r.getRequeteEtage().getNumEtage());
           System.out.print(" . ");
       }
       
       System.out.println();
       System.out.println("appel de la fonction: ");
       
       ascenseur1.triAppel();
       
       for (Requete r:ascenseur1.getRequetes())
       {
    	   System.out.print(r.getRequeteEtage().getNumEtage());
           System.out.print(" . ");
       }
       
       System.out.println();
       System.out.println("resultat attendu: 3 4 5 -2");
       
       Ascenseur ascenseur2 =new Ascenseur(600, 3, etages );
       ascenseur2.setEtageCourant(etage1);
       ascenseur2.setEtat("descendant");
       
       
       Requete requete21 = new RequeteInterne(etage02); //nouvelle Requete etage 3
       Requete requete22 = new RequeteInterne(etage4);
       Requete requete23 = new RequeteInterne(etage01);
       Requete requete24 = new RequeteExterne("descendant", etage3);
       Requete requete25 = new RequeteExterne("descendant", etage0);
       
       
       										// on l'ajoute � une list
       ascenseur2.ajouterRequete(requete21);//-2
       ascenseur2.ajouterRequete(requete24);//3
       ascenseur2.ajouterRequete(requete23);//-1
       ascenseur2.ajouterRequete(requete25);//0
       ascenseur2.ajouterRequete(requete22);//4
       
       etageCourant=ascenseur1.getEtageCourant();//etage courant = 2
       System.out.println("etage courant: "+ etageCourant.getNumEtage());
       
       
       for (Requete r:ascenseur2.getRequetes()){
    	   System.out.print(r.getRequeteEtage().getNumEtage());
           System.out.print(" . ");
       }
       
       System.out.println();
       System.out.println("appel de la fonction: ");
       
       ascenseur2.triAppel();
       
       for (Requete r:ascenseur2.getRequetes())
       {
    	   System.out.print(r.getRequeteEtage().getNumEtage());
           System.out.print(" . ");
       }
       
       System.out.println();
       System.out.println("resultat attendu: 0 -1 -2 3 4");
    	
    }

    public static void main(String[] args) {
    	//System.out.println("test monter/descendre: ");
       // testMonterDescendre();
        //System.out.println("\ntest EtatSuivant: ");
        //testEtatSuivant();
       //System.out.println("\ntest Action: ");
       //testAction();
    	//System.out.println("\ntest Bloquer/Debloquer: ");
    	//testBloquerDebloquer();
    	System.out.println("testTriappel: ");
    	testTriAppel();
    }

}
