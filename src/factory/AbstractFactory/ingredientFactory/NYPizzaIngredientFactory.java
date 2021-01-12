package factory.AbstractFactory.ingredientFactory;

import factory.AbstractFactory.ingredients.*;
import factory.AbstractFactory.ingredients.impl.cheese.ReggianoCheese;
import factory.AbstractFactory.ingredients.impl.dough.ThinCrustDough;
import factory.AbstractFactory.ingredients.impl.pepperoni.SlicedPepperoni;
import factory.AbstractFactory.ingredients.impl.sauce.MarinaraSauce;
import factory.AbstractFactory.ingredients.impl.veggies.Garlic;
import factory.AbstractFactory.ingredients.impl.veggies.Onion;

/**
 * Нью-Йоркская фабрика ингредиентов реализет общий интерфейс всех фабрик ингредиентов.
 * Для аждого ингредиента в семействе создается его версия для Нью-Йорка.
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies veggies[] = { new Garlic(), new Onion() };
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }
}
