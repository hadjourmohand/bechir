package modele;

import modele.caracteres.*;

public class CaractersFactory {

    public static CaractereJeu getCaractereJeu(char symbole) {
        switch (symbole) {
            case 'c':
                return new Champignon();
            case 'C':
                return new ChampignonVenimeux();
            case 'A':
                return new Arbre();
            case '@':
                return new Personnnage();
            case 'B':
                return new Buisson();
            case 'E':
                return new Ecureuil();
            case 'G':
                return new Gland();
            case 'R':
                return new Renard();
            case ' ':
                return new Vide();
            default:
                return null;
        }
    }
}
