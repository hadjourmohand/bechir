package modele.caracteres;

import modele.Enum.Couleur;
import modele.Enum.CouleurBackgroud;
import modele.Enum.Etat;

public class Ecureuil extends Personnnage{

    private Etat etat;
    private boolean estAmis;
    private int nbTourRestant;
    private boolean refigier;

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

    public boolean isEstAmis() {
        return estAmis;
    }

    public void setEstAmis(boolean estAmis) {
        this.estAmis = estAmis;
        if (estAmis) {
            super.setCouleur(Couleur.PURPLE);
        } else {
            super.setCouleur(Couleur.BLACK);
        }
    }

    public int getNbTourRestant() {
        return nbTourRestant;
    }

    public void setNbTourRestant(int nbTourRestant) {
        this.nbTourRestant = nbTourRestant;
    }

    public void decrementerNbTourRestant() {
        if (this.nbTourRestant > 0) {
            this.nbTourRestant--;
        }
    }

    public boolean isRefigier() {
        return refigier;
    }

    public void setRefigier(boolean refigier) {
        this.refigier = refigier;
    }
}
