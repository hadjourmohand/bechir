package modele.caracteres;

import modele.Enum.Couleur;
import modele.Enum.CouleurBackgroud;

public class Renard extends CaractereJeu{

    public Renard() {
        super();
        super.setSymbole('R');
        super.setCouleur(Couleur.BLACK);
        super.setCouleurBackgroud(CouleurBackgroud.CYAN);
    }

}
