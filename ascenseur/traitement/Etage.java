package traitement;

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

	public void setNumEtage(int i) {
		// TODO Auto-generated method stub
		
	}
	public String toString(){
		return Integer.toString(numEtage);
	}
}
