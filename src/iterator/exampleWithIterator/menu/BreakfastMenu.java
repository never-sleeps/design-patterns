package iterator.exampleWithIterator.menu;

import iterator.exampleWithIterator.MenuItem;

import java.util.ArrayList;
import java.util.Iterator;

public class BreakfastMenu implements Menu {
    ArrayList<MenuItem> menuItems;

    public BreakfastMenu() {
        menuItems = new ArrayList<>();
        addItem("Scrambled eggs", true, 1.85);
        addItem("Omelet with bacon", false, 2.35);
        addItem("Pancakes with jam", true, 2.10);
    }

    public void addItem(String name, boolean isVegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, isVegetarian, price);
        menuItems.add(menuItem);
    }

    /**
     * @return Для ArrayList используем Iterator из java.util
     */
    public Iterator<MenuItem> createIterator() {
        return menuItems.iterator();
    }
}
