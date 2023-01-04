package vue;

import java.util.Scanner;

public class Ihm {

    private  Scanner sc = new Scanner(System.in);
    public int afficherMenuPrincipal() {
        System.out.println("Bienvenue dans le jeu d'aventure");
        System.out.println("  Cataclysm : Dark Days Ahead   ");
        System.out.println("            1. Jouer            ");
        System.out.println("           2. Quitter           ");
        System.out.print("Veuillez saisir votre choix :     ");
        int choix = -1;
        do {
            try {
                choix = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Veuillez saisir un nombre");
                sc.nextLine();
            }
        } while (choix < 1 || choix > 2);
        return choix;
    }

    public int afficherMenuJouer() {
        System.out.println("1. Nouvelle partie");
        System.out.println("2. Charger une partie");
        System.out.println("3. Retour");
        System.out.print("Veuillez saisir votre choix :     ");
        int choix = -1;
        do {
            try {
                choix = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Veuillez saisir un nombre");
                sc.nextLine();
            }
        } while (choix < 1 || choix > 3);
        return choix;
    }
}
