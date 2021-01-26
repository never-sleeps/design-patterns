package factory.AbstractFactory;

import factory.AbstractFactory.pizza.Pizza;
import factory.AbstractFactory.store.ChicagoPizzaStore;
import factory.AbstractFactory.store.NYPizzaStore;
import factory.AbstractFactory.store.PizzaStore;


public class Main {
    public static void main(String[] args) {
        // Строим пиццерию в Нью-Йорке
        PizzaStore nyPizzaStore = new NYPizzaStore();
        // Заказываем сырную пиццу
        Pizza pizza1 = nyPizzaStore.orderPizza("cheese");
        System.out.println("I ordered: " + pizza1.toString());
        System.out.println();

        // Строим пиццерию в Нью-Йорке
        PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
        // Заказываем сырную пиццу
        Pizza pizza2 = chicagoPizzaStore.orderPizza("cheese");
        System.out.println("I ordered: " + pizza2.toString());
        System.out.println();

        // Заказываем нью-йоркскую пиццу-пеперони
        Pizza pizza3 = chicagoPizzaStore.orderPizza("pepperoni");
        System.out.println("I ordered: " + pizza3.toString());
    }
}
