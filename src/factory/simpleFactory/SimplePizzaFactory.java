package factory.simpleFactory;

import factory.simpleFactory.pizza.CheesePizza;
import factory.simpleFactory.pizza.PepperoniPizza;
import factory.simpleFactory.pizza.Pizza;

public class SimplePizzaFactory {
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        }
        return pizza;
    }
}
