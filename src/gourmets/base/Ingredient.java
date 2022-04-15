package gourmets.base;

public class Ingredient {

    private String nom;
    private String nature;
    private Unite unite;
    private ValeurNutritionnelle valeurNutritionnelle;


    public Ingredient(String nom, String nature, Unite unite, ValeurNutritionnelle valeurNutritionnelle) {
        this.nom = nom;
        this.nature = nature;
        this.unite = unite;
        this.valeurNutritionnelle = valeurNutritionnelle;
    }
}
