package factory.simpleFactory;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    String name;    // название
    String dough;   // тесто
    String sauce;   // соус
    List<String> toppings = new ArrayList();

    void prepare() {
        System.out.println("Preparing: " + name);
        System.out.println("Dough: " + dough);
        System.out.println("Sauce: " + sauce);
        for (String topping : toppings) {
            System.out.println("add topping " + topping);
        }
    }

    void bake() {
        System.out.println("Bake for 20 minutes at 300...");
    }

    void cut() {
        System.out.println("Cutting the pizza into diagonal slices...");
    }

    public String getName() {
        return name;
    }
}
