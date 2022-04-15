package gourmets.view;

public class Tag {

    public static String td (String element) {
        return "<td>" + element + "</td>\n";
    }

    public static String th (String element) {
        return "<th>" + element + "</th>\n";
    }

    public static String tr (String element) {
        return "<tr>\n" + element + "</tr>\n";
    }

    public static String tbody (String element) {
        return "<tbody>\n" + element + "</tbody>\n";
    }

    public static String thead (String[] elementList) {
        String sh = "<thead>\n";
        for (String element : elementList) {
            sh += th(element);
        }
        sh += "</thead>\n";
        return sh;
    }

    public static String table (String element) {
        return "<table class=\"table table-striped\">\n" + element + "</table>\n";
    }

    public static String caption (String element) {
        return "<caption>\n" + element + "\n</caption>\n";
    }

    public static String div (String element) {
        return "<div>\n" + element + "\n</div>\n";
    }

    public static String body (String element) {
        return "<body>\n" + element + "\n</body>\n";
    }

    public static String h1 (String element) {
        return "<h1>\n" + element + "\n</h1>\n";
    }

    public static String h2 (String element) {
        return "<h2>\n" + element + "\n</h2>\n";
    }

    public static String p (String element) {
        return "<p>\n" + element + "\n</p>\n";
    }

    public static String head() {
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

    public static String getHtmlEnd () {
        return "</html>";
    }

}
