import java.util.*;

public class RequeteInterne implements Requete {
	Ascenseur ascenseur = new Ascenseur();

    private Etage etageDestination;
    
    public RequeteInterne(Etage etage) {
    	etageDestination=etage;
    }
    
	@Override
	public Etage getEtage() {
		// TODO Auto-generated method stub
		return etageDestination;
	}

	@Override
	public String getDirection() {
		if(ascenseur.getEtageCourant().getNumEtage() < getEtage().getNumEtage())
			return "montant";
		else
			return "descendant";
	}
}
