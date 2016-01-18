import traitement.Ascenseur;
import traitement.Etage;

public class VueAscenseurPosition implements VueAscenseur {
	private Ascenseur asc;
	private Etage et;
	private VueImeuble vue;
	public VueAscenseurPosition(Ascenseur ascens, VueImeuble vue) {
		// TODO Auto-generated constructor stub
		this.asc = ascens;
		et=asc.getEtageCourant();
		this.vue=vue;
	}
	
	@Override
	public void miseAJour() {
		// TODO Auto-generated method stub
		et= asc.getEtageCourant();
		vue.miseAJour();
	}
	public Etage getEtage(){
		return et;
	}
	public String getEtat(){
		return asc.getEtat();
	}

}
