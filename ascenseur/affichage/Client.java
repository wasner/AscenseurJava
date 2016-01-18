package affichage;

import java.util.LinkedList;
import java.util.List;

import traitement.Ascenseur;
import traitement.Constante;
import traitement.Controleur;
import traitement.Etage;
import traitement.Immeuble;

public class Client {

	public static void main(String[] args){

		String nom = "Name";

		List<Etage> etages = new LinkedList<Etage>();
		for(int i =0; i < Constante.getNbEtage(); i++)
			etages.add(new Etage(i));
		List<Ascenseur> ascenseurs = new LinkedList<Ascenseur>();
		Controleur co =new Controleur(ascenseurs);
		Immeuble immeuble = new Immeuble(nom, etages, ascenseurs,co);
		immeuble.addVue(new VueInit(immeuble));
	}
}
