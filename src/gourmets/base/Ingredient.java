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

    public static void main(String[] args) {
        Ingredient ingredient = new Ingredient("Banane", "Fruit", Unite.UNITE, new ValeurNutritionnelle(90, 22.85, 2.2, 0.33));
        System.out.println(ingredient);
    }

    public String getNom() {
        return nom;
    }

    public Unite getUnite() {
        return unite;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "nom='" + nom + '\'' +
                ", nature='" + nature + '\'' +
                ", unite=" + unite +
                ", valeurNutritionnelle=" + valeurNutritionnelle +
                '}';
    }
}
