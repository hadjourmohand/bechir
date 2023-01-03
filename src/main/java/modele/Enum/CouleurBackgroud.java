package modele.Enum;

public enum CouleurBackgroud {
    BLACK("\u001B[40m"),
    RED("\u001B[41m"),
    GREEN("\u001B[42m"),
    YELLOW("\u001B[43m"),
    BLUE("\u001B[44m"),
    PURPLE("\u001B[45m"),
    CYAN("\u001B[46m"),
    WHITE("\u001B[47m"),
    RESET("\u001B[0m");

    private String couleur;

    CouleurBackgroud(String couleur) {
        this.couleur = couleur;
    }

    public String getCouleur() {
        return couleur;
    }

}
