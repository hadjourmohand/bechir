package modele.caracteres;

import modele.Enum.Couleur;
import modele.Enum.CouleurBackgroud;

public class ChampignonVenimeux extends CaractereJeu{

    public ChampignonVenimeux() {
        super();
        super.setSymbole('C');
        super.setCouleur(Couleur.YELLOW);
        super.setCouleurBackgroud(CouleurBackgroud.RED);
    }

}
