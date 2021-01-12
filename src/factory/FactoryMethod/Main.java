package factory.FactoryMethod;

import factory.FactoryMethod.pizza.Pizza;
import factory.FactoryMethod.store.ChicagoPizzaStore;
import factory.FactoryMethod.store.NYPizzaStore;
import factory.FactoryMethod.store.PizzaStore;

public class Main {
    public static void main(String[] args) {
        PizzaStore nyPizzaStore = new NYPizzaStore();           // Строим пиццерию в Нью-Йорке
        PizzaStore chicagoPizzaStore = new ChicagoPizzaStore(); // Строим пиццерию в Чикаго

        // пиццерии построены, теперь можно принять заказ:
        /*
         * Обе пиццы готовятся со всеми добавками, выпекаются и нарезаются.
         * Суперклассу не нужно знать подробности - субкласс решает все проблемы, просто создавая правильный экземпляр
         */
        Pizza pizza1 = nyPizzaStore.orderPizza("cheese");
        System.out.println("Rich ordered a " + pizza1.getName());

        System.out.println();

        Pizza pizza2 = chicagoPizzaStore.orderPizza("pepperoni");
        System.out.println("Meatball ordered a " + pizza2.getName());
    }
}
