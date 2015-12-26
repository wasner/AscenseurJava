package ascenseur.traitement;
import java.util.*;

/**
 * 
 */
public class Requete {
	
	private Etage etageDestination;
	
    public Etage getEtageDestination() {
		return etageDestination;
	}

	public Requete(Etage etage) {
    	etageDestination=etage;
    }

}
