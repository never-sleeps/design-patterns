package iterator.exampleWithIterator;

import iterator.exampleWithIterator.menu.BreakfastMenu;
import iterator.exampleWithIterator.menu.DinerMenu;
import iterator.exampleWithIterator.menu.Menu;

import java.util.Iterator;

public class Waitress {
    Menu breakfastMenu;
    Menu dinerMenu;

    /**
     * В конструктор передаются оба объекта меню
     * @param breakfastMenu
     * @param dinerMenu
     */
    public Waitress(Menu breakfastMenu, Menu dinerMenu) {
        this.breakfastMenu = breakfastMenu;
        this.dinerMenu = dinerMenu;
    }

    public void printMenu() {
        Iterator<MenuItem> breakfastMenuIterator = breakfastMenu.createIterator();
        System.out.println("MENU BREAKFAST:");
        printMenu(breakfastMenuIterator);

        Iterator<MenuItem> dinerMenuIterator = dinerMenu.createIterator();
        System.out.println("\nMENU DINER:");
        printMenu(dinerMenuIterator);
    }

    public void printMenu(Iterator<MenuItem> iterator) {
        while (iterator.hasNext()) {    // проверяем остались ли еще элементы
            MenuItem item = iterator.next(); // получаем следующий элемент
            System.out.println(item);   // выводим данные элемента меню
        }
    }
}
