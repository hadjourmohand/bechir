package modele.caracteres;

import modele.Enum.Couleur;
import modele.Enum.CouleurBackgroud;

public class Arbre extends CaractereJeu{

    public Arbre() {
        super();
        super.setSymbole('A');
        super.setCouleur(Couleur.GREEN);
        super.setCouleurBackgroud(CouleurBackgroud.BLACK);
    }

}
