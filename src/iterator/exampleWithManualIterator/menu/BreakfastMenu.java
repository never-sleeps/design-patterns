package iterator.exampleWithManualIterator.menu;

import iterator.exampleWithManualIterator.MenuItem;
import iterator.exampleWithManualIterator.iterators.BreakfastMenuIterator;
import iterator.exampleWithManualIterator.iterators.Iterator;

import java.util.ArrayList;

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

    @Override
    public Iterator createIterator() {
        return new BreakfastMenuIterator(menuItems);
    }
}
