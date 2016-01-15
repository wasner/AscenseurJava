package ascenseur.traitement;

import java.util.*;

/**
 * 
 */
public class RequeteExterne implements Requete {

    private String direction;
    /** Etage de l'appel */
    private Etage etage;


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
    public void RequeteMonter(Etage etage) { etage = etage;}

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

	@Override
	public Etage getRequeteEtage() {
		// TODO Auto-generated method stub
		return null;
	}

}

