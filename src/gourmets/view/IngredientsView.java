package gourmets.view;

import gourmets.base.Recette;

import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;


public class IngredientsView {

    public static void toHtml (String filePath, Recette recette) {
        String html = "";
        html += getHtmlHeader();
        html += "<body>\n";

        String caption = Utils.caption(recette.getNom());
        String thead = Utils.thead(new String[]{ "Nom", "Quantité" });
        String tbody = Utils.tbody(recette.toHtml());


        html += Utils.table(caption + thead + tbody);




        html += getHtmlEnd();


        try {
            FileWriter myWriter = new FileWriter(filePath);
            myWriter.write(html);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static String getHtmlHeader () {
        return
                "<!DOCTYPE html>\n" +
                        "<html lang=\"fr\">\n" +
                        "\n" +
                        "<head>\n" +
                        "    <title></title>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <meta name=\"author\" content=\"Tom Sartori\">\n" +
                        "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                        "\n" +
                        "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\n" +
                        "</head>\n";
    }

    private static String getHtmlEnd () {
        return "</body>\n</html>";
    }
}
