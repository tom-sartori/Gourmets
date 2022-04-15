package gourmets.base;


public class Restaurant {

    private String nom;
    private Adresse adresse;
    private Chef chefProprietaire;
    private String lien;
    private String telephone;

    public Restaurant(String nom, Adresse adresse, Chef chefProprietaire, String lien, String telephone) {
        this.nom = nom;
        this.adresse = adresse;
        this.chefProprietaire = chefProprietaire;
        this.lien = lien;
        this.telephone = telephone;
    }

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant(
                "Le Pastis",
                new Adresse(3, "Rue Terral", 34000, "Montpellier"),
                new Chef("Jean"),
                "https://pastis-restaurant.com/",
                "04.00.00.00.00"
                );
        System.out.println(restaurant);
    }

    public String calculPourNbCouverts (int nbCouverts) {
        throw new RuntimeException("Not implemented. ");
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "nom='" + nom + '\'' +
                ", adresse=" + adresse +
                ", chefProprietaire=" + chefProprietaire +
                ", lien='" + lien + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
