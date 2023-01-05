package modele.carte;

import modele.caracteres.CaractereJeu;
import modele.caracteres.Vide;

import java.io.BufferedReader;
import java.io.IOException;

public abstract class Carte {

    protected CaractereJeu[][] carte;
    protected int largeur;
    protected int hauteur;

    protected int x_personnage;
    protected int y_personnage;

    public Carte(int largeur, int hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.carte = new CaractereJeu[largeur][hauteur];
        //initialiser le tous avec des cases vides
        for (int  i = 0; i < largeur; i++) {
            for (int j = 0; j < hauteur; j++) {
                this.carte[i][j] = new Vide();
            }
        }
    }
    public CaractereJeu[][] getCarte() {
        return carte;
    }

    public void setCarte(CaractereJeu[][] carte) {
        this.carte = carte;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public abstract  void lireCarte(BufferedReader bufferedReader) throws IOException ;

    public abstract void sauvegarderCarte(String nomFichier) throws IOException;

    public abstract void crrerCarte();

    public abstract void executerTour();

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < this.getLargeur(); i++) {
            for (int j = 0; j < this.getHauteur(); j++) {
                s += this.carte[i][j].getSymboleCouleur();
            }
            s += "\n";
        }
        return s;
    }
}
