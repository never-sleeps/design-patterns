package composite.exampleWithInternalIterator;

import composite.exampleWithInternalIterator.menuComponent.MenuComponent;

/**
 *
 */
public class Waitress {
    private MenuComponent allMenus;

    /**
     * Мы просто передаём компонент меню верхнего уровня - тот, который содержит остальные меню (корень дерева).
     * @param allMenus меню верхнего уровня
     */
    public Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    /**
     * Чтобы вывести всю иерархию меню - все меню и все их элементы - достаточно вызвать print() для меню верхнего урвоня
     */
    public void printMenu() {
        allMenus.print();
    }
}
