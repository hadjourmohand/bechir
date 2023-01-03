package modele.caracteres;

import modele.Enum.Couleur;
import modele.Enum.CouleurBackgroud;

public class Gland extends CaractereJeu{

    public Gland() {
        super();
        super.setSymbole('G');
        super.setCouleur(Couleur.YELLOW);
        super.setCouleurBackgroud(CouleurBackgroud.GREEN);
    }

}
