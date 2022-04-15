package gourmets.base;

import gourmets.view.Utils;
import jdk.jshell.execution.Util;

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

    public String toHtml () {
        String sh = "";
        for (Map.Entry<Ingredient, Double> element : ingredientDoubleMap.entrySet()) {
            sh += Utils.tr(
                    Utils.td(element.getKey().getNom()) +
                            Utils.td(element.getValue() + " " + element.getKey().getUnite().toString())
            );
        }
        return sh;
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
}
