package iterator.exampleWithManualIterator;

/**
 * Элемент меню
 */
public class MenuItem {
    String name;
    boolean isVegetarian;
    double price;

    public MenuItem(String name, boolean isVegetarian, double price) {
        this.name = name;
        this.isVegetarian = isVegetarian;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "name='" + name + '\'' +
                ", isVegetarian=" + isVegetarian +
                ", price=" + price +
                '}';
    }
}
