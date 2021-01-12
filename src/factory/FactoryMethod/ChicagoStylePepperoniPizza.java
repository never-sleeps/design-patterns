package factory.FactoryMethod;

public class ChicagoStylePepperoniPizza extends Pizza {
    public ChicagoStylePepperoniPizza() {
        name = "Chicago Style Pepperoni Pizza";
        dough = "Extra thick dough";
        sauce = "Tomato sauce";

        toppings.add("Pepperoni sausages");
        toppings.add("Basil");
    }
}
