package ascenseur.traitement;
import java.util.*;

/**
 * 
 */
public class Etage {

    public Etage(String nomE, int numE) {
    	nomEtage=nomE;
    	numEtage=numE;
    }

    private int numEtage;
    private String nomEtage;
	public String getNomEtage() {
		return nomEtage;
	}
}
