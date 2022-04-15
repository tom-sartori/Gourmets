package gourmets.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
                new Adresse(3, "Rue Terral", "34000", "Montpellier"),
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
    }

    public void addRestaurantPossedeList(Restaurant restaurant) {
        this.restaurantPossedeList.add(restaurant);
    }

    public Restaurant getRestaurantPrincipal() {
        return restaurantPrincipal;
    }

    public List<Restaurant> getRestaurantPossedeList() {
        return restaurantPossedeList;
    }

    public List<Restaurant> restaurantsChef (List<Restaurant> restaurantList) {
        List<Restaurant> restaurantDuChefList = new ArrayList<>();
        for (Restaurant restaurant : restaurantList) {
            if (this.restaurantPossedeList.contains(restaurant)) {
                restaurantDuChefList.add(restaurant);
            }
        }
        return restaurantDuChefList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chef chef = (Chef) o;
        return Objects.equals(nom, chef.nom) && Objects.equals(restaurantPrincipal, chef.restaurantPrincipal) && Objects.equals(restaurantPossedeList, chef.restaurantPossedeList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, restaurantPrincipal, restaurantPossedeList);
    }

    public String getNom() {
        return nom;
    }
}
