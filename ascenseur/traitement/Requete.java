import java.util.*;

public interface Requete
{
	/**
	 * méthode abstraite qui permet de retourner l'étage de la requête
	 * @return variable selon requête interne(numéros de l'étage de destination) ou externe ( etage d'ou provient l'appel)
	 */
	public Etage getEtage();
}
