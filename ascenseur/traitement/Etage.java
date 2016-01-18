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
	 * @param numE numéros de l'étage
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
	 * @param etageCourant l'étage courant de l'ascenseur
	 * @return (int)
	 */
	public int compareEtage(Etage etageCourant) {
    	return numEtage.compareTo(etageCourant.getNumEtage());
    }

	/**
	 * permet de fixer le numéro d'étage
	 * @param i fixer le numéros de l'étage à i
	 */
	public void setNumEtage(int i) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * permet d'afficher proprement le numéro de l'étage
	 * @return String
	 */
	public String toString(){
		return Integer.toString(numEtage);
	}
}
