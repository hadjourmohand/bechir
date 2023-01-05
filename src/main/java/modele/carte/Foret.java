package modele.carte;

import modele.CaractersFactory;
import modele.Enum.Etat;
import modele.caracteres.*;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;

public class Foret extends Carte{

    private ArrayList<Point> ecureuilRefugie = new ArrayList<Point>();

    public Foret(int largeur, int hauteur) {
        super(largeur, hauteur);
    }



    @Override
    public void lireCarte(BufferedReader bufferedReader) throws IOException {
        String line = bufferedReader.readLine();
        this.hauteur = Integer.parseInt(line);
        line = bufferedReader.readLine();
        this.largeur = Integer.parseInt(line);
        this.carte = new CaractereJeu[this.largeur][this.hauteur];
        for (int i = 0; i < this.hauteur; i++) {
            line = bufferedReader.readLine();
            for (int j = 0; j < this.largeur; j++) {
                this.carte[j][i] = CaractersFactory.getCaractereJeu(line.charAt(j));
            }
        }
    }

    @Override
    public void sauvegarderCarte(String nomFichier) throws IOException {
        File file = new File(nomFichier);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("F\n");
        bw.write(this.getHauteur() + "\n");
        bw.write(this.getLargeur() + "\n");
        for (int i = 0; i < this.getLargeur(); i++) {
            for (int j = 0; j < this.getHauteur(); j++) {
                bw.write(this.carte[i][j].getSymboleCouleur());
            }
            bw.write("\n");
        }
        bw.close();
    }

    @Override
    public void crrerCarte() {

    }

    @Override
    public void executerTour() {

    }


    private void moveEcureuil(int x, int y){
        /*
            Un écureuil affamé deviendra rassasié s’il se nourrit.
            Un écureuil rassasié sera de nouveau affamé au bout de 5 tours.
            Un écureuil affamé qui se nourri sur une case adjacente au personnage deviendra son ami.
            Si le personnage donne un coup à l’écureuil, il ne sera plus son ami.
        Si l’écureuil mange un champignon venimeux, il devient junkie pendant 5 tours puis ensuite sera de
        nouveau affamé.
        Un écureuil junkie se déplace aléatoirement.
        Le déplacement d’un écureuil affamé dépend de ce qu’il voit autour de lui en suivant l'ordre de
        priorité ci-dessous :
        1. S'il voit un gland : peu importe le danger, il va le chercher et le mange. L’écureuil prend la place
        du gland.
        2. S'il voit un champignon: il va le chercher et le mange. L’écureuil prend la place du champignon.
        3. Si à moins de 4 cases, il voit un danger et :
        (a) Si vous êtes amis et à proximité : il court vers votre poche,
        (b) S'il y a un arbre : il court vers l'arbre pour s'y réfugier,
    3/6
        (c) S'il y a un buisson : il court vers le buisson pour s'y réfugier,
        (d) Sinon : il court dans le sens oppose au danger pour se placer dans la première case vide.
        Un écureuil rassasié ne se préoccupe que du danger (point 3 ci-dessus) puisqu’il ne cherche pas à
        manger. Il ne fait pas de stocke et ne mange pas.
        S’il ne voit aucun danger, il se déplace dans une des cases vide la plus proche de lui.
* */

        //On récupère l'écureuil
        Ecureuil ecureuil = (Ecureuil) this.carte[x][y];
        ecureuil.decrementerNbTourRestant();
        if (ecureuil.getNbTourRestant() == 0 && ecureuil.getEtat() == Etat.RASSASIE){
            ecureuil.setEtat(Etat.AFFAME);
        }

        switch (ecureuil.getEtat()){
            case JUNKIE :
            case RASSASIE :
                //On déplace l'écureuil aléatoirement
                this.deplacerAleatoirement(x,y);
                break;
            case AFFAME :
                this.ecureuilChercheNouriture(x,y);
                break;

        }
    }

