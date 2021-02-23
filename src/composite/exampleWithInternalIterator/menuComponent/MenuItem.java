package composite.exampleWithInternalIterator.menuComponent;

/**
 * Класс листового узла на диаграмме классов паттерна Компоновщик, он реализует поведение элементов комбинации.
 */
public class MenuItem extends MenuComponent {
    String name;
    double price;
    boolean isVegetarian;

    public MenuItem(String name, double price, boolean isVegetarian) {
        this.name = name;
        this.price = price;
        this.isVegetarian = isVegetarian;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public boolean isVegetarian() {
        return isVegetarian;
    }

    /**
     * Мы переопределяем метод print класса MenuComponent. Для MenuItem этод метод выводит полное описание элемента меню.
     */
    @Override
    public void print() {
        System.out.print(" " + getName());
        if (isVegetarian()) {
            System.out.print("(v)");
        }
        System.out.println(", " + getPrice());
    }
}
