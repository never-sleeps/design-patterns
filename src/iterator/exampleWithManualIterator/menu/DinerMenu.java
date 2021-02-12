package iterator.exampleWithManualIterator.menu;

import iterator.exampleWithManualIterator.MenuItem;
import iterator.exampleWithManualIterator.iterators.DinerMenuIterator;
import iterator.exampleWithManualIterator.iterators.Iterator;

public class DinerMenu implements Menu{
    static final int MAX_SIZE = 6;
    int numbOfItems = 0;
    MenuItem[] menuItems;

    public DinerMenu() {
        this.menuItems = new MenuItem[MAX_SIZE];
        addItem("Vegetarian BLT", true, 2.99);
        addItem("Hotdog", false, 3.25);
    }

    public void addItem(String name, boolean isVegetarian, double price) {
        MenuItem newMenuItem = new MenuItem(name, isVegetarian, price);
        if (numbOfItems >= MAX_SIZE) {
            System.err.println("Sorry, menu is full! Can't add item to menu");
        } else {
            menuItems[numbOfItems] = newMenuItem;
            numbOfItems++;
        }
    }

    /**
     * Метод создаёт объект DinerMenuIterator для массива menuItems и возвращает его клиенту.
     * Клиенту не нужно знать ни то, какая коллекция menuItems хранится в DinerMenu, ни то, как реализован DinerMenuIterator.
     * Клиент просто использует итератор для перебора элементов.
     * @return DinerMenuIterator
     */
    @Override
    public Iterator createIterator() {
        return  new DinerMenuIterator(menuItems);
    }
}
