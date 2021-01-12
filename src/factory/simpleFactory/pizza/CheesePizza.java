package factory.simpleFactory.pizza;

public class CheesePizza extends Pizza {
    public CheesePizza() {
        name = "Cheese Pizza";
        dough = "Extra thick dough";
        sauce = "Tomato sauce";

        toppings.add("Shredded Mozzarella Cheese");
    }
}