    private void ecureuilChercheNouriture(int x, int y){
        //On récupère l'écureuil
        Ecureuil ecureuil = (Ecureuil) this.carte[x][y];
        //On regarde autour de lui
        for (int i = x-1; i <= x+1; i++) {
            for (int j = y-1; j <= y+1; j++) {
                if (i >= 0 && i < this.largeur && j >= 0 && j < this.hauteur){
                    if (this.carte[i][j] instanceof Gland){
                        //On mange le gland
                        ecureuil.setEtat(Etat.RASSASIE);
                        ecureuil.setNbTourRestant(5);
                        this.carte[i][j] = ecureuil;
                        this.carte[x][y] = new Vide();
                        return;
                    }
                    if (this.carte[i][j] instanceof Champignon || this.carte[i][j] instanceof ChampignonVenimeux){
                        if(!écureuilVérifierDanger(x, y)){
                            //On mange le champignon
                            if (this.carte[i][j] instanceof ChampignonVenimeux)
                                ecureuil.setEtat(Etat.JUNKIE);
                            else
                                ecureuil.setEtat(Etat.RASSASIE);

                            ecureuil.setNbTourRestant(5);
                            this.carte[i][j] = ecureuil;
                            this.carte[x][y] = new Vide();
                            return;
                        }
                    }
                }
            }
        }
    }


    private boolean écureuilVérifierDanger(int x, int y){
        //On regarde autour de lui à moins de 4 cases
        for (int i = x-4; i <= x+4; i++) {
            for (int j = y-4; j <= y+4; j++) {
                if (i >= 0 && i < this.largeur && j >= 0 && j < this.hauteur){
                    if (this.carte[i][j] instanceof Renard){
                     //il existe un danger
                        if(this.seCacheCourir(x,y)){
                        }else {
                            this.echaperRenard(x, y, i, j);
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean seCacheCourir(int x, int y){
        /*
        *   (a) Si vous êtes amis et à proximité : il court vers votre poche,
            (b) S'il y a un arbre : il court vers l'arbre pour s'y réfugier,
            (c) S'il y a un buisson : il court vers le buisson pour s'y réfugier,
            (d) Sinon : il court dans le sens oppose au danger pour se placer dans la première case vide.
        * */
        //cherche personne ou arbre ou buisson le plus proche à moins de 4 cases
        Ecureuil ecureuil = (Ecureuil) this.carte[x][y];
        for (int i = x-1; i <= x+1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && i < this.largeur && j >= 0 && j < this.hauteur) {
                    if (ecureuil.isEstAmis() && this.carte[i][j] instanceof Personnnage) {
                        return true;
                    } else if (this.carte[i][j] instanceof Arbre || this.carte[i][j] instanceof Buisson) {
                        this.ecureuilRefugie.add(new Point(i, j));
                        this.carte[x][y] = new Vide();
                        return true;
                    }

                }
            }
        }
        return false;
    }


    private void echaperRenard( int x, int y, int xRenard, int yRenard){
        //il court dans le sens oppose au danger pour se placer dans la première case vide.
            int xDirection = 0;
            int yDirection = 0;
            if (xRenard > x){
                xDirection = -1;
            }
            else if (xRenard < x){
                xDirection = 1;
            }
            if (yRenard > y){
                yDirection = -1;
            }
            else if (yRenard < y){
                yDirection = +1;
            }
            //On regarde autour de lui à moins de 4 cases
            for (int i = x+xDirection; i <= x+xDirection; i++) {
                for (int j = y+yDirection; j <= y+yDirection; j++) {
                    if (i >= 0 && i < this.largeur && j >= 0 && j < this.hauteur){
                        if (this.carte[i][j] instanceof Vide){
                            //On court vers le vide
                            Ecureuil ecureuil = (Ecureuil) this.carte[x][y];
                            this.carte[i][j] = ecureuil;
                            this.carte[x][y] = new Vide();
                            return;
                        }
                    }
                }
        }
    }

    private void deplacerAleatoirement(int x, int y){
        ArrayList<Point> points = new ArrayList<>();
        //On regarde autour de lui
        for (int i = x-1; i <= x+1; i++) {
            for (int j = y-1; j <= y+1; j++) {
                if (i >= 0 && i < this.largeur && j >= 0 && j < this.hauteur){
                    if (this.carte[i][j] instanceof Vide){
                        //On ajoute le point
                        points.add(new Point(i, j));
                    }
                }
            }
        }
        if (points.size() > 0){
            //On choisit un point au hasard
            Point point = points.get((int)(Math.random() * points.size()));
            this.carte[point.x][point.y] = this.carte[x][y];;
            this.carte[x][y] = new Vide();
        }
    }


}
