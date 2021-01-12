package factory.AbstractFactory.store;

import factory.AbstractFactory.ingredientFactory.ChicagoPizzaIngredientFactory;
import factory.AbstractFactory.ingredientFactory.PizzaIngredientFactory;
import factory.AbstractFactory.pizza.CheesePizza;
import factory.AbstractFactory.pizza.PepperoniPizza;
import factory.AbstractFactory.pizza.Pizza;
import factory.AbstractFactory.pizza.VeggiPizza;

public class ChicagoPizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;
        // Фабрика производит ингредиенты для всех пицц в Чикагском стиле
        PizzaIngredientFactory ingredientFactory = new ChicagoPizzaIngredientFactory();

        if (type.equals("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("Chicago style Cheese Pizza");
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza(ingredientFactory);
            pizza.setName("Chicago style Pepperoni Pizza");
        } else if (type.equals("veggie")) {
            pizza = new VeggiPizza(ingredientFactory);
            pizza.setName("Chicago style Veggie Pizza");
        }
        return pizza;
    }
}
