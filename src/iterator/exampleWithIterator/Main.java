package iterator.exampleWithIterator;

import iterator.exampleWithIterator.menu.BreakfastMenu;
import iterator.exampleWithIterator.menu.DinerMenu;
import iterator.exampleWithIterator.menu.Menu;

public class Main {
    public static void main(String[] args) {
        // Создаём меню завтраков и обедов
        Menu breakfastMenu = new BreakfastMenu();
        Menu dinerMenu = new DinerMenu();

        // Создам официантку и передаём ей оба меню
        Waitress waitress = new Waitress(breakfastMenu, dinerMenu);

        // просим официантку написать элементы обоих меню
        waitress.printMenu();

        /*
            MENU BREAKFAST:
            MenuItem{name='Scrambled eggs', isVegetarian=true, price=1.85}
            MenuItem{name='Omelet with bacon', isVegetarian=false, price=2.35}
            MenuItem{name='Pancakes with jam', isVegetarian=true, price=2.1}

            MENU DINER:
            MenuItem{name='Vegetarian BLT', isVegetarian=true, price=2.99}
            MenuItem{name='Hotdog', isVegetarian=false, price=3.25}
         */
    }
}
