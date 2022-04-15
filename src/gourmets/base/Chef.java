package gourmets.base;

import java.util.ArrayList;
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

    public Chef(String nom, Restaurant restaurantPrincipal) {
        this.nom = nom;
        this.restaurantPrincipal = restaurantPrincipal;
        this.restaurantPossedeList = new ArrayList<>();
    }

    public Chef(String nom) {
        this.nom = nom;
        this.restaurantPossedeList = new ArrayList<>();
    }

    public static void main(String[] args) {
        Chef chef = new Chef("Jean");
        Restaurant restaurant = new Restaurant(
                "Le Pastis",
                new Adresse(3, "Rue Terral", 34000, "Montpellier"),
                new Chef("Jean"),
                "https://pastis-restaurant.com/",
                "04.00.00.00.00"
        );

        chef.setRestaurantPrincipal(restaurant);
        chef.addRestaurantPossedeList(restaurant);
        System.out.println(chef);
    }

    @Override
    public String toString() {
        return "Chef{" +
                "nom='" + nom + '\'' +
                ", restaurantPrincipal=" + restaurantPrincipal +
                ", restaurantPossedeList=" + restaurantPossedeList +
                '}';
    }

    public void setRestaurantPrincipal(Restaurant restaurantPrincipal) {
        this.restaurantPrincipal = restaurantPrincipal;
        // addRestaurantPossedeList(restaurantPrincipal);   // ?
    }

    public void addRestaurantPossedeList(Restaurant restaurant) {
        this.restaurantPossedeList.add(restaurant);
    }
}
