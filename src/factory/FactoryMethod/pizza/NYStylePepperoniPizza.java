package factory.FactoryMethod.pizza;

public class NYStylePepperoniPizza extends Pizza {
    public NYStylePepperoniPizza() {
        name = "NY Style Pepperoni Pizza";
        dough = "Thin dough";
        sauce = "Marinara Sauce";

        toppings.add("Pepperoni sausages");
        toppings.add("Basil");
    }
}
