package composite.exampleWithInternalIterator;

import composite.exampleWithInternalIterator.menuComponent.Menu;
import composite.exampleWithInternalIterator.menuComponent.MenuComponent;
import composite.exampleWithInternalIterator.menuComponent.MenuItem;

public class Main {
    public static void main(String[] args) {
        // сначала создаем все объекты меню
        MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU: breakfast");
        MenuComponent dinerMenu = new Menu("DINER MENU: lunch");
        MenuComponent cafeMenu = new Menu("CAFE MENU: diner");
        MenuComponent dessertMenu = new Menu("DESSERT MENU");

        // создаем меню верхнего уровня (корень дерева), включаем каждое меню в меню верхнего уровня
        MenuComponent allMenus = new Menu("ALL MENUS: all menus combined!");
        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(cafeMenu);

        // заполняем наши меню элементами
        pancakeHouseMenu.add(new MenuItem("Scrambled eggs", 1.85, true)); // создаем элемент в меню завтраков
        dinerMenu.add(new MenuItem("Hotdog", 3.25, false)); // создаем элемент в меню ланчей
        cafeMenu.add(dessertMenu); // в меню кафе включаем десертное меню
        dessertMenu.add(new MenuItem("brownie", 4.10, false)); // создаем элемент в десертном меню
        dessertMenu.add(new MenuItem("Apple pie", 3.75, true)); // создаем элемент в десертном меню

        // создаем объект официантки и передаем ей меню верхнего уровня, включающее в себя все остальные меню
        Waitress waitress = new Waitress(allMenus);
        // просим официантку написать элементы всех меню
        waitress.printMenu();

        /*
            ALL MENUS: all menus combined! ---

            PANCAKE HOUSE MENU: breakfast ---
             Scrambled eggs(v), 1.85

            DINER MENU: lunch ---
             Hotdog, 3.25

            CAFE MENU: diner ---

            DESSERT MENU ---
             brownie, 4.1
             Apple pie, 3.75
         */
    }
}
