package ascenseur.traitement;

public class Etage {

	private Integer numEtage;
	
    public Etage(int numE) {
    	numEtage=numE;
    }

    public Integer getNumEtage() {
		return numEtage;
	}

	public int compareEtage(Etage etageCourant) {
    	return numEtage.compareTo(etageCourant.getNumEtage());
    }
}
