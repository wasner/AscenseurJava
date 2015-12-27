import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * 
 */
public class RequeteExterne extends Requete {

    /** Etage de l'appel */
    private int etage;
    /** Direction de l'appel */
    private String direction;

    /**
     * Default constructor
     */
    public RequeteExterne() {
    }

    /**
     * 
     */
    public String getDirection() {
    	return direction;
        // TODO implement here
    }

    /**
     * Retourne l'etage de l'appel
     *
     * @return       Etage de l'appel
     */
    public int getEtage()
    {
        return etage;
    }

    /**
     * Constructeur
     *
     * @param etage          Etage de l'appel
     */
    public void RequeteDescendre(int etage)
    {
        etage = etage;
    }

}