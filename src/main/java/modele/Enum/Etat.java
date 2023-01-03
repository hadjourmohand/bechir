package modele.Enum;

public enum Etat {

    AFFAME(CouleurBackgroud.BLACK),
    RASSASIE(CouleurBackgroud.BLUE),
    AMI(CouleurBackgroud.PURPLE),
    JUNKIE(CouleurBackgroud.RED),
    PERCHE(CouleurBackgroud.GREEN),
    CACHE(CouleurBackgroud.YELLOW);

    private CouleurBackgroud couleur;

    Etat(CouleurBackgroud couleurBackgroud) {
        this.couleur = couleurBackgroud;
    }

    public CouleurBackgroud getCouleur() {
        return couleur;
    }

}
