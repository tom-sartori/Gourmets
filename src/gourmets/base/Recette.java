package gourmets.base;

import java.util.Map;

public class Recette {

    private String nom;
    private int code;
    private String typePlat;
    private double tempsCuisson;
    private String typeCuisson;
    private String explication;
    private int nbPersonne; // 4
    private Map<Ingredient, Double> ingredientDoubleMap;
    // photo
    private Chef createur;


    public Recette(String nom, int code, String typePlat, double tempsCuisson, String typeCuisson, String explication, int nbPersonne, Map<Ingredient, Double> ingredientDoubleMap, Chef createur) {
        this.nom = nom;
        this.code = code;
        this.typePlat = typePlat;
        this.tempsCuisson = tempsCuisson;
        this.typeCuisson = typeCuisson;
        this.explication = explication;
        this.nbPersonne = nbPersonne;
        this.ingredientDoubleMap = ingredientDoubleMap;
        this.createur = createur;
    }
}
