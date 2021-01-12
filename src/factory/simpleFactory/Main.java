package factory.simpleFactory;

public class Main {
    public static void main(String[] args) {
        // Строим пиццерию
        SimplePizzaFactory factory = new SimplePizzaFactory();
        PizzaStore pizzaStore = new PizzaStore(factory);

        // пиццерии построена, теперь можно принять заказ:
        Pizza pizza = pizzaStore.orderPizza("cheese");
        System.out.println("I ordered a " + pizza.getName());
    }
}
