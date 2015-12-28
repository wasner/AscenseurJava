package ascenseur.traitement;
import java.util.*;

/**
 * 
 */
public class RequeteInterne extends Requete {

    private Etage etageDestination;
    public RequeteInterne(Etage etage) {
    	etageDestination=etage;
    }
	public Etage getEtageDestination() {
		return etageDestination;
	}
	
    


}
