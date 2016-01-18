import java.util.*;

/**
 * 
 */
public class RequeteExterne implements Requete {
    /**
     * Direction dans la qu'elle la personne veux allez (monter ou descendre)
     */
    private String direction;
    /** Etage de l'appel */
    private Etage etage;

    /**
     * Constructeur par défaut de la requête externe
     * @param direction si la personne veux monter ou descendre
     * @param etage l'étage d'où provient l'appel de la requête
     */
    public RequeteExterne(String direction, Etage etage) {
        this.direction = direction;
        this.etage = etage;
    }

    /**
     * Retourne l'etage de l'appel
     *
     * @return       Etage de l'appel
     */
    public Etage getEtage()
    {
        return etage;
    }

    /**
     * Constructeur
     *
     * @param etage          Etage de l'appel
     */
    public void RequeteDescendre(Etage etage)
    {
        etage = etage;
    }

    /**
     * permet de faire une requête pour monter
     * @param etage
     */
    public void RequeteMonter(Etage etage) { etage = etage;}

    /**
     * permet de savoir dans qu'elle direction la personne veux allez
     * @return
     */
    public String getDirection() {
        return direction;
    }

    /**
     * permet de définir la direction de la requête
     * @param direction
     */
    public void setDirection(String direction) {
        this.direction = direction;
    }



}

