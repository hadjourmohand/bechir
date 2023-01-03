package modele.caracteres;

import modele.Enum.Couleur;
import modele.Enum.CouleurBackgroud;

public class Vide extends CaractereJeu{
    public Vide() {
        super();
        super.setSymbole(' ');
        super.setCouleur(Couleur.GREEN);
        super.setCouleurBackgroud(CouleurBackgroud.GREEN);
    }
}
