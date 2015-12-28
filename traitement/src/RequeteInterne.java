package ascenseur.traitement;
import java.util.*;

/**
 * 
 */
public class RequeteInterne extends Requete {

    private Etage etageF;
    public RequeteInterne(Etage etage) {
        etageF=etage;
    }
	public Etage getEtageF() {
		return etageF;
	}
    
    


}
