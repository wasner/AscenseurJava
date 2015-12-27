package ascenseur.traitement;

import java.util.Comparator;

public class ComparateurEtage implements Comparator<Etage> {

	@Override
	public int compare(Etage c1, Etage c2) {
		return ((c1.getEtageDestination())
				.compareTo
				(c2.getEtageCourant());
	}
	

}
