package factory.AbstractFactory.ingredientFactory;

import factory.AbstractFactory.ingredients.*;
import factory.AbstractFactory.ingredients.impl.cheese.MozzarellaCheese;
import factory.AbstractFactory.ingredients.impl.dough.ThickCrustDough;
import factory.AbstractFactory.ingredients.impl.pepperoni.SlicedPepperoni;
import factory.AbstractFactory.ingredients.impl.sauce.TomatoSauce;
import factory.AbstractFactory.ingredients.impl.veggies.BlackOlives;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory{
    @Override
    public Dough createDough() { return new ThickCrustDough(); }

    @Override
    public Sauce createSauce() {
        return new TomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies veggies[] = { new BlackOlives() };
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }
}
