package gourmets.base;

public enum Unite {
    GRAMME,
    LITRE,
    UNITE;

    @Override
    public String toString() {
        return switch (this) {
            case GRAMME -> "gramme";
            case LITRE -> "litre";
            case UNITE -> "unitée";
        };
    }
}
