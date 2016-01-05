package ascenseur.traitement;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * 
 */
public class RequeteExterne extends Requete {

    private boolean direction;
    /** Etage de l'appel */
    private Etage etage;


    public RequeteExterne(boolean direction, Etage etage) {
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
    public void RequeteMonter(Etage etage) { etage = etage;}

    public boolean getDirection() {
        return direction;
    }

    public void setDirection(boolean direction) {
        this.direction = direction;
    }

}

