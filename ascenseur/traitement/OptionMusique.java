public class OptionMusique extends Option {
    /**
     * constructeur de l'option musique
     * @param delegue ascenseur sur le quel on veut ajouter de la musique
     */
    public OptionMusique(Ascenseur delegue) {
    	super(delegue);
    }

    /**
     * affichage propre de l'option musique
     * @return
     */
    public String toString(){
    	return "Option musique " + delegue.toString();
    }

}
