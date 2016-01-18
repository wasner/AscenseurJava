package traitement;

public class OptionMusique extends Option {
	
    public OptionMusique(Ascenseur delegue) {
    	super(delegue);
    }
    public String toString(){
    	return "Option musique " + delegue.toString();
    }

}
