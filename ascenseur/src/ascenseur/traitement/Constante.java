package ascenseur.traitement;

public abstract class Constante {

    private static final int nbAscenceurMax = 10;
    private static final int nbEtage = 20;

    public static final int getNbEtage() {
        return nbEtage;
    }

    public static final int getNbAscenceur() {
        return nbAscenceurMax;
    }
}
