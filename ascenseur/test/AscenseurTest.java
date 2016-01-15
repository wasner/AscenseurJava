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

        Etage etageCourant = ascenseur1.getEtageCourant();

        List<Requete> requetes = new LinkedList<Requete>();
        for(int i = 0; i < 5; ++i){
            requetes.add(new RequeteExterne("montant",etages.get(i)));
            System.out.println(requetes.get(i).getEtage());
        }
        for(int i = 0; i < 5; ++i){
            requetes.add(new RequeteExterne("descendant",etages.get(i+5)));
            System.out.println(i+5);
        }
        System.out.println(requetes.size());
        for(Requete req: requetes)
        {

            System.out.println(req.getEtage());
        }
        ascenseur1.triAppel();
        System.out.println("Liste des requêtes triés :");
        for(Requete req: requetes)
        {
            System.out.println(req.getEtage().getNumEtage());
        }
    }
}