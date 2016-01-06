package traitement;
import java.util.*;

/**
 * 
 */
public class Etage {

    public Etage(int numE) {
    	numEtage=numE;
    }


    private Integer numEtage;

    public Integer getNumEtage() {
		return numEtage;
	}

	public int compareEtage(Etage etageCourant) {
    	return numEtage.compareTo(etageCourant.getNumEtage());
        
    }
}
