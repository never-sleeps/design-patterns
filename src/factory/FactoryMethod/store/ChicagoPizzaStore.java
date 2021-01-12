package factory.FactoryMethod.store;

import factory.FactoryMethod.pizza.ChicagoStyleCheesePizza;
import factory.FactoryMethod.pizza.ChicagoStylePepperoniPizza;
import factory.FactoryMethod.pizza.Pizza;

public class ChicagoPizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new ChicagoStyleCheesePizza();
        } else if (type.equals("pepperoni")) {
            return new ChicagoStylePepperoniPizza();
        } else return null;
    }
}
