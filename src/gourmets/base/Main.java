package gourmets.base;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello. ");
    }

    public static List<Restaurant> restaurantsDept (List<Restaurant> restaurantList, int department) {
        List<Restaurant> restaurantSameDepartmentList = new ArrayList<>();
        for (Restaurant restaurant : restaurantList) {
            if (restaurant.getAdresse().isSameDepartment(department)) {
                restaurantSameDepartmentList.add(restaurant);
            }
        }
        return restaurantSameDepartmentList;
    }
}
