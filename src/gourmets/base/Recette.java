package gourmets.base;

import gourmets.view.Tag;

import java.util.HashMap;
import java.util.Map;

public class Recette {

    private String nom;
    private int code;
    private static int currentCode = 0; // todo : singleton.
    private String typePlat;
    private double tempsCuisson;
    private String typeCuisson;
    private String explication;
    private int nbPersonne; // 4
    private Map<Ingredient, Double> ingredientDoubleMap;
    // photo
    private Chef createur;


    public Recette(String nom, String typePlat, double tempsCuisson, String typeCuisson, String explication, int nbPersonne, Chef createur) {
        this.nom = nom;
        this.code = currentCode;
        currentCode++;
        this.typePlat = typePlat;
        this.tempsCuisson = tempsCuisson;
        this.typeCuisson = typeCuisson;
        this.explication = explication;
        this.nbPersonne = nbPersonne;
        this.ingredientDoubleMap = new HashMap<>();
        this.createur = createur;
    }

    public static void main(String[] args) {
        Recette recette = new Recette(
                "Cake aux bananes à l’huile d’olive et miel",
                "Dessert",
                50,
                "Four",
                "Préchauffer le four à 180/200°C. Dans un grand bol, écraser\n" +
                        "      très grossièrement les 4 bananes très mûres à la fourchette.",
                4,
                new Chef("Jean")
        );

        Ingredient banane = new Ingredient("Banane", "Fruit", Unite.UNITE, new ValeurNutritionnelle(90, 22.85, 2.2, 0.33));
        recette.addIngredient(banane, 4.);

        System.out.println(recette);
    }

    public void addIngredient (Ingredient ingredient, Double quantite) {
        ingredientDoubleMap.put(ingredient, quantite);
    }

    public Map<Ingredient, Double> approvis (int nbCouverts) {
        Map<Ingredient, Double> ingredientMap = new HashMap<>();
        for (Map.Entry<Ingredient, Double> element : this.ingredientDoubleMap.entrySet()) {
            ingredientMap.put(element.getKey(), (nbCouverts * element.getValue()) / this.nbPersonne);
        }
        return ingredientMap;
    }

    public String ingredientToHtml () {
        return ingredientMapToHtml(this.ingredientDoubleMap);
    }

    // Return a html table.
    private String ingredientMapToHtml(Map<Ingredient, Double> ingredientMap) {
        String tbody = "";
        for (Map.Entry<Ingredient, Double> element : ingredientMap.entrySet()) {
            tbody += Tag.tr(
                    Tag.td(element.getKey().getNom()) +
                            Tag.td(element.getValue() + " " + element.getKey().getUnite().toString())
            );
        }

        String caption = Tag.caption(nom);
        String thead = Tag.thead(new String[]{ "Nom", "Quantité" });
        tbody = Tag.tbody(tbody);

        return Tag.table(caption + thead + tbody);
    }

    // Return a html div.
    public String toDiv(int nbCouvert) {
        String h1Nom = Tag.h1(nom);
        String h2Auteur = Tag.h2(createur.getNom());
        String pNbPersonne = Tag.p("Cette recette est faite pour " + nbCouvert + " personnes. ");
        String tableIngredient = ingredientMapToHtml(approvis(nbCouvert));

        return Tag.div(h1Nom + h2Auteur + pNbPersonne + tableIngredient);
    }

    @Override
    public String toString() {
        return "Recette{" +
                "nom='" + nom + '\'' +
                ", code=" + code +
                ", typePlat='" + typePlat + '\'' +
                ", tempsCuisson=" + tempsCuisson + " minutes" +
                ", typeCuisson='" + typeCuisson + '\'' +
                ", explication='" + explication + '\'' +
                ", nbPersonne=" + nbPersonne +
                ", ingredientDoubleMap=" + ingredientDoubleMap +
                ", createur=" + createur +
                '}';
    }

    public String getNom() {
        return nom;
    }

    public int getNbPersonne() {
        return nbPersonne;
    }
}
