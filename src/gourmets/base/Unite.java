package gourmets.base;

public enum Unite {
    GRAMME,
    LITRE,
    UNITE;

    @Override
    public String toString() {
        return switch (this) {
            case GRAMME -> "grammes";
            case LITRE -> "litres";
            case UNITE -> "unitées";
        };
    }
}
