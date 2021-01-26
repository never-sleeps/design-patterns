package factory.AbstractFactory.ingredientFactory;

import factory.AbstractFactory.ingredients.*;

/**
 * Интерфейс фабрики, который будет создавать все наши ингредиенты.
 * Для каждого ингредиента в интерфейсе определяется метод create.
 */
public interface PizzaIngredientFactory {
    public Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Veggies[] createVeggies();
    public Pepperoni createPepperoni();
}
