package modele.caracteres;

import modele.Enum.Couleur;
import modele.Enum.CouleurBackgroud;

public abstract class CaractereJeu {
    protected char symbole;
    protected Couleur couleur;
    protected CouleurBackgroud couleurBackgroud;

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

    public String getSymboleCouleur() {
        return this.couleurBackgroud.getCouleur() + this.couleur.getCouleur() + this.symbole + CouleurBackgroud.RESET.getCouleur();
    }

}
