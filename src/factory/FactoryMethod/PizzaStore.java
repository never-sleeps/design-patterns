package factory.FactoryMethod;

public abstract class PizzaStore {
    /**
     * Субклассы PizzaStore создают экземпляры объектов за нас при вызове orderPizza()
     * @param type
     * @return
     */
    public Pizza orderPizza(String type) {
        Pizza pizza;
        pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        return pizza;
    }

    /**
     * Вся ответственность за создание экземпляров Pizza перемещена в метод, действующий как фабрика.
     * Фабричный метод объявляется abstract, чтобы субклассы предоставили реализацию создания объектов.
     * Метод изолирует клиента от информации о конкретном тпе создаваемого продукта.
     *
     * @param type тип пиццы
     * @return Pizza
     */
    abstract Pizza createPizza(String type);
}
