package gourmets.app;

import gourmets.base.*;
import gourmets.view.IngredientsView;

import java.util.ArrayList;
import java.util.List;

public class SiteWeb {

    public static void main(String[] args) {

        Chef chefHerault = new Chef("Jean");
        Chef chefParis = new Chef("Bernard");

        Restaurant restaurantHeraultMontpellier = new Restaurant(
                "Le Pastis",
                new Adresse(3, "Rue Terral", 34000, "Montpellier"),
                "https://pastis-restaurant.com/",
                "04.00.00.00.00"
        );
        chefHerault.addRestaurantPossedeList(restaurantHeraultMontpellier);

        Restaurant restaurantHeraultSete = new Restaurant(
                "La Marine",
                new Adresse(29, "Quai Général Durand", 34200, "Sète"),
                "https://Marine.com/",
                "04.00.00.00.00"
        );
        chefHerault.addRestaurantPossedeList(restaurantHeraultSete);

        Restaurant restaurantParis = new Restaurant(
                "La Paris",
                new Adresse(35, "rue de Paris", 75000, "Paris"),
                "https://restaurant-paris.com/",
                "01.00.00.00.00"
        );
        chefParis.addRestaurantPossedeList(restaurantParis);

        chefHerault.setRestaurantPrincipal(restaurantHeraultMontpellier);

        List<Restaurant> restaurantList = new ArrayList<>();
        restaurantList.add(restaurantHeraultMontpellier);
        restaurantList.add(restaurantHeraultSete);
        restaurantList.add(restaurantParis);


        // Création des ingrédients.
        Ingredient oeuf = new Ingredient("Oeuf", "Oeuf", Unite.UNITE, new ValeurNutritionnelle(145, 0.58, 12.31, 9.88));
        Ingredient banane = new Ingredient("Banane", "Fruit", Unite.UNITE, new ValeurNutritionnelle(90, 22.85, 2.2, 0.33));
        Ingredient sucre = new Ingredient("Sucre", "Sec", Unite.GRAMME, new ValeurNutritionnelle(90, 22.85, 2.2, 0.33));
        Ingredient farine = new Ingredient("Farine", "Sec", Unite.GRAMME, new ValeurNutritionnelle(90, 22.85, 2.2, 0.33));
        Ingredient lait = new Ingredient("Lait", "Lait", Unite.LITRE, new ValeurNutritionnelle(90, 22.85, 2.2, 0.33));


        // Création recettes.
        Recette recetteAvecTout = new Recette(
                "Cake aux bananes",
                "Dessert",
                50,
                "Four",
                "Préchauffer le four à 180/200°C. Dans un grand bol, écraser\n" +
                        "      très grossièrement les 4 bananes très mûres à la fourchette.",
                4,
                chefHerault
        );
        recetteAvecTout.addIngredient(oeuf, 5.);
        recetteAvecTout.addIngredient(banane, 4.);
        recetteAvecTout.addIngredient(sucre, 250.5);
        recetteAvecTout.addIngredient(farine, 500.);
        recetteAvecTout.addIngredient(lait, 390.5);

        Recette recetteAvecDeux = new Recette(
                "Banane caramélisée",
                "Dessert",
                10,
                "Four",
                "Préchauffer le four à 180/200°C. Soupoudrer les bananes et mettre au four. \n",
                4,
                chefParis
        );
        recetteAvecDeux.addIngredient(banane, 26.);
        recetteAvecDeux.addIngredient(sucre, 5000.);


        // Création de la page html avec la <table> des recettes.
        IngredientsView.toHtml("view.html", recetteAvecDeux);


        // Test restaurantsChef(...).
        System.out.println("Liste des restaurants du chef de l'Hérault : " + chefHerault.restaurantsChef(restaurantList));
        System.out.println("Liste des restaurants du chef de Paris : " + chefParis.restaurantsChef(restaurantList));
    }
}
