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
}
