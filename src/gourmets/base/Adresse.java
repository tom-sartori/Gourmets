package gourmets.base;

public class Adresse {

    private int num;
    private String voie;
    private int codePostal;
    private String ville;

    public Adresse(int num, String voie, int codePostal, String ville) {
        this.num = num;
        this.voie = voie;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    public static void main(String[] args) {
        Adresse adresse = new Adresse(20, "Rue des Bois", 34000, "Montpellier");
        System.out.println(adresse);
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "num=" + num +
                ", voie='" + voie + '\'' +
                ", codePostal=" + codePostal +
                ", ville='" + ville + '\'' +
                '}';
    }
}
