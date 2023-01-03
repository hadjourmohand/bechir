package modele.caracteres;

import modele.Enum.Couleur;
import modele.Enum.CouleurBackgroud;

public class Champignon extends CaractereJeu{

    public Champignon() {
        super();
        super.setSymbole('C');
        super.setCouleur(Couleur.PURPLE);
        super.setCouleurBackgroud(CouleurBackgroud.WHITE);
    }

}
