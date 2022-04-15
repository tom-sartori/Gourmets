package gourmets.base;

import java.util.List;

public class Chef {

    private String nom;
    private Restaurant restaurantPrincipal;
    private List<Restaurant> restaurantPossedeList;

    public Chef(String nom, Restaurant restaurantPrincipal, List<Restaurant> restaurantPossedeList) {
        this.nom = nom;
        this.restaurantPrincipal = restaurantPrincipal;
        this.restaurantPossedeList = restaurantPossedeList;
    }
}
