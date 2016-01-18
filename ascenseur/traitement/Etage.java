/**
 * Classe concernant les étages
 */
public class Etage {
	/**
	 * Variable qui contient le numéro de l'étage
	 */
	private Integer numEtage;

	/**
	 * constructeur d'étage
	 * @param numE
	 */
    public Etage(int numE) {
    	numEtage=numE;
    }

	/**
	 * permet de renvoyé le numéro de l'étage
	 * @return (int) numEtage
	 */
    public Integer getNumEtage() {
		return numEtage;
	}

	/**
	 * comparateur d'étage
	 * @param etageCourant
	 * @return (int)
	 */
	public int compareEtage(Etage etageCourant) {
    	return numEtage.compareTo(etageCourant.getNumEtage());
    }

	/**
	 * permet de fixer le numéro d'étage
	 * @param i
	 */
	public void setNumEtage(int i) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * permet d'afficher proprement le numéro de l'étage
	 * @return
	 */
	public String toString(){
		return Integer.toString(numEtage);
	}
}
