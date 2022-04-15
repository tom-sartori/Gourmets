package gourmets.view;

public class Utils {

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
}
