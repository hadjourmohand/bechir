package modele.caracteres;

import modele.Enum.Couleur;
import modele.Enum.CouleurBackgroud;
import modele.Enum.Etat;

public class Ecureuil extends Personnnage{

    private Etat etat;

    public Ecureuil() {
        super();
        super.setSymbole('E');
        super.setCouleur(Couleur.BLACK);
        this.etat = Etat.RASSASIE;
    }

    @Override
    public CouleurBackgroud getCouleurBackgroud() {
        return this.etat.getCouleur();
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }
}
