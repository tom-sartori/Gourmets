package gourmets.base;

public class Adresse {

    private int num;
    private String voie;
    private String codePostal;
    private String ville;

    public Adresse(int num, String voie, String codePostal, String ville) {
        this.num = num;
        this.voie = voie;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    public static void main(String[] args) {
        Adresse adresse = new Adresse(20, "Rue des Bois", "34000", "Montpellier");
        System.out.println(adresse);
    }

    public boolean isSameDepartment (Integer department) {
        return codePostal.substring(0, 2).equals(department.toString());
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
