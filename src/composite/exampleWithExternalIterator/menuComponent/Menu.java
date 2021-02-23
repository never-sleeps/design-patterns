package composite.exampleWithExternalIterator.menuComponent;

import composite.exampleWithExternalIterator.CompositeIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Класс комбинационного узла. Класс комбинации может содержать элементы MenuItem или другие Menu.
 * Этот класс не реализует getPrice() и isVegetarian(), потому что эти методы не имеют особого смысла для Menu.
 */
public class Menu extends MenuComponent {
    // Menu может иметь любое количество потомков типа MenuComponent, для их хранения будет использоваться внутренняя коллекция List
    List<MenuComponent> menuComponents = new ArrayList<>();
    String name;
    Iterator iterator = null;

    // с каждым меню связывается название
    public Menu(String name) {
        this.name = name;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int i) {
        return menuComponents.get(i);
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * При выводе объекта меню будет выводиться его название и все компоненты: другие меню и элементы меню.
     * Для перебора всех компонентов объекта Menu мы используем итератор.
     * Если в процессе перебора мы встретим новый объект Menu, его метод print() начнёт новый перебор и т.д.
     */
    @Override
    public void print() {
        System.out.print("\n" + getName());
        System.out.println(" ---");

        Iterator<MenuComponent> iterator = menuComponents.iterator();
        while (iterator.hasNext()) {
            MenuComponent menuComponent = iterator.next();
            menuComponent.print();
        }
    }

    public Iterator<MenuComponent> createIterator() {
        if (iterator == null) {
            iterator = new CompositeIterator(menuComponents.iterator());
        }
        return iterator;
    }
}
