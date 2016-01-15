package ascenseur.affichage;

import ascenceur.traitement.Ascenceur;
import ascenseur.traitement.Constante;
import ascenseur.traitement.Etage;


public class ParamState{
	
	private Window window = null;
	private State state = null;
	private int nombreAscenceur = -1;
	private int nombreEtage = 2;
	private Ascenceur ascenceurs[] = null;
	private Etage[] etages;

	public ParamState(Window window, State state)
	{
		this.window = window;
		this.state  = state;
		this.ascenceurs = new Ascenceur[Constante.getNbAscenceur()];
		this.etages = new Etage[Constante.getNbEtage()];
		try{
			for(int i = 0; i <= this.nombreEtage; ++i)
				this.etages[i] = new Etage(i);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public Ascenceur[] getEtages()
	{
		return this.ascenceurs;
	}
	
	public void utiliser()
	{
		this.window.getContentPane().setVisible(false);
    	this.window.getContentPane().remove(this.window.getContentPane());
    	this.window.setContentPane(new ParamPanel(state));
    	this.window.getContentPane().setVisible(true);
	}
	
	public int getNombreAscenceur()
	{
		return this.nombreAscenceur;
	}
	
	public Ascenceur getAscenceur(int index)
	{
		if(index <= this.nombreAscenceur)
			return this.ascenceurs[index];
		else
			return null;
	}
	
	public boolean setNombreEtage(int nbEtage)
	{
		if(nbEtage <= Constante.getNbEtage())
		{
			this.nombreEtage = nbEtage;
			return true;
		}
		else
		{
			this.nombreEtage = nbEtage;
			return false;
		}	
	}
	
	public int getNombreEtage()
	{
		return this.nombreEtage;
	}
	
	public boolean creerAscenceur()
	{
		if(this.nombreAscenceur < Constante.getNbAscenceur()-1)
		{
			this.nombreAscenceur+=1;
			this.ascenceurs[this.nombreAscenceur] = new Ascenceur(600, 6, etages);
			
			return true; 
		}
		else
			return false;
	}
}
