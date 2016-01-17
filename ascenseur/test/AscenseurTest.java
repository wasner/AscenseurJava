import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by w14007405 on 15/01/2016.
 */
public class AscenseurTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testTriAppel() throws Exception {
        List<Etage> etages = new LinkedList<Etage>();
        Ascenseur ascenseur1 = new Ascenseur(9,200,etages);
        Etage r ;
        for(int i =0; i < 10; ++i){ etages.add(new Etage(i)); }

        Etage etageCourant = new Etage(5);
        ascenseur1.setEtageCourant(etageCourant);


        ascenseur1.ajouterRequete(new RequeteExterne("montant",etages.get(1)));
        ascenseur1.ajouterRequete(new RequeteExterne("montant",etages.get(8)));
        ascenseur1.ajouterRequete(new RequeteExterne("montant",etages.get(9)));
        ascenseur1.ajouterRequete(new RequeteExterne("montant",etages.get(5)));
        ascenseur1.ajouterRequete(new RequeteExterne("montant",etages.get(4)));
        ascenseur1.ajouterRequete(new RequeteExterne("montant",etages.get(6)));

        List<Requete> requetes = ascenseur1.getRequetes();


        /*for(int i = 0; i < 5; ++i){
            requetes.add(new RequeteExterne("montant",etages.get(i)));
            //System.out.println(requetes.get(i).getEtage());
        }
        for(int j = 0; j < 5; ++j){
            requetes.add(new RequeteExterne("descendant",etages.get(j+5)));
            System.out.println("Descendant : " + j+5);
        }*/
        System.out.println("Nombres de requêtes : " + requetes.size());
        System.out.println("Liste des requêtes non triées : " );
        for(Requete req: requetes)
        {
            System.out.println( req.getEtage().getNumEtage());
        }
        ascenseur1.triAppel();
        System.out.println("Liste des requêtes triés :");
        //System.out.println(requetes.get(1).getEtage().getNumEtage());
        for(Requete req: requetes)
        {
            System.out.println(req.getEtage().getNumEtage());
        }
    }
}