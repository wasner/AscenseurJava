import java.util.*;

public class RequeteInterne implements Requete {
	/**
	 * l'étage de destination de la requête
	 */
    private Etage etageDestination;

	/**
	 * constructeur de requête interne
	 * @param etage étage de destination de la personne
	 */
    public RequeteInterne(Etage etage) {
    	etageDestination=etage;
    }
    
	@Override
	/**
	 * permet de connaitre l'étage de destination de la personne
	 */
	public Etage getEtage() {
		// TODO Auto-generated method stub
		return etageDestination;
	}
}
