package modele.carte;

import modele.caracteres.CaractereJeu;

public abstract class Carte {

    private CaractereJeu[][] carte;
    private int largeur;
    private int hauteur;

    public Carte(int largeur, int hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.carte = new CaractereJeu[largeur][hauteur];
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

    public abstract void lireCarte(String nomFichier);

    public abstract void afficherCarte();

    public abstract void sauvegarderCarte(String nomFichier);

    public abstract void crrerCarte();




}
