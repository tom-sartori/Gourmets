package gourmets.app;

import gourmets.base.*;
import gourmets.exception.InvalidDepartement;
import gourmets.view.IngredientsView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SiteWeb {

    private static Chef chefHerault;
    private static Chef chefParis;

    private static Recette recetteAvecTout;
    private static Recette recetteAvecDeux;

    private static List<Restaurant> restaurantList;

    public static void main(String[] args) {
        // initialisation.
        init();


        /**
         * test toHtml().
         */
        testToHtml();


        /**
         * Test restaurantsChef(...).
         */
        testRestaurantsChef();


        /**
         * Test restaurantsDept(...).
         */
        testRestaurantDept();


        /**
         * Test approvis(...).
         */
        testApprovis();


        /**
         * test toDiv().
         */
        testToDiv();
    }

    private static int askUserDepartement () throws InvalidDepartement {
        System.out.println("Entrez un département : ");
        String s = "-1";

        try{
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            s = bufferRead.readLine();
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        int departement = Integer.parseInt(s);

        if (0 > departement || departement > 99) {
            throw new InvalidDepartement();
        }
        return departement;
    }

    private static void init () {
        /**
         * Initialisation des données.
         */
        chefHerault = new Chef("Jean");
        chefParis = new Chef("Bernard");

        Restaurant restaurantHeraultMontpellier = new Restaurant(
                "Le Pastis",
                new Adresse(3, "Rue Terral", "34000", "Montpellier"),
                "https://pastis-restaurant.com/",
                "04.00.00.00.00"
        );
        chefHerault.addRestaurantPossedeList(restaurantHeraultMontpellier);

        Restaurant restaurantHeraultSete = new Restaurant(
                "La Marine",
                new Adresse(29, "Quai Général Durand", "34200", "Sète"),
                "https://Marine.com/",
                "04.00.00.00.00"
        );
        chefHerault.addRestaurantPossedeList(restaurantHeraultSete);

        Restaurant restaurantParis = new Restaurant(
                "La Paris",
                new Adresse(35, "rue de Paris", "75000", "Paris"),
                "https://restaurant-paris.com/",
                "01.00.00.00.00"
        );
        chefParis.addRestaurantPossedeList(restaurantParis);

        chefHerault.setRestaurantPrincipal(restaurantHeraultMontpellier);

        restaurantList = new ArrayList<>();
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
        recetteAvecTout = new Recette(
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
        recetteAvecTout.addIngredient(lait, 0.390);

        recetteAvecDeux = new Recette(
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
    }

    /**
     * Test toHtml(...).
     */
    private static void testToHtml () {
        System.out.println("\n Test toHtml(...)");
        // Création de la page html avec la <table> des recettes.
        IngredientsView.toHtml("ingredient.view.html", recetteAvecDeux);
        System.out.println("Ingrédients disponibles dans la vue ingredient.view.html. ");
    }

    /**
     * Test restaurantsChef(...).
     */
    private static void testRestaurantsChef () {
        System.out.println("\n Test restaurantsChef(...)");
        System.out.println("Liste des restaurants du chef de l'Hérault : " + chefHerault.restaurantsChef(restaurantList));
        System.out.println("Liste des restaurants du chef de Paris : " + chefParis.restaurantsChef(restaurantList));
    }

    /**
     * Test restaurantsDept(...).
     */
    private static void testRestaurantDept () {
        System.out.println("\n Test restaurantsDept(...)");
        int departement = 34;
        boolean isDepartementValid = false;
        while (!isDepartementValid) {
            try {
                departement = askUserDepartement();
                isDepartementValid = true;
            } catch (InvalidDepartement e) {
                System.out.println("Catching error. ");
            }
        }
        System.out.println("Liste des restaurants du " + departement + " : " + Main.restaurantsDept(restaurantList, departement));
        System.out.println("Liste des restaurants du 34 : " + Main.restaurantsDept(restaurantList, 34));
        System.out.println("Liste des restaurants du 75 : " + Main.restaurantsDept(restaurantList, 75));
    }

    /**
     * Test approvis(...).
     */
    private static void testApprovis () {
        System.out.println("\n Test approvis(...)");
        System.out.println("Recette pour " + recetteAvecTout.getNbPersonne() + " couverts : ");
        System.out.println(recetteAvecTout.approvis(4));
        System.out.println();
        System.out.println("Même recette, mais pour 8 couverts : ");
        System.out.println(recetteAvecTout.approvis(8));
    }

    private static int askUsernbCouverts () {
        System.out.println("Entrez un nombre de couverts : ");
        String s = "-1";

        try{
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            s = bufferRead.readLine();
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        int nbCouverts = Integer.parseInt(s);
        return nbCouverts;
    }

    /**
     * test toDiv().
     */
    private static void testToDiv () {
        System.out.println("\n Test toDiv(...)");
        int nbCouverts = askUsernbCouverts();
        System.out.println("Nb couverts : " + nbCouverts);
        System.out.println("Recette : " + recetteAvecTout);
        // Création de la page html avec la <table> des recettes.
        IngredientsView.toDiv("recette.view.html", recetteAvecTout, nbCouverts);
        System.out.println("Recette disponible dans la vue recette.view.html. ");
    }
}
