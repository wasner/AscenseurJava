import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import ascenseur.traitement.Ascenseur;
import ascenseur.traitement.Controleur;
import ascenseur.traitement.Etage;
import ascenseur.traitement.Requete;
import ascenseur.traitement.RequeteExterne;

public class TestControleur {
	
	@Test
    public static void testChoisirAscenseur() {
		
		Etage etage03=new Etage(-3);
		Etage etage02=new Etage(-2);
	    Etage etage01=new Etage(-1); //creation des Etages
	    Etage etage0=new Etage(0);
	    Etage etage1=new Etage(1);
	    Etage etage2=new Etage(2);
	    Etage etage3=new Etage(3);
	    Etage etage4=new Etage(4);
	    Etage etage5=new Etage(5);

	    List<Etage> etages=new LinkedList<Etage>();
	    
	    etages.add(etage03);
	    etages.add(etage02);
	    etages.add(etage01);
	    etages.add(etage0);
	    etages.add(etage1);
	    etages.add(etage2);	//on ajoute ces Etages dans la liste
	    etages.add(etage3);
	    etages.add(etage4);
	    //System.out.println(etages.size());
	   Ascenseur ascenseur1 =new Ascenseur(600, 3, etages );
	   Ascenseur ascenseur2 =new Ascenseur(600, 3, etages );
	   Ascenseur ascenseur3 =new Ascenseur(600, 3, etages );
	   Ascenseur ascenseur4 =new Ascenseur(600, 3, etages );
	   //System.out.println(ascenseur1.getEtages().size());
	   ascenseur1.setEtat("montant");
	   ascenseur1.setEtageCourant(etage03);
	   
	   ascenseur2.setEtat("montant");
	   ascenseur2.setEtageCourant(etage2);
	   
	   ascenseur3.setEtat("descendant");
	   ascenseur3.setEtageCourant(etage5);
	   
	   ascenseur4.setEtat("descendant");
	   ascenseur4.setEtageCourant(etage2);
	   
	   List<Ascenseur> ascenseurs = new LinkedList<Ascenseur>();	   
	   
	   ascenseurs.add(ascenseur1);
	   ascenseurs.add(ascenseur2);
	   ascenseurs.add(ascenseur3);
	   ascenseurs.add(ascenseur4);
	   
	   Controleur controleur = new Controleur(ascenseurs);
	   
	   controleur.creerRequeteExterne(etage0, "montant");
	   controleur.choisirAscenseur();
	   
	   controleur.creerRequeteExterne(etage02, "montant");
	   controleur.choisirAscenseur();
	   
	   controleur.creerRequeteExterne(etage3, "montant");
	   controleur.choisirAscenseur();
	   
	   controleur.creerRequeteExterne(etage0, "descendant");
	   controleur.choisirAscenseur();
	   
	   controleur.creerRequeteExterne(etage3, "descendant");
	   controleur.choisirAscenseur();
	   
	   controleur.creerRequeteExterne(etage01, "descendant");
	   controleur.choisirAscenseur();
	   
	   System.out.println("\nAscenseur1 :");
	   for (Requete r:ascenseur1.getRequetes()){
    	   System.out.print(r.getRequeteEtage().getNumEtage()+ " ");
	   }
	   System.out.println("\nAscenseur2 :");
	   for (Requete r:ascenseur2.getRequetes()){
    	   System.out.print(r.getRequeteEtage().getNumEtage()+ " ");
	   }
	   System.out.println("\nAscenseur3 :");
	   for (Requete r:ascenseur3.getRequetes()){
    	   System.out.print(r.getRequeteEtage().getNumEtage()+ " ");
	   }
	   System.out.println("\nAscenseur4 :");
	   for (Requete r:ascenseur4.getRequetes()){
    	   System.out.print(r.getRequeteEtage().getNumEtage()+ " ");
	   }
	   
	   System.out.println("\nResultat attendu: Ascenseur1 = -2 0");
	   System.out.println("Resultat attendu: Ascenseur2 = 3");
	   System.out.println("Resultat attendu: Ascenseur3 = 3");
	   System.out.println("Resultat attendu: Ascenseur4 = -1 0");
	   
	   
	
	}
	
	public static void main(String[] args) {
    	testChoisirAscenseur();
    }
	
	
   

}
