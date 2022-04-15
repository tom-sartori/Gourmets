package gourmets.view;

import gourmets.base.Recette;

import java.io.FileWriter;
import java.io.IOException;


public class IngredientsView {

    public static void toHtml (String filePath, Recette recette) {
        String html = "";
        html += Tag.head();

        String tableIngredient = recette.ingredientToHtml();

        String body = Tag.body(tableIngredient);
        html += body;

        html += Tag.getHtmlEnd();

        createHtmlFile(filePath, html);
    }


    /**
     * Réponse à la question 8.
     * toDiv() est divisée en deux parties.
     * La première partie est ici. Elle permet de créer le squelette html et appelle une fonction contenue dans Recette,
     * pour récupérer le div avec le contenu de la recette.
     * La méthode n'est pas entièrement dans la classe Recette, car le squelette html ne dépend pas de son domaine de responsabilité.
     */
    public static void toDiv (String filePath, Recette recette, int nbCouvert) {
        String html = "";
        html += Tag.head();

        String divRecette = recette.toDiv(nbCouvert);
        String body = Tag.body(divRecette);

        html += body;
        html += Tag.getHtmlEnd();

        createHtmlFile(filePath, html);
    }

    private static void createHtmlFile (String filePath, String innerHtml) {
        try {
            FileWriter myWriter = new FileWriter(filePath);
            myWriter.write(innerHtml);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
