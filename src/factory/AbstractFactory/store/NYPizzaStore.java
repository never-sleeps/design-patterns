package factory.AbstractFactory.store;

import factory.AbstractFactory.ingredientFactory.NYPizzaIngredientFactory;
import factory.AbstractFactory.ingredientFactory.PizzaIngredientFactory;
import factory.AbstractFactory.pizza.CheesePizza;
import factory.AbstractFactory.pizza.PepperoniPizza;
import factory.AbstractFactory.pizza.Pizza;
import factory.AbstractFactory.pizza.VeggiPizza;

public class NYPizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;
        // Фабрика производит ингредиенты для всех пицц в Нью-Йоркском стиле
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

        if (type.equals("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("New York style Cheese Pizza");
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza(ingredientFactory);
            pizza.setName("New York style Pepperoni Pizza");
        } else if (type.equals("veggie")) {
            pizza = new VeggiPizza(ingredientFactory);
            pizza.setName("New York style Veggie Pizza");
        }
        return pizza;
    }
}
