package factory.simpleFactory.pizza;

public class PepperoniPizza extends Pizza {
    public PepperoniPizza() {
        name = "Pepperoni Pizza";
        dough = "Extra thick dough";
        sauce = "Tomato sauce";

        toppings.add("Pepperoni sausages");
        toppings.add("Basil");
    }
}
