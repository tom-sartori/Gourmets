package gourmets.base;


import java.util.Objects;

public class Restaurant {

    private String nom;
    private Adresse adresse;
    private String lien;
    private String telephone;

    public Restaurant(String nom, Adresse adresse, String lien, String telephone) {
        this.nom = nom;
        this.adresse = adresse;
        this.lien = lien;
        this.telephone = telephone;
    }

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant(
                "Le Pastis",
                new Adresse(3, "Rue Terral", "34000", "Montpellier"),
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
                ", lien='" + lien + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }

    public Adresse getAdresse() {
        return adresse;
    }
}
