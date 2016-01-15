package ascenseur.traitement;

import java.util.*;

public class RequeteInterne implements Requete {

    private Etage etageDestination;
    
    public RequeteInterne(Etage etage) {
    	etageDestination=etage;
    }
    
	@Override
	public Etage getRequeteEtage() {
		// TODO Auto-generated method stub
		return etageDestination;
	}
}
