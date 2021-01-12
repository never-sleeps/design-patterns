package factory.simpleFactory.pizza;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    String name;    // название
    String dough;   // тесто
    String sauce;   // соус
    List<String> toppings = new ArrayList();

    public void prepare() {
        System.out.println("Preparing: " + name);
        System.out.println("Dough: " + dough);
        System.out.println("Sauce: " + sauce);
        for (String topping : toppings) {
            System.out.println("add topping " + topping);
        }
    }

    public void bake() {
        System.out.println("Bake for 20 minutes at 300...");
    }

    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices...");
    }

    public String getName() {
        return name;
    }
}
