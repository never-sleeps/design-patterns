package factory.AbstractFactory.pizza;

import factory.AbstractFactory.ingredientFactory.PizzaIngredientFactory;

public class CheesePizza extends Pizza {
    PizzaIngredientFactory ingredientFactory;

    /**
     * @param ingredientFactory фабрика, поставляющая ингредиенты
     */
    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    /**
     * Когда методу prepare требуется какой-либо ингредиент, он запрашивает его у фабрики.
     * При этом может использоваться любая фабрика ингредиентов.
     */
    @Override
    public void prepare() {
        System.out.println("Preparing: " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
    }
}
