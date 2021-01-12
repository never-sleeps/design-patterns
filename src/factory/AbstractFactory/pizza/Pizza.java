package factory.AbstractFactory.pizza;

import factory.AbstractFactory.ingredients.*;

import java.util.Arrays;

public abstract class Pizza {
    // Каждый объект пиццы содержит набор ингредиентов, необходимых для ее приготовления
    String name;
    Dough dough;
    Sauce sauce;
    Veggies veggies[];
    Cheese cheese;
    Pepperoni pepperoni;

    /**
     * В этом методе мы будем собирать необходимые ингредиенты, которые будут производиться фабрикой ингредиентов
     */
    public abstract void prepare();

    public void bake() {
        System.out.println("Bake for 20 minutes at 300...");
    }

    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", dough=" + dough +
                ", sauce=" + sauce +
                ((veggies != null) ? ", veggies=" + Arrays.toString(veggies) : "") +
                ((cheese != null) ? ", cheese=" + cheese : "") +
                ((pepperoni != null) ? ", pepperoni=" + pepperoni : "") +
                '}';
    }
}
