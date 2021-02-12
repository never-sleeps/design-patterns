package iterator.exampleWithManualIterator;

import iterator.exampleWithManualIterator.iterators.Iterator;
import iterator.exampleWithManualIterator.menu.BreakfastMenu;
import iterator.exampleWithManualIterator.menu.DinerMenu;
import iterator.exampleWithManualIterator.menu.Menu;

public class Waitress {
    Menu breakfastMenu;
    Menu dinerMenu;

    /**
     * В конструктор передаются оба объекта меню
     * @param breakfastMenu меню завтраков
     * @param dinerMenu меня обедов
     */
    public Waitress(Menu breakfastMenu, Menu dinerMenu) {
        this.breakfastMenu = breakfastMenu;
        this.dinerMenu = dinerMenu;
    }

    public void printMenu() {
        Iterator breakfastMenuIterator = breakfastMenu.createIterator();
        System.out.println("MENU BREAKFAST:");
        printMenu(breakfastMenuIterator);

        Iterator dinerMenuIterator = dinerMenu.createIterator();
        System.out.println("\nMENU DINER:");
        printMenu(dinerMenuIterator);
    }

    public void printMenu(Iterator iterator) {
        while (iterator.hasNext()) {    // проверяем остались ли еще элементы
            MenuItem item = (MenuItem) iterator.next(); // получаем следующий элемент
            System.out.println(item);   // выводим данные элемента меню
        }
    }
}
