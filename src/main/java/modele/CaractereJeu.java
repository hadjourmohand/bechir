package modele;

public abstract class CaractereJeu {
    private char symbole;
    private Couleur couleur;
    private CouleurBackgroud couleurBackgroud;

    public char getSymbole() {
        return symbole;
    }

    public void setSymbole(char symbole) {
        this.symbole = symbole;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    public CouleurBackgroud getCouleurBackgroud() {
        return couleurBackgroud;
    }

    public void setCouleurBackgroud(CouleurBackgroud couleurBackgroud) {
        this.couleurBackgroud = couleurBackgroud;
    }
}
