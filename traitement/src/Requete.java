import java.util.*;

/**
 * 
 */
public abstract class Requete
{
	public static int deplacement; //Variable qui contient l'état actuelle de l'ascenceur (en déplacement vers le haut, bas, arrêter, etc)
	public static int monter; //L'ascenceur à reçu une requête pour monter
	public static int descendre; //L'ascenceur à reçu une requpete pour descendre
	public static int arret; //L'ascenceur à reçu une requête d'arrêt
	public static int annuler; //La dernière commande envoyé à été annuler /!\ BONUS

	public Requete() {
	}
}