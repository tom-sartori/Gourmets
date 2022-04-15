package gourmets.base;

public class ValeurNutritionnelle {

    private double calorie;
    private double glucide;
    private double proteine;
    private double lipide;


    public ValeurNutritionnelle(double calorie, double glucide, double proteine, double lipide) {
        this.calorie = calorie;
        this.glucide = glucide;
        this.proteine = proteine;
        this.lipide = lipide;
    }

    public static void main(String[] args) {
        ValeurNutritionnelle valeurNutritionnelle = new ValeurNutritionnelle(90, 22.85, 2.2, 0.33);
        System.out.println(valeurNutritionnelle);
    }

    @Override
    public String toString() {
        return "ValeurNutritionnelle{" +
                "calorie=" + calorie + " kCal" +
                ", glucide=" + glucide + "g" +
                ", proteine=" + proteine + "g" +
                ", lipide=" + lipide + "g" +
                '}';
    }
}
