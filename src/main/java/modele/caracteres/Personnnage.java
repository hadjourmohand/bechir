package modele.caracteres;

import modele.Enum.Couleur;
import modele.Enum.CouleurBackgroud;

public class Personnnage extends CaractereJeu{

    public Personnnage() {
        super();
        super.setSymbole('@');
        super.setCouleur(Couleur.PURPLE);
        super.setCouleurBackgroud(CouleurBackgroud.WHITE);
    }
}
