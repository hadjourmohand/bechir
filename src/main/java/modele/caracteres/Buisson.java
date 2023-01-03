package modele.caracteres;

import modele.Enum.Couleur;
import modele.Enum.CouleurBackgroud;

public class Buisson extends CaractereJeu{

    public Buisson() {
        super();
        super.setSymbole('B');
        super.setCouleur(Couleur.GREEN);
        super.setCouleurBackgroud(CouleurBackgroud.BLACK);
    }

}
