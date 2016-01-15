import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import ascenseur.traitement.Ascenseur;
import ascenseur.traitement.Etage;
import ascenseur.traitement.Requete;
import ascenseur.traitement.RequeteInterne;


public class TestAscenseur {

	@Test
	public static void testMonterDescendre() {

		Etage etage0=new Etage(-2);
		Etage etage1=new Etage(-1);
		Etage etage2=new Etage(0);
		Etage etage3=new Etage(1);
		Etage etage4=new Etage(2);
		Etage etage5=new Etage(3);
		
		List<Etage> etages=new LinkedList<Etage>();
		
		etages.add(etage0);
		etages.add(etage1);
		etages.add(etage2);
		etages.add(etage3);
		etages.add(etage4);
		etages.add(etage5);
		
		Ascenseur ascenseur1 =new Ascenseur(600, 3, etages );
		
		ascenseur1.setEtageCourant(etage2);
		
		
		
		Etage etageCourant=ascenseur1.getEtageCourant();
		
		Etage etageArriveMonte=new Etage(1);
		Etage etageArriveDesc=new Etage(0);
		
		ascenseur1.monter();
		
		if(ascenseur1.getEtageCourant().compareEtage(etageArriveMonte)==0){
			System.out.println(true);
			System.out.println(etageArriveMonte.getNumEtage());
		}
		else{
			System.out.println(ascenseur1.getEtageCourant().getNumEtage());
			System.out.println(etageArriveMonte.getNumEtage());
			System.out.println(false);
		}
		
		ascenseur1.descendre();
		
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
	public static void testEtatSuivant() {
		
		Etage etage0=new Etage(-2);
		Etage etage1=new Etage(-1);
		Etage etage2=new Etage(0);
		Etage etage3=new Etage(1);
		Etage etage4=new Etage(2);
		Etage etage5=new Etage(3);
		
		List<Etage> etages=new LinkedList<Etage>();
		
		etages.add(etage0);
		etages.add(etage1);
		etages.add(etage2);
		etages.add(etage3);
		etages.add(etage4);
		etages.add(etage5);
		
		Ascenseur ascenseur1 =new Ascenseur(600, 3, etages );
		
		Requete requete1 = new RequeteInterne(etage3);
		Requete requete2 = new RequeteInterne(etage4);
		Requete requete3 = new RequeteInterne(etage5);
		
		ascenseur1.ajouterRequete(requete1);
		ascenseur1.ajouterRequete(requete2);
		ascenseur1.ajouterRequete(requete3);
		
		
		ascenseur1.setEtageCourant(etage2);
		Etage etageCourant=ascenseur1.getEtageCourant();
	
		String etatAttendu="montant";
		
		System.out.println(ascenseur1.etatSuivantMontant());
		
		String etat=ascenseur1.getEtat();
		
		if(etat==etatAttendu){
			System.out.println(etat);
			System.out.println("etatSuivant Montant ");
		}
		else{
			System.out.println("false");
			System.out.println(etat);
			System.out.println(etatAttendu);
		}
		ascenseur1.getEtageCourant();
		
		ascenseur1.etatSuivantImmoOuvert();
		
		System.out.println(ascenseur1.etatSuivantImmoOuvert());
		String etatAttendu2="immobileOuvert";
		String etat2=ascenseur1.getEtat();
		for (Requete r:ascenseur1.getRequetes())
			System.out.println(r.getRequeteEtage().getNumEtage());
		
		if(etat2==etatAttendu2){
			System.out.println(etat2);
			for (Requete r:ascenseur1.getRequetes())
				System.out.println(r.getRequeteEtage().getNumEtage());
		}
		else{
			System.out.println("false");
			System.out.println(etat2);
			System.out.println(etatAttendu2);
		}

	}
	
	
	public static void main(String[] args) {
		//testMonterDescendre();
		testEtatSuivant();
    }

}
